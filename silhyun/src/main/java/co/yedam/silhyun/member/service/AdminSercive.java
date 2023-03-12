package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

public interface AdminSercive {

	
	
	//대쉬보드
	//승인 대기 count
	Map<String, Object> cfmCnt();
	
	//문의 처리대기 count
	int qstCnt();
	
	//지난 2주간 매출
	List<Map<String, Object>> lastSales();
	
	//최신 댓글 3
	List<Map<String, Object>> recentCom();
	
	//최신 결제 5
	List<Map<String, Object>> recentBuy();
	
	//최신 가입 5
	List<MemberVO> recentJoin();
	
	
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
	
	//그래프
	
	List<Map<String, String>> quitGraph();
	
	//rank
	
	List<Map<String, String>> ptgGraph();
	
	List<Map<String, Object>> ptgRank();
	
	List<Map<String, Object>> classRank();
	
	
	List<QuitVO> getListQuit(AdminCriteria cri);
	
	int getTotalQuit(AdminCriteria cri);
	
	int deleteQMember(String id);
	

	//수정
	int updateAdmin(MemberVO vo);
	
	int updateMember(MemberVO vo);
	
	//회원리스트 페이징
	List<MemberVO> getListMember(AdminCriteria cri);
	
	int getTotalCount(AdminCriteria cri);
	
	//작가리스트 페이징
	List<PhotographerVO> getListPtg(AdminCriteria cri);
	
	int getTotalPtg(AdminCriteria cri);
	
	
	//이벤트리스트
	List<Map<String, Object>>getEventList();
	
	List<Map<String, Object>>getEventAllList();
	
	//이벤트 카운트
	Map<String, String> getEventCnt();
	
	//이벤트 상세정보
	EventVO getEventContent(String eventNum);

}
