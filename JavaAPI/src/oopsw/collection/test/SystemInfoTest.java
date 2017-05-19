package oopsw.collection.test;

import java.util.Enumeration;
import java.util.Properties;
public class SystemInfoTest {
	public static void main(String[] args) {
		Properties pro=System.getProperties();
		Enumeration names=pro.propertyNames();

		while(names.hasMoreElements()){
			String key=names.nextElement().toString();
			String value=System.getProperty(key);
			System.out.println(key+" : " + value);
		}
	}
}
