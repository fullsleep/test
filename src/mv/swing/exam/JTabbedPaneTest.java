package mv.swing.exam;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class JTabbedPaneTest extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTabbedPane 	jtp;;
	MemBasicInfo  	mb;
	MemDetailInfo 	md;
	
	public JTabbedPaneTest() {
		super("JTabbedPane �׽�Ʈ");
		
		jtp = new JTabbedPane(JTabbedPane.TOP);
//		jtp = new JTabbedPane(JTabbedPane.LEFT);
//		jtp = new JTabbedPane(JTabbedPane.RIGHT);
//		jtp = new JTabbedPane(JTabbedPane.BOTTOM);

		JPanel jp1 = new JPanel();
		mb = new MemBasicInfo();
		JPanel jp2 = new JPanel();
		md = new MemDetailInfo();

		jp1.add(mb);
		jp2.add(md);

		jtp.addTab("�λ����(�⺻)", jp1);
		jtp.addTab("�λ����(����)", jp2);

		getContentPane().add(jtp, BorderLayout.CENTER);
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTabbedPaneTest();
	}
}

class MemBasicInfo extends JPanel
{
	private static final long serialVersionUID = 1L;

	public MemBasicInfo()
	{
		String[] title = {"��ȣ", "�̸�", "�Ի���"};
		String[][] data = {
							{"M0001", "�̵���", "2020-11-19"},
							{"M0002", "�迹��", "2020-11-19"},
							{"M0003", "�ȼ���", "2020-11-19"}
						  };

		JTable jt = new JTable(data, title);
		JScrollPane jcp = new JScrollPane(jt);
		add(jcp);
	}
}

class MemDetailInfo extends JPanel
{
	private static final long serialVersionUID = 1L;

	public MemDetailInfo()
	{
		String[] title = {"��ȣ", "�μ�", "����"};
		String[][] data = {
							{"10", "��ȹ��", "����"},
							{"20", "ȫ����", "����"},
							{"30", "���ߺ�", "�븮"}
						};

		JTable jt = new JTable(data, title);
		JScrollPane jcp = new JScrollPane(jt);
		add(jcp);
	}
}
