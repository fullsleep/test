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
	private static final String[] labelCaption = {	"ȸ����ȣ", "ȸ�����", "���̵�", 
													"��й�ȣ", "�̸�", "��ȭ��ȣ",
													"�̸���", "ȸ������",
													"�����", "������"};

	private static final String[] buttonCaption = {"ȸ����ȸ", "��������", "ȸ��Ż��"};

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
		jp[0].setBorder(new TitledBorder("ȸ������"));
		jp[1].setBorder(new EtchedBorder());

		for (int j=0; j < jl.length; j++ )
		{
			jl[j] = new JLabel(labelCaption[j]);			
			jl[j].setFont(new Font("����ü", Font.BOLD, 12));
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

			// ��ư �̺�Ʈ ó��
			jb[k].addActionListener(new ActionISUD());
			jp[1].add(jb[k]);
		}

		jp[0].setLayout(new GridLayout(13, 2, 5, 12));		
		jp[1].setLayout(new GridLayout(1, 4, 2, 2));
		
		// ��������, �����, ������ : Read Only : disible
		jt[7].setEditable(false);
		jt[8].setEditable(false);
		jt[9].setEditable(false);

		add(jp[0], BorderLayout.CENTER);
		add(jp[1], BorderLayout.SOUTH);	

	}
	
	// �α��� JTextField, JPasswordField �ʱ�ȭ 
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
		// setter ����
		//mvo.setMnum(jt[0].getText());
		
		ArrayList<MaxValueVO> aList = sms.memSelect(mvo);
		if (aList.size() > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "�� ��ȸ ����");
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
			System.out.println("ȸ����ȣ : " + mvo.getMnum() + " ���� �����Ͱ� �������� �ʽ��ϴ�. ");
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "�� �����Ͱ� �����ϴ�.");
		}				
	}
		
	public void memActU()
	{
		MvMypageScr mms = new MvMypageScr();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		System.out.println("jt[5] >>> : " + jt[5].getText());
		System.out.println("jt[0] >>> : " + jt[0].getText());
				
		// setter ����	
		mvo.setMhp(jt[5].getText());
		//mvo.setMnum(jt[0].getText());
						
		int nCnt = mms.memUpdate(mvo);
		if (nCnt > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "  ���� ����.");
			System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
		}else {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "  ���� ����.");
			System.out.println("���� ����  >>> :  ");
		}	
		
		//jtSetText();
		
	}
	
	public void memActD()
	{
		MvMypageScr mms = new MvMypageScr();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter ����	
		mvo.setMnum(jt[0].getText());
		
		int nCnt = mms.memDelete(mvo);
		if (nCnt > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + " ���� ����.");
			System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");	
		}else {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + " ���� ����.");
			System.out.println("���� ����  >>> :  ");
		}	
		
		//jtSetText();
	}

	class ActionISUD implements ActionListener 
	{
		public void actionPerformed(ActionEvent ae) 
		{
			JButton jbnt = (JButton)ae.getSource();
			if ("ȸ����ȸ".equals(jbnt.getText()))
			{
				memActS();				
			}
			if ("��������".equals(jbnt.getText()))
			{
				memActU();
				
			}
			if ("ȸ��Ż��".equals(jbnt.getText()))
			{
				memActD();
			}
		}
	}
}