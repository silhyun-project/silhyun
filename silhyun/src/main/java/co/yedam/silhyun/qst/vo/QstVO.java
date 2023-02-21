package co.yedam.silhyun.qst.vo;

import java.util.Date;

import lombok.Data;

@Data
public class QstVO {
	private String qstNum;
	private String ctgr;
	private String ctgrNum;
	private String ttl;
	private String id;
	private String cntn;
	private Date qstDate;
	private String rplySta;
	private String secretSta;
	private int hit;
	 
	
}
