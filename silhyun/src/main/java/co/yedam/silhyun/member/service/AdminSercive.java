package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

public interface AdminSercive {

	List<MemberVO> memberList();
	
	List<PhotographerVO> ptgList();
	
	List<StudioVO> stdList();
	

	MemberVO adminInfo();

	List<QuitVO> qtList();
	
	List<PhotographerVO> belongPtg(String stId);
	
	
	List<MemberVO> todayMem();
	
	List<MemberVO> todayPtg();
	
	List<MemberVO> todayStd();
	
	int deleteMember(String id);
	

	//탈퇴
	int insertQuitMember(String id);
	
	List<Map<String, String>> quitGraph();
	
	List<QuitVO> getListQuit(Criteria cri);
	
	int getTotalQuit(Criteria cri);
	
	int deleteQMember(String id);
	

	//수정
	int updateAdmin(MemberVO vo);
	
	int updateMember(MemberVO vo);
	
	//회원리스트 페이징
	List<MemberVO> getListMember(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	//작가리스트 페이징
	List<PhotographerVO> getListPtg(Criteria cri);
	
	int getTotalPtg(Criteria cri);

}
