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
	
}
