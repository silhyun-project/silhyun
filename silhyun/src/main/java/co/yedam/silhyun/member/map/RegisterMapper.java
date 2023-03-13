package co.yedam.silhyun.member.map;

import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;

public interface RegisterMapper {
	MemberVO getMember(String id);  //회원 한명 조회
	int ptgRegiInsert(PhotographerVO vo); //작가 등록
	int ptgFldRegiInsert(FieldVO vo); //작가 등록시 필드에도 추가
	int stdRegiInsert(StudioVO vo); //사진관 등록
}
