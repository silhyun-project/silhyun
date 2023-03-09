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
	public int paymentInsert(PaymentVO vo,String resNum,String ctgrNum,String id) {
		vo.setResNum(resNum);
		vo.setCtgrNum(ctgrNum);
		vo.setId(id);
		return paymentMapper.paymentInsert(vo);
	}

}
