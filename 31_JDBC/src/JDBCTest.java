
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//프레임워크 설정, 서버 설정 --> 유일하게 DBMS에따라 다른 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "system";
		String password="sys";
		
		//1. 드라이버 로딩 --> 프레임워크 설정, 서버 설정
		Class.forName(driver);
		System.out.println("1 드라이버가 로딩");
		//2. DBMS 연결
		Connection conn
		  =DriverManager.getConnection(url, user, password);
		System.out.println("2 DBMS 연결 OK");
		
		//3.4 SQL문을 전송
		String query="select DEPARTMENT_ID, DEPARTMENT_NAME "
				+ "from HR.DEPARTMENTS";
		Statement stmt=conn.createStatement();
		//Select만 
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			System.out.println(rs.getInt("DEPARTMENT_ID")+"-"
		               + rs.getString(2));
		}
		//5
		rs.close();
		stmt.close();
		conn.close();
		
		System.out.println("end");
	}
	
	
	
	

}
