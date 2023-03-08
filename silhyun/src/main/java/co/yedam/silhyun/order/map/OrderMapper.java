package co.yedam.silhyun.order.map;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.order.vo.ReserVO;

public interface OrderMapper {
	List<ReserVO> getMemberInfoList(ReserVO vo);
}
