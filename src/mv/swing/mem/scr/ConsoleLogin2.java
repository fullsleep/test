package mv.swing.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import mv.swing.common.PasswordUtil;
import mv.swing.mem.dao.SwingLoginDAO2;
import mv.swing.mem.dao.SwingLoginDAOImpl2;
import mv.swing.mem.vo.MaxValueVO;

public class ConsoleLogin2 {

	public boolean memLogin(MaxValueVO mvvo) {
		
		boolean bLogin = false;
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		bLogin = ldao.memLogin(mvvo);
		return bLogin;
	}
	
	public int memLogout(MaxValueVO mvvo){
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		int nCnt = ldao.memLogout(mvvo);	
		return nCnt;
	}
	
	public ArrayList<MaxValueVO> idSearch(MaxValueVO mvvo){
		
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		ArrayList<MaxValueVO> aList = ldao.idSearch(mvvo);
		
		return aList;
	}
	
	public ArrayList<MaxValueVO> pwSearch(MaxValueVO mvvo){
		
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		ArrayList<MaxValueVO> aList = ldao.pwSearch(mvvo);
		
		return aList;
	}
	
	public int memUpdate(MaxValueVO mvvo) {
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		int nCnt = ldao.pwTemp(mvvo);	
		return nCnt;
	}
	
	public String tempPW() {	
		String s1 = PasswordUtil.tempPW(10);
		return s1;
	}
	
	public boolean memAdminLogin(MaxValueVO mvvo) {	
		boolean bLogin = false;
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		bLogin = ldao.memAdminLogin(mvvo);
		return bLogin;
	}
	
	public int nowLogin(MaxValueVO mvvo){
		SwingLoginDAO2 ldao = new SwingLoginDAOImpl2();
		int nCnt = ldao.nowLogin(mvvo);	
		return nCnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mid = "";
		String mpw = "";
		String memail = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("lin, lout, id, pw, ptemp, admin >>> : ");
		String loginType = sc.next();
		
		if ("LIN".equals(loginType.toUpperCase()))	{
			System.out.println("���̵� �Է��ϼ���. >>> : ");
			mid = sc.next();
			System.out.println("��й�ȣ�� �Է��ϼ���. >>> : ");
			mpw = sc.next();
			
			ConsoleLogin2 cl = new ConsoleLogin2();
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(mid);
			mvvo.setMpw(mpw);
			boolean bLogin = cl.memLogin(mvvo);
			
			if (bLogin) {
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");
			}else {
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");
			}
		}
		if ("LOUT".equals(loginType.toUpperCase()))	{
			
		}
		if ("ID".equals(loginType.toUpperCase()))	{
			System.out.println("e-mail�� �Է��ϼ���. >>> : ");
			memail = sc.next();
			
			ConsoleLogin2 cl = new ConsoleLogin2();
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMemail(memail);
			
			ArrayList<MaxValueVO> aList = cl.idSearch(mvvo);
			String _sid = "";
			if (aList.size() > 0) {
				MaxValueVO _mvvo = aList.get(0);
				_sid = _mvvo.getMid();
				System.out.println("ã���ô� ���̵�� >>> : " + _sid +" �Դϴ�.");
			}else {
				System.out.println("�Է��� e-mail�� �ش��ϴ� ���̵� �����ϴ�. >>> : ");
			}
		}
		if ("PW".equals(loginType.toUpperCase()))	{
			System.out.println("ID�� �Է��ϼ���. >>> : ");
			mid = sc.next();
			
			ConsoleLogin2 cl = new ConsoleLogin2();
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(mid);
			
			ArrayList<MaxValueVO> aList = cl.pwSearch(mvvo);
			String _mpw = "";
			if (aList.size() > 0) {
				MaxValueVO _mvvo = aList.get(0);
				_mpw = _mvvo.getMpw();
				System.out.println("ã���ô� ��й�ȣ�� >>> : " + _mpw +" �Դϴ�.");
			}else {
				System.out.println("���̵� �����ϴ�. >>> : ");
			}
		}
		if ("PTEMP".equals(loginType.toUpperCase()))	{
			System.out.println("���̵� �Է��Ͻÿ� >>> : ");
			mid= sc.next();
					
			ConsoleLogin2 cl = new ConsoleLogin2();				
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			mpw = cl.tempPW();
			System.out.println("�ӽ� ��й�ȣ >>> : " + mpw);
			
			// setter ����
			mvvo.setMid(mid);
			mvvo.setMpw(mpw);
			
			int nCnt = cl.memUpdate(mvvo);
			if (nCnt > 0) {
				System.out.println("�����Ͱ� " + nCnt + " �� ��� �Ǿ����ϴ�. ");	
			}else {
				System.out.println("��� ����  >>> :  ");
			}
		}
		if ("ADMIN".equals(loginType.toUpperCase()))	{
			System.out.println("���̵� �Է��ϼ���. >>> : ");
			mid = sc.next();
			System.out.println("��й�ȣ�� �Է��ϼ���. >>> : ");
			mpw = sc.next();
			
			ConsoleLogin2 cl = new ConsoleLogin2();
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(mid);
			mvvo.setMpw(mpw);
			boolean bLogin = cl.memAdminLogin(mvvo);
			
			if (bLogin) {
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");
			}else {
				System.out.println(mvvo.getMid() + " �� �α��� ���� �߽��ϴ�.");
			}
		}
	}

}
