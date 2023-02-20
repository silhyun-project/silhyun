package co.yedam.silhyun.qst.service;

import java.util.Date;

import lombok.Data;

@Data
public class MainQstVO {

	String mainNum;
	int grp;
	int ord;
	int dep;
	String id;
	String assortCd;
	String ttl;
	String cntn;
	Date mainDate;
	int hit;
	String secretSta;
	String rplySta;
}
