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
		System.out.println("main() 시작  >>> : ");
		
		String mnum = "";
		String mid = "";
		String mpw = "";
		String mname = "";
		String mhp = "";
		String memail = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("신규 회원가입 테스트 >>> : ");
		System.out.println("아이디를 입력하시오 >>> : ");
		mid= sc.next();
		System.out.println("비밀번호를 입력하시오 >>> : ");
		mpw= sc.next();
		System.out.println("이름를 입력하시오 >>> : ");
		mname= sc.next();
		System.out.println("핸드폰번호를 입력하시오 >>> : ");
		mhp= sc.next();
		System.out.println("이메일를 입력하시오 >>> : ");
		memail= sc.next();
		sc.nextLine(); // 엔터(개행문자)를 제거하기 위해 추가 함 
				
		ConsoleNewMemberScr cnm = new ConsoleNewMemberScr();				
		MaxValueVO mvvo = null;
		mvvo = new MaxValueVO();
		// setter 세팅
		mvvo.setMnum(mnum);
		mvvo.setMid(mid);
		mvvo.setMpw(mpw);
		mvvo.setMname(mname);
		mvvo.setMhp(mhp);
		mvvo.setMemail(memail);
		
		int nCnt = cnm.memInsert(mvvo);
		if (nCnt > 0) {
			System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
		}else {
			System.out.println("등록 실패  >>> :  ");
		}
	}

}
