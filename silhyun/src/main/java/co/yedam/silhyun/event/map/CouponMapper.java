package co.yedam.silhyun.event.map;

import java.util.List;

import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.event.vo.CouponVO;

public interface CouponMapper {
	
	 List<CouponVO> couponSelectList();//전체
	 String insertCoupon(CouponHistoryVO vo); 		//쿠폰 히스토리 삽입
}
