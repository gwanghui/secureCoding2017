package oopsw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getMethod()); //
		//1. request에서 전달받은 데이터가 유효한지 체크
		//2. DBMS 직접 or 관련 객체를 호출
		//3. 서버내에서 View 페이지찾아서 전달(response)
		//3.1 브라우저의 주소창을 활용
		//response.sendRedirect("01_parameter/view.jsp");
		//3.2 서버내에서 View찾아서 전달(임시 메모리공유)
		request.getRequestDispatcher("/01_parameter/view.jsp")
		.forward(request, response);
	}

}
