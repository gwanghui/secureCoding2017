//VO, TO - 1.-멤버 데이터, 2. 생성자, 3, setXxx()수정 업무가 있을때만
//4. 일반적으로 멤버는  getXXX(), 
//5. 중복성, 데이터를 출력 Object's equals(),  hashCode()
  // 시스템은 기본적으로 System.out.println(xxx.toString()); 숨어서 호출한다.
public class CustomerTO {
	private String customerId;
	private String name;
	private String phoneNumber;
	//overloading - 생성자
	public CustomerTO(String customerId, String name, String phoneNumber) {
		
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public CustomerTO(String customerId,String name) {
		this(customerId, name, "");
	}
	public CustomerTO(String name) {
		this("", name, "");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		CustomerTO other = (CustomerTO) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerTO [customerId=" + customerId + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
