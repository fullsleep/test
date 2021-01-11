package mv.swing.mem.dao;

import java.util.ArrayList;

import mv.swing.mem.vo.MaxValueVO;

public interface MvMypageDAO {
	// ������ ���� ��ȸ
	public ArrayList<MaxValueVO> memSelect(MaxValueVO mvo);
	// ������ ���� ����
	public int memUpdate(MaxValueVO mvo);
	// ������ ���� ����(Ż��)
	public int memDelete(MaxValueVO mvo);
	// ���� ��ȸ
	public ArrayList<MaxValueVO> lesSelectAll();
	// ���� ���� ��ȸ
	public ArrayList<MaxValueVO> lessonSelect(MaxValueVO mvo);
	// ��û�� ���� ��ȸ
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO mvo);
	// ���� ��û
	public int lesInsert(MaxValueVO mvo);
	// ���� ��û�� ���� ���
	public int lesDelete(MaxValueVO mvo);
		
}// end of MvMypageDAO interface
