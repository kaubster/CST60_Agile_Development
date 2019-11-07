import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
}
