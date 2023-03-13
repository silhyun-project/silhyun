package co.yedam.silhyun.order.service;

import java.util.List;

import co.yedam.silhyun.order.vo.PaymentVO;

public interface PaymentService {
//	int paymentInsert(PaymentVO vo,String resNum,String ctgrNum,String id);
	String paymentInsert(PaymentVO vo);
//	List<String> paymentInsert(PaymentVO vo);
	List<PaymentVO> getPaymentInfo(String id);
}
