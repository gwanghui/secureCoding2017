package oopsw.encoding;

/* http://docs.oracle.com/javase/7/docs/technotes/guides/security/overview/jsoverview.html
 * 
 Java�� ������ ��ȣȭ�� JCA�� ���� �����ϰ� �̰��� Ȯ���� �� �ִ� JCE�� ����
 - JCA(Java Cryptography Architecture)
             �� ���� ����Ʈ���� ������Ʈ�� ����
       : �����ӿ�ũ - �˰��� �����ڰ� ��ȣȭ �˰����� ���� 
                -�����ӿ�ũ�� java.security, javax.crypto, javax.crypto.spec, javax.crypto.interfaces�� ����
                    �⺻ �˰��� ������
                - Sun, SubRsaSign, SubJCE
 - JCE(Java Cryptography Extention)
      Java �÷��� ������ ǥ���� Ȯ���� �� �ִ� ��Ŀ���� ����
              ��ȣȭ, Ű ����, Ű ��ġ, MAC(Message Authentication Code) �˰������ �����Ҽ� �ִ� �����ӿ�ũ ����
      Java �÷����� ������ �� �ְ� MessageDigest�� DisitalSignature�� �������̽��� ����ü�� ����
 
 * Provider  �� ���� �˰��� ��ȸ... */
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

/*���
 SUN :: SHA1PRNG :: SUN: SecureRandom.SHA1PRNG -> sun.security.provider.SecureRandom
  attributes: {ImplementedIn=Software}

SUN :: SHA1withDSA :: SUN: Signature.SHA1withDSA -> sun.security.provider.DSA$SHA1withDSA
  aliases: [DSA, DSS, SHA/DSA, SHA-1/DSA, SHA1/DSA, SHAwithDSA, DSAWithSHA1, OID.1.2.840.10040.4.3, 1.2.840.10040.4.3, 1.3.14.3.2.13, 1.3.14.3.2.27]
  attributes: {ImplementedIn=Software, KeySize=1024, SupportedKeyClasses=java.security.interfaces.DSAPublicKey|java.security.interfaces.DSAPrivateKey}
...
 */