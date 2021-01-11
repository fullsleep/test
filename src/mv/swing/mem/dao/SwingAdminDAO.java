package mv.swing.mem.dao;

import java.util.ArrayList;
import mv.swing.mem.vo.MaxValueVO;

public interface SwingAdminDAO {
	
	public ArrayList<MaxValueVO>memSelect(MaxValueVO mvo);
	public int memUpdate(MaxValueVO mvo);
	public ArrayList<MaxValueVO>memSelectAll();
	public ArrayList<MaxValueVO>mlSelect(MaxValueVO mvo);
	public ArrayList<MaxValueVO>lesSelectAll();
	public ArrayList<MaxValueVO>lesSelect(MaxValueVO mvo);
	public int lesInsert(MaxValueVO mvo);
	public int lesUpdate(MaxValueVO mvo);
	public int lesDelete(MaxValueVO mvo);
}

