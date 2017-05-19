package oopsw.visitor.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.nhncorp.lucy.security.xss.XssFilter;

import oopsw.visitor.dao.VisitorDAO;
import oopsw.visitor.vo.VisitorVO;

public class VisitorInsertAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {
		VisitorDAO dao=new VisitorDAO();
		String memberId = request.getParameter("id");
		String visitorPw = request.getParameter("visitor_pw");
		String contents =  request.getParameter("contents");
		//재인증 하는 과정
		
		//2. luycy-xss - 엘리먼트 중심 공격
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		contents = filter.doFilter(contents);
		//1. 그외 태그 
		//contents = contents.replaceAll("<", "");
		
		VisitorVO vo=new VisitorVO(memberId, visitorPw, contents);
		System.out.println(vo);
		String resultPage="loginError.html";
		try {
			dao.addVisitor(vo);
			resultPage="controller?cmd=visitorAllList";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //아직 없다.
		return resultPage;
	}

}
