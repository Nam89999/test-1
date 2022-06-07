package kr.inflearn.board.service;

import java.util.List;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.member.model.MemberVO;
import kr.inflearn.board.model.BoardVO;

public interface BoardService {
	//선언만 해주고 정의는 BoardServiceImpl
	
	//게시판 리스트 불러오기
	public List<BoardVO> getBoardList();
	
	//게시판 올리기
	public int registerBoard(BoardVO boardVO);

	//게시물 상세보기
	public BoardVO getBoard(int boardnum);

	//게시물 수정하기
	public String modifyBoard(BoardVO boardVO, int num);
	
	//게시물 작성자  member 이름 정보 불러오기 
	public MemberVO readMemberInfo(int boardnum);

	//댓글 등록 
	public String insertComment(CommentVO commentVO);
	
	//댓글 목록 불러오기
	public List<CommentVO> readCommentList(int boardnum);
	
	//댓글 하나 불러오기
	public CommentVO readComment(int commentId);
	
	//댓글 수정
	public String updateComment(CommentVO commentVO);

}
