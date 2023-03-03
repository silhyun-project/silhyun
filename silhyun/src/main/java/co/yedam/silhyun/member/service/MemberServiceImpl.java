package co.yedam.silhyun.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.MemberMapper;
import co.yedam.silhyun.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberMapper map;

	@Override
	public MemberVO memeberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memeberSelect(vo);
	}
	

}
