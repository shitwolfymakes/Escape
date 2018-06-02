/**
 * CollisionDetector class controls and updates the Collison thread
 * 
 * @author wolfyCSA, caseycannon423, IceKold736, Mpoznecki, indomichael
 *
 */
package application.model;

import application.Main;

public class CollisionDetector implements Runnable {
	public Thread collisionDetector;
	public boolean running = false;
	
	public CollisionDetector() {}
	
	//THREAD STARTS IN MAINMENUCONTROLLER
	public synchronized void start(){
		if (running)
			return;
		running = true;
		collisionDetector = new Thread(this);
		collisionDetector.setDaemon(true);
		collisionDetector.start();
	}//end start()
	
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			collisionDetector.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//end try/catch
		
	}//end stop()
	
	/**
	 * runs the collision thread
	 */
	public void run() {
		
		while (running)
		{
			for (EnemyShip e : Main.enemies.toArray(new EnemyShip[Main.playerBullets.size()]))
				e.update1();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end try/catch

		}//end while
		stop();
	}//end run()

}//end class CollisionDetector