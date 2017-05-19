package oopsw.string.test;

import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		String fileName="hello.jsp";
		System.out.println(fileName.indexOf(".jsp"));
		System.out.println(fileName.indexOf(".asp"));
		System.out.println(fileName.replace('.', '\u0000'));
		System.out.println(fileName.replace('.', '_'));
		
		Pattern p= Pattern.compile("^[a-zA-Z][[a-zA-Z0-9]*]{5,10}$");
		System.out.println(p.matcher("abcde").matches());
		System.out.println(p.matcher("a12345").matches());
		System.out.println(p.matcher("0bcdef").matches());
		System.out.println(p.matcher("a12345abcde").matches());
		System.out.println(p.matcher("a12345abcd!").matches());
		System.out.println(p.matcher("a12345abcdef").matches());		
	}//
}
