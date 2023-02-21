package co.yedam.silhyun.event.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CouponVO {
	private String cpnNum;
	private String ctgr;
	private String ctgrNum;
	private String cntn;
	private int discount;
	private String cpnCd;
	private Date startDate;
	private Date endDate;
	private String eventNum;
	
	//쿠폰이력
	private String id;		
	private String cpnSta;
}
