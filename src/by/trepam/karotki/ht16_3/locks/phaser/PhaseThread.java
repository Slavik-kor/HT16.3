package by.trepam.karotki.ht16_3.locks.phaser;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable{
	private Phaser phaser;
	private String name;
	
	public PhaseThread(Phaser phaser,String name){
		this.phaser = phaser;
		this.name = name;
		phaser.register();   // регистрация потока, выполняемого фазы
	}

	@Override
	public void run() {
		System.out.println("Thread "+name + " is performing " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();        // говорим, что первая фаза достигнута
         
        System.out.println("Thread "+name + " is performing " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();        // говорим, что вторая фаза достигнута
 
        System.out.println("Thread "+name + " is performing " + phaser.getPhase());
        phaser.arriveAndDeregister();        // говорим о завершении фаз и удаляем с регистрации объекты 
		
	}

}
