package co.yedam.silhyun.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PhotographerVO extends MemberVO{
	private String ptgId;
	private String stId;
	private String regionCd;
	private Date regiDate;
	private int crn;
	private String ptgCd;
	private String shotPlace;
	private String itr;
	private String inst;
	private String cfmCd;
	private Date accpDate;
	private String workDay;
}
