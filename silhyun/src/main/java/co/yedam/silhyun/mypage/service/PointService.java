package co.yedam.silhyun.mypage.service;

import co.yedam.silhyun.mypage.vo.PointVO;

public interface PointService {
	int pointInsert(PointVO vo);
	int pointDelete(PointVO vo);   //사용포인트vo를 사용
	int pointSumUpdate (PointVO vo); 
}
