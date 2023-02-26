package co.yedam.silhyun.member.map;

import java.util.List;

import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

public interface AdminMapper {

	List<MemberVO> memberList();
	 
	List<PhotographerVO> ptgList();
	
	List<StudioVO> stdList();

	MemberVO adminInfo();
	
	List<QuitVO> qtList();
}
