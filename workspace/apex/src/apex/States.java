package apex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.AbstractExecutorService;

public class States {
	int zipcode;
	String stateName, capital;
	
	public States(int zipcode, String stateName, String capital) {
		zipcode = zipcode;
		stateName = stateName;
		capital = capital;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List states = new ArrayList<>();
		states.add("New york");
		states.add("New jersey");
		states.add("Texas");
		states.add("Nevada");
		states.add("California");
		int  i;
		for(i = 0; i < states.size(); i++) {
			System.out.print(states.get(i)+", ");
		}

		System.out.println("");
		System.out.println("Hashset :");
		Set<String> hash = new HashSet<>();
		hash.add("New york");
		hash.add("New jersey");
		hash.add("Texas");
		hash.add("Nevada");
		hash.add("California");
		Iterator<String> iterator1 = hash.iterator();
		System.out.print("hash set data: ");
		while (iterator1.hasNext()) {
		System.out.print(iterator1.next() + ",");
		}
		
		System.out.println("");
		System.out.println("Tree set :");
		Set<String> tree = new TreeSet<>();
		tree.add("New york");
		tree.add("New jersey");
		tree.add("Texas");
		tree.add("Nevada");
		tree.add("California");
		Iterator<String> iterator2 = tree.iterator();
		System.out.print("Tree set data: ");
		while (iterator2.hasNext()) {
		System.out.print(iterator2.next() + ",");
		}

		System.out.println("-----------11");
		Map<Integer, String> map = new HashMap<>();
		map.put(12909,"Texas");
		map.put(13233,"Nevada");
		map.put(90412,"California");
		for(Map.Entry<Integer,String> each: map.entrySet()) {
			System.out.println(each.getKey()+" : "+each.getValue());
		}
		
		System.out.println("----------------12");
		States st1 = new States(12321, "Texas", "Austin");
		States st2 = new States(12321, "California", "SF");
		States st3 = new States(12321, "Florida", "Orlando");
		States st4 = new States(12321, "Washigton", "Seattle");
		States st5 = new States(12321, "Utah", "salt lake city");
		States st6 = new States(12321, "Idaho", "Austin");
		States st7 = new States(12321, "Arizona", "phoenix");
		States st8 = new States(12321, "Colorado", "Denver");
		States st9 = new States(12321, "Oregon", "Portland");
		States st10 = new States(12321, "Georgia", "Altanta");
		List all = new ArrayList<>();
		all.add(st1);
		all.add(st2);
		all.add(st3);
		all.add(st4);
		all.add(st5);
		all.add(st6);
		all.add(st7);
		all.add(st8);
		all.add(st9);
		all.add(st10);
		for(i = 0; i < states.size(); i++) {
			System.out.print(all.get(i)+", ");
		}
		
	}

}
