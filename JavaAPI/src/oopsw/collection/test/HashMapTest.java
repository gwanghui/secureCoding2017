package oopsw.collection.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Object> m=new HashMap<String, Object>();
		String s=new String("hello");
		m.put("k1", new String("data"));
		m.put("k2", new String("data"));
		m.put("k3", "data");
		m.put("k4", "data");
		m.put("k5", s);
		m.put("k6", s);
		s=s.replaceAll("hello", "hi");
		
		System.out.println(m.get("k1") == m.get("k2"));
		System.out.println(m.get("k3") == m.get("k4"));
		System.out.println(m.get("k1").equals(m.get("k2")));
		System.out.println(m.get("k5") == m.get("k6"));
		System.out.println(m.get("k5").equals(m.get("k6")));
		System.out.println(m.get("k5"));
		System.out.println(m.get("k6"));
		
		UserName un=new UserName();
		un.setName("jeon");
		m.put("k7", un);
		System.out.println(m.get("k7"));
		un.setName("jeon2");
		System.out.println(m.get("k7"));
	}
}
