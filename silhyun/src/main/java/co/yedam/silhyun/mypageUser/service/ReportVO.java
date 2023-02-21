package co.yedam.silhyun.mypageUser.service;

import java.util.Date;

import lombok.Data;

@Data
public class ReportVO {

	int repoNum;
	String ctgr;
	String ctgrNum;
	String id;
	String typCd;
	String result;
	String tretCd;
	int tretTerm;
	Date tretDate;
	boolean sancSta;
	
}
