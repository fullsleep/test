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
		super("JTabbedPane 테스트");
		
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

		jtp.addTab("인사관리(기본)", jp1);
		jtp.addTab("인사관리(세부)", jp2);

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
		String[] title = {"번호", "이름", "입사일"};
		String[][] data = {
							{"M0001", "이동준", "2020-11-19"},
							{"M0002", "김예빈", "2020-11-19"},
							{"M0003", "안석형", "2020-11-19"}
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
		String[] title = {"번호", "부서", "직급"};
		String[][] data = {
							{"10", "기획부", "과장"},
							{"20", "홍보부", "부장"},
							{"30", "개발부", "대리"}
						};

		JTable jt = new JTable(data, title);
		JScrollPane jcp = new JScrollPane(jt);
		add(jcp);
	}
}
