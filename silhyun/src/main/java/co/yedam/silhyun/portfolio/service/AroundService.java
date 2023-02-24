package co.yedam.silhyun.portfolio.service;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public interface AroundService {

	List<PortfolioVO> getAroundList();	//둘러보기 들어가면 보이는 어쩌구
	List<PortfolioVO> AroundTagList();	//태그별로 보이기
}
