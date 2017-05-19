package oopsw.visitor.vo;

import java.util.Arrays;

/**����ڴ� �̸�, ��ȭ��ȣ ���� ������ �ִ�.
 * ��ȭ��ȣ�� 2���� �Է��ؾ� �Ѵ�.
 * �̸��� ������ 2�� �̻��̾�� �Ѵ�.*/
public class CustomerVO {
	//1.
	private String name;
	private String[] phoneNumbers;
	//3. ������ - �ʼ� �ʱ�ȭ
	public CustomerVO(String name, String[] phoneNumbers) {
		setName(name);
		setPhoneNumbers(phoneNumbers);
	}
	//2  setXxx - ����, getXx�� ����� ���� ����.
	private void setName(String name) {
		if(name==null || name.trim().length()<2)
			throw new RuntimeException(name+ ": �̸��� 2�� �̻�");		
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
	
	//4. overriding ==> Ŭ������ ������ �ľ��ؼ� �ʼ� �޼��带 ������
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
