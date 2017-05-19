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
		//1. request���� ���޹��� �����Ͱ� ��ȿ���� üũ
		//2. DBMS ���� or ���� ��ü�� ȣ��
		//3. ���������� View ������ã�Ƽ� ����(response)
		//3.1 �������� �ּ�â�� Ȱ��
		//response.sendRedirect("01_parameter/view.jsp");
		//3.2 ���������� Viewã�Ƽ� ����(�ӽ� �޸𸮰���)
		request.getRequestDispatcher("/01_parameter/view.jsp")
		.forward(request, response);
	}

}
