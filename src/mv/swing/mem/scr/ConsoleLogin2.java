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
			System.out.println("아이디를 입력하세요. >>> : ");
			mid = sc.next();
			System.out.println("비밀번호를 입력하세요. >>> : ");
			mpw = sc.next();
			
			ConsoleLogin2 cl = new ConsoleLogin2();
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(mid);
			mvvo.setMpw(mpw);
			boolean bLogin = cl.memLogin(mvvo);
			
			if (bLogin) {
				System.out.println(mvvo.getMid() + " 님 로그인 성공 했습니다.");
			}else {
				System.out.println(mvvo.getMid() + " 님 로그인 실패 했습니다.");
			}
		}
		if ("LOUT".equals(loginType.toUpperCase()))	{
			
		}
		if ("ID".equals(loginType.toUpperCase()))	{
			System.out.println("e-mail을 입력하세요. >>> : ");
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
				System.out.println("찾으시는 아이디는 >>> : " + _sid +" 입니다.");
			}else {
				System.out.println("입력한 e-mail에 해당하는 아이디가 없습니다. >>> : ");
			}
		}
		if ("PW".equals(loginType.toUpperCase()))	{
			System.out.println("ID를 입력하세요. >>> : ");
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
				System.out.println("찾으시는 비밀번호는 >>> : " + _mpw +" 입니다.");
			}else {
				System.out.println("아이디가 없습니다. >>> : ");
			}
		}
		if ("PTEMP".equals(loginType.toUpperCase()))	{
			System.out.println("아이디를 입력하시오 >>> : ");
			mid= sc.next();
					
			ConsoleLogin2 cl = new ConsoleLogin2();				
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			
			mpw = cl.tempPW();
			System.out.println("임시 비밀번호 >>> : " + mpw);
			
			// setter 세팅
			mvvo.setMid(mid);
			mvvo.setMpw(mpw);
			
			int nCnt = cl.memUpdate(mvvo);
			if (nCnt > 0) {
				System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
			}else {
				System.out.println("등록 실패  >>> :  ");
			}
		}
		if ("ADMIN".equals(loginType.toUpperCase()))	{
			System.out.println("아이디를 입력하세요. >>> : ");
			mid = sc.next();
			System.out.println("비밀번호를 입력하세요. >>> : ");
			mpw = sc.next();
			
			ConsoleLogin2 cl = new ConsoleLogin2();
			MaxValueVO mvvo = null;
			mvvo = new MaxValueVO();
			mvvo.setMid(mid);
			mvvo.setMpw(mpw);
			boolean bLogin = cl.memAdminLogin(mvvo);
			
			if (bLogin) {
				System.out.println(mvvo.getMid() + " 님 로그인 성공 했습니다.");
			}else {
				System.out.println(mvvo.getMid() + " 님 로그인 실패 했습니다.");
			}
		}
	}

}
