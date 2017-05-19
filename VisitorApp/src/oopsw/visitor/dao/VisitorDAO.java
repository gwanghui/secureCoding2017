package oopsw.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import oopsw.visitor.vo.VisitorVO;

public class VisitorDAO {
	
	/**���� ��ü ����Ʈ : Collection
	 * �۹�ȣ, �ۼ���, ����, �ۼ��� : VisitorVO
	 * Ȥ�� ����(������) :�Ű�����
	 * ���ܴ� �߻��� �ʿ� ����.(����Ÿ�԰� ������ ����)*/
	public Collection<VisitorVO> getVisitorListAll(){
		Collection<VisitorVO> list=new ArrayList<VisitorVO>();
		//String query=Query.VISITOR_LIST;
		Connection conn=null;
		Statement stmt=null;
		try{
			conn=DataSourceManager.getConnection();
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(Query.VISITOR_LIST);
			while(rs.next())
				list.add(new VisitorVO(
					rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}catch(Exception e){
			e.printStackTrace();		
		}finally{
			if(stmt!=null){
				try {			stmt.close();	} catch (SQLException e) {	}
			}//if
			if(conn!=null ){
				try {	conn.close();	} catch (SQLException e) {	}
			}//if
		}		
		return list;				
	}

	public void addVisitor(VisitorVO vo) throws SQLException {
		//String query="insert into visitor (visi_no, mem_id, visi_pw, contents, indate) " +
		//		"values (visi_seq.nextval, ? , ?, ? ,sysdate)";
		Connection conn=null;
		PreparedStatement pstmt=null;		
		try{
			conn=DataSourceManager.getConnection();
			pstmt=conn.prepareStatement(Query.VISITOR_INSERT);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getVisitorPw());
			pstmt.setString(3, vo.getContents());			
			int num=pstmt.executeUpdate();
			if(num<=0) throw new SQLException("���� �ۼ� ����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();		
		}finally{
			if(pstmt!=null) pstmt.close();
			if(conn!=null ) conn.close();
		}
		
	}
}
