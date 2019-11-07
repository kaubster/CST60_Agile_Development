
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KattaPotterStepDefs {
	
	ArrayList<Integer> cartItems = new ArrayList<Integer>();
	double price;
	
	@Given("^the user chose book (\\d+)$")
	public void the_user_chose_book(int bookNumber) throws Throwable {
		cartItems.add(bookNumber);
	}

	@When("^the user checks out$")
	public void the_user_checks_out() throws Throwable {
		KataPotterShoppingCart cart = new KataPotterShoppingCart();
		price = cart.checkout(cartItems);
	}

	@Then("^the system should charge (\\d+) EUR$")
	public void the_system_should_charge_EUR(int expectedPrice) throws Throwable {
		assertEquals(price, expectedPrice, 0);
	}
	
	@Given("^the user chose (\\d+) of book (\\d+)$")
	public void the_user_chose_of_book(int count, int bookNumber) throws Throwable {
		for (int i = 0; i < count; i++) {
			cartItems.add(bookNumber);
		}	
	}
}
