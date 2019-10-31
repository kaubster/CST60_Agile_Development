
public class ConsoleThreadMain {

	public static void main(String[] args) {
		ThreadWrapper threadWrapper = new ThreadWrapper();
		SystemWrapper systemWrapper = new SystemWrapper();
				
		ConsoleThread consoleThread = new ConsoleThread(threadWrapper, systemWrapper);
		try {
			consoleThread.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
