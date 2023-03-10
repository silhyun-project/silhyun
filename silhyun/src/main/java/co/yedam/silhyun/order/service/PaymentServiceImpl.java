package co.yedam.silhyun.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.order.map.PaymentMapper;
import co.yedam.silhyun.order.vo.PaymentVO;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired PaymentMapper paymentMapper;

//	@Override
//	public List<String> paymentInsert(PaymentVO vo) {
////		List<String> orderList = new ArrayList<String>();
////		for()
//		return paymentMapper.paymentInsert(vo);
//	}
	
	@Override
	public String paymentInsert(PaymentVO vo) {
		paymentMapper.paymentInsert(vo);  //payment테이블에 넣고 
//		vo.setResNum(resNum);
//		vo.setCtgrNum(ctgrNum);
//		vo.setId(id);
	
		return vo.getResNum(); //예약 번호 리턴
	}

}
