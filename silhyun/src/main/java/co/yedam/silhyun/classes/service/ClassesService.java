package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.classes.vo.InetClassesWtchVO;

public interface ClassesService {

	List<Map<String, Object>> getClassIVInfo(String id, String Inum);
	
	Map<String, Object> selectIV(String classNum, String inetNum, String id);

	int insertWInfo(InetClassesWtchVO vo);
	
	List<Map<String, Object>> getC1List(); 
	
	List<Map<String, Object>> getC2List(); 
}
