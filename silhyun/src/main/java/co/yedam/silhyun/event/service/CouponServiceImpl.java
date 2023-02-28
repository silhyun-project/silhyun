package co.yedam.silhyun.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.yedam.silhyun.event.map.CouponMapper;
import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.event.vo.CouponVO;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponMapper couponMapper;
	
	@Override
	public List<CouponVO> couponSelectList(){ // 전체조회
		
		return couponMapper.couponSelectList();
	}

	@Override
	public String insertCoupon(CouponHistoryVO hvo) {
		
		return couponMapper.insertCoupon(hvo);
	}
}
