package mv.swing.mem.scr;
// 수강생 정보 조회
// 수강생 정보 수정
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminSU extends JPanel{
	
	private static final String[] labelCaption = {	"회원번호", "회원등급", "아이디", 
										            "이름", "전화번호","이메일", 
										            "회원여부","등록일","변경일"};

	private static final String[] buttonCaption = {"조회","수정"};
	
	JPanel[]			jp = null;
	JLabel[]			jl = null;
	JTextField[]  		jt = null;
	JButton[]     		jb = null;
		
	public SwingAdminSU() 
	{		
		setLayout(new BorderLayout(10, 5));
		System.out.println(" getLayout() >>> : " + getLayout());
		
		jp = new JPanel[2];
		jl = new JLabel[9];
		jt = new JTextField[9];
		jb = new JButton[2];
		
		for (int i=0; i < jp.length; i++ )
		{
			jp[i] = new JPanel();			
		}
		jp[0].setBorder(new TitledBorder("수강생정보"));
		jp[1].setBorder(new EtchedBorder());
		
		for (int j=0; j < jl.length; j++ )
		{
			jl[j] = new JLabel(labelCaption[j]);			
			jl[j].setFont(new Font("굴림체", Font.BOLD, 12));
			jl[j].setHorizontalAlignment(SwingConstants.CENTER);
			jt[j] = new JTextField(20);
			jt[j].setBorder(new EtchedBorder());
			jp[0].add(jl[j]);
			jp[0].add(jt[j]);
		}
		
		for (int k=0; k < jb.length; k++ )
		{
			jb[k] = new JButton(buttonCaption[k]);
			jb[k].setBorder(new BevelBorder(BevelBorder.RAISED));
		
			// 버튼 이벤트 처리
			jb[k].addActionListener(new ActionSU());
			jp[1].add(jb[k]);
		}
		
			jp[0].setLayout(new GridLayout(13, 2, 5, 12));		
			jp[1].setLayout(new GridLayout(1, 4, 2, 2));
			
			// 삭제여부, 등록일, 변경일 : Read Only : disible
			jt[6].setEditable(false);
			jt[7].setEditable(false);
			jt[8].setEditable(false);
			
			add(jp[0], BorderLayout.CENTER);
			add(jp[1], BorderLayout.SOUTH);		
		}
		
	// 로그인 JTextField, JPasswordField 초기화 
	public void jtSetText()
	{
		for (int i=1; i < 9; i++)
		{
		jt[i].setText("");
		}
	}
	
	public void memActS()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅
		mvo.setMnum(jt[0].getText());
	
		ArrayList<MaxValueVO> aList = ca.memSelect(mvo);
		if (aList.size() > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "님 조회 성공");
			for (int i=0; i < aList.size(); i++) {
				MaxValueVO _mvo = aList.get(i);
				MaxValueVO.printVO(_mvo);
				jt[1].setText(_mvo.getMgrade());
				jt[2].setText(_mvo.getMid());
				//jt[3].setText(_mvo.getMpw());
				jt[3].setText(_mvo.getMname());
				jt[4].setText(_mvo.getMhp());
				jt[5].setText(_mvo.getMemail());
				jt[6].setText(_mvo.getMdyn());
				jt[7].setText(_mvo.getMinsert());
				jt[8].setText(_mvo.getMupdate());							
			}
		}else {
			System.out.println("회원이름 : " + mvo.getMnum() + " 님의 데이터가 존재하지 않습니다. ");
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "님 데이터가 없습니다.");
		}				
	}
	
	
	
	public void memActU()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		System.out.println("jt[1] >>> : " + jt[1].getText());
		System.out.println("jt[0] >>> : " + jt[0].getText());
		// setter 세팅	
		mvo.setMgrade(jt[1].getText());
		mvo.setMnum(jt[0].getText());
		
		int nCnt = ca.memUpdate(mvo);
		if (nCnt > 0) {
		JOptionPane.showMessageDialog(this, mvo.getMnum() + "님  수정 성공.");
		System.out.println("데이터가 " + nCnt + " 건 수정 되었습니다. ");
		}else {
		JOptionPane.showMessageDialog(this, mvo.getMnum() + "님  수정 실패.");
		System.out.println("수정 실패  >>> :  ");
		}	
		
		jtSetText();
		
	}
	
	class ActionSU implements ActionListener 
	{
		public void actionPerformed(ActionEvent ae) 
		{
			JButton jbnt = (JButton)ae.getSource();
			if ("조회".equals(jbnt.getText()))
			{
			memActS();				
			}
			if ("수정".equals(jbnt.getText()))
			{
			memActU();
			
			}
		}
	}
}