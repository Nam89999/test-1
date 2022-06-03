package kr.inflearn.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.model.ReCommentVO;
import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
    @Autowired
    public BoardMapper boardMapper;
    
    @Autowired
    public CommentMapper commentMapper;


	// 대댓글 목록 불러오기
	@Override
	public List<ReCommentVO> reCommentList(int commentId) {
		
		//Mapper 호출 
		List<ReCommentVO> reCommentList= commentMapper.readReCommentList(commentId);
		
		return reCommentList;
	}
	
	// 대댓글 등록하기
	@Override
	public String registerReComment(ReCommentVO reCommentVO) {

		
		
		return null;
	}
	
	

}
