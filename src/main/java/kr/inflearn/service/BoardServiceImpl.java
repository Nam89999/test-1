package kr.inflearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.model.BoardVO;
@Service
public class BoardServiceImpl implements BoardService{
	
	//Service 단에서는 DB와 연결하는 Boardmapper가 필요하다.
	@Autowired
	private BoardMapper mapper; //DI(의존성 주입) Spring Container에 자동으로 객체가 들어가 있고 그 내용을 @Autowired을 통해 자동 주입

	@Override
	public List<BoardVO> getList() {
 
		return mapper.getList() ;
	}

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
		mapper.insert(board);
	}

	@Override
	public BoardVO get(int bno,String mode) {
		if(mode.equals("get")) {
		mapper.count(bno);
		}
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board);
	}

}
