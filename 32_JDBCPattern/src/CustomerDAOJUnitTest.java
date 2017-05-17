import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class CustomerDAOJUnitTest {
	static CustomerDAO dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao=new CustomerDAO();
	}
	@Test
	public void ���˻�() throws SQLException{
		CustomerVO vo=dao.getCustomerVO(3);
		assertNotNull(vo);
	}
	@Test
	public void ���߰�1() throws SQLException{
		dao.addCustomer("��μ�", "1234", 'M');
	}
	@Test
	public void ���߰�2() {
		try {
			dao.addCustomer("��μ�", "1234", 'M');
		} catch (SQLException e) {
			fail("���߰��� ����");
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao.close();
	}

	

}
