package co.yedam.silhyun.portfolio.map;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.PortfolioVO;


public interface PortfolioMapper {
	List<PortfolioVO> getPortfolioList();  //모든포트폴리오 불러오기
}
