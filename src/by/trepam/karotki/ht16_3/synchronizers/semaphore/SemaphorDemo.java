package by.trepam.karotki.ht16_3.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

import by.trepam.karotki.ht16_3.locks.lock.CommonResource;

public class SemaphorDemo {
	private static final int amount = 1;

	public static void main(String[] args) {
		// Создаем семафор, разрешающий доступ одному потоку
		Semaphore semaphore = new Semaphore(amount);
		CommonResource res = new CommonResource();
		for (int i = 0; i< 5; i++){
			Thread th = new Thread(new CountThread(res,semaphore,"Thread "+i));
			th.start();
		}
	}

}
