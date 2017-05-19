package oopsw.visitor.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhncorp.lucy.security.xss.XssFilter;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private String localName="���������� �ӽ÷� ����";
	/**��û �����߿��� cmd ���� üũ
	 * cmd�� ���� Action�� �����Ѵ�. : Action�� Request�� ���
	 * ������ �̵� : html, jsp�� Response */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action=null;		
		String resultURL="error.html";		
		//���� ����
		action=ActionFactory.getInstance(request.getParameter("cmd"));  //���ǹ�
		resultURL=action.execute(request);		
		
		//�Է°��� Ư�� ���ڿ��� ����
		/*XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		Enumeration<String> pramName= request.getParameterNames();
		while(pramName.hasMoreElements()){
			String pName=pramName.nextElement();
			request.setAttribute(pName, filter.doFilter(pName));
		}//
		*/
		//������ ������ �̵� 2����
		if(resultURL.length()>10 
				&& resultURL.substring(0, 10).equals("controller")){
		//?cmd=visitorAllList 
		response.sendRedirect(resultURL);  // �������� ������ ������
		}else{
			//html, jsp
		request.getRequestDispatcher(resultURL).forward(request, response);
		}
	}//service

}
