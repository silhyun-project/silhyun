package co.yedam.silhyun.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
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
	public List<MemberVO> getPhotoinfo(String ptgId){
		
		return mypageAoMapper.getPhotoinfo(ptgId);
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

	@Override
	public int applyClass(ClassesVO vo) {

		return mypageAoMapper.applyClass(vo);
	}

	@Override
	public int insertOption(OptionsVO vo) {
		// TODO Auto-generated method stub
		return mypageAoMapper.insertOption(vo);
	}

	
	  @Override public int updateReserTime(ReserTimeVO vo) {
	  
	  return mypageAoMapper.updateReserTime(vo);
	  }
	 


	@Override
	public int updateReserTime(List<ReserTimeVO> voList) {
		return mypageAoMapper.updateReserTime(voList);
	}


	@Override
	public int insertReserTime(ReserTimeVO vo) {
		
		return mypageAoMapper.insertReserTime(vo);
	}

	@Override
	public int deleteReserTime(String id) {
		// TODO Auto-generated method stub
		return mypageAoMapper.deleteReserTime(id);
	}

	

	@Override
	public MemberVO ptgSelect(MemberVO vo) {

		return mypageAoMapper.ptgSelect(vo);
	}

	@Override
	public List<ClassesVO> classList() {

		return mypageAoMapper.classList();

	}

	@Override
	public List<PhotographerVO> getPtg(String ptgId) {

		return mypageAoMapper.getPtg(ptgId);
	}

	@Override
	public List<PhotographerVO> getResTime(String ptgId, String redate) {

		return mypageAoMapper.getResTime(ptgId, redate);
	}



}
