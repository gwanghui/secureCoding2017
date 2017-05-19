package oopsw.collection.test;

import java.util.ArrayList;
class UserName{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList names=new ArrayList();
		names.add("hello");
		UserName un=new UserName();
		un.setName("jeon");
		names.add(un);
		un.setName("jeon2");
		System.out.println(names);
		
		ArrayList<Integer> list=new ArrayList<Integer>();  //기본 크기는 10
		System.out.println(list.size());  //값이 없으면 0으로 출력		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(list);
		
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println(list);
		System.out.println(list.get(2));
	}
}	
