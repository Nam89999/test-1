package kr.inflearn.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.member.model.MemberVO;
import kr.inflearn.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	// 서비스단에서 메서드 이름은 현실적인 로직의 이름을 명명
	// get(검색), 리스트 불러오기(getList) 등록 (register), 수정 (modify), 삭제(remove),

	@Autowired
	public BoardMapper boardMapper;

	// 게시물 리스트 불러오기
	@Override
	public List<BoardVO> getBoardList() {

		List<BoardVO> boardList = boardMapper.readboardList();

		return boardList;
	}

	// 게시물 올리기
	@Override
	public int registerBoard(BoardVO boardVO) {

		int cnt = boardMapper.insertBoard(boardVO);

		return cnt;
	}

	// 게시물 상세보기
	@Override
	public BoardVO getBoard(int boardnum) {

		return boardMapper.readBoardContents(boardnum);

	}// 예외처리하는 법

	// 게시물 수정하기
	@Override
	public String modifyBoard(BoardVO boardVO, int num) {
		try {
			// boardNum을 통해 board 가져오기
			int boardnum = boardVO.getNum(); // 이부분 설명좀 걍 느낌으로 했는데
			BoardVO board = boardMapper.readBoardContents(boardnum);// 질문: 보드 id를 뽑아서 board 함수를 호출해서 하는건 두번 일하는거 아닌가?
			// if(borad의 writer랑 num랑 같은지 체크)
			if (board.getNum() == num) {

				int result = boardMapper.updatBoard(boardVO);
				if (result > 0) {
					return "success";
				}
				return "수정에 실패했습니다";
			} // 다르면 해당 글 쓴 사람이 아니라고 판단후, 에러리턴
			else {

				return "유저가 다릅니다."; // 맞나?
			}
		} catch (Exception e) {
			return "DBerror";
		}

	}

	// 게시물 작성자 member정보 불러오기
	@Override
	public MemberVO readMemberInfo(int boardnum) {

		// 1.Mapper 호출
		MemberVO writerInfo = boardMapper.readMemberInfo(boardnum);

		System.out.println(writerInfo);
		return writerInfo; // 나중에는 한번에 보내버리자
	}

	// 댓글 등록하기
	@Override
	public String insertComment(CommentVO commentVO) {

		// mapper 댓글 등록 함수 호출
		int result = boardMapper.insertComment(commentVO);
		System.out.println(result);

		// 댓글 등록 성공하면
		if (result > 0) {

			return "success";

			// 댓글 등록 실패하면
		} else {

			return "error";
		}

	}

	// 댓글 목록 불러오기
	@Override
	public List<CommentVO> readCommentList(int boardnum) {

		List<CommentVO> commentList = boardMapper.readCommentList(boardnum);
		
		BoardVO boardInfo= boardMapper.readBoardContents(boardnum);
		
		int boardWriter = boardInfo.getNum();
		
		for(int i=0; i < commentList.size(); i++) {
			 
			  CommentVO list = commentList.get(i);
			
			  int commentWriter =list.getNum();
			
			  if(boardWriter == commentWriter) { // 댓글 작성자와 본문 작성자가 같다면  
				  
				  List<CommentVO>commentListY= boardMapper.readCommentList(boardnum);
				  
				  return commentListY;
			   
			   }else{ // 틀리다면 
				   
				   
					List<CommentVO>commentListN= boardMapper.readCommentList(boardnum);

				   return commentListN;
			   }
			
		}

		return commentList;
	}

	// 댓글 하나 불러오기
	@Override
	public CommentVO readComment(int commentId) {

		CommentVO comment = boardMapper.readComment(commentId);

		return comment;
	}

	// 댓글 수정하기
	@Override
	public String updateComment(CommentVO commentVO) {
		// 회원 수정 요청한 유저와 댓글 주인이 다를 경우를 대비해서 처리한다.
		// 세션의 num 가져오기
		// comment id로 수정할 commnet가져오기
		// comment 작성자(num)과 비교
		// 다르면 에러

		int num = commentVO.getNum();
		int commentId = commentVO.getCommentId();

		CommentVO newCommentVO = boardMapper.readComment(commentId);

		System.out.println("newCommentVO : " + newCommentVO.getNum());
		System.out.println("num : " + num);

		if (num != newCommentVO.getNum()) {

			return "WrongUser";
		}
		
		// comment가 들어있지 않으면 
		if (newCommentVO == null) {

			return "NotExistError";
		}

		// 에러 처리 후 댓글 수정에 들어간다.
		int result = boardMapper.updateComment(commentVO);

		if (result > 0) {

			return "success";

		} else {

			return "fail"; // fail
		}

	}

}
