package mv.swing.mem.sql;

public abstract class SwingAdminSqlMap {
	
	// 수강생 정보 채번조회
	public static String getSelectChabun() {

		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011066) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 COMMNO	\n");
		sb.append(" FROM    MEMBER A 									\n");	   	  
	    sb.append("	WHERE   A.MDYN = 'Y'								\n");

	    return sb.toString();
	}
	
	public static String lesSelectChabun() {

		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011066) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.LCODE, -4)), 0) + 1 COMMNO	\n");
		sb.append(" FROM    LESSON A 									\n");	   	  
	    sb.append("	WHERE   A.LDYN = 'Y'								\n");

	    return sb.toString();
	}
	
	public static String suSelectChabun() {

		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011066) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.MLNUM, -4)), 0) + 1 COMMNO	\n");
		sb.append(" FROM    MEM_LES A 									\n");	   	  
	  //  sb.append("	WHERE   A.MLDYN = 'Y'								\n");

	    return sb.toString();
	}
	
	// 수강생 정보 조회 (회원번호로 조회)
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
	    sb.append("	AND   A.MNUM 		=  ?			\n");
			
		return sb.toString();
	}

	// 수강생 정보 수정
	public static String getUpdateQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  						\n");	
		sb.append("		   MEMBER 			    	\n");	
		sb.append("	SET  							\n");
	    sb.append("		   MGRADE  		= ?			\n");
	    sb.append("		  ,MUPDATE 		= SYSDATE	\n");
		sb.append("	WHERE  MNUM 		= ?			\n");	    
		sb.append("	AND    MDYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}
	
	// 수강 정보 조회
	public static String lesSelectQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 								\n");
		sb.append("      A.LCODE 		LCODE 			\n");
		sb.append("		,A.LSUBJECT  	LSUBJECT 		\n");
		sb.append("		,A.LNAME  		LNAME 			\n");
	    sb.append("		,A.LSTR  		LSTR   			\n");
	    sb.append("		,A.LEND  	    LEND 			\n");
	    sb.append("		,A.LDAY  		LDAY			\n");
	    sb.append("		,A.LTIME  	    LTIME			\n");
	    sb.append("		,A.LTEACHER  	LTEACHER		\n");
	    sb.append("		,A.LROOM  	    LROOM			\n");
	    sb.append("		,A.LDYN 		LDYN			\n");
	    sb.append("		,TO_CHAR(A.LINSERT, 'YYYY-MM-DD')  LINSERT	\n");
	    sb.append("		,TO_CHAR(A.LUPDATE, 'YYYY-MM-DD')  LUPDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 	LESSON A 					\n");
	    sb.append("	WHERE A.LDYN 		= 'Y'			\n");
	    sb.append("	AND   A.LCODE 		=  ?			\n");
		
		return sb.toString();
	}	
	
	// 과목 생성
	public static String lesInsertQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	INSERT INTO 						\n");	
		sb.append("				LESSON 				    \n");
		sb.append("		          (			    		\n");
		sb.append("       				 LCODE 			\n");
		sb.append("		  				,LSUBJECT 		\n");
		sb.append("		  				,LNAME 			\n");
	    sb.append("						,LSTR   		\n");
	    sb.append("						,LEND 			\n");
	    sb.append("						,LDAY			\n");
	    sb.append("						,LTIME			\n");
	    sb.append("						,LTEACHER		\n");
	    sb.append("						,LROOM			\n");
	    sb.append("						,LDYN			\n");
	    sb.append("						,LINSERT		\n");
	    sb.append("						,LUPDATE		\n");
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");		
		sb.append("     				 ?				\n");
		sb.append("						,? 				\n");
	    sb.append("						,?   			\n");
	    sb.append("						,? 				\n");
	    sb.append("						,? 				\n");
	    sb.append("						,?				\n");
	    sb.append("						,?				\n");
	    sb.append("						,?				\n");
	    sb.append("						,?				\n");
	    sb.append("						,'Y'			\n");
	    sb.append("						,SYSDATE 		\n");
	    sb.append("						,SYSDATE 		\n");	
		sb.append("	              )						\n");		
			
		return sb.toString();
	}	
	
	// 과목 정보 수정
	public static String lesUpdateQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	UPDATE  						\n");	
		sb.append("		   LESSON 			    	\n");	
		sb.append("	SET  							\n");
	    sb.append("		   LNAME		= ?			\n");
	    sb.append("		  ,LUPDATE 		= SYSDATE	\n");
		sb.append("	WHERE  LCODE 		= ?			\n");	    
		sb.append("	AND    LDYN 		= 'Y'  		\n");		
		
		return sb.toString();
	}	
	
	// 과목 정보 삭제
	public static String lesDeleteQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	UPDATE  						\n");	
		sb.append("		   LESSON 			    	\n");	
		sb.append("	SET  							\n");
	    sb.append("		   LDYN 	= 'N'			\n");	    	   
	    sb.append("		  ,LUPDATE 	= SYSDATE		\n");
		sb.append("	WHERE  LCODE 	= ?				\n");	    
		sb.append("	AND    LDYN 	= 'Y'  			\n");		
		
		return sb.toString();
	}
	
	// 수강생 목록 전체 조회
	public static String getSelectQueryAll() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.MNUM 		MNUM 			\n");
		sb.append("		,A.MGRADE  		MGRAGE 			\n");
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
	    sb.append("	WHERE A.MDYN = 'Y'					\n");

	    return sb.toString();
	}
	
	// 수강생 목록 조건 조회
	public static String mlSelectQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      B.LNAME 		LNAME 			\n");
		sb.append("		,A.MNAME  		MNAME 			\n");
		sb.append("		,B.LSTR  		LSTR 			\n");
	    sb.append("		,B.LEND  		LEND   			\n");
	    sb.append("		,B.LDAY  	    LDAY 			\n");
	    sb.append("		,B.LTIME  		LTIME			\n");
	    sb.append("		,B.LTEACHER  	LTEACHER		\n");
	    sb.append("		,B.LROOM 		LROOM			\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 	MEMBER  A 					\n");
	    sb.append("		   ,LESSON  B 					\n");
	    sb.append("		   ,MEM_LES C 					\n");
	    sb.append("	WHERE A.MNUM  = C.MNUM				\n");
	    sb.append("	AND   B.LCODE = C.LCODE				\n");
	    sb.append("	AND   C.MLDYN = 'Y'					\n");
	    //sb.append("	ORDER BY B.LNAME					\n");
	    sb.append("	AND   A.MNAME = ?					\n");
	    return sb.toString();
	}
	
	// 수업 목록 조회
	public static String lesSelectQueryAll() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.LCODE 		LCODE 			\n");
		sb.append("		,A.LSUBJECT  	LSUBJECT 		\n");
	    sb.append("		,A.LNAME  		LNAME   		\n");
	    sb.append("		,A.LSTR  	    LSTR 			\n");
	    sb.append("		,A.LEND  	    LEND 			\n");
	    sb.append("		,A.LDAY  		LDAY			\n");
	    sb.append("		,A.LTIME  		LTIME			\n");
	    sb.append("		,A.LTEACHER  	LTEACHER		\n");
	    sb.append("		,A.LROOM  		LROOM			\n");
	    sb.append("		,A.LDYN 		LDYN			\n");
	    sb.append("		,TO_CHAR(A.LINSERT, 'YYYY-MM-DD')  LINSERT	\n");
	    sb.append("		,TO_CHAR(A.LUPDATE, 'YYYY-MM-DD')  LUPDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 LESSON A 					\n");
	    sb.append("	WHERE A.LDYN = 'Y'				\n");

	    return sb.toString();
	}
}
