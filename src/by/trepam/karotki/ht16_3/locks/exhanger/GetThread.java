package by.trepam.karotki.ht16_3.locks.exhanger;

import java.util.concurrent.Exchanger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetThread implements Runnable{
	public static final Logger LOG = LogManager.getLogger();
	private Exchanger<String> exchanger;
	private String message = "Message was created in GetThread";
	
	public GetThread(Exchanger<String> exchanger){
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		try {
			message = exchanger.exchange(message);   // Обмениваемся сообщениями с другими потоками
			System.out.println("GetThread got: " + message);  //выводим полученное сообщение на консоль
		} catch (InterruptedException ex) {
			LOG.warn("Thread was interrupted");
		}
		
	}

}
