package co.yedam.silhyun.qst.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MainQstVO {

	private String mainNum;
	private int grp;
	private int ord;
	private int dep;
	private String id;
	private String assortCd;
	private String ttl;
	private String cntn;
	private Date mainDate;
	private int hit;
	private String secretSta;
	private String rplySta;
}
