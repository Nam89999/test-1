package kr.inflearn.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.model.ReCommentVO;
import kr.inflearn.mapper.BoardMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	public BoardMapper boardMapper;

	@Override
	public CommentVO readBoardWriterComment(int boardnum) {
		
		CommentVO result=boardMapper.readBoardWriterComment(boardnum);
		
		return result;
		
	}

	@Override
	public List<ReCommentVO> reCommentList(int commentId) {
		
		//Mapper 호출 
		

		
		return null;
	}
	
	

}
