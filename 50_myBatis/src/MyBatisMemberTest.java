public class MyBatisMemberTest {
	public static void main(String[] args) {
		MemberDAO dao=new MemberDAO();
		
		MemberVO vo=dao.selectId("jeon");
		System.out.println(vo);
		
		//System.out.println(dao.selectList());
		
		//dao.addMember(new MemberVO("kim", "0000", "��μ�"));
		
		//dao.updateMember(new MemberVO("kim", "8888"));
		
		//dao.removeMember("kim");
		
		//System.out.println(dao.selectList());
		
	}
}
