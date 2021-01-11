package mv.swing.mem.scr;

import java.util.Scanner;

import mv.swing.mem.dao.SwingNewMemberDAO;
import mv.swing.mem.dao.SwingNewMemberDAOImpl;
import mv.swing.mem.vo.MaxValueVO;

public class ConsoleNewMemberScr {

	public int memInsert(MaxValueVO mvvo) {
		SwingNewMemberDAO ndao = new SwingNewMemberDAOImpl();
		int nCnt = ndao.memInsert(mvvo);
		
		return nCnt;
	}
	
	public boolean idConfirm(MaxValueVO mvvo) {
		SwingNewMemberDAO ndao = new SwingNewMemberDAOImpl();
		boolean newId = ndao.idConfirm(mvvo);
		
		return newId;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() ����  >>> : ");
		
		String mnum = "";
		String mid = "";
		String mpw = "";
		String mname = "";
		String mhp = "";
		String memail = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ű� ȸ������ �׽�Ʈ >>> : ");
		System.out.println("���̵� �Է��Ͻÿ� >>> : ");
		mid= sc.next();
		System.out.println("��й�ȣ�� �Է��Ͻÿ� >>> : ");
		mpw= sc.next();
		System.out.println("�̸��� �Է��Ͻÿ� >>> : ");
		mname= sc.next();
		System.out.println("�ڵ�����ȣ�� �Է��Ͻÿ� >>> : ");
		mhp= sc.next();
		System.out.println("�̸��ϸ� �Է��Ͻÿ� >>> : ");
		memail= sc.next();
		sc.nextLine(); // ����(���๮��)�� �����ϱ� ���� �߰� �� 
				
		ConsoleNewMemberScr cnm = new ConsoleNewMemberScr();				
		MaxValueVO mvvo = null;
		mvvo = new MaxValueVO();
		// setter ����
		mvvo.setMnum(mnum);
		mvvo.setMid(mid);
		mvvo.setMpw(mpw);
		mvvo.setMname(mname);
		mvvo.setMhp(mhp);
		mvvo.setMemail(memail);
		
		int nCnt = cnm.memInsert(mvvo);
		if (nCnt > 0) {
			System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
		}else {
			System.out.println("��� ����  >>> :  ");
		}
	}

}
