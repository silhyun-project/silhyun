package co.yedam.silhyun.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.order.map.OrderMapper;
import co.yedam.silhyun.order.vo.ReserVO;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<ReserVO> getMemberInfoList(ReserVO vo) {
		return orderMapper.getMemberInfoList(vo);
	}
	
	@Override
	public String reserInsert(ReserVO vo) {
		orderMapper.reserInsert(vo);
		 //예약 테이블을 인서트하고 예약 번호를 리턴 받아서 컨트롤러에서 다른 테이블에 인서트 시키면 됨
		return vo.getResNum();
		//return orderMapper.reserInsert(vo);  //reser테이블에만 insert
	}

}
