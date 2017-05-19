package oopsw.type;

public class UserType {

	public static void main(String[] args) {
		System.out.println(1+127);
		byte b2=1+126; //jdk1.5에서 부터 상수의 연산 VM 범위

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE + 1);
		//1, 10, 20, 30, 10.1  10.5  10.01
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);		
	};

}
