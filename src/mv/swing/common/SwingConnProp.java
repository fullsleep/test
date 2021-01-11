package mv.swing.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class SwingConnProp {

	public static final String MV_URL = "jdbc:oracle:thin:@localhost:1521:orclKJM00";
	public static final String MV_USER = "kjm00";
	public static final String MV_PASS = "4432";	
	public static final String MV_DRIVER = "oracle.jdbc.driver.OracleDriver";
		
	public static Connection getConnection() {		
		
		Connection conn = null;
		
		try {
			Class.forName(SwingConnProp.MV_DRIVER);
			conn = DriverManager.getConnection( SwingConnProp.MV_URL
					                           ,SwingConnProp.MV_USER
					                           ,SwingConnProp.MV_PASS);
		}catch(Exception c) {
			System.out.println("드라이버 찾기에 문제가 발생 >>> : " + c);
		}	
				
		return conn;
	}
	
	public static void conClose( Connection conn
					            ,PreparedStatement pstmt 
					            ,ResultSet rsRs) {
		try
		{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}
		catch (Exception e2){}			
	}
	
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		try
		{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}
		catch (Exception e2){}			
	}
}
