package kr.inflearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;

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

			return "home";

		}

	}

	// 게시물 등록 페이지 이동
	@RequestMapping(value = "/registerBoard.do", method = RequestMethod.GET)
	public String registerBoardGET() {

		return "board/register";

	}

	// 게시물 올리기
	@RequestMapping(value = "/registerBoard.do", method = RequestMethod.POST)
	@ResponseBody
	public String registerBoardPOST(BoardVO boardVO) {

		try {
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

	// 게시물 상세보기
	@RequestMapping(value = "/boardContents.do", method = RequestMethod.GET)
	public String boardContents(@RequestParam("bno") int boardnum, Model model) {

		// 서비스 로출
		BoardVO boardVO = boardService.getBoard(boardnum);// 같은 boardVO를 쓰면되나 안되나?

		// 객체 바인딩
		model.addAttribute("boardInfo", boardVO);

		return "board/get";

	}

	//게시물 수정 페이지 이동
	@RequestMapping(value = "/boardModify.do", method = RequestMethod.GET)
	public String boardModifyGET(@RequestParam("bno") int boardnum, Model model) {

		BoardVO result = boardService.getBoard(boardnum);

		model.addAttribute("boardInfo", result);

		return "board/modify";
	}

	// 게시물 수정 
	@RequestMapping(value = "/boardModify.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardModifyPOST(BoardVO boardVO) {

		int result = boardService.modifyBoard(boardVO);

		System.out.println("게시물 수정 로직:" + boardVO);

		if (result > 0) { // 0이면 실패 '무조건 0or1'로 오는가?

			return "true";

		} else {// 실패 라면

			return "false";
		}
	}

}
