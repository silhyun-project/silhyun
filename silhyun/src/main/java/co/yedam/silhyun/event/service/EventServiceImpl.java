package co.yedam.silhyun.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.event.map.EventMapper;
import co.yedam.silhyun.event.vo.EventVO;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventMapper eventMapper;
	
	@Override
	public List<EventVO> getEventList(){
		
		return eventMapper.getEventList();
	}

	@Override
	public List<EventVO> getBannerList() {
		
		return eventMapper.getBannerList();
	}

}
