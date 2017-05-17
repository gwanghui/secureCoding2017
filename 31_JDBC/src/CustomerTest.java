
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
	/**고객의 모든 정보를 출력(리턴) 
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
	/** 고객의 아이디, 이름을 모두 출력
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
	/**고객의 아이디를 검색해서 고객의 아이디, 비밀번호, 이름, 성별을 출력
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
	/**같은 이름을 가진 고객의 정보를 모두 출력 ? 
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
	/**회원을 추가
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
	/** 특정 고객 아이디의 비밀번호를 수정
	 * @throws SQLException */
	public void updateCustomerPw(int customerId, String pw) throws SQLException{
		String query="update customer_data "
				+ "set pw=? where cust_id=?";
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1, pw);
		pstmt.setInt(2, customerId);
		if(pstmt.executeUpdate()==0)
			throw new SQLException(customerId+"는 존재하지 않습니다.");
	}
	/** 고객 ID 삭제
	 * @throws CustomerIdException */
	public void removeCustomer(int customerId) throws CustomerIdException{
		if(!customerIdCheck(customerId))
			throw new CustomerIdException(customerId+"가 없음");
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
	/** 고객 ID 여부를 확인 공통*/
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
			//자원 반환
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
			//t.addCustomer("김민성", "12345", 'M');
			//System.out.println(t.getCustomerVO("전혜영"));
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
