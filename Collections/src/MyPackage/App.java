package MyPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class App {
	public static void main(String[] args) {
		ArrayList<String> al  = new ArrayList<String>();
		al.add("First String");
		al.add("Second String");
		al.add("Third String");
		
		for (int i = 0; i < al.size(); i++ ) {
			System.out.println(al.get(i));
		}
		
		for (String s: al) {
			System.out.println(s);
		}
		
		Iterator<String> it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
