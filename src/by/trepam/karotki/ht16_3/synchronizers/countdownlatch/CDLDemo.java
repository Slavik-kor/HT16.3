package by.trepam.karotki.ht16_3.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CDLDemo {
	public static final Logger LOG = LogManager.getLogger();

	public static void main(String[] args) {
	CountDownLatch cdl = new CountDownLatch(3);
	
	Thread th1 = new Thread(new CDLThread("1",cdl,100));
	Thread th2 = new Thread(new CDLThread("2",cdl,1000));
	Thread th3 = new Thread(new CDLThread("3",cdl,500));
	
	th1.start();
	th2.start();
	th3.start();

	System.out.println("Waiting for finish all threads");
	
	try {
		cdl.await();
	} catch (InterruptedException e) {
		LOG.warn("InterruptedException");
	}
	 
	System.out.println("All threads are finished");
	}

}
