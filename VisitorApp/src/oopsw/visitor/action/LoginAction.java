package oopsw.visitor.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oopsw.visitor.dao.MemberDAO;



public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {
		MemberDAO dao=new MemberDAO();
		String result="loginError.html";
		try {
			dao.login(request.getParameter("id"), request.getParameter("pw"));
			//세션에 로그인 여부를 체크할 항목을 추가
			HttpSession session=request.getSession(true);
			session.setAttribute("loginOK", request.getParameter("id"));
			
			result="controller?cmd=visitorAllList";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result);
		//이동할 페이지 리턴
		return result;
	}

}
