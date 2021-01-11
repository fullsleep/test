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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			
			//��� �����
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getLoginQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getLoginQuery());
			
			//������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
			pstmt.setString(2, mvvo.getMpw());
			
			//DB�� SELECT�ϱ�
			rsRs = pstmt.executeQuery();
			
			//�迭 ����
			aList = new ArrayList<MaxValueVO>();
			
			//����� �ޱ�
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				
				//����� setter�Լ��� ������
				_mvvo.setMid(rsRs.getString("MID"));
				_mvvo.setMpw(rsRs.getString("MPW"));
				
				aList.add(_mvvo);
			}
			
			// ��ȸ�� �����Ǹ� �α��� �� ������ �Ǵ�
			if (aList.size() > 0 ) {bLogin = true;}
			
			// ���� �ݱ�
			SwingConnProp.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			//��θ����
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getLoginoutQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"	+ SwingLoginSqlMap.getLoginoutQuery());
						
			//������ DB�� INSERT
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ���");
			
			//���� �ݱ�
			SwingConnProp.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			
			//��θ����
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getIdQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getIdQuery());
			
			//������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMemail());
			
			//DB�� SELECT�ϱ�
			rsRs = pstmt.executeQuery();
			
			//�迭 ����
			aList = new ArrayList<MaxValueVO>();
			
			//����� �ޱ�
			while (rsRs.next()) {
				MaxValueVO _mvvo = new MaxValueVO();
				
				//����� setter �Լ��� ������
				_mvvo.setMid(rsRs.getString("MID"));
				
				aList.add(_mvvo);
			}
				
			//���� �ݱ�
			SwingConnProp.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			
			//��θ����
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getPwdQuery());
			
			//������Ȯ��
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getPwdQuery());
			
			//������ ��ġ ����
			pstmt.setString(1, mvvo.getMid());
			
			//DB�� SELECT �ϱ�
			rsRs = pstmt.executeQuery();
			
			//�迭 ����
			aList = new ArrayList<MaxValueVO>();
			
			//����� �ޱ�
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				//����� setter�Լ��� ������
				_mvvo.setMpw(rsRs.getString("MPW"));
				
				aList.add(_mvvo);
			}
			
			//���� �ݱ�
			SwingConnProp.conClose(conn, pstmt, rsRs);		
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
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
			
			System.out.println("nCnt >>> : " + nCnt + " �� �Է� �Ǿ��� ");
			
			SwingConnProp.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			
			//��� �����
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getAdminLoginQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"+ SwingLoginSqlMap.getAdminLoginQuery());
			
			//������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
			pstmt.setString(2, mvvo.getMpw());
			
			//DB�� SELECT�ϱ�
			rsRs = pstmt.executeQuery();
			
			//�迭 ����
			aList = new ArrayList<MaxValueVO>();
			
			//����� �ޱ�
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				
				//����� setter�Լ��� ������
				_mvvo.setMid(rsRs.getString("MID"));
				_mvvo.setMpw(rsRs.getString("MPW"));
				
				aList.add(_mvvo);
			}
			
			// ��ȸ�� �����Ǹ� �α��� �� ������ �Ǵ�
			if (aList.size() > 0 ) {bLogin = true;}

			// ���� �ݱ�
			SwingConnProp.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			//��θ����
			pstmt = conn.prepareStatement(SwingLoginSqlMap.getLoginConQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"	+ SwingLoginSqlMap.getLoginConQuery());
			
			//������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
			
			//������ DB�� INSERT
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ���");
			
			//���� �ݱ�
			SwingConnProp.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("DB���� Ȥ�� �������� ������ �߻��Ͽ����ϴ�." + e);
		}
		finally {
			try {
				SwingConnProp.conClose(conn, pstmt);
			}catch(Exception e2) {}
		}
		
		return nCnt;
	}

	
}
