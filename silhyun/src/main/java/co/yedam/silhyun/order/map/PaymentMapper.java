package co.yedam.silhyun.order.map;

import java.util.List;

import co.yedam.silhyun.order.vo.PaymentVO;
import co.yedam.silhyun.order.vo.ReserVO;

public interface PaymentMapper {
	int paymentInsert(PaymentVO vo);  //결제정보 저장
}
