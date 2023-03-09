package co.yedam.silhyun.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.mypage.map.PointMapper;
import co.yedam.silhyun.mypage.vo.PointVO;

@Service
public class PointServiceImpl implements PointService {

	@Autowired PointMapper map;
	
	@Override
	public int pointInsert(PointVO vo) {
		// TODO Auto-generated method stub
		return map.pointInsert(vo);
	}

	@Override
	public int pointDelete(PointVO vo) {
		// TODO Auto-generated method stub
		return map.pointDelete(vo);    
	}

	@Override
	public int pointSumUpdate(PointVO vo) {
		// TODO Auto-generated method stub
		return map.pointSumDelete(vo);
	}

}
