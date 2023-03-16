package co.yedam.silhyun.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.mypage.map.MypageUserMapper;
import co.yedam.silhyun.mypage.vo.ScheduleVO;

@Service
public class MypageUserServiceImpl implements MypageUserService{
	@Autowired MypageUserMapper mapper;
	
	@Override
	public List<ScheduleVO> getScheduleList() {
		// TODO Auto-generated method stub
		return mapper.getScheduleList();
	}

	@Override
	public int scheduleInsert(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return mapper.scheduleInsert();
	}

	@Override
	public List<CouponHistoryVO> selectMyCoupon(String id) {
		
		return mapper.selectMyCoupon(id);
	}

}
