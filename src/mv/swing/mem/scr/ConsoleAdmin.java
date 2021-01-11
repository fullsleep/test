package mv.swing.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import mv.swing.mem.dao.SwingAdminDAO;
import mv.swing.mem.dao.SwingAdminDAOImpl;
import mv.swing.mem.vo.MaxValueVO;

public class ConsoleAdmin {
	
	// 수강생 목록 전체 조회
	public ArrayList<MaxValueVO> memSelectAll() {
				
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelectAll();		
				
		return aList;
	}
	// 수강생 정보 조회 
	public ArrayList<MaxValueVO> memSelect(MaxValueVO mvo) {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelect(mvo);
		
		return aList;
	}	

	// 수강생 정보 수정
	public int memUpdate(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.memUpdate(mvo);
		
		return nCnt;	
	}

	// 수강생 조건 조회
	public ArrayList<MaxValueVO> mlSelect(MaxValueVO mvo) {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.mlSelect(mvo);
		
		return aList;
	}		

	// 수업 목록 조회
	public ArrayList<MaxValueVO> lesSelectAll() {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.lesSelectAll();
		
		return aList;
	}		
	// 수강 정보 조회
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO mvo) {
		
		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.lesSelect(mvo);
		
		return aList;
	}		
	
	// 과목 생성
	public int lesInsert(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.lesInsert(mvo);
		
		return nCnt;	
	}
	
	// 과목 정보 수정
	public int lesUpdate(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.lesUpdate(mvo);
		
		return nCnt;	
	}
	
	// 과목 정보 삭제
	public int lesDelete(MaxValueVO mvo) {

		SwingAdminDAO sdao = new SwingAdminDAOImpl();
		int nCnt = sdao.lesDelete(mvo);
		
		return nCnt;	
	}
	
	public static void main(String[] args) {
	
		System.out.println("main() 시작  >>> : ");
		
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
		System.out.println("관리자 프로그램 시작 >>> : ");
		
		while (true) {
			System.out.println(" S U SL SA : 수강생 정보 구분자를 입력 하세요");
			System.out.println(" LI LS LU LD LSA : 수업 정보 구분자를 입력 하세요");
			System.out.println("프로그램을 종료 하려면 q 또는 Q 를 입력하세요");
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
						
						System.out.println("회원번호 >>> : " + mvo.getMnum());
						System.out.println("회원등급 >>> : " + mvo.getMgrade());
						System.out.println("회원아이디 >>> : " + mvo.getMid());
						// System.out.println("회원비밀번호 >>> : " + mvo.getMpw());
						System.out.println("회원이름 >>> : " + mvo.getMname());
						System.out.println("회원전화번호 >>> : " + mvo.getMhp());
						System.out.println("회원이메일 >>> : " + mvo.getMemail());
						System.out.println("회원삭제여부 >>> : " + mvo.getMdyn());
						System.out.println("회원등록일 >>> : " + mvo.getMinsert());
						System.out.println("회원정보수정일 >>> : " + mvo.getMupdate());
						
						// MaxValueVO.printVO(mvo);
					}
				}
			}
			if ("S".equals(isudType.toUpperCase())) {
				
				System.out.println("회원번호를 입력하세요 >>> : ");
				mnum = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅
				mvo.setMnum(mnum);
				
				ArrayList<MaxValueVO> aList = ca.memSelect(mvo);
				if (aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MaxValueVO _mvo = aList.get(i);
						System.out.println("회원번호 >>> : " + _mvo.getMnum());
						System.out.println("회원등급 >>> : " + _mvo.getMgrade());
						System.out.println("회원아이디 >>> : " + _mvo.getMid());
						// System.out.println("회원비밀번호 >>> : " + _mvo.getMpw());
						System.out.println("회원이름 >>> : " + _mvo.getMname());
						System.out.println("회원전화번호 >>> : " + _mvo.getMhp());
						System.out.println("회원이메일 >>> : " + _mvo.getMemail());
						System.out.println("회원삭제여부 >>> : " + _mvo.getMdyn());
						System.out.println("회원등록일 >>> : " + _mvo.getMinsert());
						System.out.println("회원정보수정일 >>> : " + _mvo.getMupdate());
						// MaxValueVO.printVO(_mvo);
					}
				}else {
					System.out.println("회원번호 : " + mvo.getMnum() 
					                    + " 님의 데이터가 존재하지 않습니다. ");
				}
			}
		
			if ("U".equals(isudType.toUpperCase())) {
								
				System.out.println("회원등급을 입력하세요 >>> : ");
				mgrade = sc.next();
				System.out.println("회원번호을 입력하세요 >>> : ");
				mnum = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅	
				mvo.setMgrade(mgrade);
				mvo.setMnum(mnum);
			
				int nCnt = ca.memUpdate(mvo);
				if (nCnt > 0) {
					System.out.println("데이터가 " + nCnt + " 건 수정 되었습니다. ");
				}else {
					System.out.println("수정 실패  >>> :  ");
				}				
			}
			if ("SL".equals(isudType.toUpperCase())) {
				
				System.out.println("회원이름을 입력하세요 >>> : ");
				mname = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅
				mvo.setMname(mname);
				
				ArrayList<MaxValueVO> aList = ca.mlSelect(mvo);
				if (aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MaxValueVO _mvo = aList.get(i);
						System.out.println("과목명 >>> : " + _mvo.getLname());
						System.out.println("회원이름 >>> : " + _mvo.getMname());
						System.out.println("개강일 >>> : " + _mvo.getLstr());
						System.out.println("종강일 >>> : " + _mvo.getLend());
						System.out.println("수업요일 >>> : " + _mvo.getLday());
						System.out.println("수업시간 >>> : " + _mvo.getLtime());
						System.out.println("선생님 >>> : " + _mvo.getLteacher());
						System.out.println("강의실 >>> : " + _mvo.getLroom());
						// System.out.println("수업삭제여부 >>> : " + _mvo.getLdyn());
						// System.out.println("수업등록일 >>> : " + _mvo.getLinsert());
						// System.out.println("회원정보수정일 >>> : " + _mvo.getLupdate());
						// MaxValueVO.printVO(_mvo);
					}
				}else {
					System.out.println("회원이름 : " + mvo.getMname() 
					                    + " 님의 데이터가 존재하지 않습니다. ");
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
						System.out.println("과목코드 >>> : " + mvo.getLcode());
						System.out.println("과목분류 >>> : " + mvo.getLsubject());
						System.out.println("과목명 >>> : " + mvo.getLname());
						System.out.println("개강일 >>> : " + mvo.getLstr());
						System.out.println("종강일 >>> : " + mvo.getLend());
						System.out.println("수업요일 >>> : " + mvo.getLday());
						System.out.println("수업시간 >>> : " + mvo.getLtime());
						System.out.println("선생님 >>> : " + mvo.getLteacher());
						System.out.println("강의실 >>> : " + mvo.getLroom());
						System.out.println("수업삭제여부 >>> : " + mvo.getLdyn());
						System.out.println("수업등록일 >>> : " + mvo.getLinsert());
						System.out.println("회원정보수정일 >>> : " + mvo.getLupdate());
						// MaxValueVO.printVO(mvo);
					}
				}
			}
			if ("LS".equals(isudType.toUpperCase())) {
				
				System.out.println("과목코드를 입력하세요 >>> : ");
				lcode = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅
				mvo.setLcode(lcode);
				
				ArrayList<MaxValueVO> aList = ca.lesSelect(mvo);
				if (aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						MaxValueVO _mvo = aList.get(i);
						System.out.println("과목코드 >>> : " + _mvo.getLcode());
						System.out.println("과목분류 >>> : " + _mvo.getLsubject());
						System.out.println("과목명 >>> : " + _mvo.getLname());
						System.out.println("개강일 >>> : " + _mvo.getLstr());
						System.out.println("종강일 >>> : " + _mvo.getLend());
						System.out.println("수업요일 >>> : " + _mvo.getLday());
						System.out.println("수업시간 >>> : " + _mvo.getLtime());
						System.out.println("선생님 >>> : " + _mvo.getLteacher());
						System.out.println("강의실 >>> : " + _mvo.getLroom());
						System.out.println("수업삭제여부 >>> : " + _mvo.getLdyn());
						System.out.println("수업등록일 >>> : " + _mvo.getLinsert());
						System.out.println("회원정보수정일 >>> : " + _mvo.getLupdate());
						// MaxValueVO.printVO(_mvo);
		 			}
				}else {
					System.out.println("과목코드 : " + mvo.getLcode() 
					                    + "의 데이터가 존재하지 않습니다. ");
				}
			}
			if ("LI".equals(isudType.toUpperCase())) {
										
				System.out.println("과목코드를 입력하세요 >>> : ");
				lcode= sc.next();
				System.out.println("과목분류를 입력하세요 >>> : ");
				lsubject= sc.next();
				System.out.println("과목명을 입력하세요 >>> : ");
				sc.nextLine();
				lname= sc.nextLine();
				System.out.println("개강일을 입력하세요 >>> : ");
				lstr= sc.next();
				System.out.println("종강일을 입력하세요 >>> : ");
				lend= sc.next();				
				System.out.println("수업요일을 입력하세요 >>> : ");
				lday= sc.next();
				System.out.println("수업시간을 입력하세요 >>> : ");
				ltime= sc.next();
				System.out.println("선생님을 입력하세요 >>> : ");
				lteacher= sc.next();
				System.out.println("강의실을 입력하세요 >>> : ");
				lroom= sc.next();
				
				ConsoleAdmin sas = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅
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
					System.out.println("데이터가 " + nCnt + " 건 등록 되었습니다. ");	
				}else {
					System.out.println("등록 실패  >>> :  ");
				}
				
			}
			if ("LU".equals(isudType.toUpperCase())) {
				
				System.out.println("수정할 과목명을 입력하세요 >>> : ");
				sc.nextLine();
				lname = sc.nextLine();
				System.out.println("수정할 과목코드를 입력하세요 >>> : ");
				lcode = sc.next();				
			
				
				ConsoleAdmin ca= new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅	
				mvo.setLname(lname);
				mvo.setLcode(lcode);
				
				int nCnt = ca.lesUpdate(mvo);
				if (nCnt > 0) {
					System.out.println("데이터가 " + nCnt + " 건 수정 되었습니다. ");
				}else {
					System.out.println("수정 실패  >>> :  ");
				}				
			}
			if ("LD".equals(isudType.toUpperCase())) {
				
				System.out.println("삭제할 과목코드를 입력하세요 >>> : ");
				lcode = sc.next();
				
				ConsoleAdmin ca = new ConsoleAdmin();				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅	
				mvo.setLcode(lcode);
				
				int nCnt = ca.lesDelete(mvo);
				if (nCnt > 0) {
					System.out.println("데이터가 " + nCnt + " 건 삭제 되었습니다. ");
				}else {
					System.out.println("삭제 실패  >>> :  ");
				}	
				
			}
			
			if ("Q".equals(isudType.toUpperCase())) {
				
				System.out.println("관리자 프로그램을 종료 합니다. >>> : ");
				break;
			}			
		}
		System.out.println("main() 끝  >>> : ");
	}	
}
