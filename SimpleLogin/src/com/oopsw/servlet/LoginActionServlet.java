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
		//1. 입력값을 구분
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		//지금은 단순히 처리, 나중에는 예외로 관리 - NO
		if(id==null || id.length()<3 || pw==null){
			response.sendRedirect("login.html");return;
		}
		//2. DAO에 로그인 상태를 확인 받는다.
		String name=new MemberDAO().login(id, pw);
		if(name==null){
			response.sendRedirect("login.html");return;
		}
		//3. 로그인 상태를 구분할 수 있는 서버의 프로그램
		HttpSession session = request.getSession(true);
		session.setAttribute("loginOK", id);
		request.setAttribute("loginName", name);
		//4. 결과데이터를 처리할 페이지로 이동
		request.getRequestDispatcher("/loginOK.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 상태를 체크후에
		//로그인 정보를 세션 등록
		request.getRequestDispatcher("/loginAction.jsp").forward(request, response);
		//response.sendRedirect("loginAction.jsp");
	}

}
