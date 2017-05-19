package oopsw.visitor.vo;

public class TestMain {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 10;
		String s1 = "hi";
		String s2 = "hi";
		char[] c1 ={'h','i'};
		char[] c2 ={'h','i'};
		String s3 = new String("hi");
		String s4 = new String("hi");
		
		System.out.println(num1 == num2);
		System.out.println(s1 == s2);
		System.out.println(c1 == c2);
		System.out.println(s3 == s4);
	}
}
