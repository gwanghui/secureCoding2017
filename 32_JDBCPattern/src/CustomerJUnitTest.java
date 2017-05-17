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
	public void  고객_이름_필수() {
		CustomerVO vo=new CustomerVO();
		//System.out.println(vo.getName());
		assertNull(vo.getName());
		assertNotNull(
				new CustomerVO(1234, "전혜영").getName());
	}
	//@Test
	public void 고객_이름_필수2(){
		assertNotNull(
			new CustomerVO(1234, "전혜영").getName());
		
	}
	@Test
	public void 로그인() {
		//fail("Not yet implemented");
	}
	@Test
	public void 거래명세서확인() {
		//fail("Not yet implemented");
	}

}
