package mv.swing.mem.scr;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import mv.swing.mem.vo.MaxValueVO;

public class SwingMypageSAModel extends AbstractTableModel{
	

	Object[][] filedValue = null;
	
	String[] columnName = {	"과목코드", "과목분류", "과목명", 
				            "개강일", "종강일","수업요일",
				            "수업시간","선생님","강의실",
				            "수업진행여부","수업등록일","수업수정일"};	

	DefaultTableModel dtm;
	JTable             jt;
	JPanel[]    jpR;
	JLabel      jlR;	
	JTextField  jtR;
	JButton     jbR;
	JScrollPane jsp;

	public SwingMypageSAModel()
	{
		int columnCnt = columnName.length;
		
		try {
			MvMypageScr mms = new MvMypageScr();			
			ArrayList<MaxValueVO> aList = mms.lesSelectAll();
			int rowCnt = aList.size();
			filedValue = new Object[rowCnt][columnCnt];
			
			if (aList.size() > 0) 
			{
				for (int i=0; i < aList.size(); i++) 
				{
					MaxValueVO mvo = aList.get(i);
					filedValue[i][0] = mvo.getLcode();
					filedValue[i][1] = mvo.getLsubject();
					filedValue[i][2] = mvo.getLname();
					filedValue[i][3] = mvo.getLstr();				
					filedValue[i][4] = mvo.getLend();
					filedValue[i][5] = mvo.getLday();
					filedValue[i][6] = mvo.getLtime();
					filedValue[i][7] = mvo.getLteacher();
					filedValue[i][8] = mvo.getLroom();				
					filedValue[i][9] = mvo.getLdyn();
					filedValue[i][10] = mvo.getLinsert();
					filedValue[i][11] = mvo.getLupdate();
					
					MaxValueVO.printVO(mvo);
				}
			}
			
		}catch (Exception e){
			
		}
	}

	public int getColumnCount()
	{
		if (columnName == null){ return 0;}
		else { return columnName.length;}
	}

	public int getRowCount()
	{
		if (filedValue == null) { return 0; }
		else { return filedValue.length; }
	}

	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return 	filedValue[rowIndex][columnIndex];
	}

	public String getColumnName(int column)
	{
		return (String)columnName[column];
	}
}
