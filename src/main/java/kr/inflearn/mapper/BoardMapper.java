package kr.inflearn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.inflearn.comment.model.CommentVO;
import kr.inflearn.member.model.MemberVO;
import kr.inflearn.model.BoardVO;

@Mapper
public interface BoardMapper {

	// 게시판 목록 불러오기
	public List<BoardVO> readboardList();

	// 게시물 올리기
	public int insertBoard(BoardVO boardVO);

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
	
	// 게시판 글쓴이의 댓글 read
	public CommentVO readBoardWriterComment(int boardnum);
}
