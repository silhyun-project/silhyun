package co.yedam.silhyun.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String name;
	private String pwd;
	private Date birthDate;
	private String genCd;
	private String email;
	private String tel;
	private String rcomr;
	private String memCd;
	private String token;
	private String reToken;
	private String loginCd;
	private int pointSum;
	private String profile; 
	private Date joinDate;
}
