package co.yedam.silhyun.member.map;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.member.vo.PhotographerVO;

public interface PtgMapper {
	
	List<PhotographerVO> getPtgLsit(Criteria cri,PhotographerVO vo);
	int getTotalCount(Criteria cri,PhotographerVO vo);
	
//	List<PhotographerVO> ptgSearchList(Criteria cri,PhotographerVO vo); //다중 검색
//	int getTotalListCount(Criteria cri,PhotographerVO vo);
	
	List<PhotographerVO> getPtg(String ptgId);
	
	List<PhotographerVO> getReser(String ptgId);
}
