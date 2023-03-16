package co.yedam.silhyun.mypage.service;

import java.util.List;

import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.mypage.vo.ScheduleVO;

public interface MypageUserService {
	List<ScheduleVO> getScheduleList(); //스케쥴 조회
	
	int scheduleInsert(ScheduleVO vo);//스케쥴 입력
	
	List<CouponHistoryVO> selectMyCoupon(String id);	//내 쿠폰 조회
}
