
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class KataPotterShoppingCart {

	
	public KataPotterShoppingCart() {

	}
	
	public float checkout(ArrayList<Integer> cartItems) {	
				
		float countPrice = calcPrice(cartItems);
		
		float smallestGroupPrice = calcSmallGroups(cartItems);
		
		if(countPrice < smallestGroupPrice)
			return countPrice;
		
		return smallestGroupPrice;
	}
	
	private Map<String, Integer> CreateCountMap(ArrayList<Integer> cartItems) {
		Map<String, Integer> bookToCountMap = new Hashtable<String, Integer>();
		
		for (int i = 0; i < cartItems.size(); i++) {			
			String bookNumber = cartItems.get(i).toString();
			if(!bookToCountMap.containsKey(bookNumber)) {
				bookToCountMap.put(bookNumber, 1);
			}else {
				int count = bookToCountMap.get(bookNumber);
				count++;
				bookToCountMap.put(bookNumber, count);
			}			
		}
		
		//int distinct = bookToCountMap.values().stream().reduce(0, (i,j) -> i + j);
		
		return bookToCountMap;		
	}
	
	private float calcPrice(ArrayList<Integer> cartItems) {
		Map<String, Integer> bookToCountMap = CreateCountMap(cartItems);
				
		float total = 0;
		
		while (bookToCountMap.size() > 0) {

			int unique = bookToCountMap.size();
			float discount = getDiscount(unique);
				
			total +=  8 * unique * discount;
			
			System.out.println(8 + "*" + unique + "*" +  discount);
			
			ArrayList<String> delete = new ArrayList<String>();
						
			for (String key : bookToCountMap.keySet()) {
				int count = bookToCountMap.get(key);
				count--;
				
				if(count == 0)
					delete.add(key);
				else
					bookToCountMap.put(key, count);
			}
			
			for (int i = 0; i < delete.size(); i++) {
				bookToCountMap.remove(delete.get(i));
			}
			
		}
		return total;
	}

	public float getDiscount(int uniqueBooks) {
		
		if(uniqueBooks <= 0)
			throw new java.lang.IllegalArgumentException("Unique books cannot be negative.");

		if(uniqueBooks > 5)
			throw new java.lang.IllegalArgumentException("Unique books cannot be greater then 5.");
			
		switch(uniqueBooks) {
			case 1: return 1f;
			case 2: return 0.95f;
			case 3: return 0.9f;
			case 4: return 0.8f;
			case 5: return 0.75f;
			default: return Float.NaN;
		}
	}
	
	private float calcSmallGroups(ArrayList<Integer> cartItems) {		
		List<Set> actual = spreadGroups(cartItems);		
		return PriceGroup(actual);
	}

	private float PriceGroup(List<Set> actual) {

		float total = 0;

		for (Set set : actual) {
			int count = set.size();			
			float discount = getDiscount(count);			
			total +=  8 * count * discount;
		}
		
		return total;
	}

	public static java.util.List<Set> spreadGroups(ArrayList<Integer> cartItems) {

		List<Set> groups = new ArrayList<Set>();
		
		for (Integer integer : cartItems) {
			AddToSmallestOrCreateGroup(integer, groups);			
		}

		return groups;
	}

	public static void AddToSmallestOrCreateGroup(Integer integer, List<Set> groups) {
		Set<Integer> smallestNotContaining = findSmallestNotContaining(groups, integer); 
		if(smallestNotContaining != null) {
			smallestNotContaining.add(integer);
		} else {
			Set<Integer> nSet = new HashSet<Integer>();
			nSet.add(integer);
			groups.add(nSet);			
		}		
	}

	public static Set<Integer> findSmallestNotContaining(List<Set> groups, Integer integer) {
		List<Set> smallerGroups = new ArrayList<Set>();
		
		int smallest = -1;
		
		Set<Integer> fSet = null;		
		
		for (Set grp : groups) {
			int gSize = grp.size();
			
			if(smallest == -1) // first time though, no smallest known. Assume current.
				smallest = gSize;
				
			if(!grp.contains(integer) && gSize <= smallest) {
				smallest = gSize;
				fSet = grp;
			}
		}
		
		return fSet;
	}
}
