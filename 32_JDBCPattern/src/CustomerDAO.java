
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;


public class CustomerDAO {
	private Connection conn;
	public CustomerDAO() throws ClassNotFoundException, SQLException{
		//conn = new ConnectionPool().getConnection();
		conn = ConnectionPool.getConnection();
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
	public void close() {
		//ConectionPool.close();
		
	}

}
