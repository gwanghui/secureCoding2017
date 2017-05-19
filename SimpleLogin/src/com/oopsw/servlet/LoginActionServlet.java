package com.oopsw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oopsw.model.MemberDAO;

/**
 * Servlet implementation class LoginActionServlet
 */
@WebServlet("/loginAction")
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod());
		//jdk 1.7
		switch(request.getMethod()){
		case "POST" :
			doPost(request, response);
			break;
		default:
			doGet(request, response);
		
		}//switch
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. �Է°��� ����
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		//������ �ܼ��� ó��, ���߿��� ���ܷ� ���� - NO
		if(id==null || id.length()<3 || pw==null){
			response.sendRedirect("login.html");return;
		}
		//2. DAO�� �α��� ���¸� Ȯ�� �޴´�.
		String name=new MemberDAO().login(id, pw);
		if(name==null){
			response.sendRedirect("login.html");return;
		}
		//3. �α��� ���¸� ������ �� �ִ� ������ ���α׷�
		HttpSession session = request.getSession(true);
		session.setAttribute("loginOK", id);
		request.setAttribute("loginName", name);
		//4. ��������͸� ó���� �������� �̵�
		request.getRequestDispatcher("/loginOK.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�α��� ���¸� üũ�Ŀ�
		//�α��� ������ ���� ���
		request.getRequestDispatcher("/loginAction.jsp").forward(request, response);
		//response.sendRedirect("loginAction.jsp");
	}

}
