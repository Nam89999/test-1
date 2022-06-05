package kr.inflearn.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.comment.mapper.CommentMapper;
import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.comment.model.ReCommentVO;
import kr.inflearn.mapper.BoardMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	public BoardMapper boardMapper;

	@Autowired
	public CommentMapper commentMapper;

	// 대댓글 목록 불러오기
	@Override
	public List<ReCommentVO> reCommentList(int commentId) {

		// Mapper 호출
		List<ReCommentVO> reCommentList = commentMapper.readReCommentList(commentId);

		return reCommentList;
	}

	// 대댓글 목록 불러오기
	@Override
	public List<CommentVO> reCommentList2(int boardNum) {
		
		//댓글  목록을 불러온다.
		List<CommentVO> commentList = boardMapper.readCommentList(boardNum);
		
		//
		for (int i = 0; i < commentList.size(); i++) {
			//for문을 돌려 댓글마다 댓글 번호를 불러와(commentList.get(i).getCommentId()) 이를 사용해 그 밑에 대댓글 목록들을 찾아온다.
			List<ReCommentVO> reCommentList = commentMapper.readReCommentList(commentList.get(i).getCommentId());
			//댓글 VO의 대댓글 목록에 넣어준다.결국 댓글 번호 i번 밑에 recommentList를 찾아서 넣어주는 로직 
			commentList.get(i).setRecommentList(reCommentList);
		}
		return commentList;
	}

	// 대댓글 등록하기
	@Override
	public String registerReComment(ReCommentVO reCommentVO) {
		return null;
	}

}
