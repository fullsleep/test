package mv.swing.mem.scr;
// 수업목록 조회
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingAdminSA extends JPanel{

	private static final long serialVersionUID = 1L;
	
	JPanel      jpR;
	JTable      jt;
	JScrollPane jsp;
				
	public SwingAdminSA()
	{
		this.setLayout(new BorderLayout(10, 10));
		
		jpR = new JPanel();		
		jt  = new JTable(new SwingAdminSAModel());
		jsp = new JScrollPane(jt);
		
		add(jpR.add(jsp), BorderLayout.CENTER);
		
	}
}
