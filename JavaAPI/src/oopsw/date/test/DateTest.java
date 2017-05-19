package oopsw.date.test;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date=new Date();

		System.out.println(date);
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDay());

		date=new Date(12355422345L);
		System.out.println(date);
	}
}
