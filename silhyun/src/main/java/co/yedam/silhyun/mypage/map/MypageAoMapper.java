package co.yedam.silhyun.mypage.map;

import java.util.List;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.order.vo.ReserVO;

public interface MypageAoMapper {
	List<ReserVO> getReserList();//전체조회
	List<MemberVO> getPhotoinfo();//포토그래퍼 조회	
	int ptgInfoUpdate(PhotographerVO vo); //포토그래퍼 정보 업데이트
	
	int applyEvent(EventVO vo);	//이벤트 신청
	int applyECoupon(CouponVO vo);	//이벤트 신청 쿠폰부분
	int applyClass(ClassesVO vo); 	//클래스 신청
	int insertOption(OptionsVO vo);	//작가 옵션설정
}
