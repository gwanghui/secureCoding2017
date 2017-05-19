package oopsw.date.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {

	public static void main(String[] args) {
		System.out.println("Ư�� ��¥ :"+ LocalDate.of(2009, 7, 30));
		System.out.println("���� ��¥ :"+ LocalDate.now());		
		System.out.println("���� �ð� :"+ LocalTime.now());
		System.out.println("���� ��¥/�ð� :"+ LocalDateTime.now());
		System.out.println("���� ��¥ �ð� �� : "+ ZonedDateTime.now());
		System.out.println("���� ��¥ �ð� �� : "+ ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
		System.out.println("UTC ��¥ �ð� �� : "+ ZonedDateTime.now(ZoneId.of("UTC")));	
		
		LocalDateTime newLocal = LocalDateTime.now().plusYears(10).plusMonths(2).minusDays(4);
		System.out.println(LocalDate.now()+" --> " +newLocal);
		
		DateTimeFormatter df=DateTimeFormatter.ofPattern("d�� M�� y��");
		System.out.println(LocalDate.now().format(df));
	}
}
