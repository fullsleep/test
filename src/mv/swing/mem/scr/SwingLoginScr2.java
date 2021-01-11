package mv.swing.mem.scr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingLoginScr2 extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 5999265611570349253L;
	
	static JFrame	mainFrame;
	//page1 ����
	JPanel	 		page1;
	JLabel[]        jlM;
	JTextField      jtM;
	JPasswordField  jpfM;
	JButton[]       jbM;
	
	//page2 ����
	private static final String[] labelCaption = {"���̵�", "��й�ȣ", "�̸�", "�ڵ�����ȣ", "E-mail"};
	private static final String[] buttonCaption = {"���", "���", "Ȯ��"};	
	JPanel	 		page2;
	JLabel[]        jlM2;
	JTextField[]      jtM2;
	JPasswordField  jpfM2;
	JButton[]       jbM2;
	
	public SwingLoginScr2(String title){
		super(title);
		mainFrame = new JFrame("Main");
		this.getContentPane().setLayout(null);

		// login JPanel ���̱�
		page1 = new JPanel();
		page1.setBorder(new EtchedBorder());
		page1.setBounds(0, 0, 500, 600);
		page1.setBackground(Color.GRAY);
		// memLogin 
		page1.setLayout(null);

		// ȸ������ JPanel ���̱�
		page2 = new JPanel();
		page2.setBorder(new EtchedBorder());
		page2.setBounds(0, 0, 500, 600);
		page2.setBackground(Color.GRAY);
		page2.setLayout(null);
		page2.setVisible(false);
		
//		ȭ�� �߾ӿ� ��ġ�ϱ�
//		this.setLocationRelativeTo(null);
//		Dimension sJ = this.getSize();
//		Dimension sS = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation((sS.width - sJ.width)/2, (sS.height - sJ.height)/2);
						
		//page1
		JPanel jpM = new JPanel();
		jpM.setLayout(null);
		jpM.setBounds(15, 40, 350, 330);
		jpM.setBackground(Color.LIGHT_GRAY);
		jpM.setBorder(new TitledBorder("MAX_VALUE �п�"));
		page1.add(jpM);
			
		jlM  = new JLabel[3];
		jtM  = new JTextField();
		jpfM = new JPasswordField();
		jbM  = new JButton[6];

		for (int j=0; j < jlM.length; j++ )	{
			jlM[j] = new JLabel();
			jlM[j].setHorizontalAlignment(SwingConstants.CENTER);
			jpM.add(jlM[j]);

		}
		
		for (int i=0; i < jbM.length; i++) {
			jbM[i] = new JButton();
			jbM[i].addActionListener(this);
			jpM.add(jbM[i]);
		}
		
		jlM[0].setText("���̵�");
		jlM[1].setText("�н�����");
		jlM[2].setText("LOG IN");
		jlM[2].setFont(new Font("����ü", Font.PLAIN, 30));
		
		jtM  = new JTextField(10);			
		jpfM = new JPasswordField(10);
		jpM.add(jtM);
		jpM.add(jpfM);

		jbM[0].setText("�α���");
		jbM[0].setBackground(Color.black);
		jbM[0].setForeground(Color.white);
		jbM[1].setText("ȸ������");
		jbM[1].setBackground(Color.black);
		jbM[1].setForeground(Color.white);
		jbM[2].setText("ID ã��");
		jbM[3].setText("��й�ȣã��");
		jbM[4].setText("�ӽú�й�ȣ �߱޹ޱ�");
		jbM[5].setText("������");
		jbM[5].setFont(new Font("����ü", Font.PLAIN, 5));
		
		jlM[0].setBounds(10, 100, 100, 30);
		jtM.setBounds(110, 100, 150, 30);
		
		jlM[1].setBounds(10, 140, 100, 30);
		jpfM.setBounds(110, 140, 150, 30);
		
		jbM[0].setBounds(10, 190, 330, 40);
		jbM[1].setBounds(10, 250, 110, 70);
		jbM[2].setBounds(130, 250, 90, 30);
		jbM[3].setBounds(220, 250, 120, 30);
		jbM[4].setBounds(130, 290, 180, 30);
		jbM[5].setBounds(290, 20, 50, 20);

		jlM[2].setBounds(15, 50, 100, 30);

		
		//page2
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBounds(15, 40, 350, 430);
		jp1.setBackground(Color.LIGHT_GRAY);
		jp1.setBorder(new TitledBorder("ȸ������"));
		page2.add(jp1);
						
		jlM2  = new JLabel[5];
		jtM2  = new JTextField[4];
		jpfM2 = new JPasswordField();
		jbM2  = new JButton[3];
		
		for (int k=0; k < jlM2.length; k++ )	{
			jlM2[k] = new JLabel(labelCaption[k]);
			jlM2[k].setHorizontalAlignment(SwingConstants.CENTER);	
			jp1.add(jlM2[k]);
		}
		
		for (int l=0; l < jtM2.length; l++ ) {
			jtM2[l] = new JTextField(10);
			jtM2[l].setBorder(new EtchedBorder());
			jp1.add(jtM2[l]);
		}
		
		jpfM2 = new JPasswordField(10);
		jp1.add(jpfM2);
		
		for (int m=0; m < jbM2.length; m++) {
			jbM2[m] = new JButton(buttonCaption[m]);
			jbM2[m].addActionListener(this);
			jp1.add(jbM2[m]);
		}
		
		jlM2[0].setBounds(10, 50, 100, 30);
		jtM2[0].setBounds(110, 50, 150, 30);
		jlM2[1].setBounds(10, 90, 100, 30);
		jpfM2.setBounds(110, 90, 150, 30);
		jlM2[2].setBounds(10, 130, 100, 30);
		jtM2[1].setBounds(110, 130, 150, 30);
		jlM2[3].setBounds(10, 170, 100, 30);
		jtM2[2].setBounds(110, 170, 150, 30);
		jlM2[4].setBounds(10, 210, 100, 30);
		jtM2[3].setBounds(110, 210, 150, 30);
				
		jbM2[0].setBounds(10, 280, 210, 40);
		jbM2[0].setBackground(Color.black);
		jbM2[0].setForeground(Color.white);
		jbM2[1].setBounds(230, 280, 110, 40);	
		jbM2[2].setBounds(270, 50, 60, 30);
		
		
		//JFrame setting
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		this.getContentPane().add(page1);
		this.getContentPane().add(page2);
	
		this.setLocation(100, 100);
		this.setSize(400, 600);
		this.setResizable(false);
		this.setVisible(true);	
	
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    		    		    	
		        if (JOptionPane.showConfirmDialog(null, 
		            "���α׷��� �����Ͻðڽ��ϱ�?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	
		        	ConsoleLogin2 cl = new ConsoleLogin2();
		    		MaxValueVO mvvo = null;
		    		mvvo = new MaxValueVO();
		        	
		    		int nCnt = cl.memLogout(mvvo);
		    		if (nCnt > 0) {
		    			System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");
		    			
		    		}else {
		    			System.out.println("��� ����  >>> :  ");
		    		}		    		
		            System.exit(0);
		        }	        		        
		    }
		});
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
	}

	
	// �α��� JTextField, JPasswordField �ʱ�ȭ 
	public void jtMSetText()
	{
		jtM.setText("");
		jpfM.setText("");
	}
	
	// ȸ������ JTextField, JPasswordField �ʱ�ȭ 
	public void jtMSetText2()
	{
		jtM2[0].setText("");
		jpfM2.setText("");
		jtM2[1].setText("");
		jtM2[2].setText("");
		jtM2[3].setText("");
	}
	
	// SwingMember event ó��  
	public void actionPerformed(ActionEvent ac) 
	{
		JButton jbnt = (JButton)ac.getSource();
		
		if ("�α���".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(jtM.getText());
			mvvo.setMpw(jpfM.getText());
			
			boolean bLogin = cl.memLogin(mvvo);
			
			if (bLogin) {
				
				int nCnt = cl.nowLogin(mvvo);
				if (nCnt > 0) {
					System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
				}else {
					System.out.println("��� ����  >>> :  ");
				}
				
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "�� �α��� ����");
				jtMSetText();
				
				this.getContentPane().removeAll();
				new SwingLessonScr(SwingLessonScr.mainFrame);
				dispose();
				
			}else {
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");					
				JOptionPane.showMessageDialog(this, mvvo.getMid() + " �� �α��� ����, �ٽ� �α��� ���ּ��� ");
				jtMSetText();
			}		
			
		}
		if ("ȸ������".equals(jbnt.getText())) {
						
			page1.setVisible(false);
			page2.setVisible(true);
			System.out.println("ȸ������ JPenal�� �̵� >>> : ");
		}	
		if ("ID ã��".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			String memail = 
					JOptionPane.showInputDialog("�̸����� �Է��ϼ���.");
			
			System.out.println("memail >>> : " + memail);
			if (memail != null){
				mvvo.setMemail(memail);
			}
			
			ArrayList<MaxValueVO> aList = cl.idSearch(mvvo);
			String _sid = "";
			if (aList.size() > 0) {
				MaxValueVO _mvvo = aList.get(0);
				_sid = _mvvo.getMid();
				System.out.println("ã���ô� ���̵�� >>> : " + _sid +" �Դϴ�.");
				JOptionPane.showMessageDialog(this, "�ش� e-mail�� ��ϵ� ���̵�� [ "
												+ _sid + " ] �Դϴ�.");
			}else {
				System.out.println("�Է��� e-mail�� �ش��ϴ� ���̵� �����ϴ�. >>> : ");
				JOptionPane.showMessageDialog(this, "�Է��� e-mail�� �ش��ϴ� ���̵� �����ϴ�.");
			}
		}	
		if ("��й�ȣã��".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			mvvo.setMid(jtM.getText());
			
			ArrayList<MaxValueVO> aList = cl.pwSearch(mvvo);
			String _mpw = "";
			if (aList.size() > 0) {
				MaxValueVO _mvvo = aList.get(0);
				_mpw = _mvvo.getMpw();
				System.out.println("ã���ô� ��й�ȣ�� >>> : " + _mpw +" �Դϴ�.");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "���� ��й�ȣ�� [ "
											+ _mpw + " ] �Դϴ�.");
			}else {
				System.out.println("���̵� �����ϴ�. >>> : ");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "���̵� �������� �ʽ��ϴ�.");
			}
		}	
		if ("�ӽú�й�ȣ �߱޹ޱ�".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			String mpw = cl.tempPW();
			System.out.println("�ӽ� ��й�ȣ >>> : " + mpw);
			
			// setter ����
			mvvo.setMid(jtM.getText());
			mvvo.setMpw(mpw);
			
			int nCnt = cl.memUpdate(mvvo);
			if (nCnt > 0) {
				System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "���� �ӽ� ��й�ȣ�� [ "
											 + mpw + " ] �Դϴ�.");
				jtMSetText();
			}else {
				System.out.println("��� ����  >>> :  ");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "���̵� �������� �ʽ��ϴ�.");
			}
		}	
		if ("������".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(jtM.getText());
			mvvo.setMpw(jpfM.getText());
			
			boolean bLogin = cl.memAdminLogin(mvvo);
			
			if (bLogin) {
				
				int nCnt = cl.nowLogin(mvvo);
				if (nCnt > 0) {
					System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
				}else {
					System.out.println("��� ����  >>> :  ");
				}
				
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "�� �α��� ����");
				jtMSetText();
				
				this.getContentPane().removeAll();
				new SwingAdminScr(SwingAdminScr.mainFrame);
				dispose();
			}else {
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");					
				JOptionPane.showMessageDialog(this, mvvo.getMid() + " �� �α��� ����, �ٽ� �α��� ���ּ��� ");
				jtMSetText();
			}	
		}
	
		//page2 action
		if ("���".equals(jbnt.getText())) {
			ConsoleNewMemberScr cnm = new ConsoleNewMemberScr();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			// setter ����
			//mvvo.setMnum(mnum);
			mvvo.setMid(jtM2[0].getText());
			mvvo.setMpw(jpfM2.getText());
			mvvo.setMname(jtM2[1].getText());
			mvvo.setMhp(jtM2[2].getText());
			mvvo.setMemail(jtM2[3].getText());
			
			boolean newId = cnm.idConfirm(mvvo);
			
			if (newId) {
				int nCnt = cnm.memInsert(mvvo);
				if (nCnt > 0) {
					JOptionPane.showMessageDialog(this, mvvo.getMname() + "�� ȸ������ ����.");
					System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
					jtMSetText2();
					
					page1.setVisible(true);
					page2.setVisible(false);
					System.out.println("�α��� JPenal�� �̵� >>> : ");
				}else {
					JOptionPane.showMessageDialog(this, mvvo.getMname() + "�� ȸ������ ����.");
					System.out.println("��� ����  >>> :  ");
					jtMSetText2();
				}		
			}else {
				JOptionPane.showMessageDialog(this, "�̹� ������� ���̵��Դϴ�.");
				jtMSetText2();
			}		

		}
		if ("���".equals(jbnt.getText())) {
			page1.setVisible(true);
			page2.setVisible(false);
			System.out.println("�α��� JPenal�� �̵� >>> : ");
		}
		if ("Ȯ��".equals(jbnt.getText())) {
			ConsoleNewMemberScr cnm = new ConsoleNewMemberScr();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			// setter ����
			//mvvo.setMnum(mnum);
			mvvo.setMid(jtM2[0].getText());
			//mvvo.setMpw(jpfM2.getText());
			//mvvo.setMname(jtM2[1].getText());
			//mvvo.setMhp(jtM2[2].getText());
			//mvvo.setMemail(jtM2[3].getText());
			
			boolean newId = cnm.idConfirm(mvvo);
			
			if (newId) {
				JOptionPane.showMessageDialog(this, "��� ������ ���̵��Դϴ�.");	
			}else {
				JOptionPane.showMessageDialog(this, "�̹� ������� ���̵��Դϴ�.");
				jtMSetText2();
			}	
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingLoginScr2("MAX_VALUE");
	}
}
