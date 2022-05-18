package kr.inflearn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.model.BoardVO;

//영속계층 
@Mapper
public interface BoardMapper {
	
	//게시판 목록 불러오기
	public List<BoardVO> getList();
	//게시물 등록
	public void insert(BoardVO board);
	//게시물 상세보기
	public BoardVO read(int bno);
	//게시물 삭제
	public int delete(int bno);
	//게시물 수정
	public int update(BoardVO board);
	// 조회수 증가
	public int count(int bno);
	
	//xml mapper file 연동
	//api 추가해서 annotation 생성

}
