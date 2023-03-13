package co.yedam.silhyun.member.map;

import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;

public interface StdMapper {
	List<StudioVO> getStdList(Criteria cri,StudioVO vo); // 사진관 전체 리스트
	int getTotalCount(Criteria cri,StudioVO vo);  //페이징
	
	List<StudioVO> getStd(String stdId); //사진관 상세
	List<StudioVO> getReserList(String stdId); //사진관 상세페이지 아작스 호출
	
	List<StudioVO> stdlistget(String stdId);//사진관 하나만
	
	List<PhotographerVO> ptgList(String stdId);	//작가들
	int ptgdel(PhotographerVO vo);	//스튜디오소속 작가삭제
	
}
