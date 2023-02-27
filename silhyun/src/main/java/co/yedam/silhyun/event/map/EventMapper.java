package co.yedam.silhyun.event.map;

import java.util.List;

import co.yedam.silhyun.event.vo.EventVO;

public interface EventMapper {

	List<EventVO> getEventList();	//전체
	List<EventVO> getBannerList(); 	//배너리스트
}