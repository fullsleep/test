package mv.swing.mem.scr;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mv.swing.mem.vo.MaxValueVO;

import mv.swing.mem.dao.MvMypageDAO;
import mv.swing.mem.dao.MvMypageDAOImpl;

public class SwingLessonScr extends JFrame 
{	
	private static final long serialVersionUID = 1L;
	
	static JFrame	mainFrame;
	JPanel	 		smjp;
	JTabbedPane 	jtp;
	SwingLessonSA   sasa;
	SwingMemberISD   smisd;
	SwingLessonS    smsd;
	SwingMypageSUD  smsud;
	public SwingLessonScr(JFrame mainFrame) 
	{
		SwingLoginScr2.mainFrame = mainFrame;
		mainFrame = new JFrame("Mypage");
		this.getContentPane().setLayout(null);

		// member JPanel ���̱�			
		smjp = new JPanel();
		smjp.setBorder(new EtchedBorder());

		smjp.setBounds(0, 0, 800, 600);
		smjp.setBackground(Color.gray);				
		
		// member JPanel�� JTabbedPane ���̱� 
		jtp = new JTabbedPane(JTabbedPane.TOP);
		smjp.add(jtp);
		
		smsud = new SwingMypageSUD();
		sasa = new SwingLessonSA();
		smisd = new SwingMemberISD();
		smsd = new SwingLessonS();
		
		jtp.addTab("ȸ������", smsud);
		jtp.addTab("����", sasa);
		jtp.addTab("������û", smisd);
		jtp.addTab("�������ΰ���", smsd);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.getContentPane().add(smjp);

//		ȭ�� �߾ӿ� ��ġ�ϱ�
//		this.setLocationRelativeTo(null);
//		Dimension sJ = this.getSize();
//		Dimension sS = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation((sS.width - sJ.width)/2, (sS.height - sJ.height)/2);		
		
		this.setLocation(100, 100);		
		this.setSize(800,580);
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

	public static void main(String[] args) 
	{
		//new SwingLessonScr("����������");
	}
}




