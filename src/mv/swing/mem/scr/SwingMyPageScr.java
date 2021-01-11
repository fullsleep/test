package mv.swing.mem.scr;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mv.swing.mem.dao.MvMypageDAO;
import mv.swing.mem.dao.MvMypageDAOImpl;
import mv.swing.mem.vo.MaxValueVO;

public class SwingMyPageScr extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static String mnum;
	private static String mid;
	private static String mpw;
	private static String mname;
	private static String mhp;
	private static String memail;
	private static String mdyn;
	private static String minsert;
	private static String mupdate;
		
	JPanel jp;
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JLabel jl4;
	JLabel jl5;
	JLabel jl6;
	JLabel jl7;
	JTextField jt1;
	JTextField jt2;
	JTextField jt31;
	JTextField jt32;
	JTextField jt33;
	JTextField jt4;
	JTextField jt5;
	JTextField jt6;
	JPasswordField jpw;
	JButton jb1;
	JButton jb2;
	JButton jb3;

	public SwingMyPageScr(String title) {
		super(title);
		
		setLayout(null);
		
		jp = new JPanel();
		
		jp.setLayout(null);
		
		jl1 = new JLabel("아이디");
		jl1.setBounds(10, 10, 100, 30);
				
		jl2 = new JLabel("비밀번호");
		jl2.setBounds(10, 60, 100, 30);
		
		jl3 = new JLabel("이름");
		jl3.setBounds(10, 110, 100, 30);
		
		jl4 = new JLabel("전화번호");
		jl4.setBounds(10, 160, 100, 30);
		
		jl5 = new JLabel("e-mail");
		jl5.setBounds(10, 210, 100, 30);
		
		jl6 = new JLabel("등록일");
		jl6.setBounds(10, 260, 100, 30);
		
		jl7 = new JLabel("수정일");
		jl7.setBounds(10, 310, 100, 30);
		
		jt1 = new JTextField();
		jt1.setBounds(110, 10, 500, 30);
				
		jpw = new JPasswordField();
		jpw.setBounds(110, 60, 500, 30);
				
		jt2 = new JTextField();
		jt2.setBounds(110, 110, 500, 30);
				
		jt31 = new JTextField();
		jt31.setBounds(110, 160, 100, 30);
		
		jt32 = new JTextField();
		jt32.setBounds(215, 160, 195, 30);
		
		jt33 = new JTextField();
		jt33.setBounds(415, 160, 195, 30);
		
		jt4 = new JTextField();
		jt4.setBounds(110, 210, 500, 30);
				
		jt5 = new JTextField();
		jt5.setBounds(110, 260, 500, 30);
				
		jt6 = new JTextField();
		jt6.setBounds(110, 310, 500, 30);
				
		jb1 = new JButton("조회");
		jb1.setBounds(380, 370, 70, 50);
		jb1.addActionListener(this);
		
		jb2 = new JButton("수정");
		jb2.setBounds(460, 370, 70, 50);
		jb2.addActionListener(this);
		
		jb3 = new JButton("탈퇴");
		jb3.setBounds(540, 370, 70, 50);
		jb3.addActionListener(this);
		
		jp.add(jl1);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(jl4);
		jp.add(jl5);
		jp.add(jl6);
		jp.add(jl7);
		jp.add(jt1);
		jp.add(jpw);
		jp.add(jt2);
		jp.add(jt31);
		jp.add(jt32);
		jp.add(jt33);
		jp.add(jt4);
		jp.add(jt5);
		jp.add(jt6);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		
		jp.setBounds(0, 0, 650, 470);
		getContentPane().add(jp);
				
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation(screenSize.width / 6,  screenSize.height / 6);
		this.setSize(650, 470);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			mvo.setMnum("M202011250001");
			
			ArrayList<MaxValueVO> aList = SwingMyPageScr.memSelect(mvo);
			if(aList.size() > 0) {
				for(int i = 0; i < aList.size(); i++) {
					mvo = aList.get(i);
					mnum = mvo.getMnum();
					mid = mvo.getMid();
					mpw = mvo.getMpw();
					mname = mvo.getMname();
					mhp = mvo.getMhp();
					memail = mvo.getMemail();
					mdyn = mvo.getMdyn();
					minsert = mvo.getMinsert();
					mupdate = mvo.getMupdate();
					if(mdyn.equals("Y")) {
						jt1.setText(mid);
						jpw.setText(mpw);
						jt2.setText(mname);
						jt31.setText(mhp.substring(0, 3));
						jt32.setText(mhp.substring(3, 7));
						jt33.setText(mhp.substring(7));
						jt4.setText(memail);
						jt5.setText(minsert);
						jt6.setText(mupdate);
					}
				}
			}
			else {
				jt1.setText("");
				jpw.setText("");
				jt2.setText("");
				jt31.setText("");
				jt32.setText("");
				jt33.setText("");
				jt4.setText("");
				jt5.setText("");
				jt6.setText("");
			}
		}
		if(e.getSource() == jb2) {
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			mhp = jt31.getText().concat(jt32.getText()).concat(jt33.getText());
			mvo.setMhp(mhp);
			mvo.setMnum(mnum);
			
			SwingMyPageScr.memUpdate(mvo);
		}
		if(e.getSource() == jb3) {
			MaxValueVO mvo = null;
			mvo = new MaxValueVO();
			mvo.setMnum(mnum);
						
			SwingMyPageScr.memDelete(mvo);
		}
	}
	
	public static ArrayList<MaxValueVO> memSelect(MaxValueVO _mvo) {
		MvMypageDAO sdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelect(_mvo);
		
		return aList;
	}
	
	public static int memUpdate(MaxValueVO mvo) {
		MvMypageDAO sdao = new MvMypageDAOImpl();
		int nCnt = sdao.memUpdate(mvo);
		
		return nCnt;
	}
	
	public static int memDelete(MaxValueVO mvo) {
		MvMypageDAO sdao = new MvMypageDAOImpl();
		int nCnt = sdao.memDelete(mvo);
		
		return nCnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingMyPageScr("회원정보");
	}

}
