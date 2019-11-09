import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

class KataPotterShoppingCartTest {

	KataPotterShoppingCart cart;
	
	@BeforeEach
	public void setup() {
		cart = new KataPotterShoppingCart();
	}
	
	@Test() 
	public void neg_discount_returns_exception() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cart.getDiscount(-1);
		});
	}
	
	@Test() 
	public void discount_6_or_more_returns_exception() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cart.getDiscount(6);
		});
	}
	
	@Test() 
	public void discount_1_unique_book_in_series() {
		float actual = cart.getDiscount(1);
		Assertions.assertEquals(actual, 1.0f, 0);
	}
	
	@Test() 
	public void discount_2_unique_book_in_series() {
		float actual = cart.getDiscount(2);
		Assertions.assertEquals(actual, 0.95f, 0);
	}
	
	@Test() 
	public void discount_3_unique_book_in_series() {
		float actual = cart.getDiscount(3);
		Assertions.assertEquals(actual, 0.9f, 0);
	}
	
	@Test() 
	public void discount_4_unique_book_in_series() {
		float actual = cart.getDiscount(4);
		Assertions.assertEquals(actual, 0.8f);
	}
	
	@Test() 
	public void discount_5_unique_book_in_series() {
		float actual = cart.getDiscount(5);
		Assertions.assertEquals(actual, 0.75f, 0);
	}
	
	@Test() 
	public void try_outlier_1() {

		//counts not cutting it, try spread groups...
		
		//assert_equal(2 * (8 * 4 * 0.8), price([0, 0, 1, 1, 2, 2, 3, 4]))
		// |        2 |        2 |        2 |        1 |        1 |  51.2 
		ArrayList<Integer> cartItems = new ArrayList<Integer>();
				
		cartItems.add(1);
		cartItems.add(1);
		cartItems.add(2);
		cartItems.add(2);
		cartItems.add(3);
		cartItems.add(3);
		cartItems.add(4);
		cartItems.add(5);

		KataPotterShoppingCart cart = new KataPotterShoppingCart();
		
		List<Set> actual = cart.spreadGroups(cartItems);

		List<Set> expected = new ArrayList<Set>();
		
		//https://beginnersbook.com/2014/08/hashset-vs-hashmap-java/
		// 2 * (8 * 4 * 0.8)
		Set<Integer> group1 = new HashSet<Integer>();
		group1.add(1);
		group1.add(2);
		group1.add(3);
		group1.add(5);
		
		expected.add(group1);
		
		Set<Integer> group2 = new HashSet<Integer>();
		group2.add(1);
		group2.add(2);
		group2.add(3);
		group2.add(4);
		
		expected.add(group2);
		
		assertEquals(expected, actual);		
	}
	
	@Test() 
	public void try_outlier_2() {		
		
//		  assert_equal(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), 
//				    price([0, 0, 0, 0, 0, 
//				           1, 1, 1, 1, 1, 
//				           2, 2, 2, 2, 
//				           3, 3, 3, 3, 3, 
//				           4, 4, 4, 4]))
		
		// |        2 |        2 |        2 |        1 |        1 |  51.2 
		ArrayList<Integer> cartItems = new ArrayList<Integer>();
				
		for (int i = 0; i < 5; i++) {
			cartItems.add(0);
		}
		
		for (int i = 0; i < 5; i++) {
			cartItems.add(1);
		}
		
		for (int i = 0; i < 4; i++) {
			cartItems.add(2);
		}

		for (int i = 0; i < 5; i++) {
			cartItems.add(3);
		}

		for (int i = 0; i < 4; i++) {
			cartItems.add(4);
		}
				
		List<Set> actual = KataPotterShoppingCart.spreadGroups(cartItems);

		List<Set> expected = new ArrayList<Set>();
		
		//https://beginnersbook.com/2014/08/hashset-vs-hashmap-java/
		// 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)
		Set<Integer> group1 = new HashSet<Integer>();
		group1.add(0);
		group1.add(1);
		group1.add(3);
		group1.add(4);
		
		expected.add(group1);
		
		Set<Integer> group2 = new HashSet<Integer>();
		group2.add(0);
		group2.add(1);
		group2.add(2);
		group2.add(3);
		
		expected.add(group2);
		
		Set<Integer> group3 = new HashSet<Integer>();
		group3.add(0);
		group3.add(1);
		group3.add(2);
		group3.add(3);
		group3.add(4);
		
		expected.add(group3);
		
		Set<Integer> group4 = new HashSet<Integer>();
		group4.add(0);
		group4.add(1);
		group4.add(2);
		group4.add(3);
		group4.add(4);
		
		expected.add(group4);
		
		Set<Integer> group5 = new HashSet<Integer>();
		group5.add(0);
		group5.add(1);
		group5.add(2);
		group5.add(3);
		group5.add(4);
		
		expected.add(group5);
		
		assertEquals(expected, actual);		
	}
	
	@Test() 
	public void find_smallest_group_not_containing() {
		List<Set> groups = new ArrayList<Set>();
		
		Set<Integer> group1 = new HashSet<Integer>();
		group1.add(1);
		group1.add(2);
		group1.add(3);
		
		groups.add(group1);
		
		Set<Integer> group2 = new HashSet<Integer>();
		group2.add(1);
		group2.add(2);
		
		groups.add(group2);
		
		Set<Integer> group3 = new HashSet<Integer>();
		group3.add(1);
		group3.add(4);
		
		groups.add(group3);		

		Set<Integer> actual = KataPotterShoppingCart.findSmallestNotContaining(groups, 4);		
		
		assertEquals(group2, actual);
	}
	
	@Test() 
	public void add_int_to_smallest_group_not_containing() {

		List<Set> groups = new ArrayList<Set>();
		
		Set<Integer> group1 = new HashSet<Integer>();
		group1.add(1);
		group1.add(2);
		group1.add(3);
		group1.add(4);
		
		groups.add(group1);
		
		Set<Integer> group2 = new HashSet<Integer>();
		group2.add(1);
		group2.add(2);
		group2.add(3);
		
		groups.add(group2);
				
		KataPotterShoppingCart.AddToSmallestOrCreateGroup(5, groups);		

		List<Set> expectedGrps = new ArrayList<Set>();				
		expectedGrps.add(group1);		
		group2.add(5);
		expectedGrps.add(group2);
		
		assertEquals(groups, expectedGrps);
	}
	
}
