package oopsw.encoding;
/** ���޹��� ������ byte ��ȯ �� ��ȯ���� byte�� ��ȣȭ
 * application/x-www-form-urlencoded 
 * ǥ�� ����*/

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String userName ="�������";
		//��ȣȭ
		System.out.println( URLEncoder.encode(userName, "utf-8"));   //%EC%84%B8%EC%A2%85%EB%8C%80%EC%99%95
		System.out.println( URLEncoder.encode(userName, "euc-kr"));  //%BC%BC%C1%BE%B4%EB%BF%D5
		System.out.println( URLEncoder.encode(userName, "us-ascii"));//%3F%3F%3F%3F
		
		//�ص�
		System.out.println(URLDecoder.decode("%EC%84%B8%EC%A2%85%EB%8C%80%EC%99%95", "utf-8")); //�������
		System.out.println(URLDecoder.decode("%BC%BC%C1%BE%B4%EB%BF%D5", "euc-kr"));//�������
		System.out.println(URLDecoder.decode("%3F%3F%3F%3F", "us-ascii"));  //????
	}//
}
/*�������
%EC%84%B8%EC%A2%85%EB%8C%80%EC%99%95
%BC%BC%C1%BE%B4%EB%BF%D5
%3F%3F%3F%3F
 */

/* ABC123!@
ABC123%21%40
ABC123%21%40
ABC123%21%40*/
