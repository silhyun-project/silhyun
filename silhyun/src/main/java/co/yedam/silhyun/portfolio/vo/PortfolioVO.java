package co.yedam.silhyun.portfolio.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PortfolioVO {

	
	private String portNum;
	private String ptgId;
	private String cntn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date portDate;
	private String upSta;
	private int likes;//조아요수
	
	
	
	
	//조인
	//Photo 사진불러오기
	private String phoNum;
	//private String ctgr;
	//private String ctgrNum;
	private String phoRt;
	//private String exten;
	//private int phoSize;
	
	//likePhoto//좋아요순용 
	private String id;
	
	//tag별 정렬용
	//private String tagCntn;
	
	//comment 댓글순
//	private String comNum;
//	private int dep;
//	private int ord;
//	private int grp;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
//	private Date comDate;
}
