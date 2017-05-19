package oopsw.visitor.vo;

public class TestVO {
	private String name;
	private int ko;
	public TestVO(String name, int ko) {
		super();
		this.name = name;
		this.ko = ko;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKo() {
		return ko;
	}
	public void setKo(int ko) {
		this.ko = ko;
	}
	
	
}
