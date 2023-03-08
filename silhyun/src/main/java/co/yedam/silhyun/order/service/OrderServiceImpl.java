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

}
