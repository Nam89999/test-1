package kr.inflearn.comment.service;

import kr.inflearn.comment.model.CommentVO;

public interface CommentService {
	
	
	public CommentVO readBoardWriterComment(int boardnum);

}
