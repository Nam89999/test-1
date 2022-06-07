package kr.inflearn.comment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.model.ReCommentVO;
import kr.inflearn.comment.service.CommentService;
import kr.inflearn.board.service.BoardService;

@Controller
public class CommentController {

	@Autowired
	public CommentService commentService;

	@Autowired
	public BoardService boardService;

	// 대댓글 목록
	// 댓글 번호를 넘기면 대댓글 list를 보여준다.
	public String reCommentList(int commentId, Model model) {

		// 서비스 호출
		List<ReCommentVO> reCommentList = commentService.reCommentList(commentId);

		model.addAttribute("reCommentList", reCommentList);

		return "board/get";

	}

	// 대댓글 목록
	// 댓글 번호를 넘기면 대댓글 list를 보여준다.
	@RequestMapping(value = "/reCommentList2.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentVO> reCommentList2(@RequestParam("boardNum") int boardNum) {

		// 서비스 호출
		List<CommentVO> commentList = commentService.reCommentList2(boardNum);

		return commentList;

	}
	
	// 대댓글 등록
	
	
	// 대댓글 수정

}
