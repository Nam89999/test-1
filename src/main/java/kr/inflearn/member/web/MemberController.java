package kr.inflearn.member.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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
	public String home(Model model, HttpSession session) {

		try {

			int num = (int) session.getAttribute("memberNum");
			MemberVO member = memberService.memberContent(num);

			model.addAttribute("name", member.getName());
		} catch (Exception e) {
		}
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
	public String memberRegisterGET() {

		return "member/memberRegister";

	}

	// 회원 가입로직 (확인)
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	@ResponseBody
	public String memberRegisterPOST(MemberVO memberVO, Model model) {

		int cnt = memberService.memberRegister(memberVO);

		return cnt > 0 ? "true" : "false";
		// 삼항연산자 cnt의 값이 0보다 크면 true를 0보다 작으면 false를 리턴해라

	}

//	// 로그인 페이지 이동 (확인)
//	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
//	public String loginGET(@RequestParam("msg") String msg, Model model) {
//		if (msg != null && !"".equals(msg)) {
//			model.addAttribute("msg", msg);
//		}
//		/*
//		 * @RequestParam Map<String, String> param+
//		 * 
//		 * for (String key : param.keySet()) { System.out.println("key : " + key +
//		 * ", value : " + param.get(key)); } url로 넘어오는 parm를 잘받을 수 있다.
//		 */
//		return "member/memberLogin";
//	}
	
	
	
	//로그인 페이지 이동
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginGET() {
		/*
		 * @RequestParam Map<String, String> param+
		 * 
		 * for (String key : param.keySet()) { System.out.println("key : " + key +
		 * ", value : " + param.get(key)); } url로 넘어오는 parm를 잘받을 수 있다.
		 */
		return "member/memberLogin";
	}

	// 회원 로그인 (확인)
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String loginPOST(Model model, MemberVO memberVO, HttpSession session) {

		MemberVO member = memberService.login(memberVO);

		System.out.println(member);

		if (member == null) {
			return "false";
		} else {
			int num = member.getNum(); // 회원 번호를 꺼내서 session 넣어준다.
			session.setAttribute("memberNum", num);

			String name = member.getName();
			model.addAttribute("name", name);
			System.out.println(name);

			return "true";
		}

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

		try {
			int num = (int) session.getAttribute("memberNum");// 세션에 memberinfo없으면 오류가 날 수 있어서 try catch

			MemberVO m = memberService.memberContent(num); // 서비스를 호출해서 요청을 보내주고 응답을 받아온다.

			session.setAttribute("memberNum", num);
			// System.out.println("회원 상세보기 페이지:" + m);

			model.addAttribute("ContentInfo", m); // 모델에 바인딩한 후 뿌려준다.

			return "member/memberContent";

		} catch (Exception e) {
			return "redirect:/home.do"; // url 타고 들어오는 애들을 걍 홈으로 보내버린다.
		}

	}

	// 회원 수정 페이지로 이동
	@RequestMapping(value = "/memberModify.do", method = RequestMethod.GET)
	public String memberModify(Model model, HttpSession session) {

		try {
			int num = (int) session.getAttribute("memberNum");// 세션에 memberinfo없으면 오류가 날 수 있어서 try catch

			MemberVO member = memberService.memberContent(num);

			model.addAttribute("memberInfo", member);
			session.setAttribute("memberNum", num); // 시간 초과로 세션이 파기 될수도 있으니 세션에 넣는 작업을 해준다.

			return "member/memberModify";

		} catch (Exception e) {
			return "redirect:/home.do"; // 질문 : url로 접속했는데 홈으로 가는 에러처리가 되지 않음.
		}
	}

	// 회원 수정 로직 POST
	@RequestMapping(value = "/memberModify.do", method = RequestMethod.POST)
	@ResponseBody
	public String memberUpdatePOST(MemberVO memberVO, HttpSession session) {

		// 질문 : int Num으로 맴버 업데이트를 실행하려면 어떻해야하는가?
		// 수정하는 정보를 받아서 SQL에서는 unique 값이 있는 id값으로 조건을 줘서 넣어줬음.

		int cnt = memberService.memberUpdate(memberVO);

		System.out.println("회원수정로직:" + memberVO);

		if (cnt == 0) { // 0이면 실패 '무조건 0or1'로 오는가?

			return "false";

		} else {// 실패가 아니라면

			return "true";
		}
	}

}