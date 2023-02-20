package co.yedam.silhyun.qst.service;

import java.util.Date;

import lombok.Data;

@Data
public class QstVO {
	String qstNum;
	String ctgr;
	String ctgrNum;
	String ttl;
	String id;
	String cntn;
	Date qstDate;
	String rplySta;
	String secretSta;
	int hit;
	 
	
}
