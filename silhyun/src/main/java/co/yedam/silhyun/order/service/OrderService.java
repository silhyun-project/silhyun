package co.yedam.silhyun.order.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.order.vo.ReserVO;

public interface OrderService {
	List<ReserVO> getMemberInfoList(ReserVO vo);
}
