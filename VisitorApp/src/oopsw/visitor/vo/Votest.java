package oopsw.visitor.vo;

public class Votest {
	public static void main(String[] args) {
		TestVO vo = new TestVO("hi", 123);
		int testCallOfReference = 1;
		callOfReferCheck(testCallOfReference);
		
		System.out.println(testCallOfReference);
		
		
	}
	
	public static void callOfReferCheck(TestVO tVO){
		tVO.setKo(224);
	}
	
	public static void callOfReferCheck(int tVO){
		tVO = 3;;
	}

}
