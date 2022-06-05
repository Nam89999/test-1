package kr.inflearn.note.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.note.model.NoteVO;

@Mapper
public interface NoteMapper {
	
	//쪽지 목록 조회
	public List<NoteVO> readNoteList(int recipientNum);

}
