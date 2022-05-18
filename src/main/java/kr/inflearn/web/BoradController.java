package kr.inflearn.web;

import java.util.List;

import javax.management.AttributeValueExp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;

@Controller
public class BoradController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<BoardVO> list=service.getList();
		model.addAttribute("list",list);
		return "board/boardList"; //boardList.jsp
	}
	
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	//@GetMapping("/register.do")
	public String registerGET() {
		
		
		return "board/register";// register.jsp(게시물 등록화면)
		
		
	}
	
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	//@PostMapping("/register.do")
	public String registerPOST(BoardVO board) {//게시물 등록(파라미터는 BoardVO(title,contents,writer)
		
		service.register(board);//게시물 등록
	
		
		return "redirect:/list.do";//게시물 보기	
	}
	
	
	//게시물 상세 조회
	@RequestMapping(value="/get.do")
	public String get(@RequestParam("bno") int bno,Model model) {
		
		BoardVO board2=service.get(bno,"get");
		model.addAttribute("board",board2);
		//model.addAttribut("board",board2.getTitle()); 왜 안돌아가?
		return "board/get";// get.jsp
	}
	
	
	//게시물 수정 페이지 이동
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public String modifyGet(@RequestParam("bno") int bno,Model model) {
				
		BoardVO board2=service.get(bno,"modify");
		model.addAttribute("board",board2);
		
		return "board/modify"; // modify.jsp
	}
	
	
	//게시물 수정 
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board2) {
				
		int cnt=service.modify(board2);
		
		return "redirect:/list.do"; // modify.jsp
	}
	
	
	//게시물 삭제
	@RequestMapping(value="/remove.do")
	public String remove(@RequestParam("bno") int bno) {
		
		int cnt=service.remove(bno);
		
		return "redirect:/list.do";
	}
	
	
	
	
}

/*
  /list.do--->get ---->list()
  /register.do--->post ----> register()
  /read.do    --->get  ----> read()
  /remove.do  --->get  ----> remove()
  /modify.do  --->post ----> modify() 
  
 */
