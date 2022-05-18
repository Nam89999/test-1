package kr.inflearn.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.member.model.MemberVO;
@Mapper
public interface MemberMapper {
	
	//회원 로그인 (read)
	public MemberVO login(MemberVO mvo);//memberVO를 안써도 되는 이유
	//회원 가입 (insert)
	public int register(MemberVO mvo);

	//회원 전체 검색 (read)
	public List<MemberVO> memberList();
	
	//회원 상세정보 보기(read)
	public MemberVO readmember(int num);
	
	//회원 수정 (update)
	public int updatemember(MemberVO mvo);
	
}

	
