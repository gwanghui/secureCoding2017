package oopsw.xmlpath;
import java.io.IOException;import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CustomerDataTest {
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc =builder.parse("customers.xml");
		System.out.println(doc.getDocumentElement());
		//XSLT's 경로를 찾기 위해서 xPath
		XPath xPath = XPathFactory.newInstance().newXPath();
		//String path="//name";
		
		//String input="k";
		String input="'or''='";
		input = input.replaceAll("'","");  //무조건 출력을 막아줌
		
		String path="/customers/customer[@custId='"+input+"']/name";
		NodeList nameList =(NodeList)( xPath.compile(path).evaluate(doc, XPathConstants.NODESET));
		
		for(int i=0; i<nameList.getLength(); i++){
			System.out.println(nameList.item(i).getTextContent());
		}		
		
	}
}
