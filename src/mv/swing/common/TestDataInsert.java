/*
-- 데이타 1000000 건을 넣기위해 수정
CREATE TABLE SE_BOARD(
	mnum		NUMBER(8)			NOT NULL,
	mtitle		VARCHAR2(50)		NOT NULL,
	mname		VARCHAR2(20)		NOT NULL,
	memail		VARCHAR2(50)		NOT NULL,
	marea		VARCHAR2(2000)		NOT NULL,
	mpass		VARCHAR2(20)		NOT NULL,
	mref		NUMBER(8)			NULL,
	mstep		NUMBER(8)			NULL,
	mdepth		NUMBER(8)			NULL,
	mwriteday	DATE				DEFAULT SYSDATE,
	mhits		NUMBER(8)			NULL
);

CREATE SEQUENCE B_SEQ INCREMENT BY 1 START WITH 1;

*-----------------------------------------------------------------------
* descripton
* mref     :	원본 게시물 번호
* mstep    :	같은 원본 게시물에 대한 답변글 내에서의 순서 
* mdepth   :	답변의 단계 (예, 원본=0, 원본의 답변=1, 답변의 답변=2, ...)
*-----------------------------------------------------------------------
*
*/

package mv.swing.common;

import java.sql.Connection;
import java.sql.Statement;

public class TestDataInsert 
{
	public void insertData()
	{
		System.out.println("insertData() 함수 시작 >>> : ");
		try {
			Connection con = SwingConnProp.getConnection();			
			Statement stmt = con.createStatement();
			String sqls = null;
			
	//		for (long i = 0; i < 1000000 ; i++)
			for (long i = 0; i < 50 ; i++)
			{
				System.out.println("for 조건문 시작 >>> : ");
				sqls =   "  INSERT INTO MEMBER (				\n"
						 +"                    MNUM				\n"
						 +"                    ,MGRADE			\n"
						 +"                    ,MID				\n"
						 +"                    ,MPW				\n"
						 +"                    ,MNAME			\n"
						 +"                    ,MHP				\n"
						 +"                    ,MEMAIL			\n"
						 +"                    ,MDYN			\n"
						 +"                    ,MINSERT			\n"
						 +"                    ,MUPDATE			\n"
						 +"                   )					\n"
						 +" VALUES            (					\n"
						 +"                     (SELECT 'M'||TO_CHAR(SYSDATE, 'YYYYMMDD')	\n"
						 +"                     ||LPAD(NVL(MAX(SUBSTR(A.MNUM, -4)), 0) +1, 4, '0') AS COMM FROM MEMBER A) 	\n"
						 +"                    ,'03'			\n"
						 +"                    ,'test"+i+"'		\n"
						 +"                    ,'test"+i+"'		\n"
						 +"                    ,'test"+i+"'		\n"
						 +"                    ,'test"+i+"'		\n"
						 +"                    ,'test"+i+"'		\n"
						 +"                    ,'Y'				\n"
						 +"                    ,SYSDATE			\n"
						 +"                    ,SYSDATE			\n"
						 +"                   )					\n";			
				
				int nCount = stmt.executeUpdate(sqls);
				//if (nCount % 1000 == 0) con.commit();
				if (nCount % 50 == 0) con.commit();
			}
		
			con.commit();		
			stmt.close();		stmt = null;
			con.close();		con = null;		
		}catch(Exception e) {System.out.println("DB연동 혹은 쿼리문 오류 >>> : " + e);}		
		
	}
	
	public static void main(String args[])
	{	
		System.out.println("main() 함수 시작 >>> : ");
		new TestDataInsert().insertData();
	}
}