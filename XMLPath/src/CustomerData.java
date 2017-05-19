import java.io.IOException;

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

public class CustomerData {
	private DocumentBuilder builder;
	private Document doc; //1번 읽은 데이터는 메모리에 임시 트리로 관리한다.
	private CustomerTO result;
	public CustomerData(String file, String searchData) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{		
		builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		getCustomerInfo(file);
		result = getSearchCustomer(searchData);
	}
	@Override
	public String toString() {
		return result.toString();
	}
	private CustomerTO getSearchCustomer(String searchData) throws XPathExpressionException {		
		NodeList nameList =(NodeList)( XPathFactory.newInstance().newXPath().compile("/customers/customer[@custId='"+searchData+"']/name").evaluate(doc, XPathConstants.NODESET));

		for(int i=0; i<nameList.getLength(); i++){
			return new CustomerTO(searchData, nameList.item(i).getTextContent());
		}	

		return null;
	}
	private void getCustomerInfo(String file) throws SAXException, IOException {
		doc =builder.parse(file);			
	}
}
