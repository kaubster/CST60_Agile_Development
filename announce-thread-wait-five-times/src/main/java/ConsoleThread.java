public class ConsoleThread {

	ThreadWrapper thread;
	SystemWrapper system;
	int itterations = 5;
	int intervalInMillis = 1000;
	
	public ConsoleThread(ThreadWrapper threadWrapper, SystemWrapper systemWrapper) {
		
		if(threadWrapper == null)
			throw new IllegalArgumentException("ConsoleThread: threadWrapper was null.");

		if(systemWrapper == null)
			throw new IllegalArgumentException("ConsoleThread: systemWrapper was null.");
		
		thread = threadWrapper;
		system = systemWrapper;
	}
	
	public ConsoleThread(ThreadWrapper threadWrapper, SystemWrapper systemWrapper, int numOfItterations, int intervalAsMillis) {
		this(threadWrapper, systemWrapper);
		
		if(numOfItterations <= 0)
			throw new IllegalArgumentException("numOfItterations must be greater than 0.");

		if(intervalAsMillis <= 0)
			throw new IllegalArgumentException("intervalAsMillis must be greater than 0.");
		
		itterations = numOfItterations;
		intervalInMillis = intervalAsMillis;
	}

	public void start() throws InterruptedException {
		system.println("Starting...");
		for (int i = 0; i < itterations; i++) {   
		    thread.sleep(intervalInMillis);   
		    system.println("Waited " + (i + 1) + " second.");
		}
	}
}
