package mv.swing.mem.scr;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminMSAModel extends JFrame implements ActionListener, TableModel{
	
	private static final long serialVersionUID = -7850855038230666204L;
	
	Object[][] filedValue;
	
	String[] columnName = {	"회원번호", "회원등급", "회원아이디", 
				            "회원이름", "회원전화번호","회원이메일",
				            "회원삭제여부","회원등록일","회원정보수정일"};	

	DefaultTableModel dtm;
	JTable             jt;
	JPanel[]    jpR;
	JComboBox   jcR;
	JLabel      jlR;	
	JTextField  jtR;
	JButton     jbR;
	JScrollPane jsp;

	String[] comboCaption = {"---------------", "수강생 전체", "회원번호"};
	String comboStr = "";
	
	public SwingAdminMSAModel()
	{
		this.setLayout(new BorderLayout(10, 10));

		jpR = new JPanel[2];
		jlR = new JLabel("조회조건");
		jlR.setHorizontalAlignment(SwingConstants.CENTER);

		jcR = new JComboBox<Object>(comboCaption);
		jcR.setSelectedIndex(0);
		jcR.addActionListener(this);

		jtR = new JTextField();
		jtR.setVisible(false);
		jbR = new JButton("조회");
		jbR.addActionListener(this);

		for (int i=0; i < jpR.length; i++ )
		{
			jpR[i] = new JPanel();
			jpR[i].setLayout(new BorderLayout());
		}

		dtm = new DefaultTableModel(filedValue, columnName);
		jt = new JTable(dtm);
		jt.setEnabled(true);
		jsp = new JScrollPane(jt);

		jpR[0].add(jlR);
		jpR[0].add(jcR);		
		jpR[0].add(jtR);
		jpR[0].add(jbR);
		jpR[0].setLayout(new GridLayout(1, 4, 5, 5));
//		jpR[0].setLayout(new FlowLayout(FlowLayout.LEFT));
		jpR[1].add(jsp);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.getContentPane().add(jpR[0], BorderLayout.NORTH);
		this.getContentPane().add(jpR[1], BorderLayout.CENTER);

		this.setTitle("수강생 목록");
		this.setLocation(100, 500);
		this.setSize(1200,400);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		// ComboBox 이벤트 처리
		if (e.getSource() == jcR)
		{
			comboStr = (String)jcR.getSelectedItem();
			if ("수강생 전체".equals(comboStr))
			{
				jtR.setVisible(false);				
			}
			if ("회원번호".equals(comboStr))
			{
				jtR.setVisible(true);
				
			}
		}
		
		// 조회버튼 이벤트 
		if (e.getSource() == jbR) {
			// 조회 키워드 값 
			String searchStr = "";
			
			if ("수강생 전체".equals(comboStr)) {
				
				int columnCnt = columnName.length;
				
				try {
					
					ConsoleAdmin ca = new ConsoleAdmin();			
					ArrayList<MaxValueVO> aList = ca.memSelectAll();
					
					int rowCnt = aList.size();
					filedValue = new Object[rowCnt][columnCnt];
					
					if (aList.size() > 0) 
					{
						for (int i=0; i < aList.size(); i++) 
						{
							MaxValueVO mvo = aList.get(i);
							filedValue[i][0] = mvo.getMnum();
							filedValue[i][1] = mvo.getMgrade();
							filedValue[i][2] = mvo.getMid();
							filedValue[i][3] = mvo.getMname();				
							filedValue[i][4] = mvo.getMhp();
							filedValue[i][5] = mvo.getMemail();
							filedValue[i][6] = mvo.getMdyn();
							filedValue[i][7] = mvo.getMinsert();
							filedValue[i][8] = mvo.getMupdate();				
							MaxValueVO.printVO(mvo);
						}
					}					
				}catch (Exception e2){
					System.out.println("e >>> : " + e2);
				}
				
				dtm = new DefaultTableModel(filedValue, columnName);
				jt.setModel(dtm);
				
				return;				
			}
			if ("회원번호".equals(comboStr)) {
				
				searchStr = jtR.getText();
				System.out.println(" searchStr >>> : " + searchStr);
				
				int columnCnt = columnName.length;
				
				try {
					
					ConsoleAdmin ca = new ConsoleAdmin();				
					MaxValueVO mvo = null;
					mvo = new MaxValueVO();
					// setter 세팅
					mvo.setMnum(searchStr);
					ArrayList<MaxValueVO> aList = ca.memSelect(mvo);
					
					int rowCnt = aList.size();
					filedValue = new Object[rowCnt][columnCnt];
					
					if (aList.size() > 0) 
					{
						for (int i=0; i < aList.size(); i++) 
						{
							MaxValueVO _mvo = aList.get(i);
							filedValue[i][0] = _mvo.getMnum();
							filedValue[i][1] = _mvo.getMgrade();
							filedValue[i][2] = _mvo.getMid();
							filedValue[i][3] = _mvo.getMname();				
							filedValue[i][4] = _mvo.getMhp();
							filedValue[i][5] = _mvo.getMemail();
							filedValue[i][6] = _mvo.getMdyn();
							filedValue[i][7] = _mvo.getMinsert();
							filedValue[i][8] = _mvo.getMupdate();			
							MaxValueVO.printVO(_mvo);
						}
					}					
				}catch (Exception e2){
					System.out.println("e >>> : " + e2);
				}
				
				dtm = new DefaultTableModel(filedValue, columnName);
				jt.setModel(dtm);
				
				return;				
			}
		}
	}
	public static void main(String args[])
	{
		new SwingAdminSAModel();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
}



