import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class KataPotterShoppingCart {

	
	public KataPotterShoppingCart() {

	}

	public float checkout(ArrayList<Integer> cartItems) {	
		
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
}
