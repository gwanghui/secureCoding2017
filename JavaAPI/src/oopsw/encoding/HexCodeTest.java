package oopsw.encoding;
/*
 byte �迭�� 16���� ���ڿ��� ��ȣȭ�ϴ� ���
 URLEncoding���� "%" ���� ǥ���� XML, XHTML ��� ǥ���� �� �ִ� ���� �ڵ� ������ ��� ������ ��� &#xcode; ���� xcode �κ�
 Unicode ������ ǥ�� �� �پ��� ������ ���ǰ� �ִ� ��ȣȭ ���
 //javaee / JAXB 2.0  jdk 1.6 Ȯ�� ����
 */
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
public class HexCodeTest {
	public static void main(String[] args) {
		byte [] name =new String("������").getBytes();		
		System.out.println(name);
				
		HexBinaryAdapter hba=new HexBinaryAdapter();
		String encoderData = hba.marshal(name);
		byte [] decoderData = hba.unmarshal(encoderData);
		
		System.out.println(encoderData);           //C0FCC7FDBFB5
		System.out.println(new String(decoderData)); //������
	}
}

/*
 [B@19e0bfd
C0FCC7FDBFB5
������
 */