package co.yedam.silhyun.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.AdminMapper;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;


@Service
public class AdminServiceImpl implements AdminSercive {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public List<MemberVO> memberList(){
		return adminMapper.memberList();
	}

	@Override
	public List<PhotographerVO> ptgList() {
		return adminMapper.ptgList();
	}

	@Override
	public List<StudioVO> stdList() {
		// TODO Auto-generated method stub
		return adminMapper.stdList();
	}
	
}
