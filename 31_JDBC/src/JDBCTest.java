
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//�����ӿ�ũ ����, ���� ���� --> �����ϰ� DBMS������ �ٸ� ����
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "system";
		String password="sys";
		
		//1. ����̹� �ε� --> �����ӿ�ũ ����, ���� ����
		Class.forName(driver);
		System.out.println("1 ����̹��� �ε�");
		//2. DBMS ����
		Connection conn
		  =DriverManager.getConnection(url, user, password);
		System.out.println("2 DBMS ���� OK");
		
		//3.4 SQL���� ����
		String query="select DEPARTMENT_ID, DEPARTMENT_NAME "
				+ "from HR.DEPARTMENTS";
		Statement stmt=conn.createStatement();
		//Select�� 
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
