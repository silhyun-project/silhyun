package co.yedam.silhyun.qst.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QstVO {
	private String qstNum;
	private String ctgr;
	private String ctgrNum;
	private String ttl;
	private String id;
	private String cntn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date qstDate;
	private String rplySta;
	private String secretSta;
	private int hit;
	 
	
}
