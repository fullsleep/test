package mv.swing.mem.dao;

import java.util.ArrayList;

import mv.swing.mem.vo.MaxValueVO;

public interface SwingLoginDAO2 {

	public boolean memLogin(MaxValueVO mvvo);
	public int memLogout(MaxValueVO mvvo);
	public ArrayList<MaxValueVO> idSearch(MaxValueVO mvvo);
	public ArrayList<MaxValueVO> pwSearch(MaxValueVO mvvo);
	public int pwTemp(MaxValueVO mvvo);
	public boolean memAdminLogin(MaxValueVO mvvo);
	public int nowLogin(MaxValueVO mvvo);
}
