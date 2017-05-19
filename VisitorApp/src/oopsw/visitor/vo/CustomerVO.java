package oopsw.visitor.vo;

import java.util.Arrays;

/**사용자는 이름, 전화번호 등의 정보가 있다.
 * 전화번호는 2개를 입력해야 한다.
 * 이름의 조건은 2자 이상이어야 한다.*/
public class CustomerVO {
	//1.
	private String name;
	private String[] phoneNumbers;
	//3. 생성자 - 필수 초기화
	public CustomerVO(String name, String[] phoneNumbers) {
		setName(name);
		setPhoneNumbers(phoneNumbers);
	}
	//2  setXxx - 수정, getXx를 만드는 것이 좋다.
	private void setName(String name) {
		if(name==null || name.trim().length()<2)
			throw new RuntimeException(name+ ": 이름은 2자 이상");		
		this.name = name;
	}
	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getName() {
		return name;
	}

	
	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}
	
	//4. overriding ==> 클래스의 구조를 파악해서 필수 메서드를 재정의
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(phoneNumbers);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerVO other = (CustomerVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(phoneNumbers, other.phoneNumbers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "{name=" + name + ", phoneNumbers=" + Arrays.toString(phoneNumbers) + "}";
	}


	

}
