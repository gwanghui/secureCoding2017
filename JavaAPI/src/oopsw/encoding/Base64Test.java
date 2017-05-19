package oopsw.encoding;
/*
 byte 배열을 알파벳 대소문자와 숫자 그리고 +, / 기호로 부호화하는 코드와 방법
 6bit만 사용하기 때문에 byte를 2 bit 만큼 쉬프트 시킨후 남는 bit 는 0으로 채워넣는 기법
 주로 text 기반 프로토콜을 통해 byte 정보를 전달하거나 보전할 때 사용
예) 인증서 저장 및 유통, email 전송, 이미지 등 이진 데이터의 문서 포함
//jdk 1.8
 */
import java.util.Base64;
public class Base64Test {
	public static void main(String[] args) {
		byte [] name =new String("전혜영").getBytes();		
		System.out.println(name);		
		
		String encoderData = Base64.getEncoder().encodeToString(name);		
		byte [] decoderData =Base64.getDecoder().decode(encoderData);
		
		System.out.println(encoderData);             //wPzH/b+1
		System.out.println(new String(decoderData)); //전혜영

	}
}
/*
[B@19e0bfd
wPzH/b+1
전혜영
*/
