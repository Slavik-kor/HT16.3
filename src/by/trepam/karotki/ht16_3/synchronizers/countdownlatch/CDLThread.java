package by.trepam.karotki.ht16_3.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CDLThread implements Runnable {
	public static final Logger LOG = LogManager.getLogger();
	private CountDownLatch cdl;
	private String name;
	private int duration;
	
	public CDLThread(String name, CountDownLatch cdl,int duration){
		this.name = name;
		this.cdl = cdl;
		this.duration = duration;
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread "+name+" is performing...");
		try{
			Thread.sleep(duration);
		}catch(InterruptedException e){
			LOG.warn("Thread "+name+" is inurrupted");
		}
		cdl.countDown();
		System.out.println("Thread "+name+" is stoping...");
	}

}
