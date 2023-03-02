package co.yedam.silhyun.mypage.service;

import java.util.List;

import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.order.vo.ReserVO;

public interface MypageAoService {
	List<ReserVO> getReserList();//전체조회
	List<MemberVO> getPhotoinfo(); //포토그래퍼 조회
	int ptgInfoUpdate(PhotographerVO vo);	//정보 업데이트
	
	int applyEvent(EventVO vo);	//이벤트 신청
	int applyECoupon(CouponVO vo);	//이벤트 신청 쿠폰부분
}
