import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** DBMS - DAO �ҽ��� �������� Driver �� Connection ����*/
public class ConnectionPool {
	private static ConnectionPool pool;
	private static Connection conn;  //���� : N�� connection ����
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(pool== null)
			pool =new ConnectionPool();
		return conn;
	}
	private ConnectionPool() throws ClassNotFoundException, SQLException{
		//�����ӿ�ũ ����, ���� ���� --> �����ϰ� DBMS������ �ٸ� ����
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password="hr";
		//1. ����̹� �ε� --> �����ӿ�ũ ����, ���� ����
		Class.forName(driver);
		System.out.println("1 ����̹��� �ε�");
		//2. DBMS ����
		conn=DriverManager.getConnection(url, user, password);
		System.out.println("2 DBMS ���� OK");
	}
	
}
