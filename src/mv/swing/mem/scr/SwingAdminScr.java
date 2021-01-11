package mv.swing.mem.scr;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;

import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminScr extends JFrame{
	
private static final long serialVersionUID = 1L;
	
	static JFrame	mainFrame;
	JPanel	 		sajp;
	JTabbedPane 	jtp;
	SwingAdminSU	sasu;
	SwingAdminISUD 	saisud;
	SwingAdminSL	sasl;
	SwingAdminSA   	sasa;
	SwingAdminMSA   sama;
	
	public SwingAdminScr(JFrame mainFrame) 
	{
		SwingLoginScr2.mainFrame = mainFrame;
		mainFrame = new JFrame("������");
		this.getContentPane().setLayout(null);
	
		// member JPanel ���̱�			
		sajp = new JPanel();
		sajp.setBorder(new EtchedBorder());

		sajp.setBounds(0, 0, 480, 600);
		sajp.setBackground(Color.gray);				
		
		// member JPanel�� JTabbedPane ���̱� 
		jtp = new JTabbedPane(JTabbedPane.TOP);
		sajp.add(jtp);

		sasu = new SwingAdminSU();
		saisud = new SwingAdminISUD();		
		sasl = new SwingAdminSL();
		sasa = new SwingAdminSA();
		sama = new SwingAdminMSA();
		
		jtp.addTab("����������", sasu);
		jtp.addTab("��������", saisud);
		jtp.addTab("���� ���� ȸ��", sasl);
		//jtp.addTab("�������", sasa);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.getContentPane().add(sajp);
		
//		ȭ�� �߾ӿ� ��ġ�ϱ�
//		this.setLocationRelativeTo(null);
//		Dimension sJ = this.getSize();
//		Dimension sS = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation((sS.width - sJ.width)/2, (sS.height - sJ.height)/2);		
		
		this.setLocation(1300, 100);		
		this.setSize(500,580);
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
	
	public static void main(String[] args) {
		
		//new SwingAdminScr();
	}

}
