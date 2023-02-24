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
	
	@Override//둘러보기 들어가면 바로 보이는 리스트
	public List<PortfolioVO> getAroundList(){
		return aroundMapper.getAroundList();
	}

	@Override//태그 들어가면 바로 보이는 리스트
	public List<PortfolioVO> AroundTagList() {
		// TODO Auto-generated method stub
		return aroundMapper.AroundTagList();
	}
	
	
}
