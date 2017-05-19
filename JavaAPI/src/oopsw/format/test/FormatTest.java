package oopsw.format.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {

	public static void main(String[] args) {
		double userNumber=123456.789;
		
		DecimalFormat df = new DecimalFormat("#");
		System.out.println(df.format(userNumber));
		
		df = new DecimalFormat("#.#");
		System.out.println(df.format(userNumber));
		
		df = new DecimalFormat("#.######");
		System.out.println(df.format(userNumber));
		
		df = new DecimalFormat("#.0");
		System.out.println(df.format(userNumber));
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		System.out.println(sdf.format(d));
		sdf = new SimpleDateFormat("yy-mm-dd");
		System.out.println(sdf.format(d));
		sdf = new SimpleDateFormat("yy-MM-dd");
		System.out.println(sdf.format(d));
	}

}
