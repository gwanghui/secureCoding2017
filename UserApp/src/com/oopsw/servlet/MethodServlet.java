package com.oopsw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/methodServlet")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printMessage("doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userId");
		printMessage(name + "doPost()");
	}
/*
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printMessage("doPut()");
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printMessage("doDelete()");
	}

	
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printMessage("doHead()");
	}

	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printMessage("doHead()");
	}

	
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		printMessage("doHead()");
	}
*/
	public void printMessage(String message){
		System.out.println(message);
	}
}
