package oopsw.esapi;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encryptor;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.codecs.MySQLCodec.Mode;
import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;


public class ESAPI_UnitTest {
	@BeforeClass
	public static void 환경_설정() throws Exception{
		System.setProperty("user.home", System.getProperty("user.dir")+"\\src");
		System.setProperty("org.owasp.esapi.resources",System.getProperty("user.home")+"\\esapi");
	}
	@Test
	public void ESAPI_EMAIL() throws ValidationException, IntrusionException {
		String email="oopsw@tistory.com";
		String validEmail = ESAPI.validator().getValidInput("Email",  email,  "Email", 25, false);		

		String output = ESAPI.encoder().encodeForHTML(validEmail);
		System.out.println(output);
	}

	@Test
	public void ESAPI_Base64() throws IOException{
		String userId="jeon";

		String esEncodeData=ESAPI.encoder().encodeForBase64(userId.getBytes(), true);
		System.out.println(esEncodeData);
		System.out.println(new String(ESAPI.encoder().decodeFromBase64(esEncodeData)));	
	}
	@Test
	public void ESAPI_SQL(){
		Codec MYSQL_CODEC = new MySQLCodec(Mode.STANDARD);
		String query=
				"select name from member where mem_id='" +
						ESAPI.encoder().encodeForSQL(MYSQL_CODEC, "'userId' or 1=1 or '") +"'"+
						"and mem_pw='" + 
						ESAPI.encoder().encodeForSQL(MYSQL_CODEC, "userPw")+"'";

		System.out.println(query);
	}
	@Test
	public void XSS_DATA(){
		String input="<script>alert('hello')</script>";
		System.out.println(ESAPI.encoder().encodeForHTML(input));
		System.out.println(ESAPI.encoder().encodeForHTMLAttribute(input));
	}
	@Test
	public void 해쉬함수테스트() throws EncryptionException{
		Encryptor ec=ESAPI.encryptor();
		String hash1=ec.hash("user1", "salt");
		String hash2=ec.hash("user2", "salt");
		assertFalse(hash1.equals(hash2));
		
		String hash3=ec.hash("test", "salt1");
		String hash4=ec.hash("test", "salt2");
		assertFalse(hash3.equals(hash4));
	}

}
