package co.yedam.silhyun.member.map;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.member.vo.PhotographerVO;

public interface PtgMapper {
	
	List<PhotographerVO> getPtgLsit(String searchType);
	List<PhotographerVO> ptgSearchList(PhotographerVO searchWord); //다중 검색
	
	List<PhotographerVO> getPtg(String ptgId);
}
