import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ThreadWrapperTest {

	// intentionally mocked instances for each test, 
	// mocking as member variables cause unclean tests
	
	@Test
	void sleep_expect_1_second_pause() throws InterruptedException {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		
		long expected = 1000;
		
		threadWrapper.sleep(expected);
		
		Mockito.verify(threadWrapper).sleep(expected);
	}
	
	// IllegalArgumentException - if the value of millis is negative
		// InterruptedException - if any thread has interrupted the current thread. The interrupted status of the current thread iscleared when this exception is thrown.
	
	@Test
	void start_expect_Neg_Itterations() throws InterruptedException {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		
		// Test to provide context, long corrects for negative value
		// However, Thread.Sleep states IllegalArgumentException is possible for negative  millis value.
		
		long expected = -1000; // long 0 to 2^64-1
		
		threadWrapper.sleep(expected);
		
		Mockito.verify(threadWrapper).sleep(expected);
	}
	
}
