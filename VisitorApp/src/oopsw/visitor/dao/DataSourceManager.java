package oopsw.visitor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**1, 2번 동작
 * connection 리턴*/
public class DataSourceManager {
	private static DataSourceManager manager;
	private DataSourceManager() 
			throws ClassNotFoundException{
		String driverClass="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverClass);
		System.out.println("1. driver loading ok..");
	}
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException{
		if(manager==null) new DataSourceManager();
		
		String uri="jdbc:oracle:thin:@70.12.50.139:1521:XE";
		String id="system";
		String pw="sys";
		return  DriverManager.getConnection(uri, id, pw);		
	}
}
