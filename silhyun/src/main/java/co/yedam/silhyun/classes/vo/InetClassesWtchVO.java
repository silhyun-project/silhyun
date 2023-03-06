package co.yedam.silhyun.classes.vo;

import lombok.Data;

@Data
public class InetClassesWtchVO {

	private String inetNum;
	private String classNum;
	private String id;
	
	//기존항목 일부 삭제, 하단 항목들 추가됐어요
	private String inetwtNum;
	private String stwTime;
	private String ewTime;
	private String cumlwTime;
	
	
}
