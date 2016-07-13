package by.trepam.karotki.ht16_3.locks.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Store {
	public static final Logger LOG = LogManager.getLogger();
	private static final int MAX = 3; // максимальное количество места на складе
	private int product = 0;
	private ReentrantLock locker;
	private Condition condition;

	public Store() {
		locker = new ReentrantLock(); // создаем блокировку
		condition = locker.newCondition(); // получаем условие, связанное с
											// блокировкой
	}

	public void get() {

		try {
			locker.lock();
			
			while (product < 1)    // пока нет доступных товаров на складе, ожидаем
				condition.await();

			product--;
			System.out.println("Consumer bought 1 item of goods");
			System.out.println("Items of goods on stock: " + product);
			
			condition.signalAll();   // сигнализируем другим потокам об изменении условий
		} catch (InterruptedException e) {
			LOG.warn("Thread was interrupted");
		} finally {
			locker.unlock();
		}
	}

	public void put() {

		try {
			locker.lock();
			
			while (product >= MAX)   // пока на складе максимальное количество товара, ждем освобождения места
				condition.await();

			product++;
			System.out.println("Producer added 1 item");
			System.out.println("Items of goods on stock: " + product);
			condition.signalAll();   // сигнализируем другим потокам об изменении условий
		} catch (InterruptedException e) {
			LOG.warn("Thread was interrupted");
		} finally {
			locker.unlock();  // отпускаем блокировку
		}
	}
}
