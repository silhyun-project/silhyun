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
	
	//=======================종합승인관리
	//승인신청 카운트
	Map<String, Object> countNeedCfm();
	
	
	//기록가 승인관리
	List<Map<String, Object>> ptgCfmList();
	
	//기록가 승인상세정보
	Map<String, Object> ptgSelect(String ptgId);
	
	//기록가 승인신청 승인
	int ptgAccept(String ptgId);
	
	//기록가 승인신청 반려
	int noPtgAccept(String ptgId);
	
	
	//사진관 =========================================
	//사진관 승인관리
	List<Map<String, Object>> stdCfmList();
	
	//사진관 승인상세정보
	Map<String, Object> stdSelect(String stId);
	
	//사진관 승인신청 승인
	int stdAccept(String stId);
	
	//사진관 승인신청 반려
	int noStdAccept(String stId);
	
	//클래스 =================================================
	
	//클래스 승인관리
	List<Map<String, Object>> classCfmList();
	
	//클래스 승인상세정보
	Map<String, Object> classSelect(String classNum);
	
	//클래스 승인신청 승인
	int classAccept(String classNum);
	
	//클래스 승인신청 반려
	int noClassAccept(String classNum);
	
	
	//이벤트 ========================================================
	
	
	
	//이벤트 승인신청 승인
	int eventAccept(String eventNum);
	
	//이벤트 승인신청 반려
	int noEventAccept(String eventNum);
	
	
	
	
	List<MemberVO> memberList();
	
	List<PhotographerVO> ptgList();
	
	List<StudioVO> stdList();
	

	MemberVO adminInfo();

	List<QuitVO> qtList();
	
	List<PhotographerVO> belongPtg(String stId);
	
	
	List<MemberVO> todayMem();
	
	List<MemberVO> todayPtg();
	
	List<MemberVO> todayStd();
	
	int disableMember(String id);

	int ableMember(String id);

	//그래프
	
	List<Map<String, String>> quitGraph();
	
	//rank
	
	List<Map<String, String>> ptgGraph();
	
	List<Map<String, Object>> ptgRank();
	
	List<Map<String, Object>> classRank();
	
	
	List<Map<String, Object>> getListQuit(AdminCriteria cri);
	
	int getTotalQuit(AdminCriteria cri);
	

	//수정
	int updateAdmin(MemberVO vo);
	
	int updateMember(MemberVO vo);
	
	//회원리스트 페이징
	List<MemberVO> getListMember(AdminCriteria cri);
	
	int getTotalCount(AdminCriteria cri);
	
	//작가리스트 페이징
	List<PhotographerVO> getListPtg(AdminCriteria cri2);
	
	int getTotalPtg(AdminCriteria cri2);
	
	//사진관리스트 페이징
	List<StudioVO> getListStd(AdminCriteria cri3);
	
	int getTotalStd(AdminCriteria cri3);
	
	//이벤트리스트 페이징
	List<EventVO> getListEvent(AdminCriteria cri);
	
	int getTotalEvent(AdminCriteria cri);
	
	
	//이벤트리스트
	List<Map<String, Object>>getEventList();
	
	List<Map<String, Object>>getEventAllList();
	
	List<Map<String, Object>>getEventOList();
	
	//이벤트 카운트
	Map<String, String> getEventCnt();
	
	//이벤트 상세정보
	EventVO getEventContent(String eventNum);
	
	//이벤트추가
	int addAdminEvent(EventVO vo);

}
