
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;


public class CustomerTest {
	private Connection conn;
	public CustomerTest() throws ClassNotFoundException, SQLException{
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
	/**���� ��� ������ ���(����) 
	 * @throws SQLException */
	public void printCustomer() throws SQLException{
		String query="select * from customer_data";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+ 
		                            rs.getString("name"));
		}
	}
	/** ���� ���̵�, �̸��� ��� ���
	 * @throws SQLException */
	public Collection<CustomerVO> getCustomerAll() throws SQLException{
		Collection<CustomerVO> list=new ArrayList<CustomerVO>();
		String query="select cust_id, name from customer_data";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
			list.add(new CustomerVO(rs.getInt(1), rs.getString(2)));
		
		return list;		
	}
	/**���� ���̵� �˻��ؼ� ���� ���̵�, ��й�ȣ, �̸�, ������ ���
	 * @throws SQLException */
	public CustomerVO getCustomerVO(int customerId) throws SQLException{
		String query="select pw, name, gender "
				+ "from customer_data where cust_id="+customerId;
		CustomerVO vo=null;
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
			vo=new CustomerVO(
					customerId, rs.getString(1), 
					rs.getString(2), rs.getString(3).charAt(0));
		return vo;
	}
	/**���� �̸��� ���� ���� ������ ��� ��� ? 
	 * @throws SQLException */
	public Collection<CustomerVO> getCustomerVO(String name) throws SQLException{
		Collection<CustomerVO> list=new ArrayList<CustomerVO>();
		String query="select cust_id, gender, pw "
				+ "from customer_data where name=?";
		
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1, name);  //'name'   
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
			list.add(new CustomerVO(rs.getInt(1), 
					rs.getString("pw"), name, rs.getString(2).charAt(0)));
		
		return list;
	}
	/**ȸ���� �߰�
	 * @throws SQLException */
	public void addCustomer(String name, String pw, char gender) throws SQLException{
		addCustomer(new CustomerVO(name, pw, gender));
	}
	public void addCustomer(CustomerVO vo) throws SQLException{
		String query="insert into "
				+ "customer_data(cust_id, pw, name, gender) "
				+ "values (cust_seq.nextval, ?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1, vo.getPw());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getGender()+"");
		pstmt.executeUpdate();
	}	
	/** Ư�� �� ���̵��� ��й�ȣ�� ����
	 * @throws SQLException */
	public void updateCustomerPw(int customerId, String pw) throws SQLException{
		String query="update customer_data "
				+ "set pw=? where cust_id=?";
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1, pw);
		pstmt.setInt(2, customerId);
		if(pstmt.executeUpdate()==0)
			throw new SQLException(customerId+"�� �������� �ʽ��ϴ�.");
	}
	/** �� ID ����
	 * @throws CustomerIdException */
	public void removeCustomer(int customerId) throws CustomerIdException{
		if(!customerIdCheck(customerId))
			throw new CustomerIdException(customerId+"�� ����");
		String query="delete from customer_data where cust_id=?";
		
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, customerId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e) {	}
		}		
		
	}
	/** �� ID ���θ� Ȯ�� ����*/
	public boolean customerIdCheck(int customerId){
		boolean result=false;
		String query="select count(cust_id) from customer_data where cust_id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, customerId);
			rs=pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1) == 1) result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//�ڿ� ��ȯ
			try{if(rs!=null) rs.close();}catch(SQLException e){}			
			try{if(pstmt!=null) pstmt.close();}catch(SQLException e){}			
		}		
		return result;		
	}
	public static void main(String[] args) {
		try {
			CustomerTest t=new CustomerTest();
			//t.removeCustomer(125);
			t.removeCustomer(1);
			//t.updateCustomerPw(10, "9874");
			//t.addCustomer("��μ�", "12345", 'M');
			//System.out.println(t.getCustomerVO("������"));
			//System.out.println(t.getCustomerVO(1));
			//System.out.println(t.getCustomerVO(3));
			//t.printCustomer();
			//System.out.println(t.getCustomerAll());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		System.out.println("end");
	}





}
