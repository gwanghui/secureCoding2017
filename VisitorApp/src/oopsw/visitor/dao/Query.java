package oopsw.visitor.dao;
//SQL巩父 包府 按眉--> xml, text 包府
public interface Query {
	String LOGIN="select mem_id from hr.member where mem_id=? and member_pw=?";
	String MEMBER_INSERT="insert into hr.member (mem_id, member_pw, name) values (?,?,?)";
	String VISITOR_INSERT="insert into hr.visitor (visi_no, mem_id, visi_pw, contents, indate) values (visi_seq.nextval, ? , ?, ? ,sysdate)";
	String VISITOR_LIST="select visi_no, mem_id, contents, indate from hr.visitor";
				
}
