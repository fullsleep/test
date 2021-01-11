package mv.swing.mem.sql;

public abstract class SwingLoginSqlMap {
	
	// �α���  
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
	
	// ������ �α���
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
	
	// ���̵� ã��
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
	
	// �н����� ã��
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
	
	// �ӽ� ��� �ޱ�
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
	
	// �α��� �����ϱ�
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
	
	// �α׾ƿ� �ϱ�
	public static String getLoginoutQuery() {
		StringBuffer sb = new StringBuffer();			
		sb.append(" UPDATE 							\n");		
		sb.append("		 	MEMBER A				\n");	    	  	
	    sb.append("	SET 							\n");
	    sb.append("		  	A.MSTATE 	= 'N'		\n");
	    
	    return sb.toString();
	}
}
