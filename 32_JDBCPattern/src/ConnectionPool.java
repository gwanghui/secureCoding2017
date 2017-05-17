import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** DBMS - DAO 소스가 여러개라도 Driver 및 Connection 공유*/
public class ConnectionPool {
	private static ConnectionPool pool;
	private static Connection conn;  //서버 : N개 connection 관리
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(pool== null)
			pool =new ConnectionPool();
		return conn;
	}
	private ConnectionPool() throws ClassNotFoundException, SQLException{
		//프레임워크 설정, 서버 설정 --> 유일하게 DBMS에따라 다른 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password="hr";
		//1. 드라이버 로딩 --> 프레임워크 설정, 서버 설정
		Class.forName(driver);
		System.out.println("1 드라이버가 로딩");
		//2. DBMS 연결
		conn=DriverManager.getConnection(url, user, password);
		System.out.println("2 DBMS 연결 OK");
	}
	
}
