package co.yedam.silhyun.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.yedam.silhyun.member.map.StdMapper;
import co.yedam.silhyun.member.vo.StudioVO;

public class StdServiceImpl implements StdService {
	@Autowired StdMapper stdMapper;
	
	@Override
	public List<StudioVO> getStdList(String searchType) {
		// TODO Auto-generated method stub
		return stdMapper.getStdList(searchType);
	}

}
