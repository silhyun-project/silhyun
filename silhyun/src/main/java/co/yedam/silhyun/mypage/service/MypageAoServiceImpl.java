package co.yedam.silhyun.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.mypage.map.MypageAoMapper;
import co.yedam.silhyun.order.vo.ReserVO;

@Service
public class MypageAoServiceImpl implements MypageAoService {
	
	@Autowired
	private MypageAoMapper mypageAoMapper;
	
	@Override
	public List<ReserVO> getReserList(){
		
		return mypageAoMapper.getReserList();
	}
}
