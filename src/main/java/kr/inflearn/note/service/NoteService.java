package kr.inflearn.note.service;

import java.util.List;

import kr.inflearn.note.model.NoteVO;

public interface NoteService {
	
	
	//수신자 id 받아서 쪽지 목록 불러오기
	public List<NoteVO> readNoteList(int recipientNum);
	
	//쪽지 발송 insert
	public String sendNote(NoteVO noteVO);
	
	//쪽지 상세보기 
	public NoteVO readNoteContent(int noteId);
	
	//쪽지 수신 확인
	public int checkNote(int noteId); 

}
