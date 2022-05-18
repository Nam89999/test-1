package kr.inflearn.member.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.inflearn.member.model.MemberVO;
import kr.inflearn.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	public MemberService memberService;

	// 홈으로 이동 (확인)
	@RequestMapping("/home.do")
	public String home() {

		return "home";
	}

	// 회원 리스트보기 (확인)
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {

		List<MemberVO> list = memberService.memberList();
		model.addAttribute("memberList", list);
	

		return "member/memberList"; // webapp/views/ (+) member/memberList (+) .jsp

	}

	// 회원 가입 페이지 이동 (확인)
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String memberRegister() {

		return "member/memberRegister";

	}

	// 회원 가입로직 (확인)
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	@ResponseBody
	public String memberRegister(MemberVO memberVO, Model model) {

		int cnt = memberService.memberRegister(memberVO);
		// 회원가입 실패 했을 경우나 성공했을 경우 다른 페이지로 보내거나 회원가입을 축하한다고 메시지를 띄우고 싶은데 안되나?
		//=>ajax 처리로 해결
		model.addAttribute("data",cnt);

		return null;
		//return "redirect:/login.do";

	}

	// 로그인 페이지 이동 (확인)
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginGET() {

		/*
		 * @RequestParam Map<String, String> param+
		 * 
		 * for (String key : param.keySet()) {
			System.out.println("key : " + key + ", value : " + param.get(key));
		}
		url로 넘어오는 parm를 잘받을 수 있다.
		*/
		return "member/memberLogin";
	}

	// 회원 로그인 (확인)
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginPOST(Model model, MemberVO memberVO, HttpSession session) {

		MemberVO member = memberService.login(memberVO);

		System.out.println(member);
		
		
		int num=member.getNum();
		//String name = member.getName(); //?
		//System.out.println(name);

		if (member == null) {

			return "redirect:/login.do"; // 페이지로 리다이렉트 시켜도 되고, url로 보내도 되는지? 그리고 된다면 그차이?

			
			//return null;
		} else {
			
			session.setAttribute("memberInfo", num);
			//session.setAttribute("memberInfo", member);
			model.addAttribute("member", member); //의미가 없음
			System.out.println(member);
			
			return "home";
		} // else 밖에 return을 안써도 되는지 쓴다면 이유는?

	}

	// 로그아웃 (확인)
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/home.do";
	}

	// 회원 상세보기 페이지
	@RequestMapping("/readMember.do")
	public String memberContent(Model model, HttpSession session) {
		
		//MemberVO member = (MemberVO) session.getAttribute("memberInfo");

		int num = (int) session.getAttribute("memberInfo");

		MemberVO m = memberService.memberContent(num); // 서비스를 호출해서 요청을 보내주고 응답을 받아온다.

		System.out.println("회원 상세보기 페이지:" + m);

		model.addAttribute("ContentInfo", m); // 모델에 바인딩한 후 뿌려준다.(세션에 있으니깐 뿌려줄 바인딩을 해줄 필요가 없는가?)

		return "member/memberContent";
	}

	// 회원 수정 페이지로 이동
	@RequestMapping(value = "/memberModify.do", method = RequestMethod.GET)
	public String memberModify(int num, Model model) {

		MemberVO memberInfo = memberService.memberContent(num);

		model.addAttribute("memberInfo", memberInfo);

		return "member/memberModify";
	}

	// 회원 수정 로직
	@RequestMapping(value = "/memberModify.do", method = RequestMethod.POST)
	public String memberUpdatePOST(MemberVO memberVO) {

	//	MemberVO member = (MemberVO) session.getAttribute("memberInfo");

	//	memberVO.setNum(member.getNum());

		System.out.println("회원수정로직:" + memberVO);

		int cnt = memberService.memberUpdate(memberVO);
		// 회원 수정 로직에서 view단에 int num을 안보이게 받고 싶다.
		//=>seeion에 넘을 받아 놓고 사용하면 된다.(#session 파기 되지 않게 항상

		return "redirect:/home.do";
	}

}