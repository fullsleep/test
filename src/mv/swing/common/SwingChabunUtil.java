package mv.swing.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mv.swing.mem.sql.SwingMyPageSqlMap;

public abstract class SwingChabunUtil {
		
	public static final String MV_MEMBER_M 	= "M";
	public static final String MV_LESSON_L = "L";
	public static final String MV_MESLES_ML = "ML";
	
	public static String commNum(String cNO){
		
		if (1 == cNO.length()){
			cNO = "000" + cNO;			
		}
		if (2 == cNO.length()){
			cNO = "00" + cNO;
		}	
		if (3 == cNO.length()){
			cNO = "0" + cNO;
		}			
		System.out.println("cNO >>>> : " + cNO);
		
		return cNO;
	}
	
	
	public static String ymdNum()
	{	
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet  rsRs         = null;			
		String commNO  = "";		 
		
		try
		{
			conn = SwingConnProp.getConnection();				
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.getMemberChabun());
			System.out.println("CAHBUN >>> : \n" + SwingMyPageSqlMap.getMemberChabun());			
			rsRs = pstmt.executeQuery();	
				
			
			if ( rsRs != null){
			  while (rsRs.next()){					
				commNO = rsRs.getString("COMMNO");	
			  }
			}
//			System.out.println("commNO >>>> : " + commNO);		
			
			commNO =  MV_MEMBER_M 
					+ DateFormatUtil.ymdFormat() 
					+ SwingChabunUtil.commNum(commNO);
			System.out.println("commNO >>>> : " + commNO);
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}
		catch (Exception e){
			System.out.println("DB 에러 " + e.getMessage());
		}
		finally {
			SwingConnProp.conClose(conn, pstmt, rsRs);			
		} 
	
		return commNO;
	}
	public static String ymdLes()
	{	
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet  rsRs         = null;			
		String commNO  = "";		 
		
		try
		{
			conn = SwingConnProp.getConnection();				
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.getLessonChabun());
			System.out.println("CAHBUN >>> : \n" + SwingMyPageSqlMap.getLessonChabun());			
			rsRs = pstmt.executeQuery();	
				
			
			if ( rsRs != null){
			  while (rsRs.next()){					
				commNO = rsRs.getString("COMMNO");	
			  }
			}
//			System.out.println("commNO >>>> : " + commNO);		
			
			commNO =  MV_LESSON_L 
					+ DateFormatUtil.ymdFormat() 
					+ SwingChabunUtil.commNum(commNO);
			System.out.println("commNO >>>> : " + commNO);
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}
		catch (Exception e){
			System.out.println("DB 에러 " + e.getMessage());
		}
		finally {
			SwingConnProp.conClose(conn, pstmt, rsRs);			
		} 
	
		return commNO;
	}
	public static String ymdNumLes()
	{	
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet  rsRs         = null;			
		String commNO  = "";		 
		
		try
		{
			conn = SwingConnProp.getConnection();				
			pstmt = conn.prepareStatement(SwingMyPageSqlMap.getMemlesChabun());
			System.out.println("CAHBUN >>> : \n" + SwingMyPageSqlMap.getMemlesChabun());			
			rsRs = pstmt.executeQuery();	
				
			
			if ( rsRs != null){
			  while (rsRs.next()){					
				commNO = rsRs.getString("COMMNO");	
			  }
			}
//			System.out.println("commNO >>>> : " + commNO);		
			
			commNO =  MV_MESLES_ML 
					+ DateFormatUtil.ymdFormat() 
					+ SwingChabunUtil.commNum(commNO);
			System.out.println("commNO >>>> : " + commNO);
			
			SwingConnProp.conClose(conn, pstmt, rsRs);
		}
		catch (Exception e){
			System.out.println("DB 에러 " + e.getMessage());
		}
		finally {
			SwingConnProp.conClose(conn, pstmt, rsRs);			
		} 
	
		return commNO;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ymdNum = SwingChabunUtil.ymdNum();
		System.out.println("ymdNum >>> : " + ymdNum);
		String ymdLes = SwingChabunUtil.ymdLes();
		System.out.println("ymdLes >>> : " + ymdLes);
		String ymdNumLes = SwingChabunUtil.ymdNumLes();
		System.out.println("ymdNumLes >>> : " + ymdNumLes);
	}
}
