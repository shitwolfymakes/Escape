/**
 * Bullet Handler class controls and updates the bullet thread
 * 
 * @author wolfyCSA, caseycannon423, IceKold736, Mpoznecki, indomichael
 *
 */
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
		bulletHandler.setDaemon(true);
		bulletHandler.start();
	}//end start()
	
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			bulletHandler.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//end try/catch
	}//end stop()
	
	/**
	 *  Runs the bullet thread. 
	 */
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
				e.printStackTrace();
			}//end try/catch
		}//end while
		stop();
	}//end run()
	
}//end class BulletHandler