package co.yedam.silhyun.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.PtgMapper;
import co.yedam.silhyun.member.vo.PhotographerVO;
@Service
public class PtgServiceImpl implements PtgService {
	@Autowired 
	private PtgMapper ptgMapper;
	
	@Override  //작가 전체 조회
	public List<PhotographerVO> getPtgLsit() {
		return ptgMapper.getPtgLsit();
	}

}
