/**
 * EnemyHandler class controls and updates the Enemy Ship thread
 * 
 * @author wolfyCSA, caseycannon423, IceKold736, Mpoznecki, indomichael
 */
package application.model;

import application.Main;

public class EnemyHandler implements Runnable {
	public Thread enemyHandler;
	public boolean running = false;
	
	public EnemyHandler() {}
	
	//THREAD STARTS IN MAINMENUCONTROLLER
	public synchronized void start(){
		if (running)
			return;
		running = true;
		enemyHandler = new Thread(this);
		enemyHandler.setDaemon(true);
		enemyHandler.start();
	}
	
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			enemyHandler.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * runs the Enemy ship Thread
	 */
	public void run() {
		
		while (running)
		{
			for (EnemyShip e : Main.enemies.toArray(new EnemyShip[Main.playerBullets.size()])) 
				e.update1();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end try/catch
			
			for (EnemyShip e : Main.enemies.toArray(new EnemyShip[Main.playerBullets.size()]))
				e.update();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end try/catch
			
		}//end while
		stop();
	}//end run()
	
}//end class EnemyHandler