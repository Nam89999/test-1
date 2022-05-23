package kr.inflearn.member.service;

import java.sql.SQLDataException;
import java.util.List;

import javax.xml.ws.http.HTTPException;

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

		List<MemberVO> list = memberMapper.memberList();

		return list;
	}

	@Override
	public int memberRegister(MemberVO mvo) {

		int cnt = memberMapper.register(mvo);

		return cnt;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		MemberVO member = memberMapper.login(mvo);

		return member;
	}

	@Override
	public MemberVO memberContent(int num) {
		try {
			return memberMapper.readmember(num);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int memberUpdate(MemberVO memberVO) {
		try {
			return memberMapper.updatemember(memberVO); 
			//과거int cnt = memberMapper.updatemember(memberVO); 4바이트
		} catch (Exception e) {
			return 0;
		}
	}

}
