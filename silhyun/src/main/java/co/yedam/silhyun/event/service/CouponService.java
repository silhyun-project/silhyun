package co.yedam.silhyun.event.service;

import java.util.List;

import org.springframework.ui.Model;

import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.event.vo.CouponVO;

public interface CouponService {
	List<CouponVO> couponSelectList(); // 전체조회
	int insertCoupon(CouponHistoryVO hvo); 		//쿠폰 히스토리 삽입
	
}
