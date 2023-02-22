package co.yedam.silhyun.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.yedam.silhyun.portfolio.map.PortfolioMapper;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public class PortfolioServiceImpl implements PortfolioService {
	@Autowired
	private PortfolioMapper portfolioMapper;
	
	
	@Override
	public List<PortfolioVO> getPortfolioList(){
		return portfolioMapper.getPortfolioList();
	}
}
