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
		//Action에서 DAO의 메서드를 호출하고 처리 결과를
		//JSP에서 화면 출력하기 위해서 임시 메모리에 값을 추가한다.
		request.setAttribute("visitorAllList", dao.getVisitorListAll());  
		return "visitorAllList.jsp";
	}

}
