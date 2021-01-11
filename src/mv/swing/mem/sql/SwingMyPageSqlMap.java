package mv.swing.mem.sql;

public abstract class SwingMyPageSqlMap {

	// ä�� ���� MEMBER
	public static String getMemberChabun() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT /*+ INDEXT_DESC(SYS_C0011095)*/  \n");
		sb.append("		NVL(MAX(SUBSTR(MNUM, -4)), 0) + 1 COMMNO  \n");
		sb.append("FROM MEMBER    \n");
		
		return sb.toString();
	}
	
	// ä�� ���� LESSON
	public static String getLessonChabun() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT /*+ INDEXT_DESC(SYS_C0011095)*/  \n");
		sb.append("		NVL(MAX(SUBSTR(LCODE, -4)), 0) + 1 COMMNO  \n");
		sb.append("FROM LESSON    \n");
		
		return sb.toString();
	}
	
	// ä�� ����  MEM_LES
	public static String getMemlesChabun() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT /*+ INDEXT_DESC(SYS_C0011095)*/  \n");
		sb.append("		NVL(MAX(SUBSTR(MLNUM, -4)), 0) + 1 COMMNO  \n");
		sb.append("FROM MEM_LES    \n");
		
		return sb.toString();
	}
	// ������ ���� ��ȸ 
	public static String getSelectQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.MNUM 		MNUM 			\n");
		sb.append("		,A.MGRADE  		MGRADE 			\n");
		sb.append("		,A.MID  		MID 			\n");
	    sb.append("		,A.MPW  		MPW   			\n");
	    sb.append("		,A.MNAME  	    MNAME 			\n");
	    sb.append("		,A.MHP  		MHP				\n");
	    sb.append("		,A.MEMAIL  	    MEMAIL			\n");
	    sb.append("		,A.MDYN 		MDYN			\n");
	    sb.append("		,TO_CHAR(A.MINSERT, 'YYYY-MM-DD')  MINSERT	\n");
	    sb.append("		,TO_CHAR(A.MUPDATE, 'YYYY-MM-DD')  MUPDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 	MEMBER A 					\n");
	    sb.append("	WHERE A.MDYN 		= 'Y'			\n");
	    sb.append("	AND   A.MNUM 		=  (SELECT A.MNUM FROM MEMBER A WHERE A.MSTATE = 'Y')			\n");
			
		return sb.toString();
	}

	// ������ ���� ����
	public static String getUpdateQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  						\n");	
		sb.append("		   MEMBER 			    	\n");	
		sb.append("	SET  							\n");
	    sb.append("		   MHP  		= ?			\n");
	    sb.append("		  ,MUPDATE 		= SYSDATE	\n");
		sb.append("	WHERE  MNUM 		= (SELECT A.MNUM FROM MEMBER A WHERE A.MSTATE = 'Y')	\n");	    
		sb.append("	AND    MDYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}
	
	// ������ ���� ����(Ż��)
	public static String getDeleteQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  						\n");	
		sb.append("		   MEMBER 			    	\n");	
		sb.append("	SET  							\n");
	    sb.append("		   MDYN 	= 'N'			\n");	    	   
	    sb.append("		  ,MUPDATE 	= SYSDATE		\n");
	    sb.append("		  ,MSTATE 	= 'N'			\n");
		//sb.append("	WHERE  MNUM 	= ?				\n");	    
		sb.append("	AND    MDYN 	= 'Y'  			\n");		
					
		return sb.toString();
	}	

	// ��û�� ���� ��ȸ
	public static String lesSelectQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 								\n");
		sb.append("      A.MNAME 		MNAME 			\n");
		sb.append("		,B.LNAME  		LNAME 			\n");
		sb.append("		,B.LSTR  		LSTR 			\n");
		sb.append("		,B.LEND  	    LEND 			\n");
	    sb.append("		,B.LDAY  		LDAY			\n");
	    sb.append("		,B.LTIME  	    LTIME			\n");
	    sb.append("		,B.LTEACHER  	LTEACHER		\n");
	    sb.append("		,B.LROOM  	    LROOM			\n");
	    sb.append("		,B.LDYN 		LDYN			\n");
	    sb.append("	FROM 								\n");
	    sb.append("		  MEMBER A 						\n");
	    sb.append("		 ,LESSON B 						\n");
	    sb.append("		 ,MEM_LES C 					\n");
	    sb.append("	WHERE A.MNUM 		= (SELECT A.MNUM FROM MEMBER A WHERE A.MSTATE = 'Y')	\n");
	    sb.append("	AND   B.LCODE 		= C.LCODE		\n");
	    sb.append("	AND   C.MLDYN 		= 'Y'			\n");
	    sb.append("	AND   A.MNUM 		= C.MNUM		\n");
		
		return sb.toString();
	}	
	
	// ���� ��û
	public static String lesInsertQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	INSERT INTO 						\n");	
		sb.append("				MEM_LES 				\n");
		sb.append("		          (			    		\n");
		sb.append("       				 MLNUM 			\n");
		sb.append("		  				,MNUM 			\n");
		sb.append("		  				,LCODE 			\n");
		sb.append("						,MLDYN			\n");
	    sb.append("						,MLINSERT		\n");
	    sb.append("						,MLUPDATE		\n");
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");		
		sb.append("						 ?				\n");
		sb.append("						,(SELECT A.MNUM FROM MEMBER A WHERE A.MSTATE = 'Y')		\n");
	    sb.append("						,?				\n");
	    sb.append("						,'Y'			\n");
	    sb.append("						,SYSDATE 		\n");
	    sb.append("						,SYSDATE 		\n");	
		sb.append("	              )						\n");		
			
		return sb.toString();
	}	
	
	// ���� ���� ���� ����
	public static String lesDeleteQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	UPDATE  						\n");	
		sb.append("		   MEM_LES 			    	\n");	
		sb.append("	SET  							\n");
	    sb.append("		   MLDYN 	= 'N'			\n");	    	   
	    sb.append("		  ,MLUPDATE = SYSDATE		\n");
		sb.append("	WHERE  MNUM 	= (SELECT A.MNUM FROM MEMBER A WHERE A.MSTATE = 'Y')	\n");	    
		sb.append("	AND    MLDYN 	= 'Y'  			\n");
		sb.append("	AND    LCODE 	= ?  			\n");
		
		return sb.toString();
	}
	
	// ���� ���� ��ȸ
	public static String lessonSelectQuery() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT								\n");
		sb.append("		 A.LCODE 		LCODE		    \n");
		sb.append("		,A.LSUBJECT  	LSUBJECT   		\n"); 
		sb.append("		,A.LNAME  		LNAME   		\n");
		sb.append("		,A.LSTR  	    LSTR    		\n");			
		sb.append("		,A.LEND  	    LEND     		\n");		
		sb.append("		,A.LDAY  		LDAY	  		\n");		
		sb.append("		,A.LTIME  		LTIME   		\n");		
		sb.append("		,A.LTEACHER  	LTEACHER   		\n");		
		sb.append("		,A.LROOM  		LROOM			\n");	
		sb.append("		,A.LDYN 	   	LDYN   			\n");		
		sb.append("		,TO_CHAR(A.LINSERT, 'YYYY-MM-DD')  LINSERT  \n");	
		sb.append("		,TO_CHAR(A.LUPDATE, 'YYYY-MM-DD')  LUPDATE  \n");
		sb.append(" FROM   								\n");
		sb.append("		 	 LESSON A					\n");
		sb.append(" WHERE    A.LDYN =  'Y'  			\n");
		sb.append(" AND    	 A.LCODE =  ?				\n");
		
		return sb.toString();
	} 
}
