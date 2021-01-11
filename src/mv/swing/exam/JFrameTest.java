package mv.swing.exam;

//Swing 패키지 는 
//자바에서 제공하는 C/S (Client/Server) 환경에서 
//사용하는 GUI(Graphical User Interface) 컴포넌트이다.
// Swing 패키지, awt 패키지에 있는 컴포넌트 클래스를 사용할 때는 
// 생성자 사용법을 잘 알고 있어야 한다. 

//1. 생성자에서 UI 그리는 것을 한다. 
//   UI 내용이 많으면 함수 또는 클래스로 만들어서 생성자에서 호출 한다. 
//2. UI 컴포넌트를 JPanel 을 이용해서 JFrame 붙인다.    
//3. 이벤트를 선정해서 이벤트리스너를 이용해서 해당 컴포넌트와 이벤트 연결 한다. 
//4. 스웡은 컴포넌트 생성자를 잘 이용해야 한다. API 보면서 
//https://www.javatpoint.com/java-jbutton
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class JFrameTest extends JFrame {

	private static final long serialVersionUID = 1L;
		
	public JFrameTest(String title) {
		super(title);
		
		setLayout(null);
		// 수강생정보 버튼
		JButton jb1 = new JButton("수강생정보");
		jb1.setBounds(10, 10, 140, 50);
		this.add(jb1);
		// 수강중인강의 버튼
		JButton jb2 = new JButton("수강중인강의");
		jb2.setBounds(170, 10, 140, 50);
		this.add(jb2);
		// 수강신청 버튼
		JButton jb3 = new JButton("수강신청");
		jb3.setBounds(330, 10, 140, 50);
		this.add(jb3);
		// 아이디 라벨
		JLabel jl1 = new JLabel("아이디");
		jl1.setBounds(50, 100, 150, 50);
		jl1.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl1);
		// 아이디 입력
		JTextField jt1 = new JTextField();		
		jt1.setBounds(140, 110, 150, 30);		
		this.add(jt1);
		// 비밀번호 라벨
		JLabel jl2 = new JLabel("비밀번호");
		jl2.setBounds(50, 150, 150, 50);
		jl2.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl2);
		// 비밀번호 입력
		JTextField jt2 = new JTextField();		
		jt2.setBounds(140, 160, 150, 30);		
		this.add(jt2);
		// 이름 라벨
		JLabel jl3 = new JLabel("이름");
		jl3.setBounds(50, 200, 150, 50);
		jl3.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl3);
		// 이름 입력
		JTextField jt3 = new JTextField();		
		jt3.setBounds(140, 210, 150, 30);		
		this.add(jt3);
		// 전화번호 라벨
		JLabel jl4 = new JLabel("전화번호");
		jl4.setBounds(50, 250, 150, 50);
		jl4.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl4);
		// 전화번호 입력
		JTextField jt4 = new JTextField();		
		jt4.setBounds(140, 260, 150, 30);		
		this.add(jt4);
		// e-mail 라벨
		JLabel jl5 = new JLabel("e-mail");
		jl5.setBounds(50, 300, 150, 50);
		jl5.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl5);
		// e-mail 입력
		JTextField jt5 = new JTextField();		
		jt5.setBounds(140, 310, 150, 30);		
		this.add(jt5);
		// 등록일 라벨
		JLabel jl6 = new JLabel("등록일");
		jl6.setBounds(50, 350, 150, 50);
		jl6.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl6);
		// 등록일 입력
		JTextField jt6 = new JTextField();		
		jt6.setBounds(140, 360, 150, 30);		
		this.add(jt6);
		// 수정일 라벨
		JLabel jl7 = new JLabel("수정일");
		jl7.setBounds(50, 400, 150, 50);
		jl7.setFont(new Font("돋움체", Font.PLAIN, 20));
		this.add(jl7);
		// 수정일 입력
		JTextField jt7 = new JTextField();		
		jt7.setBounds(140, 410, 150, 30);		
		this.add(jt7);
		
		//수정 버튼
		JButton jb4 = new JButton("정보수정");
		jb4.setBounds(250, 600, 100, 30);
		this.add(jb4);
		//탈퇴 버튼
		JButton jb5 = new JButton("회원탈퇴");
		jb5.setBounds(370, 600, 100, 30);
		this.add(jb5);
		
		this.setBounds(100,  300, 500, 700);	

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameTest("마이페이지");
	}

}
