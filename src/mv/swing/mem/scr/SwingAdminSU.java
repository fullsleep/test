package mv.swing.mem.scr;
// ������ ���� ��ȸ
// ������ ���� ����
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminSU extends JPanel{
	
	private static final String[] labelCaption = {	"ȸ����ȣ", "ȸ�����", "���̵�", 
										            "�̸�", "��ȭ��ȣ","�̸���", 
										            "ȸ������","�����","������"};

	private static final String[] buttonCaption = {"��ȸ","����"};
	
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
		jp[0].setBorder(new TitledBorder("����������"));
		jp[1].setBorder(new EtchedBorder());
		
		for (int j=0; j < jl.length; j++ )
		{
			jl[j] = new JLabel(labelCaption[j]);			
			jl[j].setFont(new Font("����ü", Font.BOLD, 12));
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
		
			// ��ư �̺�Ʈ ó��
			jb[k].addActionListener(new ActionSU());
			jp[1].add(jb[k]);
		}
		
			jp[0].setLayout(new GridLayout(13, 2, 5, 12));		
			jp[1].setLayout(new GridLayout(1, 4, 2, 2));
			
			// ��������, �����, ������ : Read Only : disible
			jt[6].setEditable(false);
			jt[7].setEditable(false);
			jt[8].setEditable(false);
			
			add(jp[0], BorderLayout.CENTER);
			add(jp[1], BorderLayout.SOUTH);		
		}
		
	// �α��� JTextField, JPasswordField �ʱ�ȭ 
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
		// setter ����
		mvo.setMnum(jt[0].getText());
	
		ArrayList<MaxValueVO> aList = ca.memSelect(mvo);
		if (aList.size() > 0) {
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "�� ��ȸ ����");
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
			System.out.println("ȸ���̸� : " + mvo.getMnum() + " ���� �����Ͱ� �������� �ʽ��ϴ�. ");
			JOptionPane.showMessageDialog(this, mvo.getMnum() + "�� �����Ͱ� �����ϴ�.");
		}				
	}
	
	
	
	public void memActU()
	{
		ConsoleAdmin ca = new ConsoleAdmin();				
		MaxValueVO mvo = null;
		mvo = new MaxValueVO();
		System.out.println("jt[1] >>> : " + jt[1].getText());
		System.out.println("jt[0] >>> : " + jt[0].getText());
		// setter ����	
		mvo.setMgrade(jt[1].getText());
		mvo.setMnum(jt[0].getText());
		
		int nCnt = ca.memUpdate(mvo);
		if (nCnt > 0) {
		JOptionPane.showMessageDialog(this, mvo.getMnum() + "��  ���� ����.");
		System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
		}else {
		JOptionPane.showMessageDialog(this, mvo.getMnum() + "��  ���� ����.");
		System.out.println("���� ����  >>> :  ");
		}	
		
		jtSetText();
		
	}
	
	class ActionSU implements ActionListener 
	{
		public void actionPerformed(ActionEvent ae) 
		{
			JButton jbnt = (JButton)ae.getSource();
			if ("��ȸ".equals(jbnt.getText()))
			{
			memActS();				
			}
			if ("����".equals(jbnt.getText()))
			{
			memActU();
			
			}
		}
	}
}