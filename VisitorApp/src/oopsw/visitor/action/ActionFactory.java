package oopsw.visitor.action;

public class ActionFactory {

	public static Action getInstance(String cmd) {
		Action action = null;
		//jdk 7 switch문에서 문자열을 체크
		//switch(cmd){
		//	case "loginUI": action=new LoginUIAction();
		//	break;
		//}
		if(cmd.equals("loginUI")){
			action=new LoginUIAction();		
		}else if(cmd.equals("loginAction")){
			action=new LoginAction();
		}else if(cmd.equals("visitorAllList")){
			action=new VisitorAllListAction();
		}else if(cmd.equals("visitorInsertUI")){
			action=new VisitorInsertUIAction();
		}else if(cmd.equals("visitorInsertAction")){
			action=new VisitorInsertAction();
		}else if(cmd.equals("logoutAction")){
			action=new LogoutAction();
		}else {	
			action=new LoginUIAction();		//기본 페이지
		}
		return action;
	}

}
