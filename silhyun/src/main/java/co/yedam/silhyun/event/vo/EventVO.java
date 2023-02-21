package co.yedam.silhyun.event.vo;

import java.util.Date;

import lombok.Data;

@Data
public class EventVO {
	private String eventNum;
	private String id;
	private String name;
	private int term;
	private Date startDate;
	private String cntn;
	private String thni;
	private String bnph;
	private String bnphSta;
	private String cfmCd;
	private String cpnPubSta;
	private String regionCd;
	private Date accpDt;

}
