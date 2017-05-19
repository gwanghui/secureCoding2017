package oopsw.encoding;
/*
 byte 배열을 16진수 문자열로 부호화하는 방법
 URLEncoding에서 "%" 이후 표현과 XML, XHTML 등에서 표현할 수 있는 문자 코드 범위를 벗어난 문자의 경우 &#xcode; 에서 xcode 부분
 Unicode 문자의 표현 등 다양한 곳에서 사용되고 있는 부호화 기법
 //javaee / JAXB 2.0  jdk 1.6 확인 가능
 */
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
public class HexCodeTest {
	public static void main(String[] args) {
		byte [] name =new String("전혜영").getBytes();		
		System.out.println(name);
				
		HexBinaryAdapter hba=new HexBinaryAdapter();
		String encoderData = hba.marshal(name);
		byte [] decoderData = hba.unmarshal(encoderData);
		
		System.out.println(encoderData);           //C0FCC7FDBFB5
		System.out.println(new String(decoderData)); //전혜영
	}
}

/*
 [B@19e0bfd
C0FCC7FDBFB5
전혜영
 */