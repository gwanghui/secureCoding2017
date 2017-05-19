package oopsw.encoding;


public class IntTest {

	public static void main(String[] args) {
		int num = Integer.MAX_VALUE;
		System.out.println(num);
		System.out.println(num + 1);
		
		int size = new Integer("1234").intValue();
		System.out.println(size);
		size = new Integer("-2147483648").intValue();
		System.out.println(size);
		size = new Integer("2147483648").intValue();
		System.out.println(size);
		size = new Integer(2147483646+2).intValue();
		System.out.println(size);


	}

}
