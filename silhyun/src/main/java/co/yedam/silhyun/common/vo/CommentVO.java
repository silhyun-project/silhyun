package co.yedam.silhyun.common.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {
	private String comNum;
	private String ctgr;
	private String ctgrNum;
	private int dep;
	private int ord;
	private int grp;
	private String id;
	private String cntn;
	private Date comDate;
}	
