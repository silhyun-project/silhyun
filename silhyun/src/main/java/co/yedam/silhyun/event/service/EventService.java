package co.yedam.silhyun.event.service;

import java.util.List;

import co.yedam.silhyun.event.vo.EventVO;

public interface EventService {
	List<EventVO> getEventList(); // 전체조회
	List<EventVO> getBannerList();//배너 전체조회
}
