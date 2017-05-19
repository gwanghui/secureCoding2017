package oopsw.date.test;

import java.util.Calendar;
public class CalenderTest {
	public static void main(String[] args) {
		Calendar calender=Calendar.getInstance();
		System.out.println(calender);

		System.out.println("YEAR : "+ calender.get(Calendar.YEAR));
		System.out.println("MONTH : "+ (calender.get(Calendar.MONTH)+1));
		System.out.println("DAY_OF_MONTH : "+ calender.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("MONDAY : "+ Calendar.MONDAY);
		System.out.println("DAY_OF_WEEK : "+ calender.get(Calendar.DAY_OF_WEEK));		

		System.out.println("HOUR_OF_DAY : "+ calender.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE : "+ calender.get(Calendar.MINUTE));
		System.out.println("SECOND : "+ calender.get(Calendar.SECOND));
	}

}
