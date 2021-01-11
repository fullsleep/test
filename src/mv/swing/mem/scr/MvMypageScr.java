package mv.swing.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import mv.swing.common.SwingChabunUtil;
import mv.swing.mem.dao.MvMypageDAO;
import mv.swing.mem.dao.MvMypageDAOImpl;
import mv.swing.mem.vo.MaxValueVO;

public class MvMypageScr {

	// TODO Auto-generated method stub
	// 수강생 정보 조회
	public ArrayList<MaxValueVO> memSelect(MaxValueVO _mvo)
	{
		MvMypageDAO sdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelect(_mvo);
		
		return aList;
	} // end of memSelect()
	// 수강생 정보 수정
	public int memUpdate(MaxValueVO mvo) 
	{
		MvMypageDAO sdao = new MvMypageDAOImpl();
		int nCnt = sdao.memUpdate(mvo);
		
		return nCnt;
	} // end of memUpdate()
	// 수강생 정보 삭제(탈퇴)
	public int memDelete(MaxValueVO mvo)
	{
		MvMypageDAO sdao = new MvMypageDAOImpl();
		int nCnt = sdao.memDelete(mvo);
		
		return nCnt;
	} // end of memDelete()
	// 과목 조회
	public ArrayList<MaxValueVO> lesSelectAll()
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = mdao.lesSelectAll();
		
		return aList;
	} // end of lesSelectAll()
	// 과목 선택 조회
	public ArrayList<MaxValueVO> lessonSelect(MaxValueVO _mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = mdao.lessonSelect(_mvo);
		
		return aList;
	} // end of lessonSelect()
	// 신청한 강의 조회
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO _mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = mdao.lesSelect(_mvo);
		
		return aList;
	} // end of lesSelect()
	// 수강 신청
	public int lesInsert(MaxValueVO mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		int nCnt = mdao.lesInsert(mvo);
		
		return nCnt;
	} // end of lesInsert()
	// 수강 신청한 강의 취소
	public int lesDelete(MaxValueVO mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		int nCnt = mdao.lesDelete(mvo);
		
		return nCnt;
	} // end of lesDelete()
	public static void main(String[] args) {
		
		System.out.println("main 함수 시작");
		
		String mnum = "";
		String mname = "";
		String mhp = "";
		
		String lcode = "";
		String lname = "";
		String lstr = "";
		String lend = "";
		String lday = "";
		String ltime = "";
		String lteacher = "";
		String lroom = "";
		String ldyn = "";
		
		String mlnum = "";
		String mldyn = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("마이페이지 시작");
				
		while (true) {
			System.out.println("MS, MU, MD 구분자를 입력하세요");
			System.out.println("I, S, LS, D, SA구분자를 입력하세요.");
			System.out.println("마이페이지를 종료하려면 q 또는 Q 를 입력하세요");
			String type = sc.next();
			// 수강생 정보 조회
			if("MS".equals(type.toUpperCase()))
			{
				System.out.println("회원 번호를 입력하세요.");
				mnum = sc.next();
				
				MvMypageScr cms = new MvMypageScr();
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				mvo.setMnum(mnum);
				
				ArrayList<MaxValueVO> aList = cms.memSelect(mvo);
				if (aList.size() > 0)
				{
					for(int i=0; i < aList.size(); i++)
					{
						MaxValueVO _mvo = aList.get(i);
						MaxValueVO.printVO(_mvo);
					}
				}else {
					System.out.println("입력한 회원 번호에 해당하는 데이터가 존재하지 않습니다.");
				}
			}
			// 수강생 정보 수정
			else if("MU".equals(type.toUpperCase()))
			{
				System.out.println("회원 번호를 입력하세요.");
				mnum = sc.next();
				System.out.println("휴대폰 번호를 입력하세요.");
				mhp= sc.next();
				
				MvMypageScr cms = new MvMypageScr();
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				mvo.setMhp(mhp);
				mvo.setMnum(mnum);
				
				int nCnt = cms.memUpdate(mvo);
				if(nCnt > 0)
				{
					System.out.println(nCnt + " 건의 데이터가 수정 되었습니다.");
				}else {
					System.out.println("데이터 수정에 실패하였습니다.");
				}
			}
			// 수강생 정보 삭제(탈퇴)
			else if ("MD".equals(type.toUpperCase()))
			{
				System.out.println("삭제할 회원 번호를 입력하세요.");
				mnum = sc.next();
				
				MvMypageScr cms = new MvMypageScr();
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				mvo.setMnum(mnum);
				
				int nCnt = cms.memDelete(mvo);
				if(nCnt > 0)
				{
					System.out.println(nCnt + " 건의 데이터가 삭제 되었습니다.");
				}
				else {
					System.out.println("데이터 삭제에 실패하였습니다.");
				}
			}
			// 과목 조회
			if ("SA".equals(type.toUpperCase()))
			{
				MvMypageScr mms = new MvMypageScr();
				ArrayList<MaxValueVO> aList = mms.lesSelectAll();
				if(aList.size() > 0)
				{
					for (int i=0; i < aList.size(); i++)
					{
						MaxValueVO mvo = (MaxValueVO)aList.get(i);
						System.out.println("mvo.getLcode() : " + mvo.getLcode());
						System.out.println("mvo.getLsubject() : " + mvo.getLsubject());
						System.out.println("mvo.getLname() : " + mvo.getLname());
						System.out.println("mvo.getLstr() : " + mvo.getLstr());
						System.out.println("mvo.getLend() : " + mvo.getLend());
						System.out.println("mvo.getLday() : " + mvo.getLday());
						System.out.println("mvo.getLtime() : " + mvo.getLtime());
						System.out.println("mvo.getLteacher() : " + mvo.getLteacher());
						System.out.println("mvo.getLroom() : " + mvo.getLroom());
						System.out.println("mvo.getLdyn() : " + mvo.getLdyn());
						System.out.println("mvo.getLinsert() : " + mvo.getLinsert());
						System.out.println("mvo.getLupdate() : " + mvo.getLupdate());
						
					}
				}
			}
			// 수강 신청
			if ("I".equals(type.toUpperCase()))
			{
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				
				// setter 세팅
				mvo.setMlnum(SwingChabunUtil.ymdNumLes());
				mvo.setMnum(SwingChabunUtil.ymdNum()); //
				mvo.setLcode(SwingChabunUtil.ymdLes());
							
				int nCnt = mms.lesInsert(mvo);
				System.out.println("수강신청한 강의가 " + nCnt + "건 등록되었습니다.");
			}
			// 과목 선택 조회
			if ("LS".equals(type.toUpperCase()))
			{
				System.out.println("과목코드를 입력하세요 >>> ");
				lcode = sc.next();
				
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				
				// setter 세팅
				mvo.setLcode(lcode);
				
				ArrayList<MaxValueVO> aList = mms.lessonSelect(mvo);
				if(aList.size() > 0)
				{
					for (int i=0; i < aList.size(); i++)
					{
						MaxValueVO _mvo = aList.get(i);
						System.out.println("_mvo.getLcode() : " + _mvo.getLcode());
						System.out.println("_mvo.getLsubject() : " + _mvo.getLsubject());
						System.out.println("_mvo.getLname() : " + _mvo.getLname());
						System.out.println("_mvo.getLstr() : " + _mvo.getLstr());
						System.out.println("_mvo.getLend() : " + _mvo.getLend());
						System.out.println("_mvo.getLday() : " + _mvo.getLday());
						System.out.println("_mvo.getLtime() : " + _mvo.getLtime());
						System.out.println("_mvo.getLteacher() : " + _mvo.getLteacher());
						System.out.println("_mvo.getLroom() : " + _mvo.getLroom());
						System.out.println("_mvo.getLdyn() : " + _mvo.getLdyn());
						System.out.println("_mvo.getLinsert() : " + _mvo.getLinsert());
						System.out.println("_mvo.getLupdate() : " + _mvo.getLupdate());
					}
				}
			}
			// 수강 신청한 과목 조회 (mnum 에서 lname으로 수정?)
			if ("S".equals(type.toUpperCase()))
			{
				System.out.println("회원번호를 입력하세요 >>> ");
				mnum = sc.next();
				
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				
				// setter 세팅
				mvo.setMnum(mnum);
				
				ArrayList<MaxValueVO> aList = mms.lesSelect(mvo);
				if(aList.size() > 0)
				{
					for (int i=0; i < aList.size(); i++)
					{
						MaxValueVO _mvo = aList.get(i);
						System.out.println("_mvo.getMname() : " + _mvo.getMname());
						System.out.println("_mvo.getLname() : " + _mvo.getLname());
						System.out.println("_mvo.getLstr() : " + _mvo.getLstr());
						System.out.println("_mvo.getLend() : " + _mvo.getLend());
						System.out.println("_mvo.getLday() : " + _mvo.getLday());
						System.out.println("_mvo.getLtime() : " + _mvo.getLtime());
						System.out.println("_mvo.getLteacher() : " + _mvo.getLteacher());
						System.out.println("_mvo.getLroom() : " + _mvo.getLroom());
						System.out.println("_mvo.getLdyn() : " + _mvo.getLdyn());
					}
				}
			}
			// 수강 신청한 강의 삭제
			if ("D".equals(type.toUpperCase()))
			{
				System.out.println("수강신청번호를 입력하세요 >>> ");
				mlnum = sc.next();
				
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter 세팅
				mvo.setMlnum(mlnum);
				
				int nCnt = mms.lesDelete(mvo);
				System.out.println("수강 신청한 강의가 " + nCnt + "건 삭제되었습니다.");
			}
			// 마이페이지 종료
			if ("Q".equals(type.toUpperCase())) {
				
				System.out.println("마이페이지를 종료 합니다. >>> : ");
				break;
			}
		}
		System.out.println("main 함수 끝");
	} // end of main()

} // end of MvMyPageScr class
