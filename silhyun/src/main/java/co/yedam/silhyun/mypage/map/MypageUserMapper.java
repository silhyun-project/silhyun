package co.yedam.silhyun.mypage.map;

import java.util.List;

import co.yedam.silhyun.mypage.vo.ScheduleVO;

public interface MypageUserMapper {
	List<ScheduleVO> getScheduleList(); //스케쥴 조회
	
	int scheduleInsert();//스케쥴 입력
	
	
}
