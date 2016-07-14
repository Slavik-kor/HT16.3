package by.trepam.karotki.ht16_3.synchronizers.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

	public static void main(String[] args) {
		 Phaser phaser = new Phaser(1);
	      Thread th1 = new Thread(new PhaseThread(phaser, "PhaseThread 1"));
	      Thread th2 = new Thread(new PhaseThread(phaser, "PhaseThread 2"));
	      
	      th1.start();
	      th2.start();
	         
	        
	        int phase = phaser.getPhase();
	        phaser.arriveAndAwaitAdvance();   // ждем завершения фазы 0
	        System.out.println("Phase " + phase + " is completed");
	      
	        phase = phaser.getPhase();
	        phaser.arriveAndAwaitAdvance();     // ждем завершения фазы 1
	        System.out.println("Phase " + phase + " is completed");
	         
	        
	        phase = phaser.getPhase();
	        phaser.arriveAndAwaitAdvance();    // ждем завершения фазы 2
	        System.out.println("Phase " + phase + " is completed");
	         
	        phaser.arriveAndDeregister(); //отмена регистрации всех потоков

	}

}
