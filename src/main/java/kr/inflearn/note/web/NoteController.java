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

import kr.inflearn.note.model.NoteVO;
import kr.inflearn.note.service.NoteService;

@Controller
public class NoteController {
	
	@Autowired
	public NoteService noteService;
	
	
	//쪽지 목록 불러오기
	@RequestMapping(value="/notebox.do", method = RequestMethod.GET)
	public String readNoteList(Model model,HttpSession session){
		
		//수신자id로 쪽지함 구분
		int recipientNum=(int)session.getAttribute("memberNum");
		
		//service 호출
		List<NoteVO> noteList=noteService.readNoteList(recipientNum);
		
		//객체 바인딩
		model.addAttribute("noteList", noteList);
		
		return "note/noteList";
	}

}
