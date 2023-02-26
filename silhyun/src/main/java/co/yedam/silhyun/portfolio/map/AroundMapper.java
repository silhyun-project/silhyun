package co.yedam.silhyun.portfolio.map;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public interface AroundMapper {
	List<PortfolioVO> getAroundList(); // 모든포트폴리오 불러오기
	List<PortfolioVO> AroundTagList(); //태그별로 보이기
	
	
}
