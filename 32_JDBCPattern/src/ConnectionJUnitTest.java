import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ConnectionJUnitTest {
	static Connection conn;
	int dml=0;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn=ConnectionPool.getConnection();
	}	
	@Before
	public void Ʈ�����_����() throws SQLException{
		System.out.println("Ʈ�����_����");
		conn.setAutoCommit(false);
	}
	@After
	public void Ʈ�����_����() throws SQLException{
		if(dml>1) conn.rollback();
		else conn.commit();		
		dml=0;
		System.out.println("Ʈ�����_����");
	}	
	@Test
	public void ��_���ڵ�_����() throws SQLException{
		String sql="update customer_data set pw='12345' "
				+ "where cust_id=2";
		dml = conn.createStatement().executeUpdate(sql);
	}
	//@Test
	public void �����ͺ��̽�_����Ȯ��1() throws SQLException{
		conn.setAutoCommit(false);
		assertFalse(conn.getAutoCommit());
		conn.setAutoCommit(true);
	}
	
	
}
