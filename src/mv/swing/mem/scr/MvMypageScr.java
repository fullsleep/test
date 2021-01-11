package mv.swing.mem.scr;

import java.util.ArrayList;
import java.util.Scanner;

import mv.swing.common.SwingChabunUtil;
import mv.swing.mem.dao.MvMypageDAO;
import mv.swing.mem.dao.MvMypageDAOImpl;
import mv.swing.mem.vo.MaxValueVO;

public class MvMypageScr {

	// TODO Auto-generated method stub
	// ������ ���� ��ȸ
	public ArrayList<MaxValueVO> memSelect(MaxValueVO _mvo)
	{
		MvMypageDAO sdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = sdao.memSelect(_mvo);
		
		return aList;
	} // end of memSelect()
	// ������ ���� ����
	public int memUpdate(MaxValueVO mvo) 
	{
		MvMypageDAO sdao = new MvMypageDAOImpl();
		int nCnt = sdao.memUpdate(mvo);
		
		return nCnt;
	} // end of memUpdate()
	// ������ ���� ����(Ż��)
	public int memDelete(MaxValueVO mvo)
	{
		MvMypageDAO sdao = new MvMypageDAOImpl();
		int nCnt = sdao.memDelete(mvo);
		
		return nCnt;
	} // end of memDelete()
	// ���� ��ȸ
	public ArrayList<MaxValueVO> lesSelectAll()
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = mdao.lesSelectAll();
		
		return aList;
	} // end of lesSelectAll()
	// ���� ���� ��ȸ
	public ArrayList<MaxValueVO> lessonSelect(MaxValueVO _mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = mdao.lessonSelect(_mvo);
		
		return aList;
	} // end of lessonSelect()
	// ��û�� ���� ��ȸ
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO _mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		ArrayList<MaxValueVO> aList = mdao.lesSelect(_mvo);
		
		return aList;
	} // end of lesSelect()
	// ���� ��û
	public int lesInsert(MaxValueVO mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		int nCnt = mdao.lesInsert(mvo);
		
		return nCnt;
	} // end of lesInsert()
	// ���� ��û�� ���� ���
	public int lesDelete(MaxValueVO mvo)
	{
		MvMypageDAO mdao = new MvMypageDAOImpl();
		int nCnt = mdao.lesDelete(mvo);
		
		return nCnt;
	} // end of lesDelete()
	public static void main(String[] args) {
		
		System.out.println("main �Լ� ����");
		
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
		System.out.println("���������� ����");
				
		while (true) {
			System.out.println("MS, MU, MD �����ڸ� �Է��ϼ���");
			System.out.println("I, S, LS, D, SA�����ڸ� �Է��ϼ���.");
			System.out.println("������������ �����Ϸ��� q �Ǵ� Q �� �Է��ϼ���");
			String type = sc.next();
			// ������ ���� ��ȸ
			if("MS".equals(type.toUpperCase()))
			{
				System.out.println("ȸ�� ��ȣ�� �Է��ϼ���.");
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
					System.out.println("�Է��� ȸ�� ��ȣ�� �ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
				}
			}
			// ������ ���� ����
			else if("MU".equals(type.toUpperCase()))
			{
				System.out.println("ȸ�� ��ȣ�� �Է��ϼ���.");
				mnum = sc.next();
				System.out.println("�޴��� ��ȣ�� �Է��ϼ���.");
				mhp= sc.next();
				
				MvMypageScr cms = new MvMypageScr();
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				mvo.setMhp(mhp);
				mvo.setMnum(mnum);
				
				int nCnt = cms.memUpdate(mvo);
				if(nCnt > 0)
				{
					System.out.println(nCnt + " ���� �����Ͱ� ���� �Ǿ����ϴ�.");
				}else {
					System.out.println("������ ������ �����Ͽ����ϴ�.");
				}
			}
			// ������ ���� ����(Ż��)
			else if ("MD".equals(type.toUpperCase()))
			{
				System.out.println("������ ȸ�� ��ȣ�� �Է��ϼ���.");
				mnum = sc.next();
				
				MvMypageScr cms = new MvMypageScr();
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				mvo.setMnum(mnum);
				
				int nCnt = cms.memDelete(mvo);
				if(nCnt > 0)
				{
					System.out.println(nCnt + " ���� �����Ͱ� ���� �Ǿ����ϴ�.");
				}
				else {
					System.out.println("������ ������ �����Ͽ����ϴ�.");
				}
			}
			// ���� ��ȸ
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
			// ���� ��û
			if ("I".equals(type.toUpperCase()))
			{
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				
				// setter ����
				mvo.setMlnum(SwingChabunUtil.ymdNumLes());
				mvo.setMnum(SwingChabunUtil.ymdNum()); //
				mvo.setLcode(SwingChabunUtil.ymdLes());
							
				int nCnt = mms.lesInsert(mvo);
				System.out.println("������û�� ���ǰ� " + nCnt + "�� ��ϵǾ����ϴ�.");
			}
			// ���� ���� ��ȸ
			if ("LS".equals(type.toUpperCase()))
			{
				System.out.println("�����ڵ带 �Է��ϼ��� >>> ");
				lcode = sc.next();
				
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				
				// setter ����
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
			// ���� ��û�� ���� ��ȸ (mnum ���� lname���� ����?)
			if ("S".equals(type.toUpperCase()))
			{
				System.out.println("ȸ����ȣ�� �Է��ϼ��� >>> ");
				mnum = sc.next();
				
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				
				// setter ����
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
			// ���� ��û�� ���� ����
			if ("D".equals(type.toUpperCase()))
			{
				System.out.println("������û��ȣ�� �Է��ϼ��� >>> ");
				mlnum = sc.next();
				
				MvMypageScr mms = new MvMypageScr();
				
				MaxValueVO mvo = null;
				mvo = new MaxValueVO();
				// setter ����
				mvo.setMlnum(mlnum);
				
				int nCnt = mms.lesDelete(mvo);
				System.out.println("���� ��û�� ���ǰ� " + nCnt + "�� �����Ǿ����ϴ�.");
			}
			// ���������� ����
			if ("Q".equals(type.toUpperCase())) {
				
				System.out.println("������������ ���� �մϴ�. >>> : ");
				break;
			}
		}
		System.out.println("main �Լ� ��");
	} // end of main()

} // end of MvMyPageScr class
