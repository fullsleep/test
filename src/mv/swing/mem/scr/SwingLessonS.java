package mv.swing.mem.scr;
// ������� ��ȸ
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingLessonS extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JPanel      jpR;
	JTable      jt;
	JScrollPane jsp;
	JButton 	jbR;
				
	public SwingLessonS()
	{
		this.setLayout(new BorderLayout(10, 10));

		jpR = new JPanel();		
		jt  = new JTable(new SwingMypageSModel());
		jsp = new JScrollPane(jt);
		
		jbR  = new JButton();
	    jbR.addActionListener(this);
	    jbR.setText("���ΰ�ħ");
		
		add(jpR.add(jsp), BorderLayout.CENTER);
		add(jpR.add(jbR), BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent ac) 
	   {
	      if ("���ΰ�ħ".equals(jbR.getText())) {
	         jt.setModel(new SwingMypageSModel());
	         jt.repaint();
	      	}
	   }
}
