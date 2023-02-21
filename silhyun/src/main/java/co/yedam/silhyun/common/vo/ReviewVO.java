package co.yedam.silhyun.common.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	private String revNum;
	private String ctgr;
	private String ctgrNum;
	private String id;
	private int star;
	private String cntn;
	private Date revDate;
}
