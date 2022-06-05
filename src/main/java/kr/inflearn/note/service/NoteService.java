package kr.inflearn.note.service;

import java.util.List;

import kr.inflearn.note.model.NoteVO;

public interface NoteService {
	
	
	//수신자 id 받아서 쪽지 목록 불러오기
	public List<NoteVO> readNoteList(int recipientNum);

}
