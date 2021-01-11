package mv.swing.mem.sql;

public abstract class SwingNewMemberSqlMap {
	

	//채번로직
	public static String getSelectChabun() {

		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011095) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 COMMNO	\n");
		sb.append(" FROM    MEMBER A 									\n");	   	  
	    sb.append("	WHERE   A.MDYN = 'Y'								\n");

	    return sb.toString();
	}
	
	// 회원 가입
	public static String getInsertQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("				MEMBER 				    \n");
		sb.append("		          (			    		\n");
		sb.append("       				 MNUM 			\n");
		sb.append("		  				,MGRADE 		\n");
		sb.append("		  				,MID 			\n");
	    sb.append("						,MPW   			\n");
	    sb.append("						,MNAME 			\n");
	    sb.append("						,MHP			\n");
	    sb.append("						,MEMAIL			\n");
	    sb.append("						,MDYN			\n");
	    sb.append("						,MINSERT		\n");
	    sb.append("						,MUPDATE		\n");
		sb.append("			      )						\n");
		sb.append(" VALUES 		  (  					\n");		
		sb.append("     				 ? 				\n");
		sb.append("						,'03' 			\n");
	    sb.append("						,?   			\n");
	    sb.append("						,? 				\n");
	    sb.append("						,? 				\n");
	    sb.append("						,?				\n");
	    sb.append("						,?				\n");
	    sb.append("						,'Y'			\n");
	    sb.append("						,SYSDATE 		\n");
	    sb.append("						,SYSDATE 		\n");	
		sb.append("	              )						\n");		
			
		return sb.toString();
	}
	
	//아이디 중복 검사하기
	public static String getIdConfrimQuery() {
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 							\n");		
		sb.append("		 	A.MID	AS MID			\n");	    	  	
	    sb.append("	FROM 							\n");
	    sb.append("		  	MEMBER A				\n");
	    sb.append("	WHERE 	A.MDYN 	= 'Y'			\n");
	    sb.append("	AND 	A.MID 	= ?				\n");
	    
	    return sb.toString();
	}
}
