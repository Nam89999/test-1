package kr.inflearn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.member.model.MemberVO;
import kr.inflearn.model.BoardVO;

@Mapper
public interface BoardMapper {

	// 게시판 목록 불러오기
	public List<BoardVO> readboardList();
	/*
	 * 입력변수 : 리스트 불러오기에는 따로 입력 값을 받읋 필요가 없다. 리턴 값: 뿌려줄 게시물 리스트
	 */

	// 게시물 올리기
	public int insertBoard(BoardVO boardVO);
	/*
	 * 입력변수 : 클라이언트가 입력한 게시글(type BoardVO) 리턴 값: int 성공여부(0은 실패/1은 성공)
	 */

	// 게시글 상세 보기
	public BoardVO readBoardContents(int boardnum);

	// 게시물 수정하기
	public int updatBoard(BoardVO boardVO);

	// 작성자 이름 불러오기
	public MemberVO readMemberInfo(int boardnum);

	// 댓글 insert
	public int insertComment(CommentVO commentVO);
	
	// 댓글 리스트 read
	public List<CommentVO> readCommentList(int boardnum);
	
	// 댓글 하나 read
	public CommentVO readComment(int commentId);
	
	// 댓글 update
	public int updateComment(CommentVO commentVO);
	
	// 게시판 글쓴이 댓글 read
	public CommentVO readBoardWriterComment(int boardnum);
}
