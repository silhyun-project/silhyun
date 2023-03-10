package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;

public interface ClassesService {

	List<Map<String, Object>> getClassIVInfo(String id, String classNum);
	
	Map<String, Object> selectIV(String classNum, String inetNum, String id);

	int insertWInfo(InetClassesWtchVO vo);
	
	List<Map<String, Object>> getC1List(); 
	
	List<Map<String, Object>> getC2List(); 
	
	//조건에 맞는 페이지
	List<Map<String, Object>> cdtC1List(int param1); 
	
	List<Map<String, Object>> cdtC2List(int param1);
	
	//무료강의 페이지
	List<Map<String, Object>> getFC1List(); 
	
	List<Map<String, Object>> getFC2List();
	
	//클래스 개별정보
	ClassesVO selectClass(String classNum);
	
	//클래스 개별정보와 함께 보낼 부가 정보
	Map<String, Object> CPlusInfo(String classNum, String id);
	
	List<Map<String, Object>> randomList(String classNum);
	
	//내 수강강의 페이지
	String getName(String id);
	
	List<Map<String, Object>> myTakeC1(String id);
	
	List<Map<String, Object>> myTakeC2(String id);
}
