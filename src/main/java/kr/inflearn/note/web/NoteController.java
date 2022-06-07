package kr.inflearn.note.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inflearn.member.model.MemberVO;
import kr.inflearn.member.service.MemberService;
import kr.inflearn.note.model.NoteVO;
import kr.inflearn.note.service.NoteService;

@Controller
public class NoteController {

	@Autowired
	public NoteService noteService;

	@Autowired
	public MemberService memberService;

	// 쪽지 목록 불러오기
	@RequestMapping(value = "/notebox.do", method = RequestMethod.GET)
	public String readNoteList(Model model, HttpSession session) {

		// 수신자id로 쪽지함 구분
		int recipientNum = (int) session.getAttribute("memberNum");

		// service 호출
		List<NoteVO> noteList = noteService.readNoteList(recipientNum);

		// 객체 바인딩
		model.addAttribute("noteList", noteList);

		return "note/noteList";
	}

	// 쪽지 보내기 페이지 이동
	@RequestMapping(value = "/writeNote.do", method = RequestMethod.GET)
	public String sendNoteGET(Model model, HttpSession session) {

		try {
			int memberNum = (int) session.getAttribute("memberNum");
			MemberVO senderInfo = memberService.memberContent(memberNum);
			model.addAttribute("senderMemberId", senderInfo.getId());
			session.setAttribute("memberNum", memberNum);

			return "note/writeNote";

		} catch (Exception e) {

			return "home";
		}
	}

	// 쪽지 보내기 POST
	@RequestMapping(value = "/writeNote.do", method = RequestMethod.POST)
	@ResponseBody
	public String sendNotePOST(NoteVO noteVO, Model model, HttpSession session) {

		try {
			int memberNum = (int) session.getAttribute("memberNum");
			// 발신자 번호
			noteVO.setSenderNum(memberNum);
			// 발신자 ID
			MemberVO SenderInfo = memberService.memberContent(memberNum);
			noteVO.setSenderMember(SenderInfo.getId());

			// 수신자 번호
			noteVO.getRecipientMember();
			MemberVO RecipientInfo = memberService.RecipientInfo(noteVO.getRecipientMember());
			noteVO.setRecipientNum(RecipientInfo.getNum()); 
			System.out.println("쪽지 보내기 POST:" + noteVO);

			String result = noteService.sendNote(noteVO);

			return result;

		} catch (Exception e) {

			return "fail";
		}
	}
	
	
	// 쪽지 상세보기 GET
	@RequestMapping(value = "/noteContent.do", method = RequestMethod.GET)
	public String noteContent (@RequestParam("noticeNo") int noteId, Model model, HttpSession session) {
		
		try {
		int memberNum = (int) session.getAttribute("memberNum");
		
		NoteVO noteContent=noteService.readNoteContent(noteId);
		
		if (noteContent==null) {
			
			return "home";
			
		}
		//쪽지 수신 확인 값 변경해주기
		int noteCheck=noteService.checkNote(noteId);
						
		if(noteCheck>0) {//수신 확인 처리 되었으면
			System.out.println("noteContent:"+noteContent.getReadCheck());//질문 : 왜 0으로 나오나?
			noteContent.setReadCheck(1);//질문 : 어쩌피 여기서 수신확인을 하지않으니 넣어줄 필요가 없나?
		}
		
		//senderId 아이디 담기
	    MemberVO senderInfo= memberService.memberContent(noteContent.getSenderNum());
	    noteContent.setSenderMember(senderInfo.getId());
	    
		System.out.println("noteContent-상세보기:"+noteContent);
		
		model.addAttribute("noteContent", noteContent);
		
		return "note/noteContent";

		}catch (Exception e) {

		
			return "home";
		}
		
		
	}
}
