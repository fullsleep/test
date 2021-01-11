package mv.swing.mem.scr;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingMypageSUD extends JPanel 
{
	private static final String[] labelCaption = {	"회원번호", "회원등급", "아이디", 
													"비밀번호", "이름", "전화번호",
													"이메일", "회원유지",
													"등록일", "수정일"};

	private static final String[] buttonCaption = {"회원조회", "정보수정", "회원탈퇴"};

	JPanel[]			jp = null;
	JLabel[]			jl = null;
	JTextField[]  jt = null;
	JButton[]     jb = null;
	
	public SwingMypageSUD() 
	{		
		setLayout(new BorderLayout(15, 5));
		System.out.println(" getLayout() >>> : " + getLayout());
		
		jp = new JPanel[2];
		jl = new JLabel[10];
		jt = new JTextField[10];
		jb = new JButton[3];

		for (int i=0; i < jp.length; i++ )
		{
			jp[i] = new JPanel();			
		}
		jp[0].setBorder(new TitledBorder("회원정보"));
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
			jb[k].addActionListener(new ActionISUD());
			jp[1].add(jb[k]);
		}

		jp[0].setLayout(new GridLayout(13, 2, 5, 12));		
		jp[1].setLayout(new GridLayout(1, 4, 2, 2));
		
		// 삭제여부, 등록일, 변경일 : Read Only : disible
		jt[7].setEditable(false);
		jt[8].setEditable(false);
		jt[9].setEditable(false);

		add(jp[0], BorderLayout.CENTER);
		add(jp[1], BorderLayout.SOUTH);	

	}
	
	// 로그인 JTextField, JPasswordField 초기화 
	public void jtSetText()
	{
		for (int i=1; i < 13; i++)
		{
			jt[i].setText("");
		}
	}

	public void memActS()
	{
		MvMypageScr sms = new MvMypageScr();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅
		//mvo.setMnum(jt[0].getText());
		
		ArrayList<MaxValueVO> aList = sms.memSelect(mvo);
		if (aList.size() > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "님 조회 성공");
			for (int i=0; i < aList.size(); i++) {
				MaxValueVO _mvo = aList.get(i);
				MaxValueVO.printVO(_mvo);
				jt[0].setText(_mvo.getMnum());
				jt[1].setText(_mvo.getMgrade());
				jt[2].setText(_mvo.getMid());
				jt[3].setText(_mvo.getMpw());
				jt[4].setText(_mvo.getMname());
				jt[5].setText(_mvo.getMhp());
				jt[6].setText(_mvo.getMemail());
				jt[7].setText(_mvo.getMdyn());
				jt[8].setText(_mvo.getMinsert());
				jt[9].setText(_mvo.getMupdate());
											
			}
		}else {
			System.out.println("회원번호 : " + mvo.getMnum() + " 님의 데이터가 존재하지 않습니다. ");
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "님 데이터가 없습니다.");
		}				
	}
		
	public void memActU()
	{
		MvMypageScr mms = new MvMypageScr();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		System.out.println("jt[5] >>> : " + jt[5].getText());
		System.out.println("jt[0] >>> : " + jt[0].getText());
				
		// setter 세팅	
		mvo.setMhp(jt[5].getText());
		//mvo.setMnum(jt[0].getText());
						
		int nCnt = mms.memUpdate(mvo);
		if (nCnt > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "  수정 성공.");
			System.out.println("데이터가 " + nCnt + " 건 수정 되었습니다. ");
		}else {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "  수정 실패.");
			System.out.println("수정 실패  >>> :  ");
		}	
		
		//jtSetText();
		
	}
	
	public void memActD()
	{
		MvMypageScr mms = new MvMypageScr();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅	
		mvo.setMnum(jt[0].getText());
		
		int nCnt = mms.memDelete(mvo);
		if (nCnt > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + " 삭제 성공.");
			System.out.println("데이터가 " + nCnt + " 건 삭제 되었습니다. ");	
		}else {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + " 삭제 실패.");
			System.out.println("삭제 실패  >>> :  ");
		}	
		
		//jtSetText();
	}

	class ActionISUD implements ActionListener 
	{
		public void actionPerformed(ActionEvent ae) 
		{
			JButton jbnt = (JButton)ae.getSource();
			if ("회원조회".equals(jbnt.getText()))
			{
				memActS();				
			}
			if ("정보수정".equals(jbnt.getText()))
			{
				memActU();
				
			}
			if ("회원탈퇴".equals(jbnt.getText()))
			{
				memActD();
			}
		}
	}
}