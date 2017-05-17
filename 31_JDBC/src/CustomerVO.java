
public class CustomerVO {
	private int customerId;
	private String name;
	private String pw;
	private char gender;
	
	public CustomerVO(){}
	public CustomerVO(int customerId, String name) {
		this.customerId = customerId;
		this.name = name;
		//this(customerId, null, name, (char)0);
	}
	
	public CustomerVO(int customerId, String pw, String name, char gender) {		
		this.customerId = customerId;
		this.name = name;
		this.pw = pw;
		this.gender = gender;
	}
	public CustomerVO(String name, String pw, char gender) {
		this(0, pw, name, gender);
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "회원아이디 : "+ customerId+", name:"+ name+" 성별: "+gender;
	}
	
}
