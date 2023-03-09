package co.yedam.silhyun.mypage.map;

import co.yedam.silhyun.mypage.vo.PointVO;

public interface PointMapper {
	int pointInsert(PointVO vo);
	int pointDelete(PointVO vo);
	int pointSumUpdate (PointVO vo);
}
