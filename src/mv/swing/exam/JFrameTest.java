package mv.swing.exam;

//Swing ��Ű�� �� 
//�ڹٿ��� �����ϴ� C/S (Client/Server) ȯ�濡�� 
//����ϴ� GUI(Graphical User Interface) ������Ʈ�̴�.
// Swing ��Ű��, awt ��Ű���� �ִ� ������Ʈ Ŭ������ ����� ���� 
// ������ ������ �� �˰� �־�� �Ѵ�. 

//1. �����ڿ��� UI �׸��� ���� �Ѵ�. 
//   UI ������ ������ �Լ� �Ǵ� Ŭ������ ���� �����ڿ��� ȣ�� �Ѵ�. 
//2. UI ������Ʈ�� JPanel �� �̿��ؼ� JFrame ���δ�.    
//3. �̺�Ʈ�� �����ؼ� �̺�Ʈ�����ʸ� �̿��ؼ� �ش� ������Ʈ�� �̺�Ʈ ���� �Ѵ�. 
//4. ������ ������Ʈ �����ڸ� �� �̿��ؾ� �Ѵ�. API ���鼭 
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
		// ���������� ��ư
		JButton jb1 = new JButton("����������");
		jb1.setBounds(10, 10, 140, 50);
		this.add(jb1);
		// �������ΰ��� ��ư
		JButton jb2 = new JButton("�������ΰ���");
		jb2.setBounds(170, 10, 140, 50);
		this.add(jb2);
		// ������û ��ư
		JButton jb3 = new JButton("������û");
		jb3.setBounds(330, 10, 140, 50);
		this.add(jb3);
		// ���̵� ��
		JLabel jl1 = new JLabel("���̵�");
		jl1.setBounds(50, 100, 150, 50);
		jl1.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl1);
		// ���̵� �Է�
		JTextField jt1 = new JTextField();		
		jt1.setBounds(140, 110, 150, 30);		
		this.add(jt1);
		// ��й�ȣ ��
		JLabel jl2 = new JLabel("��й�ȣ");
		jl2.setBounds(50, 150, 150, 50);
		jl2.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl2);
		// ��й�ȣ �Է�
		JTextField jt2 = new JTextField();		
		jt2.setBounds(140, 160, 150, 30);		
		this.add(jt2);
		// �̸� ��
		JLabel jl3 = new JLabel("�̸�");
		jl3.setBounds(50, 200, 150, 50);
		jl3.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl3);
		// �̸� �Է�
		JTextField jt3 = new JTextField();		
		jt3.setBounds(140, 210, 150, 30);		
		this.add(jt3);
		// ��ȭ��ȣ ��
		JLabel jl4 = new JLabel("��ȭ��ȣ");
		jl4.setBounds(50, 250, 150, 50);
		jl4.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl4);
		// ��ȭ��ȣ �Է�
		JTextField jt4 = new JTextField();		
		jt4.setBounds(140, 260, 150, 30);		
		this.add(jt4);
		// e-mail ��
		JLabel jl5 = new JLabel("e-mail");
		jl5.setBounds(50, 300, 150, 50);
		jl5.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl5);
		// e-mail �Է�
		JTextField jt5 = new JTextField();		
		jt5.setBounds(140, 310, 150, 30);		
		this.add(jt5);
		// ����� ��
		JLabel jl6 = new JLabel("�����");
		jl6.setBounds(50, 350, 150, 50);
		jl6.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl6);
		// ����� �Է�
		JTextField jt6 = new JTextField();		
		jt6.setBounds(140, 360, 150, 30);		
		this.add(jt6);
		// ������ ��
		JLabel jl7 = new JLabel("������");
		jl7.setBounds(50, 400, 150, 50);
		jl7.setFont(new Font("����ü", Font.PLAIN, 20));
		this.add(jl7);
		// ������ �Է�
		JTextField jt7 = new JTextField();		
		jt7.setBounds(140, 410, 150, 30);		
		this.add(jt7);
		
		//���� ��ư
		JButton jb4 = new JButton("��������");
		jb4.setBounds(250, 600, 100, 30);
		this.add(jb4);
		//Ż�� ��ư
		JButton jb5 = new JButton("ȸ��Ż��");
		jb5.setBounds(370, 600, 100, 30);
		this.add(jb5);
		
		this.setBounds(100,  300, 500, 700);	

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameTest("����������");
	}

}
