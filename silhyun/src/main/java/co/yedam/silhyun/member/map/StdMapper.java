package co.yedam.silhyun.member.map;

import java.util.List;

import co.yedam.silhyun.member.vo.StudioVO;

public interface StdMapper {
	List<StudioVO> getStdList(String searchType);
}
