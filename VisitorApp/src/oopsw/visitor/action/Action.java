package oopsw.visitor.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	//request ���� �ް� , ó���ؼ� �޸� Ȱ�� ����, ��� ������ �̵�
	public String execute(HttpServletRequest request)
			throws ServletException, IOException ;
}
