package mv.swing.mem.scr;




import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mv.swing.mem.vo.MaxValueVO;

public class SwingMemberSearchModel extends JFrame implements ActionListener
{	
	private static final long serialVersionUID = -7850855038230666204L;
	
	DefaultTableModel dtm;
	JTable             jt;
	Object[][] filedValue;
	String[] columnName = {	
							"과목번호", "과목분류", "과목명", 
						    "개강일", "종강일", "수업요일",
						    "수업시간", "선생님", "강의실",
						    "수업취소여부", "등록일", "변경일"};

	JPanel[]    jpR;
	JLabel      jlR;
	JComboBox   jcR;
	JTextField  jtR;
	JButton     jbR;
	JScrollPane jsp;

	String[] comboCaption = {"----------", "전체", "회원번호", "이름"};
	String comboStr = "";

	@SuppressWarnings("unchecked")
	public SwingMemberSearchModel()
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

		this.setLocation(100, 100);
		this.setSize(1200,540);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		// ComboBox 이벤트 처리
		if (e.getSource() == jcR)
		{
			comboStr = (String)jcR.getSelectedItem();
			if ("전체".equals(comboStr))
			{
				jtR.setVisible(false);				
			}
			if ("회원번호".equals(comboStr))
			{
				jtR.setVisible(true);
				
			}
			if ("이름".equals(comboStr))
			{
				jtR.setVisible(true);
			}
		}
		
		// 조회버튼 이벤트 
		if (e.getSource() == jbR) {
			// 조회 키워드 값 
			String searchStr = "";
			
			if ("전체".equals(comboStr)) {
				
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
					
					MvMypageScr mms = new MvMypageScr();				
					MaxValueVO mvo = null;
					mvo = new MaxValueVO();
					// setter 세팅
					mvo.setMnum(searchStr);
					ArrayList<MaxValueVO> aList = mms.lesSelect(mvo);
					
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
			if ("이름".equals(comboStr)) {
				
				searchStr = jtR.getText();
				System.out.println(" searchStr >>> : " + searchStr);
				
				// 직접 구현해 보기 
			}
		}
	}

	public static void main(String args[])
	{
		new SwingMemberSearchModel();
	}
}