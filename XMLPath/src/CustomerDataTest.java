
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


//TDD, refactoring
public class CustomerDataTest {
	public static void main(String[] args)  {
		System.out.println("start-->"+new Date().toString());
		try{		
			//k의 입력 형태 체크
			System.out.println(new CustomerData("customers.xml", "///k"));	
		
		}catch(Exception e){
			try{
			e.printStackTrace(new PrintStream(new FileOutputStream("error.txt"), true));
			}catch(FileNotFoundException fe){
				e.printStackTrace();
			}
		}
		System.out.println("end....>"+new Date().toString());
	}
}
