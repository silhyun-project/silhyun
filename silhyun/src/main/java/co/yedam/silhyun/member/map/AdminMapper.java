package co.yedam.silhyun.member.map;

import java.util.List;

import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;

public interface AdminMapper {

	List<MemberVO> memberList();
	 
	List<PhotographerVO> ptgList();
	
	List<StudioVO> stdList();
}
