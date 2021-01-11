package mv.swing.mem.dao;

import java.util.ArrayList;

import mv.swing.mem.vo.MaxValueVO;

public interface MvMypageDAO {
	// 수강생 정보 조회
	public ArrayList<MaxValueVO> memSelect(MaxValueVO mvo);
	// 수강생 정보 수정
	public int memUpdate(MaxValueVO mvo);
	// 수강생 정보 삭제(탈퇴)
	public int memDelete(MaxValueVO mvo);
	// 과목 조회
	public ArrayList<MaxValueVO> lesSelectAll();
	// 과목 선택 조회
	public ArrayList<MaxValueVO> lessonSelect(MaxValueVO mvo);
	// 신청한 강의 조회
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO mvo);
	// 수강 신청
	public int lesInsert(MaxValueVO mvo);
	// 수강 신청한 강의 취소
	public int lesDelete(MaxValueVO mvo);
		
}// end of MvMypageDAO interface
