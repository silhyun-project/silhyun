package co.yedam.silhyun.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class StudioVO {
	private String stId;
	private String regionCd;
	private String stName;
	private String addr;
	private String tel;
	private String ceoName;
	private String cfmCd;
	private int crn;
	private String latiAddr;
	private String lonAddr;
	private Date accpDate;
	private String detAddr;
	private String zipAddr;
}
