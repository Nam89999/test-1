package kr.inflearn.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.comment.model.ReCommentVO;

@Mapper
public interface CommentMapper {

	//대댓글 목록 Read
	public List<ReCommentVO> readCommentList(int commentId);
	
	
	

}
