package co.yedam.silhyun.order.vo;

import java.util.Date;

import lombok.Data;
@Data
public class PaymentVO {
	String ordNum;
	String ctgr;
	String ctgrNum;
	String id;
	String resNum;
	String ordMthd;
	String uCpNum;
	int uPoint;
	String ordSta;
	Date ordDate;
	int paymPri;
	int ordPri;
}
