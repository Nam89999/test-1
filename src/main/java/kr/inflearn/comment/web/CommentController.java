package kr.inflearn.comment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.inflearn.comment.model.ReCommentVO;
import kr.inflearn.comment.service.CommentService;
import kr.inflearn.service.BoardService;

@Controller
public class CommentController {
	
	@Autowired
	public CommentService commentService;
	
	@Autowired
	public BoardService boardService;
	
	
	//대댓글 목록 
	//댓글 번호를 넘기면 대댓글 list를 보여준다.
    public String reCommentList(int commentId){
    	
    	//서비스 호출
    	List<ReCommentVO> reCommentList=commentService.reCommentList(commentId);
    	
    	
    	return "board/get";
    	
    }
	
	

}
