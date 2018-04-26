package application.model;

import application.Main;

public class BulletHandler implements Runnable {
	public Thread bulletHandler;
	public boolean running = false;
	
	public BulletHandler() {}
	
	//THREAD STARTS IN MAINMENUCONTROLLER
	public synchronized void start(){
		if (running)
			return;
		running = true;
		bulletHandler = new Thread(this);
		bulletHandler.start();
	}
	
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			bulletHandler.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		
		while (running)
		{
			
			for (PlayerBullet b : Main.playerBullets.toArray(new PlayerBullet[Main.playerBullets.size()])) {
				b.update();
				//System.out.println("move");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stop();
	}
}
