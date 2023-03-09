package co.yedam.silhyun.order.service;

import co.yedam.silhyun.order.vo.PaymentVO;

public interface PaymentService {
	int paymentInsert(PaymentVO vo,String id);
}
