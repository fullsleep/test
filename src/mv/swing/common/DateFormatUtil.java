package mv.swing.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {

	public static String ymdFormat(){
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String sd = sdf.format(d);

		return sd;
	}
	
	public static String ymFormat(){
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String sd = sdf.format(d);
		
		return sd;
	}
	
	public static String yFormat(){
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String sd = sdf.format(d);
		
		return sd;
	}
	
	public static String ymdFormats(String ymdFlag){
		
		String sd = "";		
		Date d = new Date();
		
		if ("D".equals(ymdFlag)){
			sd = new SimpleDateFormat("yyyyMMdd").format(d);
		}
		if ("M".equals(ymdFlag)){
			sd = new SimpleDateFormat("yyyyMM").format(d);
		}
		if ("Y".equals(ymdFlag)){
			sd = new SimpleDateFormat("yyyy").format(d);
		}
		
		return sd;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
