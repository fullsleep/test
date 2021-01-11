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
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			//��θ����
			pstmt = conn.prepareStatement(SwingNewMemberSqlMap.getInsertQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"	+ SwingNewMemberSqlMap.getInsertQuery());
			
			//������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, SwingChabunUtil.ymdNum());
			pstmt.setString(2, mvvo.getMid());
			pstmt.setString(3, mvvo.getMpw());
			pstmt.setString(4, mvvo.getMname());
			pstmt.setString(5, mvvo.getMhp());
			pstmt.setString(6, mvvo.getMemail());
			
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
	public boolean idConfirm(MaxValueVO mvvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MaxValueVO> aList = null;
		boolean newId = false;
		
		try {
			//�����ϱ�
			conn = SwingConnProp.getConnection();
			
			//��� �����
			pstmt = conn.prepareStatement(SwingNewMemberSqlMap.getIdConfrimQuery());
			
			//������ Ȯ��
			System.out.println("QUERY >>> : \n"+ SwingNewMemberSqlMap.getIdConfrimQuery());
			
			//������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, mvvo.getMid());
				
			//DB�� SELECT�ϱ�
			rsRs = pstmt.executeQuery();
			
			//�迭 ����
			aList = new ArrayList<MaxValueVO>();
			
			//����� �ޱ�
			while (rsRs.next()) {
				
				MaxValueVO _mvvo = new MaxValueVO();
				
				//����� setter�Լ��� ������
				_mvvo.setMid(rsRs.getString("MID"));
				
				aList.add(_mvvo);
			}
			
			// ��ȸ�� �����Ǹ� �ߺ� ���̵�� �Ǵ�
			if (aList.size() == 0 ) {newId = true;}
			
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
		
		return newId;
	}
	
}
