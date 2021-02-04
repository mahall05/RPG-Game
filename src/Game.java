
public class Game implements Runnable {     // Implements runnable so it can be run on a thread
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		
	}
	
	private void tick() {
		
	}
	
	private void render() {
		
	}
	
	public void run() {
		
		init();
		
		while(running) {
			tick();
			render();
			
		}
		
		stop();
		
	}
	
	public synchronized void start() {     // Synchronized is only used for working with threads
		if(running)
			return;
		running = true;
		thread = new Thread(this);     // Initialize a new thread and run this class on that thread
		thread.start();     // Start the thread, which runs the run method
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();     // Stops the thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
