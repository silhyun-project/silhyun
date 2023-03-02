package co.yedam.silhyun.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.mypage.map.MypageAoMapper;
import co.yedam.silhyun.order.vo.ReserVO;

@Service
public class MypageAoServiceImpl implements MypageAoService {
	
	@Autowired
	private MypageAoMapper mypageAoMapper;
	
	@Override
	public List<ReserVO> getReserList(){
		
		return mypageAoMapper.getReserList();
	}
	
	@Override
	public List<MemberVO> getPhotoinfo(){
		
		return mypageAoMapper.getPhotoinfo();
	}

	@Override
	public int ptgInfoUpdate(PhotographerVO vo) {
	
		return mypageAoMapper.ptgInfoUpdate(vo);
	}
	@Override
	public int applyEvent(EventVO vo) {
		
		return mypageAoMapper.applyEvent(vo);
	}
	
	@Override
	public int applyECoupon(CouponVO vo) {
		
		return mypageAoMapper.applyECoupon(vo);
	}
}
