package mv.swing.mem.scr;
// 수업정보 입력
// 수업정보 조회
// 수업정보 수정
// 수업정보 삭제
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminISUD extends JPanel{
	
	private static final String[] labelCaption = {	"과목코드", "과목분류", "과목명", 
										            "개강일", "종강일", "수업요일",
										            "수업시간", "선생님", "강의실",
										            "수업삭제여부","수업등록일","수업수정일"};

	private static final String[] buttonCaption = {"조회", "등록", "수정", "삭제"};
	
	JPanel[]	  jp = null;
	JLabel[]	  jl = null;
	JTextField[]  jt = null;
	JButton[]     jb = null;
	// JRadioButton[] jrb = null;
	
	public SwingAdminISUD() 
	{		
	setLayout(new BorderLayout(10, 5));
	System.out.println(" getLayout() >>> : " + getLayout());
	/*
	JRadioButton jrb = new JRadioButton("주중(WD)");
	jrb.setBounds(0, 0, 100, 20);		
	this.add(jrb);
	*/
	
	jp = new JPanel[2];
	jl = new JLabel[12];
	jt = new JTextField[12];
	jb = new JButton[4];
	// jrb = new JRadioButton[2]; 
	
	for (int i=0; i < jp.length; i++ )
	{
	jp[i] = new JPanel();			
	}
	jp[0].setBorder(new TitledBorder("수업정보"));
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
	jt[9].setEditable(false);
	jt[10].setEditable(false);
	jt[11].setEditable(false);
	
	add(jp[0], BorderLayout.CENTER);
	add(jp[1], BorderLayout.SOUTH);		
	/*
	JRadioButton jrb = new JRadioButton("주중(WD)");
	jrb.setBounds(0, 0, 10, 10);		
	this.add(jrb);
	*/
	
	}
	
	// 로그인 JTextField, JPasswordField 초기화 
	public void jtSetText()
	{
	for (int i=1; i < 12; i++)
	{
	jt[i].setText("");
	}
	}
	
	public void lesActS()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅
		mvo.setLcode(jt[0].getText());
		
		ArrayList<MaxValueVO> aList = ca.lesSelect(mvo);
		if (aList.size() > 0) {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + "과목 조회 성공");
		for (int i=0; i < aList.size(); i++) {
		MaxValueVO _mvo = aList.get(i);
		MaxValueVO.printVO(_mvo);
		jt[1].setText(_mvo.getLsubject());
		jt[2].setText(_mvo.getLname());
		jt[3].setText(_mvo.getLstr());
		jt[4].setText(_mvo.getLend());
		jt[5].setText(_mvo.getLday());
		jt[6].setText(_mvo.getLtime());
		jt[7].setText(_mvo.getLteacher());
		jt[8].setText(_mvo.getLroom());
		jt[9].setText(_mvo.getLdyn());
		jt[10].setText(_mvo.getLinsert());
		jt[11].setText(_mvo.getLupdate());
								
		}
	}else {
		System.out.println("과목코드 : " + mvo.getLcode() + " 데이터가 존재하지 않습니다. ");
		JOptionPane.showMessageDialog(this, mvo.getLcode() + " 데이터가 없습니다.");
		}				
	}
	
	public void lesActI()
	{
		try
		{
			ConsoleAdmin ca = new ConsoleAdmin();				
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			// setter 세팅
			mvo.setLcode(jt[0].getText());
			mvo.setLsubject(jt[1].getText());
			mvo.setLname(jt[2].getText());
			mvo.setLstr(jt[3].getText());
			mvo.setLend(jt[4].getText());
			mvo.setLday(jt[5].getText());
			mvo.setLtime(jt[6].getText());
			mvo.setLteacher(jt[7].getText());
			mvo.setLroom(jt[8].getText());
			mvo.setLdyn(jt[9].getText());
			mvo.setLinsert(jt[10].getText());
			mvo.setLupdate(jt[11].getText());
	
			int nCnt = ca.lesInsert(mvo);
			if (nCnt > 0) {
			JOptionPane.showMessageDialog(this, mvo.getLname() + "입력 성공.");
			System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
		}else {
			JOptionPane.showMessageDialog(this, mvo.getLname() + "입력 실패.");
			System.out.println("등록 실패  >>> :  ");
		}
		
		jtSetText();
	}
		catch (Exception e)
		{
		System.out.println("e >>> : " + e);
		}	
	}
	
	public void lesActU()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		System.out.println("jt[2] >>> : " + jt[2].getText());
		System.out.println("jt[0] >>> : " + jt[0].getText());
		// setter 세팅	
		mvo.setLname(jt[2].getText());
		mvo.setLcode(jt[0].getText());
		
		int nCnt = ca.lesUpdate(mvo);
		if (nCnt > 0) {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + " 수정 성공.");
		System.out.println("데이터가 " + nCnt + " 건 수정 되었습니다. ");
		}else {
			JOptionPane.showMessageDialog(this, mvo.getLcode() + "수정 실패.");
			System.out.println("수정 실패  >>> :  ");
		}	
		
		jtSetText();
		
	}
	
	public void lesActD()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅	
		mvo.setLcode(jt[0].getText());
		
		int nCnt = ca.lesDelete(mvo);
		if (nCnt > 0) {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + "삭제 성공.");
		System.out.println("데이터가 " + nCnt + " 건 삭제 되었습니다. ");
		}else {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + "삭제 실패.");
		System.out.println("삭제 실패  >>> :  ");
		}	
		
		jtSetText();
	}
	
	class ActionISUD implements ActionListener 
	{
	public void actionPerformed(ActionEvent ae) 
	{
		JButton jbnt = (JButton)ae.getSource();
		if ("조회".equals(jbnt.getText()))
		{
		lesActS();				
		}
		if ("등록".equals(jbnt.getText()))
		{
		lesActI();
		
		}
		if ("수정".equals(jbnt.getText()))
		{
		lesActU();
		
		}
		if ("삭제".equals(jbnt.getText()))
		{
		lesActD();
		}
		}
	}
}
