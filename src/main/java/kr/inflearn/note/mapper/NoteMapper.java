package kr.inflearn.note.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.note.model.NoteVO;

@Mapper
public interface NoteMapper {
	
	//쪽지 목록 조회 read
	public List<NoteVO> readNoteList(int recipientNum);
	
	//쪽지 보내기 insert
	public int insertNote(NoteVO noteVO);
	
	//쪽지 상세보기  read
	public NoteVO readNoteContent(int noteId);
	
	//쪽지 읽음 표시
	//읽으면 쪽지 목록에서 수신확인이라는 글을 띄운다.
	//상세보기를 할 때 메시지를 읽지 않은 메시지들을 읽음으로 바꾼다.
	public int updateReadCheck(int noteId);
}
