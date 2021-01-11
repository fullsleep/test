package mv.swing.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mv.swing.common.SwingChabunUtil;
import mv.swing.common.SwingConnProp;
import mv.swing.mem.sql.SwingLoginSqlMap;
import mv.swing.mem.sql.SwingNewMemberSqlMap;
import mv.swing.mem.vo.MaxValueVO;

public class SwingNewMemberDAOImpl implements SwingNewMemberDAO {

	@Override
	public int memInsert(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			//통로만들기
			pstmt = conn.prepareStatement(SwingNewMemberSqlMap.getInsertQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"	+ SwingNewMemberSqlMap.getInsertQuery());
			
			//데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, SwingChabunUtil.ymdNum());
			pstmt.setString(2, mvvo.getMid());
			pstmt.setString(3, mvvo.getMpw());
			pstmt.setString(4, mvvo.getMname());
			pstmt.setString(5, mvvo.getMhp());
			pstmt.setString(6, mvvo.getMemail());
			
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
	public boolean idConfirm(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		boolean newId = false;
		
		try {
			//연결하기
			conn = SwingConnProp.getConnection();
			
			//통로 만들기
			pstmt = conn.prepareStatement(SwingNewMemberSqlMap.getIdConfrimQuery());
			
			//쿼리문 확인
			System.out.println("QUERY >>> : \n"+ SwingNewMemberSqlMap.getIdConfrimQuery());
			
			//데이터 위치 세팅
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
				
			//DB에 SELECT하기
			rsRs = pstmt.executeQuery();
			
			//배열 선언
			aList = new ArrayList<MaxValueVO>();
			
			//결과값 받기
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				
				//결과값 setter함수에 보내기
				_mvvo.setMid(rsRs.getString("MID"));
				
				aList.add(_mvvo);
			}
			
			// 조회가 성공되면 중복 아이디로 판단
			if (aList.size() == 0 ) {newId = true;}
			
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
		
		return newId;
	}
	
}
