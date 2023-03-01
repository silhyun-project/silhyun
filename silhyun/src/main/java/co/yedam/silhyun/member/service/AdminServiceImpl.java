package co.yedam.silhyun.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.AdminMapper;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;


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
		return adminMapper.stdList();
	}

	@Override
	public MemberVO adminInfo() {
		return adminMapper.adminInfo();
	}
	
	public List<QuitVO> qtList() {
		return adminMapper.qtList();
	}

	@Override
	public List<MemberVO> todayMem() {
		return adminMapper.todayMem();
	}

	@Override
	public List<MemberVO> todayPtg() {
		return adminMapper.todayPtg();
	}

	@Override
	public List<MemberVO> todayStd() {
		return adminMapper.todayStd();
	}

	@Override
	public int deleteMember(String id) {
		return adminMapper.deleteMember(id);
	}

	@Override
	public int insertQuitMember(String id) {
		return adminMapper.insertQuitMember(id);
	}
	
}
