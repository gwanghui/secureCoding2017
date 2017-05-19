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
	//private String localName="개인정보를 임시로 저장";
	/**요청 정보중에서 cmd 값을 체크
	 * cmd에 따라 Action을 생성한다. : Action은 Request를 담당
	 * 페이지 이동 : html, jsp는 Response */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action=null;		
		String resultURL="error.html";		
		//패턴 적용
		action=ActionFactory.getInstance(request.getParameter("cmd"));  //조건문
		resultURL=action.execute(request);		
		
		//입력값을 특정 문자에만 적용
		/*XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		Enumeration<String> pramName= request.getParameterNames();
		while(pramName.hasMoreElements()){
			String pName=pramName.nextElement();
			request.setAttribute(pName, filter.doFilter(pName));
		}//
		*/
		//원래는 페이지 이동 2가지
		if(resultURL.length()>10 
				&& resultURL.substring(0, 10).equals("controller")){
		//?cmd=visitorAllList 
		response.sendRedirect(resultURL);  // 브라우저에 페이지 재전송
		}else{
			//html, jsp
		request.getRequestDispatcher(resultURL).forward(request, response);
		}
	}//service

}
