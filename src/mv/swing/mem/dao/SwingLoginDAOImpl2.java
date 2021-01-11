package mv.swing.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mv.swing.common.SwingConnProp;
import mv.swing.mem.sql.SwingLoginSqlMap;
import mv.swing.mem.vo.MaxValueVO;

public class SwingLoginDAOImpl2 implements SwingLoginDAO2 {

	@Override
	public boolean memLogin(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		boolean bLogin = false;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			
			//통로 만들기
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getLoginQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getLoginQuery());
			
			//데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
			pstmt.setString(2, mvvo.getMpw());
			
			//DB에 SELECT하기
			rsRs = pstmt.executeQuery();
			
			//배열 선언
			aList = new ArrayList<MaxValueVO>();
			
			//결과값 받기
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				
				//결과값 setter함수에 보내기
				_mvvo.setMid(rsRs.getString("MID"));
				_mvvo.setMpw(rsRs.getString("MPW"));
				
				aList.add(_mvvo);
			}
			
			// 조회가 성공되면 로그인 된 것으로 판단
			if (aList.size() > 0 ) {bLogin = true;}
			
			// 연결 닫기
			SwingConnProp.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);
			}catch(Exception e2) {}
		}		
		
		return bLogin;
	}

	@Override
	public int memLogout(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			//통로만들기
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getLoginoutQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"	+ SwingLoginSqlMap.getLoginoutQuery());
						
			//데이터 DB에 INSERT
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음");
			
			//연결 닫기
			SwingConnProp.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}

	@Override
	public ArrayList<MaxValueVO> idSearch(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			
			//통로만들기
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getIdQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getIdQuery());
			
			//데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMemail());
			
			//DB에 SELECT하기
			rsRs = pstmt.executeQuery();
			
			//배열 선언
			aList = new ArrayList<MaxValueVO>();
			
			//결과값 받기
			while (rsRs.next()) {
				MaxValueVO _mvvo = new MaxValueVO();
				
				//결과값 setter 함수에 보내기
				_mvvo.setMid(rsRs.getString("MID"));
				
				aList.add(_mvvo);
			}
				
			//연결 닫기
			SwingConnProp.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);
			}catch(Exception e2) {}
		}
		
		return aList;
	}

	@Override
	public ArrayList<MaxValueVO> pwSearch(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			
			//통로만들기
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getPwdQuery());
			
			//쿼리문확인
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getPwdQuery());
			
			//데이터 위치 세팅
			pstmt.setString(1, mvvo.getMid());
			
			//DB에 SELECT 하기
			rsRs = pstmt.executeQuery();
			
			//배열 선언
			aList = new ArrayList<MaxValueVO>();
			
			//결과값 받기
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				//결과값 setter함수에 보내기
				_mvvo.setMpw(rsRs.getString("MPW"));
				
				aList.add(_mvvo);
			}
			
			//연결 닫기
			SwingConnProp.conClose(conn, pstmt, rsRs);		
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);
			}catch(Exception e2) {}
		}

		return aList;
	}

	@Override
	public int pwTemp(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {
			conn = SwingConnProp.getConnection();
			
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getTempPwdQuery());
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getTempPwdQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMpw());
			pstmt.setString(2, mvvo.getMid());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 입력 되었음 ");
			
			SwingConnProp.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}
	
	@Override
	public boolean memAdminLogin(MaxValueVO mvvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		boolean bLogin = false;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			
			//통로 만들기
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getAdminLoginQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getAdminLoginQuery());
			
			//데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
			pstmt.setString(2, mvvo.getMpw());
			
			//DB에 SELECT하기
			rsRs = pstmt.executeQuery();
			
			//배열 선언
			aList = new ArrayList<MaxValueVO>();
			
			//결과값 받기
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				
				//결과값 setter함수에 보내기
				_mvvo.setMid(rsRs.getString("MID"));
				_mvvo.setMpw(rsRs.getString("MPW"));
				
				aList.add(_mvvo);
			}
			
			// 조회가 성공되면 로그인 된 것으로 판단
			if (aList.size() > 0 ) {bLogin = true;}

			// 연결 닫기
			SwingConnProp.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rsRs);
			}catch(Exception e2) {}
		}
		
		return bLogin;
	}
	
	@Override
	public int nowLogin(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			//통로만들기
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getLoginConQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"	+ SwingLoginSqlMap.getLoginConQuery());
			
			//데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
			
			//데이터 DB에 INSERT
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음");
			
			//연결 닫기
			SwingConnProp.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("DB연동 혹은 쿼리문에 문제가 발생하였습니다." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}

	
}
