package co.yedam.silhyun.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.order.map.PaymentMapper;
import co.yedam.silhyun.order.vo.PaymentVO;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired PaymentMapper paymentMapper;
	
	@Override
	public int paymentInsert(PaymentVO vo,String id) {
		return paymentMapper.paymentInsert(vo);
	}

}
