package mv.swing.mem.scr;
// 수강생 목록 전체 조회
// 수강생 목록 조건 조회
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminSL extends JPanel {
	
	private static final String[] labelCaption = {	"과목명", "회원이름", "개강일", 
										            "종강일", "수업요일", "수업시간",
										            "선생님", "강의실"};

	private static final String[] buttonCaption = {"조회"};
	
	JPanel[]			jp = null;
	JLabel[]			jl = null;
	JTextField[]  		jt = null;
	JButton[]     		jb = null;

	public SwingAdminSL() 
	{		
	setLayout(new BorderLayout(15, 5));
	System.out.println(" getLayout() >>> : " + getLayout());
	
	jp = new JPanel[2];
	jl = new JLabel[8];
	jt = new JTextField[8];
	jb = new JButton[1];
	
	for (int i=0; i < jp.length; i++ )
	{
	jp[i] = new JPanel();			
	}
	jp[0].setBorder(new TitledBorder("수강 중인 회원"));
	jp[1].setBorder(new EtchedBorder());
	
	for (int j=0; j < jl.length; j++ )
	{
	jl[j] = new JLabel(labelCaption[j]);			
	jl[j].setFont(new Font("굴림체", Font.BOLD, 12));
	jl[j].setHorizontalAlignment(SwingConstants.CENTER);
	jt[j] = new JTextField(15);
	jt[j].setBorder(new EtchedBorder());
	jp[0].add(jl[j]);
	jp[0].add(jt[j]);
	}
	
	for (int k=0; k < jb.length; k++ )
	{
	jb[k] = new JButton(buttonCaption[k]);
	jb[k].setBorder(new BevelBorder(BevelBorder.RAISED));
	
	// 버튼 이벤트 처리
	jb[k].addActionListener(new ActionSL());
	jp[1].add(jb[k]);
	}
	
	jp[0].setLayout(new GridLayout(13, 2, 5, 12));		
	jp[1].setLayout(new GridLayout(1, 4, 2, 2));
	
	add(jp[0], BorderLayout.CENTER);
	add(jp[1], BorderLayout.SOUTH);		
	}
	
	// 로그인 JTextField, JPasswordField 초기화 
	public void jtSetText()
	{
	for (int i=1; i < 8; i++)
	{
	jt[i].setText("");
	}
}

	public void mlActS()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅
		mvo.setMname(jt[1].getText());
		
		ArrayList<MaxValueVO> aList = ca.mlSelect(mvo);
		if (aList.size() > 0) {
		JOptionPane.showMessageDialog(this, mvo.getMname() + "님 조회 성공");
		for (int i=0; i < aList.size(); i++) {
		MaxValueVO _mvo = aList.get(i);
		MaxValueVO.printVO(_mvo);
		jt[0].setText(_mvo.getLname());
		jt[2].setText(_mvo.getLstr());
		jt[3].setText(_mvo.getLend());
		jt[4].setText(_mvo.getLday());
		jt[5].setText(_mvo.getLtime());
		jt[6].setText(_mvo.getLteacher());
		jt[7].setText(_mvo.getLroom());
							
		}
		}else {
		System.out.println("회원이름 : " + mvo.getMname() + " 님의 데이터가 존재하지 않습니다. ");
		JOptionPane.showMessageDialog(this, mvo.getMname() + "의 데이터가 없습니다.");
		}				
	}
	
		class ActionSL implements ActionListener 
		{
		public void actionPerformed(ActionEvent ae) 
		{
			JButton jbnt = (JButton)ae.getSource();
			if ("조회".equals(jbnt.getText()))
			{
			mlActS();				
			}

		}
	}
}
