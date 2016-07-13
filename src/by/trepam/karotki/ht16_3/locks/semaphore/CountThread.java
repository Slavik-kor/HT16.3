package by.trepam.karotki.ht16_3.locks.semaphore;

import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.trepam.karotki.ht16_3.locks.lock.CommonResource;

public class CountThread implements Runnable {
	public static final Logger LOG = LogManager.getLogger();
	private static final int init = 1;
	private CommonResource res;
	private Semaphore semaphore;
	private String name;

	// в конструктор передается ссылка на общий ресурс и ссылка на объект
	// реализующий интерфейс Lock
	CountThread(CommonResource res, Semaphore semaphore, String name) {
		this.res = res;
		this.semaphore = semaphore;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " waiting for resolution");
			semaphore.acquire();// запрос разрешения на доступ к общему ресурсу
			res.setX(init); 
			for (int i = 1; i < 5; i++) {
				System.out.println(this.name + ":" + res.getX());
				res.setX(res.getX()+1);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			LOG.warn("Thread " + this.name + "was interrupted");
		} finally {
			semaphore.release(); 			// говорим семафору, что поработали и отпускаем общий ресурс	

		}
	}
}
