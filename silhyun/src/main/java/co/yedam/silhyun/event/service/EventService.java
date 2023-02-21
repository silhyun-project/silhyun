package co.yedam.silhyun.event.service;

import java.util.List;

import co.yedam.silhyun.event.vo.EventVO;

public interface EventService {
	List<EventVO> eventSelectList(); // 전체조회
}
