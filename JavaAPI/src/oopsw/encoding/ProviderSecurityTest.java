package oopsw.encoding;

/* http://docs.oracle.com/javase/7/docs/technotes/guides/security/overview/jsoverview.html
 * 
 Java는 데이터 암호화를 JCA를 통해 지원하고 이것을 확장할 수 있는 JCE를 제공
 - JCA(Java Cryptography Architecture)
             두 가지 소프트웨어 컴포넌트로 구성
       : 프레임워크 - 알고리즘 제공자가 암호화 알고리즘을 제공 
                -프레임워크는 java.security, javax.crypto, javax.crypto.spec, javax.crypto.interfaces를 포함
                    기본 알고리즘 제공자
                - Sun, SubRsaSign, SubJCE
 - JCE(Java Cryptography Extention)
      Java 플랫폼 내부의 표준을 확장할 수 있는 메커니즘 제공
              암호화, 키 생성, 키 일치, MAC(Message Authentication Code) 알고리즘들을 구현할수 있는 프레임워크 제공
      Java 플랫폼을 보완할 수 있고 MessageDigest와 DisitalSignature의 인터페이스와 구현체를 포함
 
 * Provider  및 지원 알고리즘 조회... */
import java.security.Provider;
import java.util.Set;

public class ProviderSecurityTest {
	public static void main(String[] args) {
		Provider[] providers = java.security.Security.getProviders();
		for(Provider prov : providers) { 
		    Set<Provider.Service> svcs = prov.getServices();
		    for(Provider.Service svc : svcs) {
		        System.out.println(prov.getName() + " :: " + svc.getAlgorithm() + " :: " + svc);
		    }
		}

	}//main
}

/*결과
 SUN :: SHA1PRNG :: SUN: SecureRandom.SHA1PRNG -> sun.security.provider.SecureRandom
  attributes: {ImplementedIn=Software}

SUN :: SHA1withDSA :: SUN: Signature.SHA1withDSA -> sun.security.provider.DSA$SHA1withDSA
  aliases: [DSA, DSS, SHA/DSA, SHA-1/DSA, SHA1/DSA, SHAwithDSA, DSAWithSHA1, OID.1.2.840.10040.4.3, 1.2.840.10040.4.3, 1.3.14.3.2.13, 1.3.14.3.2.27]
  attributes: {ImplementedIn=Software, KeySize=1024, SupportedKeyClasses=java.security.interfaces.DSAPublicKey|java.security.interfaces.DSAPrivateKey}
...
 */