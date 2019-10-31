public class ConsoleThread {

	ThreadWrapper thread;
	SystemWrapper system;
	
	public ConsoleThread(ThreadWrapper threadWrapper, SystemWrapper systemWrapper) {
		thread = threadWrapper;
		system = systemWrapper;
	}

	public void start() throws InterruptedException {
		system.println("Starting...");
		for (int i = 0; i < 5; i++) {   
		    thread.sleep(1000);   
		    system.println("Waited " + (i + 1) + " second.");
		}
	}
}
