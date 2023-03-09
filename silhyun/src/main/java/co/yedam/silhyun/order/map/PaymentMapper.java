package co.yedam.silhyun.order.map;

import co.yedam.silhyun.order.vo.PaymentVO;

public interface PaymentMapper {
	int paymentInsert(PaymentVO vo);  //결제정보 저장
}
