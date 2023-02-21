package co.yedam.silhyun.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PhotographerVO {
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
}
