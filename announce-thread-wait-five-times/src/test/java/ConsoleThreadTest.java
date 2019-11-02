import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConsoleThreadTest {

	// intentionally mocked instances for each test, 
	// mocking as member variables cause unclean tests
	
	//	Z – Zero
	//	O – One
	//	M – Many (or More complex)
	//	B – Boundary Behaviors
	//	I – Interface definition
	//	E – Exercise Exceptional behavior
	//	S – Simple Scenarios, Simple Solutions
	
	@Test
	void start_expect_6_specific_println_text() throws InterruptedException {
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
		
	@Test
	void start_expect_N_Itterations_M_milli_sec_sleeps() throws InterruptedException {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);
		
		int nItterations = 6;
		int mInterval = 2000;
		ConsoleThread consoleThread = new ConsoleThread(threadWrapper, systemWrapper, nItterations, mInterval);
		consoleThread.start();
		
		for (int i = 0; i < nItterations; i++) {
			Mockito.verify(systemWrapper, Mockito.times(1)).println("Waited " + (i+1) + " second.");
		}
		
		Mockito.verify(threadWrapper, Mockito.times(nItterations)).sleep(mInterval);
	}
	
	@Test
	void start_expect_Neg_Itterations_Exception() throws InterruptedException {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 new ConsoleThread(threadWrapper, systemWrapper, -5, 1000);
		});
	}
	
	@Test
	void start_expect_Zero_Itterations_Exception() {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 new ConsoleThread(threadWrapper, systemWrapper, 5, 0);
		});
	}
	
	@Test
	void start_expect_Neg_Interval_Exception() {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 new ConsoleThread(threadWrapper, systemWrapper, -5, 1000);
		});
	}
	
	@Test
	void start_expect_Zero_Interval_Exception() {
		ThreadWrapper threadWrapper = Mockito.mock(ThreadWrapper.class);
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 new ConsoleThread(threadWrapper, systemWrapper, 5, 0);
		});
	}
}
