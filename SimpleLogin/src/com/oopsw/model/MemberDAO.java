package com.oopsw.model;

public class MemberDAO {
	//DBMS 연결 코드
	public MemberDAO(){
		
	}
	//SQL 문을 전달하는 코드 
	public String login(String id, String pw) {
		if(id.equals("jeon") && pw.equals("1234"))
			return "jeonhye0";
		
		return null;
	}

}
