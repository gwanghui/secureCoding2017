import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

 
public class CustomerJUnitTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void  ��_�̸�_�ʼ�() {
		CustomerVO vo=new CustomerVO();
		//System.out.println(vo.getName());
		assertNull(vo.getName());
		assertNotNull(
				new CustomerVO(1234, "������").getName());
	}
	//@Test
	public void ��_�̸�_�ʼ�2(){
		assertNotNull(
			new CustomerVO(1234, "������").getName());
		
	}
	@Test
	public void �α���() {
		//fail("Not yet implemented");
	}
	@Test
	public void �ŷ�����Ȯ��() {
		//fail("Not yet implemented");
	}

}
