package co.yedam.silhyun.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.event.map.EventMapper;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.mypage.vo.ChulcheckVO;

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

	@Override
	public int insertChulcheck(ChulcheckVO vo) {

		return eventMapper.insertChulcheck(vo);
	}

	@Override
	public List<ChulcheckVO> chulIdSelect(String id) {

		return eventMapper.chulIdSelect(id);
	}

	@Override
	public int updateChulcheck(ChulcheckVO vo) {

		return eventMapper.updateChulcheck(vo);
	}

}
