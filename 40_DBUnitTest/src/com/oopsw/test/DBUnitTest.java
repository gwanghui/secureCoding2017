package com.oopsw.test;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.oracle.OracleConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

public class DBUnitTest {
	private final String driver = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String username = "hr";
	private final String userpass = "hr";
	private Connection conn;
	private IDatabaseConnection connection;

	
	@Test
	public void test_데이터를_잘가지고_오는지_테스트한다() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, userpass);
		connection = new OracleConnection(conn, "hr");
		try {
			IDataSet dataset = new FlatXmlDataSetBuilder().build(new File("customer.xml"));
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);			
		} finally {
			connection.close();
			conn.close();
		}
	}
}
