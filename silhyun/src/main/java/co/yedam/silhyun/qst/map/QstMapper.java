package co.yedam.silhyun.qst.map;

import java.util.List;

import co.yedam.silhyun.qst.vo.QstVO;

public interface QstMapper {

	List<QstVO> getAoQstList(); // 작가 문의글 리스트
	int aoQstInsert(QstVO vo); // 작가 문의글 입력
	int aoQstDelete(QstVO vo); // 작가 문의글 삭제
	
}
