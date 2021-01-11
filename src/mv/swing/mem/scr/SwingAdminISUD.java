package mv.swing.mem.scr;
// �������� �Է�
// �������� ��ȸ
// �������� ����
// �������� ����
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminISUD extends JPanel{
	
	private static final String[] labelCaption = {	"�����ڵ�", "����з�", "�����", 
										            "������", "������", "��������",
										            "�����ð�", "������", "���ǽ�",
										            "������������","���������","����������"};

	private static final String[] buttonCaption = {"��ȸ", "���", "����", "����"};
	
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
	JRadioButton jrb = new JRadioButton("����(WD)");
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
	jp[0].setBorder(new TitledBorder("��������"));
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
	jt[9].setEditable(false);
	jt[10].setEditable(false);
	jt[11].setEditable(false);
	
	add(jp[0], BorderLayout.CENTER);
	add(jp[1], BorderLayout.SOUTH);		
	/*
	JRadioButton jrb = new JRadioButton("����(WD)");
	jrb.setBounds(0, 0, 10, 10);		
	this.add(jrb);
	*/
	
	}
	
	// �α��� JTextField, JPasswordField �ʱ�ȭ 
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
		// setter ����
		mvo.setLcode(jt[0].getText());
		
		ArrayList<MaxValueVO> aList = ca.lesSelect(mvo);
		if (aList.size() > 0) {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + "���� ��ȸ ����");
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
		System.out.println("�����ڵ� : " + mvo.getLcode() + " �����Ͱ� �������� �ʽ��ϴ�. ");
		JOptionPane.showMessageDialog(this, mvo.getLcode() + " �����Ͱ� �����ϴ�.");
		}				
	}
	
	public void lesActI()
	{
		try
		{
			ConsoleAdmin ca = new ConsoleAdmin();				
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			// setter ����
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
			JOptionPane.showMessageDialog(this, mvo.getLname() + "�Է� ����.");
			System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
		}else {
			JOptionPane.showMessageDialog(this, mvo.getLname() + "�Է� ����.");
			System.out.println("��� ����  >>> :  ");
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
		// setter ����	
		mvo.setLname(jt[2].getText());
		mvo.setLcode(jt[0].getText());
		
		int nCnt = ca.lesUpdate(mvo);
		if (nCnt > 0) {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + " ���� ����.");
		System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
		}else {
			JOptionPane.showMessageDialog(this, mvo.getLcode() + "���� ����.");
			System.out.println("���� ����  >>> :  ");
		}	
		
		jtSetText();
		
	}
	
	public void lesActD()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		// setter ����	
		mvo.setLcode(jt[0].getText());
		
		int nCnt = ca.lesDelete(mvo);
		if (nCnt > 0) {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + "���� ����.");
		System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
		}else {
		JOptionPane.showMessageDialog(this, mvo.getLcode() + "���� ����.");
		System.out.println("���� ����  >>> :  ");
		}	
		
		jtSetText();
	}
	
	class ActionISUD implements ActionListener 
	{
	public void actionPerformed(ActionEvent ae) 
	{
		JButton jbnt = (JButton)ae.getSource();
		if ("��ȸ".equals(jbnt.getText()))
		{
		lesActS();				
		}
		if ("���".equals(jbnt.getText()))
		{
		lesActI();
		
		}
		if ("����".equals(jbnt.getText()))
		{
		lesActU();
		
		}
		if ("����".equals(jbnt.getText()))
		{
		lesActD();
		}
		}
	}
}
