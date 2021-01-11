package mv.swing.mem.dao;

import mv.swing.mem.vo.MaxValueVO;

public interface SwingNewMemberDAO {
	
	public int memInsert(MaxValueVO mvvo);
	public boolean idConfirm(MaxValueVO mvvo);
}
