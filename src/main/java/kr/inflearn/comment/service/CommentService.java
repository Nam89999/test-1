package kr.inflearn.comment.service;

import java.util.List;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.model.ReCommentVO;

public interface CommentService {
	
	
	
	//글쓴이 댓글 찾기? 필요가 있나 걍 boardService에서 처리하기로함.
	public CommentVO readBoardWriterComment(int boardnum);
	
	//대댓글 리스트 불러오기
	public List<ReCommentVO> reCommentList(int commentId);

}
