import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConsoleThreadTest {

	// intentionally mocked instances for each test, 
	// mocking as member variables cause unclean tests
	
	@Test
	void start_expect_5_specific_println_text() throws InterruptedException {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);		
		ConsoleThread consoleThread = new ConsoleThread(threadWrapper, systemWrapper);
		consoleThread.start();
		Mockito.verify(systemWrapper, Mockito.times(1)).println("Starting...");
		Mockito.verify(systemWrapper, Mockito.times(1)).println("Waited 1 second.");
		Mockito.verify(systemWrapper, Mockito.times(1)).println("Waited 2 second.");
		Mockito.verify(systemWrapper, Mockito.times(1)).println("Waited 3 second.");
		Mockito.verify(systemWrapper, Mockito.times(1)).println("Waited 4 second.");
		Mockito.verify(systemWrapper, Mockito.times(1)).println("Waited 5 second.");
	}
	
	@Test
	void start_expect_5_1_sec_sleeps() throws InterruptedException {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);		
		ConsoleThread consoleThread = new ConsoleThread(threadWrapper, systemWrapper);
		consoleThread.start();
		Mockito.verify(threadWrapper, Mockito.times(5)).sleep(1000);
	}
}
