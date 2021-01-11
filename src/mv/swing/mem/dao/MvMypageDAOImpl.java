package mv.swing.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mv.swing.common.SwingChabunUtil;
import mv.swing.common.SwingConnProp;
import mv.swing.mem.sql.SwingMyPageSqlMap;
import mv.swing.mem.sql.SwingAdminSqlMap;
import mv.swing.mem.vo.MaxValueVO;

public class MvMypageDAOImpl implements MvMypageDAO {
	// 수강생 정보 조회
	@Override
	public ArrayList<MaxValueVO> memSelect(MaxValueVO mvo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try 
		{
			conn = SwingConnProp.getConnection();
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.getSelectQuery());
			// pstmt.setString(1, mvo.getMnum());
			rsRs = pstmt.executeQuery();
			
			if(rsRs != null) {
				aList = new ArrayList<MaxValueVO>();
				while(rsRs.next()) {
					MaxValueVO _mvo = null;
					_mvo = new MaxValueVO();
					
					_mvo.setMnum(rsRs.getString("MNUM"));
					_mvo.setMgrade(rsRs.getString("MGRADE"));
					_mvo.setMid(rsRs.getString("MID"));
					_mvo.setMpw(rsRs.getString("MPW"));
					_mvo.setMname(rsRs.getString("MNAME"));
					_mvo.setMhp(rsRs.getString("MHP"));
					_mvo.setMemail(rsRs.getString("MEMAIL"));
					_mvo.setMdyn(rsRs.getString("MDYN"));
					_mvo.setMinsert(rsRs.getString("MINSERT"));
					_mvo.setMupdate(rsRs.getString("MUPDATE"));
					
					aList.add(_mvo);
				}
			}
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}
		catch(Exception e)
		{
			System.out.println("디비연동에 문제가 생겼습니다.");
		}
		finally
		{
			try
			{
				SwingConnProp.conClose(conn, pstmt, rsRs);
			}
			catch(Exception e) {}
		}
		return aList;
	}
	// 수강생 정보 수정
	@Override
	public int memUpdate(MaxValueVO mvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean isAutoCommit = false;
		
		try {
			conn = SwingConnProp.getConnection();
			isAutoCommit = conn.getAutoCommit();
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.getUpdateQuery());
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMhp());
			//pstmt.setString(2, mvo.getMnum());
			nCnt = pstmt.executeUpdate();
			if(!isAutoCommit) conn.commit();
			//System.out.println(nCnt + " 건의 데이터가 수정 되었습니다.");
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "수정완료");
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e) {
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "DB 연동 에러");
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return nCnt;
	}
	// 수강생 정보 삭제(탈퇴)
	@Override
	public int memDelete(MaxValueVO mvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean isAutoCommit = false;
		
		try {
			conn = SwingConnProp.getConnection(); 
			isAutoCommit = conn.getAutoCommit();
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.getDeleteQuery());
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMnum());
			nCnt = pstmt.executeUpdate();
			if(!isAutoCommit) conn.commit();
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "탈퇴완료");
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e) {
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "DB 연동 에러");
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return nCnt;
	}
	// 과목 전체 조회
	@Override
	public ArrayList<MaxValueVO> lesSelectAll()
	{
		// 사용할 객체 변수로 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MaxValueVO> aList = null;
		try
		{
			// 연결하기
			conn = SwingConnProp.getConnection();
			//통로 만들기
			pstmt = conn.prepareStatement(SwingAdminSqlMap.lesSelectQueryAll());
			System.out.println("QUERY >>> : \n" + SwingAdminSqlMap.lesSelectQueryAll());
			
			rs = pstmt.executeQuery();
			System.out.println("rs : " + rs);
			
			if (rs != null)
			{
				aList = new ArrayList<MaxValueVO>();
				while (rs.next()) {
					
					MaxValueVO mvo = new MaxValueVO();
					mvo.setLcode(rs.getString(1));
					mvo.setLsubject(rs.getString(2));
					mvo.setLname(rs.getString(3));
					mvo.setLstr(rs.getString(4));
					mvo.setLend(rs.getString(5));
					mvo.setLday(rs.getString(6));
					mvo.setLtime(rs.getString(7));
					mvo.setLteacher(rs.getString(8));
					mvo.setLroom(rs.getString(9));
					mvo.setLdyn(rs.getString(10));
					mvo.setLinsert(rs.getString(11));
					mvo.setLupdate(rs.getString(12));

					aList.add(mvo);
				}
			}	
			
			SwingConnProp.conClose(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rs);				
			}catch(Exception e2) {}
		}
				
		return aList;
	} // end of lesSelectAll()
	// 과목 선택 조회
	@Override
	public ArrayList<MaxValueVO> lessonSelect(MaxValueVO _mvo)
	{
		//사용할 객체 변수로 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MaxValueVO> aList = null;
		try
		{
			// 연결하기
			conn = SwingConnProp.getConnection();
			// 통로 만들기
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lessonSelectQuery());
			System.out.println("QUERY >>> : \n " + SwingMyPageSqlMap.lessonSelectQuery());
			// 데이터 위치 고정하기
			pstmt.clearParameters();
			pstmt.setString(1, _mvo.getLcode());
			rs = pstmt.executeQuery();
			
			if (rs != null)
			{
				aList = new ArrayList<MaxValueVO>();
				while(rs.next())
				{
					MaxValueVO mvo = null;
					mvo = new MaxValueVO();
					
					mvo.setLcode(rs.getString(1));
					mvo.setLsubject(rs.getString(2));
					mvo.setLname(rs.getString(3));
					mvo.setLstr(rs.getString(4));
					mvo.setLend(rs.getString(5));
					mvo.setLday(rs.getString(6));
					mvo.setLtime(rs.getString(7));
					mvo.setLteacher(rs.getString(8));
					mvo.setLroom(rs.getString(9));
					mvo.setLdyn(rs.getString(10));
					mvo.setLinsert(rs.getString(11));
					mvo.setLupdate(rs.getString(12));
					//add() 메소드를 사용해 생성자만 호출
					aList.add(mvo);
				}
			}
			// 연결닫기
			SwingConnProp.conClose(conn, pstmt, rs);
		}
		catch(Exception e)
		{
			System.out.println("DB 연동에 문제가 생겼습니다." + e);
		}
		finally
		{
			try
			{
				SwingConnProp.conClose(conn, pstmt, rs);
			}
			catch(Exception e2) {}
		}
		return aList;
	} // end of lessonSelectQuery()
	// 신청한 과목 조회
	@Override
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO _mvo)
	{
		//사용할 객체 변수로 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MaxValueVO> aList = null;
		try
		{
			// 연결하기
			conn = SwingConnProp.getConnection();
			// 통로 만들기
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lesSelectQuery());
			System.out.println("QUERY >>> : \n " + SwingMyPageSqlMap.lesSelectQuery());
			
			rs = pstmt.executeQuery();
			
			if (rs != null)
			{
				aList = new ArrayList<MaxValueVO>();
				while(rs.next())
				{
					MaxValueVO mvo = null;
					mvo = new MaxValueVO();
				
					mvo.setMname(rs.getString(1));
					mvo.setLname(rs.getString(2));
					mvo.setLstr(rs.getString(3));
					mvo.setLend(rs.getString(4));
					mvo.setLday(rs.getString(5));
					mvo.setLtime(rs.getString(6));
					mvo.setLteacher(rs.getString(7));
					mvo.setLroom(rs.getString(8));
					mvo.setLdyn(rs.getString(9));
					// add() 메소드를 사용해 생성자만 호출
					aList.add(mvo);
				}
			}
			// 연결닫기
			SwingConnProp.conClose(conn, pstmt, rs);
		}
		catch(Exception e)
		{
			System.out.println("DB 연동에 문제가 생겼습니다." + e);
		}
		finally
		{
			try
			{
				SwingConnProp.conClose(conn, pstmt, rs);
			}
			catch(Exception e2) {}
		}
		return aList;
	} // end of lesSelect()
	// 수강신청
	@Override
	public int lesInsert(MaxValueVO mvo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try
		{
			// 연결하기
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() : " + conn.getAutoCommit());
			// 통로 만들기
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lesInsertQuery());
			// 쿼리문 확인
			System.out.println("QUERY : \n" + SwingMyPageSqlMap.lesInsertQuery());
			// 데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, SwingChabunUtil.ymdNumLes());
			//pstmt.setString(2, mvo.getMnum());
			pstmt.setString(2, mvo.getLcode());
			//pstmt.setString(3, mvo.getLcode());
									
			// 데이터 DB에 INSERT
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt" + nCnt + "건 등록되었습니다.");
			// 연결 닫기
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e)
		{
			System.out.println("DB연동에 문제가 생겼습니다." + e);
		}
		finally
		{
			try
			{
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		return nCnt;
	} // end of lesInsert()
	// 수강 신청한 강의 취소
	@Override
	public int lesDelete(MaxValueVO mvo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try
		{	
			// 연결하기
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() : " + conn.getAutoCommit());
			// 통로 만들기
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lesDeleteQuery());
			// 쿼리문 확인
			System.out.println("QUERY : \n" + SwingMyPageSqlMap.lesDeleteQuery());
			// 데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getLcode());
			// 데이터 DB에 INSERT
			nCnt = pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			System.out.println("nCnt : " + nCnt + "건 삭제되었습니다.");
			// 연결 닫기
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e)
		{
			System.out.println("DB연동에 문제가 생겼습니다." + e);
		}
		finally
		{
			try
			{
				SwingConnProp.conClose(conn, pstmt);
			}
			catch(Exception e2) {}
		}
		return nCnt;
	} // end of lesDelete()
} // end of MvMypageDAOImpl class
