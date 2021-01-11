package mv.swing.mem.scr;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingNewMemberScr extends JPanel {

	private static final String[] labelCaption = {"���̵�", "��й�ȣ", "�̸�", "�ڵ�����ȣ", "E-mail"};
	private static final String[] buttonCaption = {"���", "���"};

	JPanel[]		jp;
	JTabbedPane 	jtp;	
	JLabel[]        jlM;
	JTextField      jtM;
	JPasswordField  jpfM;
	JButton[]       jbM;
	CardLayout 		cards;
	
	public SwingNewMemberScr() 
	{		
		setLayout(null);
		
		jp = new JPanel[2];	
		for (int i=0; i < jp.length; i++ )
		{
			jp[i] = new JPanel();	
			jp[i].setLayout(null);
		}
		jp[0].setBounds(0, 0, 350, 330);
		jp[0].setBackground(Color.GRAY);
		jp[0].setBorder(new TitledBorder("ȸ������"));
		
		jp[1].setBounds(0, 0, 350, 330);
		jp[1].setBackground(Color.LIGHT_GRAY);
		jp[1].setBorder(new EtchedBorder());
		
		jp[0].setVisible(true);
		jp[1].setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingNewMemberScr();
	}
}
