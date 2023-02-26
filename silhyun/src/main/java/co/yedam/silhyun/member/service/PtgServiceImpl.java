package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.PtgMapper;
import co.yedam.silhyun.member.vo.PhotographerVO;
@Service
public class PtgServiceImpl implements PtgService {
	@Autowired 
	private PtgMapper ptgMapper;
	
	@Override  //작가 전체 조회
	public List<PhotographerVO> getPtgLsit(String searchType) {
		return ptgMapper.getPtgLsit(searchType);
	}

	@Override
	public List<PhotographerVO> ptgSearchList(PhotographerVO searchWord) {
		// 
		return ptgMapper.ptgSearchList(searchWord);
	}

	@Override
	public List<PhotographerVO> getPtg(String ptgId) {
		
		return ptgMapper.getPtg(ptgId);
	}


}
