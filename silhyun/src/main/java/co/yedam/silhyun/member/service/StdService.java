package co.yedam.silhyun.member.service;

import java.util.List;

import co.yedam.silhyun.member.vo.StudioVO;

public interface StdService {
	List<StudioVO> getStdList(String searchType);
}
