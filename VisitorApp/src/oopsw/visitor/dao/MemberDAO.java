package oopsw.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oopsw.visitor.vo.MemberVO;

public class MemberDAO {
	/**ȸ������
	 * ���� �߻��� SQLException �߻�*/
	public void insertMember(MemberVO vo) throws SQLException {
		//String query=Query.MEMBER_INSERT;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DataSourceManager.getConnection();
			pstmt=conn.prepareStatement(Query.MEMBER_INSERT);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("ȸ�� �����ϴٰ� ���� �߻�");
		}finally{
			if(pstmt!=null) pstmt.close();
			if(conn!=null ) conn.close();
		}
	}
	/**�α���
	public String login(String id, String pw) throws SQLException{
		//String query=Query.LOGIN;
		Connection conn=null;
		Statement pstmt=null;
		String result=null;
		try{
			conn=DataSourceManager.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery("select mem_id from member where mem_id='"+id+"' and member_pw='"+pw+"'");
			if(!rs.next()) throw new SQLException("�α��� ���� �߻�");
			else
				result= rs.getString(1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//throw new SQLException("�α��� ���� �߻�");
		}finally{
			if(pstmt!=null) pstmt.close();
			if(conn!=null ) conn.close();
		}		
		return result;
	}
	*/
	/**/
	public String login(String id, String pw) throws SQLException{
		//String query=Query.LOGIN;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String result=null;
		try{
			conn=DataSourceManager.getConnection();
			pstmt=conn.prepareStatement(Query.LOGIN);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs=pstmt.executeQuery();
			if(!rs.next()) throw new SQLException("�α��� ���� �߻�");
			else
				result= rs.getString(1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//throw new SQLException("�α��� ���� �߻�");
		}finally{
			if(pstmt!=null) pstmt.close();
			if(conn!=null ) conn.close();
		}		
		return result;
	}
}
