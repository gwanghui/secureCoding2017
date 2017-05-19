package oopsw.encoding;
/*
 byte �迭�� ���ĺ� ��ҹ��ڿ� ���� �׸��� +, / ��ȣ�� ��ȣȭ�ϴ� �ڵ�� ���
 6bit�� ����ϱ� ������ byte�� 2 bit ��ŭ ����Ʈ ��Ų�� ���� bit �� 0���� ä���ִ� ���
 �ַ� text ��� ���������� ���� byte ������ �����ϰų� ������ �� ���
��) ������ ���� �� ����, email ����, �̹��� �� ���� �������� ���� ����
//jdk 1.8
 */
import java.util.Base64;
public class Base64Test {
	public static void main(String[] args) {
		byte [] name =new String("������").getBytes();		
		System.out.println(name);		
		
		String encoderData = Base64.getEncoder().encodeToString(name);		
		byte [] decoderData =Base64.getDecoder().decode(encoderData);
		
		System.out.println(encoderData);             //wPzH/b+1
		System.out.println(new String(decoderData)); //������

	}
}
/*
[B@19e0bfd
wPzH/b+1
������
*/
