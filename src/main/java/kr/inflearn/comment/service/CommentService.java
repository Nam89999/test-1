package kr.inflearn.comment.service;

import java.util.List;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.model.ReCommentVO;

public interface CommentService {
	
	//대댓글 리스트 불러오기
	public List<ReCommentVO> reCommentList(int commentId);

	public List<CommentVO> reCommentList2(int commentId);
	
	//대댓글 등록하기 
	public String registerReComment(ReCommentVO reCommentVO);
	
	//대댓글 수정하기 
}
