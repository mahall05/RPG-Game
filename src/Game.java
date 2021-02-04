import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {     // Implements runnable so it can be run on a thread
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage test;
	private SpriteSheet ss;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		test = ImageLoader.loadImage("/textures/sprite_sheet.png");
		ss = new SpriteSheet(test);
	}
	
	private void tick() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();     // Buffer strategy is a way for the computer to draw things to the game, uses buffers, check Resources for more detailed description
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();     // Graphics allows us to draw things to the canvas
		
		// Clear Screen
		g.clearRect(0, 0, width, height);
		
		///////////////////////////// START DRAWING
		
		
		
		///////////////////////////// END DRAWING
		
		bs.show();
		g.dispose();
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
