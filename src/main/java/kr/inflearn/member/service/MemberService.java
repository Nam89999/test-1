package kr.inflearn.member.service;

import java.util.List;

import kr.inflearn.member.mapper.MemberMapper;
import kr.inflearn.member.model.MemberVO;

public interface MemberService {
	
	//회원 리스트
	public List<MemberVO> memberList();
	//회원 가입
	public int memberRegister(MemberVO memberVO);
	//로그인
	public MemberVO login(MemberVO memberVO);
	
	//개인 회원 정보 보기
	public MemberVO memberContent(int num);
	
	//회원정보 수정
	public int memberUpdate(MemberVO memberVO);
	
	public MemberVO RecipientInfo(String id);
 
	
	
}
