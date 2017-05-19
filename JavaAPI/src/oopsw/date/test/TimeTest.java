package oopsw.date.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {

	public static void main(String[] args) {
		System.out.println("특정 날짜 :"+ LocalDate.of(2009, 7, 30));
		System.out.println("현재 날짜 :"+ LocalDate.now());		
		System.out.println("현재 시간 :"+ LocalTime.now());
		System.out.println("현재 날짜/시간 :"+ LocalDateTime.now());
		System.out.println("현재 날짜 시간 존 : "+ ZonedDateTime.now());
		System.out.println("서울 날짜 시간 존 : "+ ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
		System.out.println("UTC 날짜 시간 존 : "+ ZonedDateTime.now(ZoneId.of("UTC")));	
		
		LocalDateTime newLocal = LocalDateTime.now().plusYears(10).plusMonths(2).minusDays(4);
		System.out.println(LocalDate.now()+" --> " +newLocal);
		
		DateTimeFormatter df=DateTimeFormatter.ofPattern("d일 M월 y년");
		System.out.println(LocalDate.now().format(df));
	}
}
