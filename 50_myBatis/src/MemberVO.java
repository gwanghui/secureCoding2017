public class MemberVO {
	private String memberId;
	private String pw;
	private String name;
	public MemberVO(){}
	public MemberVO(String memberId, String pw, String name) {
		this.memberId = memberId;
		this.pw = pw;
		this.name = name;
	}
	public MemberVO(String memberId, String pw) {
		this(memberId, pw, null);
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "memberId=" + memberId + ", pw=" + pw + ", name="	+ name ;
	}
}
