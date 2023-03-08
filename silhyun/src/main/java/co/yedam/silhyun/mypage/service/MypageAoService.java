package co.yedam.silhyun.mypage.service;

import java.util.List;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
import co.yedam.silhyun.order.vo.ReserVO;

public interface MypageAoService {
	List<ReserVO> getReserList();//전체조회
	List<MemberVO> getPhotoinfo(); //포토그래퍼 조회
	int ptgInfoUpdate(PhotographerVO vo);	//정보 업데이트
	
	int applyEvent(EventVO vo);	//이벤트 신청
	int applyECoupon(CouponVO vo);	//이벤트 신청 쿠폰부분
	int applyClass(ClassesVO vo); 	//클래스 신청
	int insertOption(OptionsVO vo);	//작가 옵션설정
	
	int updateReserTime(List<ReserTimeVO> voList);	//작가 예약시간 수정설정
	int updateReserTime(ReserTimeVO vo);	//작가 예약시간 수정

	int deleteReserTime(String id);	// 작가 예약시간정보 삭제
	int insertReserTime(ReserTimeVO vo );	//작가 예약시간 정보 삽입
	
	int updateProfileImage(MemberVO vo);//프사 바꾸기

	
}
