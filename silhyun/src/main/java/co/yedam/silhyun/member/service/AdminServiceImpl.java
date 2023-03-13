package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.map.AdminMapper;
import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;


@Service
public class AdminServiceImpl implements AdminSercive {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public List<MemberVO> memberList(){
		return adminMapper.memberList();
	}

	@Override
	public List<PhotographerVO> ptgList() {
		return adminMapper.ptgList();
	}

	@Override
	public List<StudioVO> stdList() {
		return adminMapper.stdList();
	}

	@Override
	public MemberVO adminInfo() {
		return adminMapper.adminInfo();
	}
	
	public List<QuitVO> qtList() {
		return adminMapper.qtList();
	}

	@Override
	public List<MemberVO> todayMem() {
		return adminMapper.todayMem();
	}

	@Override
	public List<MemberVO> todayPtg() {
		return adminMapper.todayPtg();
	}

	@Override
	public List<MemberVO> todayStd() {
		return adminMapper.todayStd();
	}

	@Override
	public int deleteMember(String id) {
		return adminMapper.deleteMember(id);
	}

	@Override
	public int insertQuitMember(String id) {
		return adminMapper.insertQuitMember(id);
	}

	@Override
	public int updateAdmin(MemberVO vo) {
		return adminMapper.updateAdmin(vo);
	}

	@Override
	public List<PhotographerVO> belongPtg(String stId) {
		return adminMapper.belongPtg(stId);
	}

	
	//회원리스트 페이징
	@Override
	public List<MemberVO> getListMember(AdminCriteria cri) {
		return adminMapper.getListMember(cri);
	}

	@Override
	public int getTotalCount(AdminCriteria cri) {
		return adminMapper.getTotalCount(cri);
	}

	@Override
	public int updateMember(MemberVO vo) {
		return adminMapper.updateMember(vo);
	}

	@Override
	public List<Map<String, String>> quitGraph() {
		return adminMapper.quitGraph();
	}

	@Override
	public List<QuitVO> getListQuit(AdminCriteria cri) {
		return adminMapper.getListQuit(cri);
	}

	@Override
	public int getTotalQuit(AdminCriteria cri) {
		return adminMapper.getTotalQuit(cri);
	}

	@Override
	public int deleteQMember(String id) {
		return adminMapper.deleteQMember(id);
	}

	@Override
	public List<PhotographerVO> getListPtg(AdminCriteria cri) {
			return adminMapper.getListPtg(cri);
	}

	@Override
	public int getTotalPtg(AdminCriteria cri) {
			return adminMapper.getTotalPtg(cri);
	}

	@Override
	public List<Map<String, String>> ptgGraph() {
		return adminMapper.ptgGraph();
	}

	@Override
	public List<Map<String, Object>> ptgRank() {
			return adminMapper.ptgRank();
	}

	@Override
	public List<Map<String, Object>> classRank() {
		return adminMapper.classRank();
	}

	@Override
	public List<Map<String, Object>> getEventList() {
		return adminMapper.getEventList();
	}

	@Override
	public EventVO getEventContent(String eventNum) {
		return adminMapper.getEventContent(eventNum);
	}

	@Override
	public List<Map<String, Object>> getEventAllList() {
		return adminMapper.getEventAllList();
	}

	@Override
	public Map<String, String> getEventCnt() {
		return adminMapper.getEventCnt();
	}

	@Override
	public List<Map<String, Object>> recentCom() {
		return adminMapper.recentCom();
	}

	@Override
	public List<MemberVO> recentJoin() {
		return adminMapper.recentJoin();
	}

	@Override
	public List<Map<String, Object>> recentBuy() {
		return adminMapper.recentBuy();
	}

	@Override
	public Map<String, Object> cfmCnt() {
		return adminMapper.cfmCnt();
	}

	@Override
	public int qstCnt() {
		return adminMapper.qstCnt();
	}

	@Override
	public List<Map<String, Object>> lastSales() {
		return adminMapper.lastSales();
	}

	@Override
	public List<Map<String, Object>> ptgCfmList() {
		return adminMapper.ptgCfmList();
	}

	@Override
	public Map<String, Object> ptgSelect(String ptgId) {
		return adminMapper.ptgSelect(ptgId);
	}

	@Override
	public int ptgAccept(String ptgId) {
		return adminMapper.ptgAccept(ptgId);
	}

	@Override
	public int noPtgAccept(String ptgId) {
		return adminMapper.noPtgAccept(ptgId);
	}




}
