package by.trepam.karotki.ht16_3.locks.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	private static int limitThreads = 6;

	public static void main(String[] args) {
		CommonResource commonResource = new CommonResource();
		ReentrantLock locker = new ReentrantLock(); // создаем заглушку
		for (int i = 0; i < limitThreads; i++) {
			Thread t = new Thread(new CountThread(commonResource, locker));
			t.setName("Thread " + i);
			t.start();
		}

	}

}
