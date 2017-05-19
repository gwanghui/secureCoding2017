package oopsw.visitor.vo;

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	private String blood;
	private String other;
	private String inDate;  //Date inDate
	public MemberVO() {
		super();
	}
	public MemberVO(String memberId, String memberPw, String name, String tel,
			String gender, String hobby, String blood, String other) {
		this(memberId, memberPw, name, tel, gender, hobby, blood, other, "");
	}
	public MemberVO(String memberId, String memberPw, String name, String tel,
			String gender, String hobby, String blood, String other, String inDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
		this.blood = blood;
		this.other = other;
		this.inDate = inDate;
		this.hobby=hobby;
	}
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	@Override
	public String toString() {
		return "[memberId=" + memberId + ", name=" + name + ", tel="
				+ tel + ", gender=" + gender + ", blood=" + blood + ", other="
				+ other + ", inDate=" + inDate + "]";
	}
	
	
}
