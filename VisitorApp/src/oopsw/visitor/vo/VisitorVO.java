package oopsw.visitor.vo;

public class VisitorVO {
	//5��
	private int visitorNumber;
	private String memberId;
	private String visitorPw;
	private String contents;
	private String inDate;
	public VisitorVO() {
		super();
	}
	//���� ����Ҷ�
	public VisitorVO(String memberId, String visitorPw,String contents){
		this(0, memberId, visitorPw, contents, null);
	}
	//����Ʈ �Ѹ���
	public VisitorVO(int visitorNumber, String memberId,
			String contents, String inDate) {
		this(visitorNumber, memberId, "", contents, inDate);
	}
	public VisitorVO(int visitorNumber, String memberId, String visitorPw,
			String contents, String inDate) {
		super();
		this.visitorNumber = visitorNumber;
		this.memberId = memberId;
		this.visitorPw = visitorPw;
		this.contents = contents;
		this.inDate = inDate;
	}
	public int getVisitorNumber() {
		return visitorNumber;
	}
	public void setVisitorNumber(int visitorNumber) {
		this.visitorNumber = visitorNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getVisitorPw() {
		return visitorPw;
	}
	public void setVisitorPw(String visitorPw) {
		this.visitorPw = visitorPw;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	@Override
	public String toString() {
		return " [visitorNumber=" + visitorNumber + ", memberId="
				+ memberId + ", contents=" + contents + ", inDate=" + inDate
				+ "]";
	}
	
	
}
