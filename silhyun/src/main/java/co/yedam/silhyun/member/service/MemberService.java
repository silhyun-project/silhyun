package co.yedam.silhyun.member.service;

import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;

public interface MemberService {
	MemberVO memeberSelect(MemberVO vo); //로그인(멤버단건조회)
	
	int memberInsert(MemberVO vo); //회원가입
	boolean isidCheck(MemberVO vo); //중복검사 
}
