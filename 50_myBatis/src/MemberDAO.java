
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MemberDAO 
{
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDAO(){
		InputStream inputStream = null;

		try {
			String resource = "mybatis-Config.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	}

	public MemberVO selectId(String id){
		//connection
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo = null;
		try {
			vo = (MemberVO)session.selectOne("memberMapper.selectMember", id);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//connection ¹ÝÈ¯
			session.close();
		}
		return vo;
	}
	
	public Collection<MemberVO> selectList(){
		SqlSession session = sqlSessionFactory.openSession();
		Collection<MemberVO> list=null;
		
		try {
			list = session.selectList("memberMapper.selectMemberList");
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
		
	public void addMember(MemberVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("memberMapper.addMember", vo);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void updateMember(MemberVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("memberMapper.updateMember", vo);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void removeMember(String memberId){
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("memberMapper.removeMember", memberId);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}

