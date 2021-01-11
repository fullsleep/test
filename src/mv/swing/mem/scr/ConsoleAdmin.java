package mv.swing.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import mv.swing.mem.dao.SwingAdminDAO;
import mv.swing.mem.dao.SwingAdminDAOImpl;
import mv.swing.mem.vo.MaxValueVO;

public class ConsoleAdmin {
	
	// ������ ��� ��ü ��ȸ
	public ArrayList<MaxValueVO> memSelectAll() {
				
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelectAll();		
				
		return aList;
	}
	// ������ ���� ��ȸ 
	public ArrayList<MaxValueVO> memSelect(MaxValueVO mvo) {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelect(mvo);
		
		return aList;
	}	

	// ������ ���� ����
	public int memUpdate(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.memUpdate(mvo);
		
		return nCnt;	
	}

	// ������ ���� ��ȸ
	public ArrayList<MaxValueVO> mlSelect(MaxValueVO mvo) {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.mlSelect(mvo);
		
		return aList;
	}		

	// ���� ��� ��ȸ
	public ArrayList<MaxValueVO> lesSelectAll() {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.lesSelectAll();
		
		return aList;
	}		
	// ���� ���� ��ȸ
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO mvo) {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.lesSelect(mvo);
		
		return aList;
	}		
	
	// ���� ����
	public int lesInsert(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.lesInsert(mvo);
		
		return nCnt;	
	}
	
	// ���� ���� ����
	public int lesUpdate(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.lesUpdate(mvo);
		
		return nCnt;	
	}
	
	// ���� ���� ����
	public int lesDelete(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.lesDelete(mvo);
		
		return nCnt;	
	}
	
	public static void main(String[] args) {
	
		System.out.println("main() ����  >>> : ");
		
		String mnum = "";
		String mgrade = "";
		String mname = "";
		String lcode = "";
		String lsubject = "";
		String lname = "";
		String lstr = "";
		String lend = "";
		String lday = "";
		String ltime = "";
		String lteacher = "";
		String lroom = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���α׷� ���� >>> : ");
		
		while (true) {
			System.out.println(" S U SL SA : ������ ���� �����ڸ� �Է� �ϼ���");
			System.out.println(" LI LS LU LD LSA : ���� ���� �����ڸ� �Է� �ϼ���");
			System.out.println("���α׷��� ���� �Ϸ��� q �Ǵ� Q �� �Է��ϼ���");
			String isudType = sc.next();
			
			if ("SA".equals(isudType.toUpperCase())) 
			{			
				ConsoleAdmin ca = new ConsoleAdmin();			
				ArrayList<MaxValueVO> aList = ca.memSelectAll();
				
				if (aList.size() > 0) 
				{
					for (int i=0; i < aList.size(); i++) 
					{
						MaxValueVO mvo = aList.get(i);
						
						System.out.println("ȸ����ȣ >>> : " + mvo.getMnum());
						System.out.println("ȸ����� >>> : " + mvo.getMgrade());
						System.out.println("ȸ�����̵� >>> : " + mvo.getMid());
						// System.out.println("ȸ����й�ȣ >>> : " + mvo.getMpw());
						System.out.println("ȸ���̸� >>> : " + mvo.getMname());
						System.out.println("ȸ����ȭ��ȣ >>> : " + mvo.getMhp());
						System.out.println("ȸ���̸��� >>> : " + mvo.getMemail());
						System.out.println("ȸ���������� >>> : " + mvo.getMdyn());
						System.out.println("ȸ������� >>> : " + mvo.getMinsert());
						System.out.println("ȸ������������ >>> : " + mvo.getMupdate());
						
						// MaxValueVO.printVO(mvo);
					}
				}
			}
			if ("S".equals(isudType.toUpperCase())) {
				
				System.out.println("ȸ����ȣ�� �Է��ϼ��� >>> : ");
				mnum = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����
				mvo.setMnum(mnum);
				
				ArrayList<MaxValueVO> aList = ca.memSelect(mvo);
				if (aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MaxValueVO _mvo = aList.get(i);
						System.out.println("ȸ����ȣ >>> : " + _mvo.getMnum());
						System.out.println("ȸ����� >>> : " + _mvo.getMgrade());
						System.out.println("ȸ�����̵� >>> : " + _mvo.getMid());
						// System.out.println("ȸ����й�ȣ >>> : " + _mvo.getMpw());
						System.out.println("ȸ���̸� >>> : " + _mvo.getMname());
						System.out.println("ȸ����ȭ��ȣ >>> : " + _mvo.getMhp());
						System.out.println("ȸ���̸��� >>> : " + _mvo.getMemail());
						System.out.println("ȸ���������� >>> : " + _mvo.getMdyn());
						System.out.println("ȸ������� >>> : " + _mvo.getMinsert());
						System.out.println("ȸ������������ >>> : " + _mvo.getMupdate());
						// MaxValueVO.printVO(_mvo);
					}
				}else {
					System.out.println("ȸ����ȣ : " + mvo.getMnum() 
					                    + " ���� �����Ͱ� �������� �ʽ��ϴ�. ");
				}
			}
		
			if ("U".equals(isudType.toUpperCase())) {
								
				System.out.println("ȸ������� �Է��ϼ��� >>> : ");
				mgrade = sc.next();
				System.out.println("ȸ����ȣ�� �Է��ϼ��� >>> : ");
				mnum = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����	
				mvo.setMgrade(mgrade);
				mvo.setMnum(mnum);
			
				int nCnt = ca.memUpdate(mvo);
				if (nCnt > 0) {
					System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
				}else {
					System.out.println("���� ����  >>> :  ");
				}				
			}
			if ("SL".equals(isudType.toUpperCase())) {
				
				System.out.println("ȸ���̸��� �Է��ϼ��� >>> : ");
				mname = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����
				mvo.setMname(mname);
				
				ArrayList<MaxValueVO> aList = ca.mlSelect(mvo);
				if (aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MaxValueVO _mvo = aList.get(i);
						System.out.println("����� >>> : " + _mvo.getLname());
						System.out.println("ȸ���̸� >>> : " + _mvo.getMname());
						System.out.println("������ >>> : " + _mvo.getLstr());
						System.out.println("������ >>> : " + _mvo.getLend());
						System.out.println("�������� >>> : " + _mvo.getLday());
						System.out.println("�����ð� >>> : " + _mvo.getLtime());
						System.out.println("������ >>> : " + _mvo.getLteacher());
						System.out.println("���ǽ� >>> : " + _mvo.getLroom());
						// System.out.println("������������ >>> : " + _mvo.getLdyn());
						// System.out.println("��������� >>> : " + _mvo.getLinsert());
						// System.out.println("ȸ������������ >>> : " + _mvo.getLupdate());
						// MaxValueVO.printVO(_mvo);
					}
				}else {
					System.out.println("ȸ���̸� : " + mvo.getMname() 
					                    + " ���� �����Ͱ� �������� �ʽ��ϴ�. ");
				}
			}
			
			if ("LSA".equals(isudType.toUpperCase())) 
			{			
				ConsoleAdmin ca = new ConsoleAdmin();			
				ArrayList<MaxValueVO> aList = ca.lesSelectAll();
				
				if (aList.size() > 0) 
				{
					for (int i=0; i < aList.size(); i++) 
					{
						MaxValueVO mvo = aList.get(i);
						System.out.println("�����ڵ� >>> : " + mvo.getLcode());
						System.out.println("����з� >>> : " + mvo.getLsubject());
						System.out.println("����� >>> : " + mvo.getLname());
						System.out.println("������ >>> : " + mvo.getLstr());
						System.out.println("������ >>> : " + mvo.getLend());
						System.out.println("�������� >>> : " + mvo.getLday());
						System.out.println("�����ð� >>> : " + mvo.getLtime());
						System.out.println("������ >>> : " + mvo.getLteacher());
						System.out.println("���ǽ� >>> : " + mvo.getLroom());
						System.out.println("������������ >>> : " + mvo.getLdyn());
						System.out.println("��������� >>> : " + mvo.getLinsert());
						System.out.println("ȸ������������ >>> : " + mvo.getLupdate());
						// MaxValueVO.printVO(mvo);
					}
				}
			}
			if ("LS".equals(isudType.toUpperCase())) {
				
				System.out.println("�����ڵ带 �Է��ϼ��� >>> : ");
				lcode = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����
				mvo.setLcode(lcode);
				
				ArrayList<MaxValueVO> aList = ca.lesSelect(mvo);
				if (aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MaxValueVO _mvo = aList.get(i);
						System.out.println("�����ڵ� >>> : " + _mvo.getLcode());
						System.out.println("����з� >>> : " + _mvo.getLsubject());
						System.out.println("����� >>> : " + _mvo.getLname());
						System.out.println("������ >>> : " + _mvo.getLstr());
						System.out.println("������ >>> : " + _mvo.getLend());
						System.out.println("�������� >>> : " + _mvo.getLday());
						System.out.println("�����ð� >>> : " + _mvo.getLtime());
						System.out.println("������ >>> : " + _mvo.getLteacher());
						System.out.println("���ǽ� >>> : " + _mvo.getLroom());
						System.out.println("������������ >>> : " + _mvo.getLdyn());
						System.out.println("��������� >>> : " + _mvo.getLinsert());
						System.out.println("ȸ������������ >>> : " + _mvo.getLupdate());
						// MaxValueVO.printVO(_mvo);
		 			}
				}else {
					System.out.println("�����ڵ� : " + mvo.getLcode() 
					                    + "�� �����Ͱ� �������� �ʽ��ϴ�. ");
				}
			}
			if ("LI".equals(isudType.toUpperCase())) {
										
				System.out.println("�����ڵ带 �Է��ϼ��� >>> : ");
				lcode= sc.next();
				System.out.println("����з��� �Է��ϼ��� >>> : ");
				lsubject= sc.next();
				System.out.println("������� �Է��ϼ��� >>> : ");
				sc.nextLine();
				lname= sc.nextLine();
				System.out.println("�������� �Է��ϼ��� >>> : ");
				lstr= sc.next();
				System.out.println("�������� �Է��ϼ��� >>> : ");
				lend= sc.next();				
				System.out.println("���������� �Է��ϼ��� >>> : ");
				lday= sc.next();
				System.out.println("�����ð��� �Է��ϼ��� >>> : ");
				ltime= sc.next();
				System.out.println("�������� �Է��ϼ��� >>> : ");
				lteacher= sc.next();
				System.out.println("���ǽ��� �Է��ϼ��� >>> : ");
				lroom= sc.next();
				
				ConsoleAdmin sas = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����
				mvo.setLcode(lcode);
				mvo.setLsubject(lsubject);
				mvo.setLname(lname);
				mvo.setLstr(lstr);
				mvo.setLend(lend);
				mvo.setLday(lday);
				mvo.setLtime(ltime);
				mvo.setLteacher(lteacher);
				mvo.setLroom(lroom);
				
				int nCnt = sas.lesInsert(mvo);
				if (nCnt > 0) {
					System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
				}else {
					System.out.println("��� ����  >>> :  ");
				}
				
			}
			if ("LU".equals(isudType.toUpperCase())) {
				
				System.out.println("������ ������� �Է��ϼ��� >>> : ");
				sc.nextLine();
				lname = sc.nextLine();
				System.out.println("������ �����ڵ带 �Է��ϼ��� >>> : ");
				lcode = sc.next();				
			
				
				ConsoleAdmin ca= new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����	
				mvo.setLname(lname);
				mvo.setLcode(lcode);
				
				int nCnt = ca.lesUpdate(mvo);
				if (nCnt > 0) {
					System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
				}else {
					System.out.println("���� ����  >>> :  ");
				}				
			}
			if ("LD".equals(isudType.toUpperCase())) {
				
				System.out.println("������ �����ڵ带 �Է��ϼ��� >>> : ");
				lcode = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����	
				mvo.setLcode(lcode);
				
				int nCnt = ca.lesDelete(mvo);
				if (nCnt > 0) {
					System.out.println("�����Ͱ� " + nCnt + " �� ���� �Ǿ����ϴ�. ");
				}else {
					System.out.println("���� ����  >>> :  ");
				}	
				
			}
			
			if ("Q".equals(isudType.toUpperCase())) {
				
				System.out.println("������ ���α׷��� ���� �մϴ�. >>> : ");
				break;
			}			
		}
		System.out.println("main() ��  >>> : ");
	}	
}
