package oopsw.visitor.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class VisitorInsertUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		return "visitorInsert.jsp";
	}

}
