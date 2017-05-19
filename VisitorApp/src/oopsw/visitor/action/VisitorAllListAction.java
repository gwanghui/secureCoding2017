package oopsw.visitor.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import oopsw.visitor.dao.VisitorDAO;

public class VisitorAllListAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {
		VisitorDAO dao=new VisitorDAO();
		//Action���� DAO�� �޼��带 ȣ���ϰ� ó�� �����
		//JSP���� ȭ�� ����ϱ� ���ؼ� �ӽ� �޸𸮿� ���� �߰��Ѵ�.
		request.setAttribute("visitorAllList", dao.getVisitorListAll());  
		return "visitorAllList.jsp";
	}

}
