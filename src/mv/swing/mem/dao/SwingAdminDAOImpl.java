package mv.swing.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mv.swing.common.SwingChabunUtil;
import mv.swing.common.SwingConnProp;
import mv.swing.mem.sql.SwingAdminSqlMap;
import mv.swing.mem.vo.MaxValueVO;

public class SwingAdminDAOImpl implements SwingAdminDAO {
	
	@Override
	public ArrayList<MaxValueVO> memSelectAll() {
	
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {			

			conn = SwingConnProp.getConnection();
			pstmt = conn.prepareStatement(SwingAdminSqlMap.getSelectQueryAll());
			System.out.println("QUERY >>> : \n"+ SwingAdminSqlMap.getSelectQueryAll());
  
			rsRs = pstmt.executeQuery();
			System.out.println("rsRs >>> : " + rsRs);
			
			if (rsRs !=null) {
				aList = new ArrayList<MaxValueVO>();
				
				while (rsRs.next()) {
					
					MaxValueVO mvo = new MaxValueVO();
					mvo.setMnum(rsRs.getString(1));
					mvo.setMgrade(rsRs.getString(2));
					mvo.setMid(rsRs.getString(3));
					mvo.setMpw(rsRs.getString(4));
					mvo.setMname(rsRs.getString(5));
					mvo.setMhp(rsRs.getString(6));
					mvo.setMemail(rsRs.getString(7));
					mvo.setMdyn(rsRs.getString(8));
					mvo.setMinsert(rsRs.getString(9));
					mvo.setMupdate(rsRs.getString(10));

					aList.add(mvo);
				}
			}	
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return aList;
	}

	@Override
	public ArrayList<MaxValueVO> memSelect(MaxValueVO mvo) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {			

			conn = SwingConnProp.getConnection();
			pstmt = conn.prepareStatement(SwingAdminSqlMap.getSelectQuery());
			System.out.println("QUERY >>> : \n"+ SwingAdminSqlMap.getSelectQuery());
  
			pstmt.setString(1, mvo.getMnum());
			rsRs = pstmt.executeQuery();
			System.out.println("rsRs >>> : " + rsRs);
			
			if (rsRs !=null) {
				aList = new ArrayList<MaxValueVO>();
				
				while (rsRs.next()) {
					
					MaxValueVO _mvo = new MaxValueVO();
					_mvo.setMnum(rsRs.getString(1));
					_mvo.setMgrade(rsRs.getString(2));
					_mvo.setMid(rsRs.getString(3));
					_mvo.setMpw(rsRs.getString(4));
					_mvo.setMname(rsRs.getString(5));
					_mvo.setMhp(rsRs.getString(6));
					_mvo.setMemail(rsRs.getString(7));
					_mvo.setMdyn(rsRs.getString(8));
					_mvo.setMinsert(rsRs.getString(9));
					_mvo.setMupdate(rsRs.getString(10));

					aList.add(_mvo);
				}
			}	
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return aList;	
	}

	@Override
	public int memUpdate(MaxValueVO mvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = SwingConnProp.getConnection(); 
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			//conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(SwingAdminSqlMap.getUpdateQuery());
			System.out.println("QUERY >>> : \n"	+ SwingAdminSqlMap.getUpdateQuery());
			
			pstmt.clearParameters();			
		
			pstmt.setString(1, mvo.getMgrade());
			pstmt.setString(2, mvo.getMnum());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
			SwingConnProp.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}

	@Override
	public ArrayList<MaxValueVO> mlSelect(MaxValueVO mvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {			

			conn = SwingConnProp.getConnection();
			pstmt = conn.prepareStatement(SwingAdminSqlMap.mlSelectQuery());
			System.out.println("QUERY >>> : \n"+ SwingAdminSqlMap.mlSelectQuery());
  
			pstmt.setString(1, mvo.getMname());
			rsRs = pstmt.executeQuery();
			System.out.println("rsRs >>> : " + rsRs);
			
			if (rsRs !=null) {
				aList = new ArrayList<MaxValueVO>();
				
				while (rsRs.next()) {
					
					MaxValueVO mlmvo = new MaxValueVO();
					mlmvo.setLname(rsRs.getString(1));
					mlmvo.setMname(rsRs.getString(2));
					mlmvo.setLstr(rsRs.getString(3));
					mlmvo.setLend(rsRs.getString(4));
					mlmvo.setLday(rsRs.getString(5));
					mlmvo.setLtime(rsRs.getString(6));
					mlmvo.setLteacher(rsRs.getString(7));
					mlmvo.setLroom(rsRs.getString(8));
				
					aList.add(mlmvo);
				}
			}	
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return aList;	
	}
	
	@Override
	public ArrayList<MaxValueVO> lesSelectAll() {
	
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {			

			conn = SwingConnProp.getConnection();
			pstmt = conn.prepareStatement(SwingAdminSqlMap.lesSelectQueryAll());
			System.out.println("QUERY >>> : \n"+ SwingAdminSqlMap.lesSelectQueryAll());
  
			rsRs = pstmt.executeQuery();
			System.out.println("rsRs >>> : " + rsRs);
			
			if (rsRs !=null) {
				aList = new ArrayList<MaxValueVO>();
				
				while (rsRs.next()) {
					
					MaxValueVO mvo = new MaxValueVO();
					mvo.setLcode(rsRs.getString(1));
					mvo.setLsubject(rsRs.getString(2));
					mvo.setLname(rsRs.getString(3));
					mvo.setLstr(rsRs.getString(4));
					mvo.setLend(rsRs.getString(5));
					mvo.setLday(rsRs.getString(6));
					mvo.setLtime(rsRs.getString(7));
					mvo.setLteacher(rsRs.getString(8));
					mvo.setLroom(rsRs.getString(9));
					mvo.setLdyn(rsRs.getString(10));
					mvo.setLinsert(rsRs.getString(11));
					mvo.setLupdate(rsRs.getString(12));

					aList.add(mvo);
				}
			}	
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return aList;
	}

	@Override
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO mvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {			

			conn = SwingConnProp.getConnection();
			pstmt = conn.prepareStatement(SwingAdminSqlMap.lesSelectQuery());
			System.out.println("QUERY >>> : \n"+ SwingAdminSqlMap.lesSelectQuery());
  
			pstmt.setString(1, mvo.getLcode());
			rsRs = pstmt.executeQuery();
			System.out.println("rsRs >>> : " + rsRs);
			
			if (rsRs !=null) {
				aList = new ArrayList<MaxValueVO>();
				
				while (rsRs.next()) {
					
					MaxValueVO _mvo = new MaxValueVO();
					_mvo.setLcode(rsRs.getString(1));
					_mvo.setLsubject(rsRs.getString(2));
					_mvo.setLname(rsRs.getString(3));
					_mvo.setLstr(rsRs.getString(4));
					_mvo.setLend(rsRs.getString(5));
					_mvo.setLday(rsRs.getString(6));
					_mvo.setLtime(rsRs.getString(7));
					_mvo.setLteacher(rsRs.getString(8));
					_mvo.setLroom(rsRs.getString(9));
					_mvo.setLdyn(rsRs.getString(10));
					_mvo.setLinsert(rsRs.getString(11));
					_mvo.setLupdate(rsRs.getString(12));

					aList.add(_mvo);
				}
			}	
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return aList;	
	}

	@Override
	public int lesInsert(MaxValueVO mvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = SwingConnProp.getConnection(); 
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			//conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(SwingAdminSqlMap.lesInsertQuery());
			System.out.println("QUERY >>> : \n"	+ SwingAdminSqlMap.lesInsertQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getLcode());
			pstmt.setString(2, mvo.getLsubject());
			pstmt.setString(3, mvo.getLname());
			pstmt.setString(4, mvo.getLstr());
			pstmt.setString(5, mvo.getLend());
			pstmt.setString(6, mvo.getLday());
			pstmt.setString(7, mvo.getLtime());
			pstmt.setString(8, mvo.getLteacher());
			pstmt.setString(9, mvo.getLroom());

			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
			SwingConnProp.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}

	@Override
	public int lesUpdate(MaxValueVO mvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = SwingConnProp.getConnection(); 
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			//conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(SwingAdminSqlMap.lesUpdateQuery());
			System.out.println("QUERY >>> : \n"	+ SwingAdminSqlMap.lesUpdateQuery());
			
			pstmt.clearParameters();			
			pstmt.setString(1, mvo.getLname());
			pstmt.setString(2, mvo.getLcode());
		
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
			SwingConnProp.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}

	@Override
	public int lesDelete(MaxValueVO mvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = SwingConnProp.getConnection(); 
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			//conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(SwingAdminSqlMap.lesDeleteQuery());
			System.out.println("QUERY >>> : \n"	+ SwingAdminSqlMap.lesDeleteQuery());
			
			pstmt.clearParameters();						
			pstmt.setString(1, mvo.getLcode());
 
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
			SwingConnProp.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}
}
