package oopsw.visitor.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {
		HttpSession session=request.getSession() ;
		if(session !=null) session.invalidate(); //��ü �Ǵ� �κ����� ��� ����
			
		return "controller?cmd=loginUI";
	}

}