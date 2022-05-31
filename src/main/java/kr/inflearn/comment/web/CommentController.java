package kr.inflearn.comment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.inflearn.comment.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	public CommentService commentService;
	
	
	

}
