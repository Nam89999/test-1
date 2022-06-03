package kr.inflearn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.comment.model.ReCommentVO;

@Mapper
public interface CommentMapper {

	//대댓글 목록  Read
	public List<ReCommentVO> readReCommentList(int commentId);
	
	//대댓글 등록  CREATE
	public int insertReComment(ReCommentVO reComment);
	
	//대댓글 수정  Update
	public int updateReComment(ReCommentVO reComment);
	

}
