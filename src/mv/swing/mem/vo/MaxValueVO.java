package mv.swing.mem.vo;

public class MaxValueVO {
	
	private String mnum;
	private String mgrade;
	private String mid;
	private String mpw;
	private String mname;
	private String mhp;
	private String memail;
	private String mdyn;
	private String minsert;
	private String mupdate;
	private String lcode;
	private String lsubject;
	private String lname;
	private String lstr;
	private String lend;
	private String lday;
	private String ltime;
	private String lteacher;
	private String lroom;
	private String ldyn;
	private String linsert;
	private String lupdate;
	private String mlnum;
	private String mldyn;
	private String mlinsert;
	private String mlupdate;
	
	public MaxValueVO() {}
	
	public MaxValueVO(String mnum, String mgrade, 
					  String mid, String mpw, String mname, 
					  String mhp, String memail,String mdyn, 
					  String minsert, String mupdate, String lcode,
					  String lsubject, String lname, String lstr,
					  String lend, String lday, String ltime,
					  String lteacher, String lroom, String ldyn,
					  String linsert, String lupdate, String mlnum,
					  String mldyn, String mlinsert, String mlupdate) {
		
		this.mnum = mnum;
		this.mgrade = mgrade;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mhp = mhp;
		this.memail = memail;
		this.mdyn = mdyn;
		this.minsert = minsert;
		this.mupdate = mupdate;
		this.lcode = lcode;
		this.lsubject = lsubject;
		this.lname = lname;
		this.lstr = lstr;
		this.lend = lend;
		this.lteacher = lteacher;
		this.lroom = lroom;
		this.ldyn = ldyn;
		this.linsert = linsert;
		this.lupdate = lupdate;
		this.mlnum = mlnum;
		this.mldyn = mldyn;
		this.mlinsert = mlinsert;
		this.mlupdate = mlupdate;
	}
	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getMgrade() {
		return mgrade;
	}

	public void setMgrade(String mgrade) {
		this.mgrade = mgrade;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMhp() {
		return mhp;
	}

	public void setMhp(String mhp) {
		this.mhp = mhp;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMdyn() {
		return mdyn;
	}

	public void setMdyn(String mdyn) {
		this.mdyn = mdyn;
	}

	public String getMinsert() {
		return minsert;
	}

	public void setMinsert(String minsert) {
		this.minsert = minsert;
	}

	public String getMupdate() {
		return mupdate;
	}

	public void setMupdate(String mupdate) {
		this.mupdate = mupdate;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public String getLsubject() {
		return lsubject;
	}

	public void setLsubject(String lsubject) {
		this.lsubject = lsubject;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLstr() {
		return lstr;
	}

	public void setLstr(String lstr) {
		this.lstr = lstr;
	}

	public String getLend() {
		return lend;
	}

	public void setLend(String lend) {
		this.lend = lend;
	}

	public String getLday() {
		return lday;
	}

	public void setLday(String lday) {
		this.lday = lday;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public String getLteacher() {
		return lteacher;
	}

	public void setLteacher(String lteacher) {
		this.lteacher = lteacher;
	}

	public String getLroom() {
		return lroom;
	}

	public void setLroom(String lroom) {
		this.lroom = lroom;
	}

	public String getLdyn() {
		return ldyn;
	}

	public void setLdyn(String ldyn) {
		this.ldyn = ldyn;
	}

	public String getLinsert() {
		return linsert;
	}

	public void setLinsert(String linsert) {
		this.linsert = linsert;
	}

	public String getLupdate() {
		return lupdate;
	}

	public void setLupdate(String lupdate) {
		this.lupdate = lupdate;
	}

	public String getMlnum() {
		return mlnum;
	}

	public void setMlnum(String mlnum) {
		this.mlnum = mlnum;
	}
	
	public String getMldyn() {
		return mldyn;
	}
	
	public void setMldyn(String mldyn) {
		this.mldyn = mldyn;
	}
	
	public String getMlinsert() {
		return mlinsert;
	}

	public void setMlinsert(String mlinsert) {
		this.mlinsert = mlinsert;
	}

	public String getMlupdate() {
		return mlupdate;
	}

	public void setMlupdate(String mlupdate) {
		this.mlupdate = mlupdate;
	}

	
	public static void printVO(MaxValueVO mvo) {
		System.out.println("회원번호    		: mvo.getMnum() >>> : " 	+ mvo.getMnum());
		System.out.println("회원등급 		: mvo.getMgrade() >>> : " 	+ mvo.getMgrade());
		System.out.println("회원아이디 		: mvo.getMid() >>> : " 		+ mvo.getMid());
		System.out.println("회원비밀번호 	: mvo.getMpw() >>> : " 		+ mvo.getMpw());
		System.out.println("회원이름 		: mvo.getMname() >>> : " 	+ mvo.getMname());
		System.out.println("회원전화번호 	: mvo.getMhp() >>> : " 		+ mvo.getMhp());
		System.out.println("회원이메일 		: mvo.getMemail() >>> : " 	+ mvo.getMemail());
		System.out.println("회원삭제여부 	: mvo.getMdyn() >>> : " 	+ mvo.getMdyn());
		System.out.println("회원등록일 		: mvo.getMinsert() >>> : " 	+ mvo.getMinsert());
		System.out.println("회원정보수정일 	: mvo.getMupdate() >>> : " + mvo.getMupdate());
		System.out.println("과목코드 		: mvo.getLcode() >>> : " + mvo.getLcode());
		System.out.println("과목분류 		: mvo.getLsubject() >>> : " + mvo.getLsubject());
		System.out.println("과목명 		: mvo.getLname() >>> : " + mvo.getLname());
		System.out.println("개강일 		: mvo.getLstr() >>> : " + mvo.getLstr());
		System.out.println("종강일 		: mvo.getLend() >>> : " + mvo.getLend());
		System.out.println("수업요일 		: mvo.getLday() >>> : " + mvo.getLday());
		System.out.println("수업시간 		: mvo.getLtime() >>> : " + mvo.getLtime());
		System.out.println("선생님 		: mvo.getLteacher() >>> : " + mvo.getLteacher());
		System.out.println("강의실 		: mvo.getLroom() >>> : " + mvo.getLroom());
		System.out.println("수업취소여부 	: mvo.getLdyn() >>> : " + mvo.getLdyn());
		System.out.println("수업등록일 		: mvo.getLinsert() >>> : " + mvo.getLinsert());
		System.out.println("수업수정일 		: mvo.getLupdate() >>> : " + mvo.getLupdate());
		System.out.println("신청번호 		: mvo.getMlnum() >>> : " + mvo.getMlnum());
		System.out.println("신청취소여부 	: mvo.getMldyn() >>> : " + mvo.getMldyn());
		System.out.println("수강신청등록일	: mvo.getMlinsert() >>> : " + mvo.getMlinsert());
		System.out.println("수강신청수정일 	: mvo.getMlupdate() >>> : " + mvo.getMlupdate());
		
	}	
}