package oopsw.visitor.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	//request 전달 받고 , 처리해서 메모리 활용 여부, 결과 페이지 이동
	public String execute(HttpServletRequest request)
			throws ServletException, IOException ;
}
