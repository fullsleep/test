package mv.swing.mem.sql;

public abstract class SwingLoginSqlMap {
	
	// 로그인  
	public static String getLoginQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");		
		sb.append("		 	 A.MID	  	AS MID			\n");	    	  
		sb.append("		  	,A.MPW		AS MPW			\n");	
	    sb.append("	FROM 								\n");
	    sb.append("		  	MEMBER A 					\n");
	    sb.append("	WHERE 	A.MDYN 	= 'Y'				\n");
	    sb.append("	AND   	A.MID 		=  ?			\n");
	    sb.append("	AND   	A.MPW 		=  ?			\n");
			
		return sb.toString();
	}
	
	// 관리자 로그인
	public static String getAdminLoginQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");		
		sb.append("		 	 A.MID	  	AS MID			\n");	    	  
		sb.append("		  	,A.MPW		AS MPW			\n");	
	    sb.append("	FROM 								\n");
	    sb.append("		  	MEMBER A 					\n");
	    sb.append("	WHERE 	A.MDYN 	= 'Y'				\n");
	    sb.append("	AND   	A.MID 		=  ?			\n");
	    sb.append("	AND   	A.MPW 		=  ?			\n");
	    sb.append("	AND   	A.MGRADE	= '01'			\n");
			
		return sb.toString();
	}
	
	// 아이디 찾기
	public static String getIdQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");		
		sb.append("		 	 A.MID	  	AS MID			\n");	    	  	
	    sb.append("	FROM 								\n");
	    sb.append("		  		MEMBER A 				\n");
	    sb.append("	WHERE 	A.MDYN 	= 'Y'				\n");
	    sb.append("	AND   	A.MEMAIL	=  ?			\n");

		return sb.toString();
	}
	
	// 패스워드 찾기
	public static String getPwdQuery() {
			
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");		
		sb.append("		 	A.MPW	  	AS MPW			\n");	    	  	
	    sb.append("	FROM 								\n");
	    sb.append("		  		MEMBER A 				\n");
	    sb.append("	WHERE 	A.MDYN 		= 'Y'			\n");
	    sb.append("	AND   	A.MID		=  ?			\n");

		return sb.toString();
	}	
	
	// 임시 비번 받기
	public static String getTempPwdQuery() {
		StringBuffer sb = new StringBuffer();			
		sb.append(" UPDATE 							\n");		
		sb.append("		 	MEMBER A				\n");	    	  	
	    sb.append("	SET 							\n");
	    sb.append("		  	A.MPW 	=  ? 			\n");
	    sb.append("	WHERE 	A.MDYN 	= 'Y'			\n");
	    sb.append("	AND   	A.MID	=  ?			\n");
	    
	    return sb.toString();
	}
	
	// 로그인 유지하기
	public static String getLoginConQuery() {
		StringBuffer sb = new StringBuffer();			
		sb.append(" UPDATE 							\n");		
		sb.append("		 	MEMBER A				\n");	    	  	
	    sb.append("	SET 							\n");
	    sb.append("		  	A.MSTATE 	= 'Y' 		\n");
	    sb.append("	WHERE 	A.MDYN 		= 'Y'		\n");
	    sb.append("	AND   	A.MID		=  ?		\n");
	    
	    return sb.toString();
	}
	
	// 로그아웃 하기
	public static String getLoginoutQuery() {
		StringBuffer sb = new StringBuffer();			
		sb.append(" UPDATE 							\n");		
		sb.append("		 	MEMBER A				\n");	    	  	
	    sb.append("	SET 							\n");
	    sb.append("		  	A.MSTATE 	= 'N'		\n");
	    
	    return sb.toString();
	}
}
