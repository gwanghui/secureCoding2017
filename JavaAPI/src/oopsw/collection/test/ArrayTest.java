package oopsw.collection.test;
class UserData{
	private String[] userName;

	public String[] getUserName() {
		String [] u=new String[userName.length];
		System.arraycopy(userName, 0, u, 0, userName.length);
		//return userName;
		return u;
	}

	public void setUserName(String[] userName) {
		this.userName = new String[userName.length];
		for (int i = 0; i < userName.length; i++) {
			this.userName[i] = userName[i];
		}
		//this.userName= userName;  //문제코드
	}
	@Override
	public String toString() {
		String message="";
		for (String tmp : userName) {
			message +=tmp;
		}
		return message;
	}
}
public class ArrayTest {
	public static void main(String[] args) {
		UserData d=new UserData();
		String [] names={"jeon", "hye", "young"};
		d.setUserName(names);
		names[2]="NoN";
		System.out.println(d.toString());
		String [] names2=d.getUserName();
		names2[0]="lee";
		System.out.println(d.toString());
		for (int i = 0; i < names2.length; i++) {
			System.out.println(names[i]);
		}
	}
}
