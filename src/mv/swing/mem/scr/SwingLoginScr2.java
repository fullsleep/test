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
	//page1 변수
	JPanel	 		page1;
	JLabel[]        jlM;
	JTextField      jtM;
	JPasswordField  jpfM;
	JButton[]       jbM;
	
	//page2 변수
	private static final String[] labelCaption = {"아이디", "비밀번호", "이름", "핸드폰번호", "E-mail"};
	private static final String[] buttonCaption = {"등록", "취소", "확인"};	
	JPanel	 		page2;
	JLabel[]        jlM2;
	JTextField[]      jtM2;
	JPasswordField  jpfM2;
	JButton[]       jbM2;
	
	public SwingLoginScr2(String title){
		super(title);
		mainFrame = new JFrame("Main");
		this.getContentPane().setLayout(null);

		// login JPanel 붙이기
		page1 = new JPanel();
		page1.setBorder(new EtchedBorder());
		page1.setBounds(0, 0, 500, 600);
		page1.setBackground(Color.GRAY);
		// memLogin 
		page1.setLayout(null);

		// 회원가입 JPanel 붙이기
		page2 = new JPanel();
		page2.setBorder(new EtchedBorder());
		page2.setBounds(0, 0, 500, 600);
		page2.setBackground(Color.GRAY);
		page2.setLayout(null);
		page2.setVisible(false);
		
//		화면 중앙에 위치하기
//		this.setLocationRelativeTo(null);
//		Dimension sJ = this.getSize();
//		Dimension sS = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation((sS.width - sJ.width)/2, (sS.height - sJ.height)/2);
						
		//page1
		JPanel jpM = new JPanel();
		jpM.setLayout(null);
		jpM.setBounds(15, 40, 350, 330);
		jpM.setBackground(Color.LIGHT_GRAY);
		jpM.setBorder(new TitledBorder("MAX_VALUE 학원"));
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
		
		jlM[0].setText("아이디");
		jlM[1].setText("패스워드");
		jlM[2].setText("LOG IN");
		jlM[2].setFont(new Font("굴림체", Font.PLAIN, 30));
		
		jtM  = new JTextField(10);			
		jpfM = new JPasswordField(10);
		jpM.add(jtM);
		jpM.add(jpfM);

		jbM[0].setText("로그인");
		jbM[0].setBackground(Color.black);
		jbM[0].setForeground(Color.white);
		jbM[1].setText("회원가입");
		jbM[1].setBackground(Color.black);
		jbM[1].setForeground(Color.white);
		jbM[2].setText("ID 찾기");
		jbM[3].setText("비밀번호찾기");
		jbM[4].setText("임시비밀번호 발급받기");
		jbM[5].setText("관리자");
		jbM[5].setFont(new Font("굴림체", Font.PLAIN, 5));
		
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
		jp1.setBorder(new TitledBorder("회원가입"));
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
		            "프로그램을 종료하시겠습니까?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	
		        	ConsoleLogin2 cl = new ConsoleLogin2();
		    		MaxValueVO mvvo = null;
		    		mvvo = new MaxValueVO();
		        	
		    		int nCnt = cl.memLogout(mvvo);
		    		if (nCnt > 0) {
		    			System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");
		    			
		    		}else {
		    			System.out.println("등록 실패  >>> :  ");
		    		}		    		
		            System.exit(0);
		        }	        		        
		    }
		});
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
	}

	
	// 로그인 JTextField, JPasswordField 초기화 
	public void jtMSetText()
	{
		jtM.setText("");
		jpfM.setText("");
	}
	
	// 회원가입 JTextField, JPasswordField 초기화 
	public void jtMSetText2()
	{
		jtM2[0].setText("");
		jpfM2.setText("");
		jtM2[1].setText("");
		jtM2[2].setText("");
		jtM2[3].setText("");
	}
	
	// SwingMember event 처리  
	public void actionPerformed(ActionEvent ac) 
	{
		JButton jbnt = (JButton)ac.getSource();
		
		if ("로그인".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(jtM.getText());
			mvvo.setMpw(jpfM.getText());
			
			boolean bLogin = cl.memLogin(mvvo);
			
			if (bLogin) {
				
				int nCnt = cl.nowLogin(mvvo);
				if (nCnt > 0) {
					System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
				}else {
					System.out.println("등록 실패  >>> :  ");
				}
				
				System.out.println(mvvo.getMid() + " 님 로그인 성공 했습니다.");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "님 로그인 성공");
				jtMSetText();
				
				this.getContentPane().removeAll();
				new SwingLessonScr(SwingLessonScr.mainFrame);
				dispose();
				
			}else {
				System.out.println(mvvo.getMid() + " 님 로그인 실패 했습니다.");					
				JOptionPane.showMessageDialog(this, mvvo.getMid() + " 님 로그인 실패, 다시 로그인 해주세요 ");
				jtMSetText();
			}		
			
		}
		if ("회원가입".equals(jbnt.getText())) {
						
			page1.setVisible(false);
			page2.setVisible(true);
			System.out.println("회원가입 JPenal로 이동 >>> : ");
		}	
		if ("ID 찾기".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			String memail = 
					JOptionPane.showInputDialog("이메일을 입력하세요.");
			
			System.out.println("memail >>> : " + memail);
			if (memail != null){
				mvvo.setMemail(memail);
			}
			
			ArrayList<MaxValueVO> aList = cl.idSearch(mvvo);
			String _sid = "";
			if (aList.size() > 0) {
				MaxValueVO _mvvo = aList.get(0);
				_sid = _mvvo.getMid();
				System.out.println("찾으시는 아이디는 >>> : " + _sid +" 입니다.");
				JOptionPane.showMessageDialog(this, "해당 e-mail로 등록된 아이디는 [ "
												+ _sid + " ] 입니다.");
			}else {
				System.out.println("입력한 e-mail에 해당하는 아이디가 없습니다. >>> : ");
				JOptionPane.showMessageDialog(this, "입력한 e-mail에 해당하는 아이디가 없습니다.");
			}
		}	
		if ("비밀번호찾기".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			mvvo.setMid(jtM.getText());
			
			ArrayList<MaxValueVO> aList = cl.pwSearch(mvvo);
			String _mpw = "";
			if (aList.size() > 0) {
				MaxValueVO _mvvo = aList.get(0);
				_mpw = _mvvo.getMpw();
				System.out.println("찾으시는 비밀번호는 >>> : " + _mpw +" 입니다.");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "님의 비밀번호는 [ "
											+ _mpw + " ] 입니다.");
			}else {
				System.out.println("아이디가 없습니다. >>> : ");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "아이디가 존재하지 않습니다.");
			}
		}	
		if ("임시비밀번호 발급받기".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			String mpw = cl.tempPW();
			System.out.println("임시 비밀번호 >>> : " + mpw);
			
			// setter 세팅
			mvvo.setMid(jtM.getText());
			mvvo.setMpw(mpw);
			
			int nCnt = cl.memUpdate(mvvo);
			if (nCnt > 0) {
				System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "님의 임시 비밀번호는 [ "
											 + mpw + " ] 입니다.");
				jtMSetText();
			}else {
				System.out.println("등록 실패  >>> :  ");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "아이디가 존재하지 않습니다.");
			}
		}	
		if ("관리자".equals(jbnt.getText())) {
			
			ConsoleLogin2 cl = new ConsoleLogin2();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(jtM.getText());
			mvvo.setMpw(jpfM.getText());
			
			boolean bLogin = cl.memAdminLogin(mvvo);
			
			if (bLogin) {
				
				int nCnt = cl.nowLogin(mvvo);
				if (nCnt > 0) {
					System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
				}else {
					System.out.println("등록 실패  >>> :  ");
				}
				
				System.out.println(mvvo.getMid() + " 님 로그인 성공 했습니다.");
				JOptionPane.showMessageDialog(this, mvvo.getMid() + "님 로그인 성공");
				jtMSetText();
				
				this.getContentPane().removeAll();
				new SwingAdminScr(SwingAdminScr.mainFrame);
				dispose();
			}else {
				System.out.println(mvvo.getMid() + " 님 로그인 실패 했습니다.");					
				JOptionPane.showMessageDialog(this, mvvo.getMid() + " 님 로그인 실패, 다시 로그인 해주세요 ");
				jtMSetText();
			}	
		}
	
		//page2 action
		if ("등록".equals(jbnt.getText())) {
			ConsoleNewMemberScr cnm = new ConsoleNewMemberScr();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			// setter 세팅
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
					JOptionPane.showMessageDialog(this, mvvo.getMname() + "님 회원가입 성공.");
					System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
					jtMSetText2();
					
					page1.setVisible(true);
					page2.setVisible(false);
					System.out.println("로그인 JPenal로 이동 >>> : ");
				}else {
					JOptionPane.showMessageDialog(this, mvvo.getMname() + "님 회원가입 실패.");
					System.out.println("등록 실패  >>> :  ");
					jtMSetText2();
				}		
			}else {
				JOptionPane.showMessageDialog(this, "이미 사용중인 아이디입니다.");
				jtMSetText2();
			}		

		}
		if ("취소".equals(jbnt.getText())) {
			page1.setVisible(true);
			page2.setVisible(false);
			System.out.println("로그인 JPenal로 이동 >>> : ");
		}
		if ("확인".equals(jbnt.getText())) {
			ConsoleNewMemberScr cnm = new ConsoleNewMemberScr();			
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			// setter 세팅
			//mvvo.setMnum(mnum);
			mvvo.setMid(jtM2[0].getText());
			//mvvo.setMpw(jpfM2.getText());
			//mvvo.setMname(jtM2[1].getText());
			//mvvo.setMhp(jtM2[2].getText());
			//mvvo.setMemail(jtM2[3].getText());
			
			boolean newId = cnm.idConfirm(mvvo);
			
			if (newId) {
				JOptionPane.showMessageDialog(this, "사용 가능한 아이디입니다.");	
			}else {
				JOptionPane.showMessageDialog(this, "이미 사용중인 아이디입니다.");
				jtMSetText2();
			}	
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingLoginScr2("MAX_VALUE");
	}
}
