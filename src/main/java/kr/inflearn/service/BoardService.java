package kr.inflearn.service;

import java.util.List;

import kr.inflearn.model.BoardVO;

public interface BoardService {
	//서비스 annotation을 여기에 안해주는 이유?
	
	//게시판 리스트 불러오기
	public List<BoardVO> getBoardList();
	
	//게시판 올리기
	public int registerBoard(BoardVO boardVO);

	//게시물 상세보기
	public BoardVO getBoard(int boardnum);

	//게시물 수정하기
	public int modifyBoard(BoardVO boardVO);

}
