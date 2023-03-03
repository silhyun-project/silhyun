package co.yedam.silhyun.member.map;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.common.vo.Criteria;
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
	
	List<PhotographerVO> belongPtg(String stId);
	
	List<MemberVO> todayMem();
	
	List<MemberVO> todayPtg();
	
	List<MemberVO> todayStd();
	
	int deleteMember(String id);

	int insertQuitMember(String id);
	
	//그래프

	
	List<Map<String, String>> quitGraph();
	
	int deleteQMember(String id);
	
	List<QuitVO> getListQuit(Criteria cri);
	
	int getTotalQuit(Criteria cri);
	
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
