package co.yedam.silhyun.member.service;

import java.util.List;

import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

public interface AdminSercive {

	List<MemberVO> memberList();
	
	List<PhotographerVO> ptgList();
	
	List<StudioVO> stdList();
	
	List<QuitVO> qtList();
}
