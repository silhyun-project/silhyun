package co.yedam.silhyun.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.portfolio.map.AroundMapper;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
@Service
public class AroundServiceImpl implements AroundService {

	@Autowired
	private AroundMapper aroundMapper;
	
	@Override//포트폴리오 랜덤조회
	public List<PortfolioVO> getAroundList(){
		return aroundMapper.getAroundList();
	}
}
