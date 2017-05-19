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
			//���ǿ� �α��� ���θ� üũ�� �׸��� �߰�
			HttpSession session=request.getSession(true);
			session.setAttribute("loginOK", request.getParameter("id"));
			
			result="controller?cmd=visitorAllList";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result);
		//�̵��� ������ ����
		return result;
	}

}
