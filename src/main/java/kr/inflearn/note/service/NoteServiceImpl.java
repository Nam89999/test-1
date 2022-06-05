package kr.inflearn.note.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.member.mapper.MemberMapper;
import kr.inflearn.member.model.MemberVO;
import kr.inflearn.note.mapper.NoteMapper;
import kr.inflearn.note.model.NoteVO;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	public NoteMapper noteMapper;
	
	@Autowired
	public MemberMapper memberMapper;
	
	
	//수신인 id로 댓글 리스트 불러오기
	@Override
	public List<NoteVO> readNoteList(int recipientNum) {
		
		//mapper를 호출
		List<NoteVO> noteList=noteMapper.readNoteList(recipientNum);
		
		//쪽지마다 발송인 id 받아오기 
		for(int i=0; i < noteList.size(); i++) {
			//i=0;
			//발송자(num)으로 받아온다.
			//num으로 아이디를 찾아온다.
			MemberVO senderInfo=memberMapper.readmember(noteList.get(i).getSenderNum());
			String senderMemberId=senderInfo.getId();
			
			noteList.get(i).setSenderMember(senderMemberId);	
		}
		
		return noteList;
	}

}
