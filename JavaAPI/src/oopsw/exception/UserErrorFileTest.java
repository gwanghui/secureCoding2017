package oopsw.exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class UserObject{
	public UserObject(){
		methodA();
	}

	private void methodA() {
		methodB();
		
	}

	private void methodB() {
		Integer.parseInt("methodB's exception");
		
	}
	
}
public class UserErrorFileTest {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			new UserObject();
		} catch (Exception e) {
			e.printStackTrace(new PrintStream(
					new FileOutputStream("out_file.txt", true)));
		}
	
		System.out.println("end");
	}
}
