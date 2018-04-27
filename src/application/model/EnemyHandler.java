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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		
		while (running)
		{
			for (EnemyShip e : Main.enemies.toArray(new EnemyShip[Main.playerBullets.size()])) {
				e.update1();
				//System.out.println("move");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (EnemyShip e : Main.enemies.toArray(new EnemyShip[Main.playerBullets.size()])) {
				e.update();
				//System.out.println("move");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stop();
	}
}
