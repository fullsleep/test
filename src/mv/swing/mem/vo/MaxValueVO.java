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
		System.out.println("ȸ����ȣ    		: mvo.getMnum() >>> : " 	+ mvo.getMnum());
		System.out.println("ȸ����� 		: mvo.getMgrade() >>> : " 	+ mvo.getMgrade());
		System.out.println("ȸ�����̵� 		: mvo.getMid() >>> : " 		+ mvo.getMid());
		System.out.println("ȸ����й�ȣ 	: mvo.getMpw() >>> : " 		+ mvo.getMpw());
		System.out.println("ȸ���̸� 		: mvo.getMname() >>> : " 	+ mvo.getMname());
		System.out.println("ȸ����ȭ��ȣ 	: mvo.getMhp() >>> : " 		+ mvo.getMhp());
		System.out.println("ȸ���̸��� 		: mvo.getMemail() >>> : " 	+ mvo.getMemail());
		System.out.println("ȸ���������� 	: mvo.getMdyn() >>> : " 	+ mvo.getMdyn());
		System.out.println("ȸ������� 		: mvo.getMinsert() >>> : " 	+ mvo.getMinsert());
		System.out.println("ȸ������������ 	: mvo.getMupdate() >>> : " + mvo.getMupdate());
		System.out.println("�����ڵ� 		: mvo.getLcode() >>> : " + mvo.getLcode());
		System.out.println("����з� 		: mvo.getLsubject() >>> : " + mvo.getLsubject());
		System.out.println("����� 		: mvo.getLname() >>> : " + mvo.getLname());
		System.out.println("������ 		: mvo.getLstr() >>> : " + mvo.getLstr());
		System.out.println("������ 		: mvo.getLend() >>> : " + mvo.getLend());
		System.out.println("�������� 		: mvo.getLday() >>> : " + mvo.getLday());
		System.out.println("�����ð� 		: mvo.getLtime() >>> : " + mvo.getLtime());
		System.out.println("������ 		: mvo.getLteacher() >>> : " + mvo.getLteacher());
		System.out.println("���ǽ� 		: mvo.getLroom() >>> : " + mvo.getLroom());
		System.out.println("������ҿ��� 	: mvo.getLdyn() >>> : " + mvo.getLdyn());
		System.out.println("��������� 		: mvo.getLinsert() >>> : " + mvo.getLinsert());
		System.out.println("���������� 		: mvo.getLupdate() >>> : " + mvo.getLupdate());
		System.out.println("��û��ȣ 		: mvo.getMlnum() >>> : " + mvo.getMlnum());
		System.out.println("��û��ҿ��� 	: mvo.getMldyn() >>> : " + mvo.getMldyn());
		System.out.println("������û�����	: mvo.getMlinsert() >>> : " + mvo.getMlinsert());
		System.out.println("������û������ 	: mvo.getMlupdate() >>> : " + mvo.getMlupdate());
		
	}	
}