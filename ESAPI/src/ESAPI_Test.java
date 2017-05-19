import java.io.IOException;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;

public class ESAPI_Test {
	public static void main(String[] args) throws ValidationException, IntrusionException, IOException {
		System.setProperty("user.home", 
				System.getProperty("user.dir")+"\\src");
		System.setProperty("org.owasp.esapi.resources",
				System.getProperty("user.home")+"\\esapi");
	
		String email="oopsw@tistory.com";
		String validEmail = ESAPI.validator().getValidInput("Email",  email,  "Email", 25, false);		
		System.out.println(validEmail);
		String output = ESAPI.encoder().encodeForHTML(validEmail);
		System.out.println(output);
		
		
		String name=ESAPI.encoder().encodeForBase64("ÀüÇý¿µ".getBytes(), true);
		System.out.println(name);
		System.out.println(new String(ESAPI.encoder().decodeFromBase64(name)));
	}
}