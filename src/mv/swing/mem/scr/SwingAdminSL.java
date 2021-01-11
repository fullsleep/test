package mv.swing.mem.scr;
// ������ ��� ��ü ��ȸ
// ������ ��� ���� ��ȸ
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminSL extends JPanel {
	
	private static final String[] labelCaption = {	"�����", "ȸ���̸�", "������", 
										            "������", "��������", "�����ð�",
										            "������", "���ǽ�"};

	private static final String[] buttonCaption = {"��ȸ"};
	
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
	jp[0].setBorder(new TitledBorder("���� ���� ȸ��"));
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
	jb[k].addActionListener(new ActionSL());
	jp[1].add(jb[k]);
	}
	
	jp[0].setLayout(new GridLayout(13, 2, 5, 12));		
	jp[1].setLayout(new GridLayout(1, 4, 2, 2));
	
	add(jp[0], BorderLayout.CENTER);
	add(jp[1], BorderLayout.SOUTH);		
	}
	
	// �α��� JTextField, JPasswordField �ʱ�ȭ 
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
		// setter ����
		mvo.setMname(jt[1].getText());
		
		ArrayList<MaxValueVO> aList = ca.mlSelect(mvo);
		if (aList.size() > 0) {
		JOptionPane.showMessageDialog(this, mvo.getMname() + "�� ��ȸ ����");
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
		System.out.println("ȸ���̸� : " + mvo.getMname() + " ���� �����Ͱ� �������� �ʽ��ϴ�. ");
		JOptionPane.showMessageDialog(this, mvo.getMname() + "�� �����Ͱ� �����ϴ�.");
		}				
	}
	
		class ActionSL implements ActionListener 
		{
		public void actionPerformed(ActionEvent ae) 
		{
			JButton jbnt = (JButton)ae.getSource();
			if ("��ȸ".equals(jbnt.getText()))
			{
			mlActS();				
			}

		}
	}
}
