package co.yedam.silhyun.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PhotographerVO{
	private String ptgId;
	private String stId;
	private String regionCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date regiDate;
	private int crn;
	private String ptgCd;
	private String shotPlace;
	private String itr;
	private String inst;
	private String cfmCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date accpDate;
	private String workDay;
	
	private String[] chkArray;  // 지역태그
	private String[] chkfldArray; //분야태그
	private String region;
	private String field;
	private String searchType;
	private String searchWord;
	
	
	//조인
	private String id;
	private String name;
	private String pwd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date joinDate;
}
