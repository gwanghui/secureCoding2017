package com.oopsw.model;

public class MemberDAO {
	//DBMS ���� �ڵ�
	public MemberDAO(){
		
	}
	//SQL ���� �����ϴ� �ڵ� 
	public String login(String id, String pw) {
		if(id.equals("jeon") && pw.equals("1234"))
			return "jeonhye0";
		
		return null;
	}

}
