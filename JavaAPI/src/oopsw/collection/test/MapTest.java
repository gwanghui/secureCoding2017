package oopsw.collection.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(123, "±è¹Î¼º");
		map.put(456, "±è¹Î±Ô");

		Iterator<Integer> keyNames=map.keySet().iterator();
		while(keyNames.hasNext()){
			Integer keyName=keyNames.next();
			String keyValue=map.get(keyName);
			System.out.println(keyName+"'s value => "+ keyValue);
		}
	}
}

