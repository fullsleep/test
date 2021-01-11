package mv.swing.mem.scr;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingMemberISD extends JPanel
{
	private static final String[] labelCaption = {	"과목번호", "과목분류", "과목명", 
										            "개강일", "종강일", "수업요일",
										            "수업시간", "선생님", "강의실",
										            "수업진행여부", "등록일", "수정일"
										         };

	private static final String[] buttonCaption = {"과목조회", "수강신청", "수강취소"};

	JPanel[]			jp = null;
	JLabel[]			jl = null;
	JTextField[]  jt = null;
	JButton[]     jb = null;
	
	public SwingMemberISD() 
	{		
		setLayout(new BorderLayout(15, 5));
System.out.println(" getLayout() >>> : " + getLayout());
		
		jp = new JPanel[3];
		jl = new JLabel[12];
		jt = new JTextField[12];
		jb = new JButton[3];

		for (int i=0; i < jp.length; i++ )
		{
			jp[i] = new JPanel();			
		}
		jp[0].setBorder(new TitledBorder("과목선택"));
		jp[1].setBorder(new EtchedBorder());

		for (int j=0; j < jl.length; j++ )
		{
			jl[j] = new JLabel(labelCaption[j]);			
			jl[j].setFont(new Font("굴림체", Font.BOLD, 12));
			jl[j].setHorizontalAlignment(SwingConstants.CENTER);
			jt[j] = new JTextField(33);
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
	}
	
	// 로그인 JTextField, JPasswordField 초기화 
	public void jtSetText()
	{
		for (int i=1; i < 13; i++)
		{
			jt[i].setText("");
		}
	}

	public void lesActS()
	{
		MvMypageScr mms = new MvMypageScr();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter 세팅
		mvo.setLcode(jt[0].getText());
		
		ArrayList<MaxValueVO> aList = mms.lessonSelect(mvo);
		if (aList.size() > 0) {
			JOptionPane.showMessageDialog(this, mvo.getLcode() + "조회 성공");
			for (int i=0; i < aList.size(); i++) {
				MaxValueVO _mvo = aList.get(i);
				MaxValueVO.printVO(_mvo);
				//jt[1].setText(_mvo.getLcode());
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
			System.out.println("과목 : " + mvo.getLcode() + " 의 데이터가 존재하지 않습니다. ");
			JOptionPane.showMessageDialog(this, mvo.getLcode() + " 데이터가 없습니다.");
		}				
	}
	
	public void lesActI()
	{
		try
		{
			MvMypageScr mms = new MvMypageScr();				
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			// setter 세팅
			mvo.setLcode(jt[0].getText());
			mvo.setLname(jt[2].getText());
			// 다른  textfield 값 사용하시 않아서 Exception 발생, 프로그램 가동에는 문제 없음
			mvo.setLsubject(jt[1].getText());
			mvo.setLstr(jt[3].getText());
			mvo.setLend(jt[4].getText());
			mvo.setLday(jt[5].getText());
			mvo.setLtime(jt[6].getText());
			mvo.setLteacher(jt[7].getText());
			mvo.setLroom(jt[8].getText());
			mvo.setLdyn(jt[9].getText());
			mvo.setLinsert(jt[10].getText());
			mvo.setLupdate(jt[11].getText());
			
			// mvo.setSnum(jt[0].getText());
			//mvo.setMlnum(jt[0].getText());
			//mvo.setMnum(jt[1].getText());
			//mvo.setLcode(jt[2].getText());
			//mvo.setMldyn(jt[3].getText());
			//mvo.setMlinsert(jt[4].getText());
			//mvo.setMlupdate(jt[5].getText());
				
			int nCnt = mms.lesInsert(mvo);
// 에러 날 수 있음
			if (nCnt > 0) {
				JOptionPane.showMessageDialog(this, mvo.getLcode() + " 수강신청이 완료되었습니다.");
				System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
			}else {
				JOptionPane.showMessageDialog(this, mvo.getLcode() + "수강신청에 실패하였습니다.");
				System.out.println("등록 실패  >>> :  ");
			}
			
			jtSetText();
		}
		catch (Exception e)
		{
			System.out.println("e >>> : " + e);
		}	
	}
	public void lesActD()
	{
			MvMypageScr mms = new MvMypageScr();				
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			// setter 세팅
			// mvo.setMlnum(jt[0].getText());
			mvo.setLcode(jt[0].getText());
			mvo.setLname(jt[2].getText());
			
			int nCnt = mms.lesDelete(mvo);
			if (nCnt > 0)
			{
				JOptionPane.showMessageDialog(this, mvo.getLname() + " 수강취소 성공.");
				System.out.println("수강신청이 " + nCnt + " 건 취소 되었습니다. ");
			}else {
				JOptionPane.showMessageDialog(this, mvo.getLname() + " 수강취소 실패.");
				System.out.println("수강취소 실패  >>> :  ");
			}
			//jtSetText();  <= 오류 발생
	}
	class ActionISUD implements ActionListener 
	{
		public void actionPerformed(ActionEvent ae) 
		{
			
			JButton jbnt = (JButton)ae.getSource();
			if ("과목조회".equals(jbnt.getText()))
			{
				lesActS();				
			}
			
			if ("수강신청".equals(jbnt.getText()))
			{
				lesActI();
				
			}
			if ("수강취소".equals(jbnt.getText()))
			{
				lesActD();
			}
		}
	}
}