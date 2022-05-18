package kr.inflearn.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.member.mapper.MemberMapper;
import kr.inflearn.member.model.MemberVO;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	public MemberMapper memberMapper; 
	
	
	@Override
	public List<MemberVO> memberList() {

		List<MemberVO> list=memberMapper.memberList();
		
		return list;
	}


	@Override
	public int memberRegister(MemberVO mvo) {
		
		int cnt=memberMapper.register(mvo);
		
		return cnt;
	}


	@Override
	public MemberVO login(MemberVO mvo) {
		MemberVO member=memberMapper.login(mvo);
		
		return member;
	}



	@Override
	public MemberVO memberContent(int num) {
		MemberVO member=memberMapper.readmember(num);
		
		return member;
	}


	@Override
	public int memberUpdate(MemberVO memberVO) {
		
		int cnt=memberMapper.updatemember(memberVO);
		
		return cnt;
	}

}
