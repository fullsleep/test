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

public class SwingMypageSModel extends AbstractTableModel{
	

	Object[][] filedValue = null;
	
	String[] columnName = {	"학생이름", "과목이름",  
				            "개강일", "종강일","수업요일",
				            "수업시간","선생님","강의실",
				            "수업진행여부"};	

	DefaultTableModel dtm;
	JTable             jt;
	JPanel[]    jpR;
	JLabel      jlR;	
	JTextField  jtR;
	JButton     jbR;
	JScrollPane jsp;

	public SwingMypageSModel()
	{
		int columnCnt = columnName.length;
		// 불러옴
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		try {
			MvMypageScr ca = new MvMypageScr();			
			ArrayList<MaxValueVO> aList = ca.lesSelect(mvo);
			int rowCnt = aList.size();
			filedValue = new Object[rowCnt][columnCnt];
			
			if (aList.size() > 0) 
			{
				for (int i=0; i < aList.size(); i++) 
				{
					MaxValueVO _mvo = aList.get(i);
					filedValue[i][0] = _mvo.getMname();
					filedValue[i][1] = _mvo.getLname();
					filedValue[i][2] = _mvo.getLstr();				
					filedValue[i][3] = _mvo.getLend();
					filedValue[i][4] = _mvo.getLday();
					filedValue[i][5] = _mvo.getLtime();
					filedValue[i][6] = _mvo.getLteacher();
					filedValue[i][7] = _mvo.getLroom();				
					filedValue[i][8] = _mvo.getLdyn();
										
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
