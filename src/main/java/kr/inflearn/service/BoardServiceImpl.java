package kr.inflearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	// 서비스단에서 메서드 이름은 현실적인 로직의 이름을 명명
	// get(검색), 리스트 불러오기(getList) 등록 (register), 수정 (modify), 삭제(remove),

	@Autowired
	public BoardMapper boardMapper;
	// 객체 생성 사용할 수 있게 만든것?
	// 오버라이드 안써도 잘동작하는데 왜 오버라이드를 써주나? 오버라이드는 덮어쓰기라는 의미?

	// 게시물 리스트 불러오기
	@Override
	public List<BoardVO> getBoardList() {

		List<BoardVO> boardList = boardMapper.readboardList();

		return boardList;
	}

	// 게시물 올리기
	@Override
	public int registerBoard(BoardVO boardVO) {

		int cnt = boardMapper.insertBoard(boardVO);

		return cnt;
	}

	//게시물 상세보기
	@Override
	public BoardVO getBoard(int boardnum) {
		
		
	
		return boardMapper.readBoardContents(boardnum);
		
		}//예외처리하는 법

	
	//게시물 수정하기
	@Override
	public int modifyBoard(BoardVO boardVO) {
		
		int result=boardMapper.updatBoard(boardVO);
		
		return result;
	}
	
	
	

}
