package oopsw.systeminfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;

public class ViewSystemInfo {
	public static void main(String[] args) throws FileNotFoundException {
		Properties vmInfo = System.getProperties();
		Enumeration e= vmInfo.propertyNames();
		vmInfo.setProperty("user.home", "C:\\OOPSW\\workspace");
		//열겨형 자료 데이터는 while
		System.setOut(new PrintStream(
			new FileOutputStream("fileout.property")));
		while(e.hasMoreElements()){
			String key = e.nextElement().toString();
			String value = vmInfo.getProperty(key);
			
			System.out.println(key+"--> "+value);
		}//		
	}//
}
