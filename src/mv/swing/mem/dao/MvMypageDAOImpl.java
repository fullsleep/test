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
	// ������ ���� ��ȸ
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
			System.out.println("��񿬵��� ������ ������ϴ�.");
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
	// ������ ���� ����
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
			//System.out.println(nCnt + " ���� �����Ͱ� ���� �Ǿ����ϴ�.");
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "�����Ϸ�");
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e) {
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "DB ���� ����");
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
	// ������ ���� ����(Ż��)
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
			JOptionPane.showMessageDialog(jf, "Ż��Ϸ�");
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e) {
			JFrame jf = new JFrame();
			JOptionPane.showMessageDialog(jf, "DB ���� ����");
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
	// ���� ��ü ��ȸ
	@Override
	public ArrayList<MaxValueVO> lesSelectAll()
	{
		// ����� ��ü ������ �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MaxValueVO> aList = null;
		try
		{
			// �����ϱ�
			conn = SwingConnProp.getConnection();
			//��� �����
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
			System.out.println("��񿬵��� ������ ������ϴ�. >>> : " + e);
		}finally {
			try {
				SwingConnProp.conClose(conn, pstmt, rs);				
			}catch(Exception e2) {}
		}
				
		return aList;
	} // end of lesSelectAll()
	// ���� ���� ��ȸ
	@Override
	public ArrayList<MaxValueVO> lessonSelect(MaxValueVO _mvo)
	{
		//����� ��ü ������ �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MaxValueVO> aList = null;
		try
		{
			// �����ϱ�
			conn = SwingConnProp.getConnection();
			// ��� �����
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lessonSelectQuery());
			System.out.println("QUERY >>> : \n " + SwingMyPageSqlMap.lessonSelectQuery());
			// ������ ��ġ �����ϱ�
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
					//add() �޼ҵ带 ����� �����ڸ� ȣ��
					aList.add(mvo);
				}
			}
			// ����ݱ�
			SwingConnProp.conClose(conn, pstmt, rs);
		}
		catch(Exception e)
		{
			System.out.println("DB ������ ������ ������ϴ�." + e);
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
	// ��û�� ���� ��ȸ
	@Override
	public ArrayList<MaxValueVO> lesSelect(MaxValueVO _mvo)
	{
		//����� ��ü ������ �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MaxValueVO> aList = null;
		try
		{
			// �����ϱ�
			conn = SwingConnProp.getConnection();
			// ��� �����
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
					// add() �޼ҵ带 ����� �����ڸ� ȣ��
					aList.add(mvo);
				}
			}
			// ����ݱ�
			SwingConnProp.conClose(conn, pstmt, rs);
		}
		catch(Exception e)
		{
			System.out.println("DB ������ ������ ������ϴ�." + e);
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
	// ������û
	@Override
	public int lesInsert(MaxValueVO mvo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try
		{
			// �����ϱ�
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() : " + conn.getAutoCommit());
			// ��� �����
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lesInsertQuery());
			// ������ Ȯ��
			System.out.println("QUERY : \n" + SwingMyPageSqlMap.lesInsertQuery());
			// ������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, SwingChabunUtil.ymdNumLes());
			//pstmt.setString(2, mvo.getMnum());
			pstmt.setString(2, mvo.getLcode());
			//pstmt.setString(3, mvo.getLcode());
									
			// ������ DB�� INSERT
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt" + nCnt + "�� ��ϵǾ����ϴ�.");
			// ���� �ݱ�
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e)
		{
			System.out.println("DB������ ������ ������ϴ�." + e);
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
	// ���� ��û�� ���� ���
	@Override
	public int lesDelete(MaxValueVO mvo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try
		{	
			// �����ϱ�
			conn = SwingConnProp.getConnection();
			System.out.println("conn.getAutoCommit() : " + conn.getAutoCommit());
			// ��� �����
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.lesDeleteQuery());
			// ������ Ȯ��
			System.out.println("QUERY : \n" + SwingMyPageSqlMap.lesDeleteQuery());
			// ������ ��ġ ����
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getLcode());
			// ������ DB�� INSERT
			nCnt = pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			System.out.println("nCnt : " + nCnt + "�� �����Ǿ����ϴ�.");
			// ���� �ݱ�
			SwingConnProp.conClose(conn, pstmt);
		}
		catch(Exception e)
		{
			System.out.println("DB������ ������ ������ϴ�." + e);
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
