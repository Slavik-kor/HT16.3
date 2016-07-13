package by.trepam.karotki.ht16_3.locks.lock;

import java.util.concurrent.locks.Lock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountThread implements Runnable {
	public static final Logger LOG = LogManager.getLogger();
	private static final int init = 1;
	private CommonResource res;
	private Lock locker;

	// в конструктор передается ссылка на общий ресурс и ссылка на объект реализующий интерфейс Lock
	CountThread(CommonResource res, Lock lock) {
		this.res = res;
		locker = lock;
	}

	@Override
	public void run() {
		Thread current = Thread.currentThread();				// получаем ссылку на текущий поток
		try {
			locker.lock(); 					// блокируем доступ к общему ресурсу для всех потоков кроме текущего
			res.setX(init);					// устанавливаем начальное значение поля x объекта общего ресурса
			for (int i = 1; i < 5; i++) { 		//выполняем 5 инкремент поля x 
				System.out.println(current.getName() + " increments " + res.getX());
				res.setX(res.getX() + 1);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			LOG.warn("Thread " + current.getName() + "was interrupted");
		} finally {
			locker.unlock();                  // снимаем блокировку с общего ресурса для других потоков
		}
	}

}
