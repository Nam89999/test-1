package kr.inflearn.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.service.CommentService;
import kr.inflearn.member.model.MemberVO;
import kr.inflearn.member.service.MemberService;
import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;

	@Autowired
	public MemberService memberService;

	@Autowired
	public CommentService commentService;

	// 게시물 리스트 불러오기
	@RequestMapping(value = "/readBoardList.do")
	public String boardList(Model model) {

		try {
			// 1.서비스 호출
			List<BoardVO> boardList = boardService.getBoardList();

			// 2. 객체 바인딩
			model.addAttribute("boardList", boardList);

			return "board/boardList";

		} catch (Exception e) {
			// e.printStackTrace();

			return "home";

		}

	}

	// 게시물 등록 페이지 이동
	@RequestMapping(value = "/registerBoard.do", method = RequestMethod.GET)
	public String registerBoardGET(Model model, HttpSession session) {

		/*
		 * Integer a = 0; int b = 0;
		 * 
		 * a.toString(); String.valueOf(b);
		 */

		try {
			int memberNum = (int) session.getAttribute("memberNum");// 세션에 memberNum없으면 오류가 날 수 있어서 try catch

			// 추가
			String memberId = (String) memberService.memberContent(memberNum).getId();
			model.addAttribute("memberId", memberId);
			session.setAttribute("memberNum", memberNum);

			return "board/register";
		} catch (Exception e) {
			// String msg = "로그인을 해주세요";
			// return "redirect:/login.do?msg=" + msg;
			return "redirect:/login.do";
		}

	}

	// 게시물 올리기
	@RequestMapping(value = "/registerBoard.do", method = RequestMethod.POST)
	@ResponseBody
	public String registerBoardPOST(BoardVO boardVO, HttpSession session) {

		try {

			System.out.println("게시물 등록 정보:"+boardVO);
			
			int memberNum = (int) session.getAttribute("memberNum");
			
			System.out.println("게시물 작성자:"+memberNum);

			// 서비스 호출
			int result = boardService.registerBoard(boardVO);
	

			if (result > 0) {// 게시물 등록 성공시

				return "true";
			} else { // 게시물 등록 실패시

				return "false";
			}
		} catch (Exception e) {
			// ajax를 쓴 경우 예외 처리시 홈으로 어떻게 보내나?
			return "false";
		}

		// return result > 0 ? "true" : "false"; 맞나?

	}

	// 게시물 상세보기 + 댓글 목록 보기 수정 버튼은 글쓴이만 보이게
		@RequestMapping(value = "/boardContents.do", method = RequestMethod.GET)
		public String boardContents(@RequestParam("bno") int boardnum, Model model, HttpSession session) {

			try {
				// 세션에서 유저 번호 꺼내고,
				int memberNum = (int) session.getAttribute("memberNum");
				// 서비스 호출 (게시판 번호로 게시물 불러오기)
				BoardVO boardVO = boardService.getBoard(boardnum);

				// 객체 바인딩
				model.addAttribute("boardInfo", boardVO);

				// boardVO의 작성자 번호랑 세션에 있는 작성자 번호랑 같은지 체크
				// 같으면 뭔가 변수를 넘겨서 view에서 수정 버튼이 보일 수 있도록
				if (boardVO.getNum() == memberNum) {
					model.addAttribute("goModify", boardVO);

				}

				// 댓글 : 로그인 한 사람 이름 불러오기
				MemberVO memberInfo = memberService.memberContent(memberNum);
				model.addAttribute("memberInfo", memberInfo.getId());

				// 댓글 리스트 불러오기
				List<CommentVO> commentList = boardService.readCommentList(boardnum);
//				
//			    BoardVO boardInfo = boardService.getBoard(boardnum);
//			    int boardWriter = boardInfo.getNum();
//			    
//			    //for 문으로  댓글 목록을 돌리고 
//		        for (int i = 0; i < commentList.size(); i++) {
//		            // 댓글 목록 각각의 정보 호출
//		        	CommentVO list = commentList.get(i);
//		        	// 각각의 comment 작성자 정보를 담아준다. 
//		            int commentWriter = list.getNum();
//		            // 그리고 객체(VO)에 BoardWriter에 false를 넣어준다.
//		            commentList.get(i).setIsBoardWriter(false);
//		            // if (board 글쓴이 번호 == comment 작성자) 라면  
//		            if (boardWriter == commentWriter) {
//		            	// 그리고 객체(VO)에 BoardWriter에 true를 넣어준다.
//		                commentList.get(i).setIsBoardWriter(true);
//		            }
//		        }
		        
		    	model.addAttribute("commentList", commentList);
			        
				
				for(int i = 0; i < commentList.size(); i++) {
				System.out.println("댓글 출력:"+commentList.get(i));
				}

				return "board/get";

			} catch (Exception e) {// 로그인 하지 않은 사용자

				// 서비스 호출
				BoardVO boardVO = boardService.getBoard(boardnum);
				// 객체 바인딩
				model.addAttribute("boardInfo", boardVO);

				// 댓글 리스트 불러오기
				List<CommentVO> commentList = boardService.readCommentList(boardnum);
				
				
				model.addAttribute("commentList", commentList);
				
				for(int i = 0; i < commentList.size(); i++) {
					System.out.println("댓글 출력:"+commentList.get(i));
					}

				return "board/get";

			}

		}
		
		
		
		


		

	// 게시물 수정 페이지 이동+ 들어오지 못하게
	@RequestMapping(value = "/boardModify.do", method = RequestMethod.GET)
	public String boardModifyGET(@RequestParam("bno") int boardnum, Model model, HttpSession session) {

		try {
			// 세션에서 로그인 된 유저 번호 꺼내고,
			int memberNum = (int) session.getAttribute("memberNum");
			// 보드 작성자 번호 꺼내기
			BoardVO result = boardService.getBoard(boardnum);
			int boardMemberNum = result.getNum();
			// 작성자가 아니면,get page로 보낸다.
			if (memberNum != boardMemberNum) {
				return "redirect:/home.do";
				// 질문-에러 처리를 제대로 해준다면 어떻게 해줘야될까?
			}

			// MemberVO writerInfo = boardService.readMemberInfo(boardnum);
			// 게시글 정보
			model.addAttribute("boardInfo", result);
			// 작성자 정보
			// model.addAttribute("writerInfo", writerInfo);
			return "board/modify";

		} catch (Exception e) {

			return "redirect:/readBoardList.do";

		}
	}

	// 게시물 수정
	@RequestMapping(value = "/boardModify.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardModifyPOST(BoardVO boardVO, HttpSession session) {

		int num = (int) session.getAttribute("memberNum");

		String result = boardService.modifyBoard(boardVO, num);
		//System.out.println("수정결과:" + result); 확인

		return result;

	}

	// 댓글 등록
	@RequestMapping(value = "/registerComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String registerComment(CommentVO commentVO, HttpSession session) {

		try {

			// 댓글 작성자 memberId 받아옴
			int memberNum = (int) session.getAttribute("memberNum");

			// 로그인한 사용자의 memberID를 세션에서 뺴어 바구니에 넣어준다.(확인 필요)
			commentVO.setNum(memberNum);

			// 확인 System.out.println("comment-register controller: " + commentVO);

			// 댓글 등록 서비스 호출
			String result = boardService.insertComment(commentVO);

			// 결과를 Ajax로 리턴
			return result;

		} catch (Exception e) {
			// 로그인 하지 않았으면
			return "false";
		}

	}
	
	
	// 댓글 수정 GET
	@RequestMapping(value = "/modifyComment.do", method = RequestMethod.GET)
	public String modifyCommentGET(@RequestParam("cno") int commentId, HttpSession session, Model model) {

		try {
			// 세션에서 유저 번호 꺼내고,
			int memberNum = (int) session.getAttribute("memberNum");

			System.out.println("댓글번호" + commentId);
			

			// 수정 할 댓글 내용 불러오기
			CommentVO comment = boardService.readComment(commentId);			

			//확인 System.out.println(comment);

			// 로그인 한 사용자 번호와 댓글 작성자의 번호가 같은지 확인 후
			// 같으면 뭔가 변수를 넘겨서 view에서 수정 버튼이 보일 수 있도록
			if (memberNum == comment.getNum()) {
				model.addAttribute("goCommentModify", comment);

			}

			// 객체 바인딩
			model.addAttribute("comment", comment);
			// 게시글 번호 바인

			return "board/commentModify";
		} catch (Exception e) {
			return "member/memberLogin";
		}
	}
	
	
	

		
	
	//댓글 수정 POST
	@RequestMapping(value = "/modifyComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String modifyCommentPost(CommentVO commentVO, HttpSession session) {
		System.out.println("commentVO param : " + commentVO);
		try {

			// 댓글 작성자 memberId 받아옴
			int memberNum = (int) session.getAttribute("memberNum");

			// 로그인한 사용자의 memberID를 세션에서 뺴어 바구니에 넣어준다.(확인 필요)
			commentVO.setNum(memberNum);

			// 확인
			System.out.println("comment-register controller: " + commentVO);

			// 댓글 등록 서비스 호출
			String result = boardService.updateComment(commentVO);

			// 결과를 Ajax로 리턴
			return result;

		} catch (Exception e) {
			// 로그인 하지 않았으면
			return "false";
		}

	}
	
	
	
	
}
