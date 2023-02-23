package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.member.vo.PhotographerVO;

public interface PtgService {
	List<PhotographerVO> getPtgLsit();
	List<PhotographerVO> ptgSearchList(PhotographerVO searchWord); //다중 검색

}
