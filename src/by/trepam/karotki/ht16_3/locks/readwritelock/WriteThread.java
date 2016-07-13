package by.trepam.karotki.ht16_3.locks.readwritelock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import by.trepam.karotki.ht16_3.locks.lock.CommonResource;

public class WriteThread implements Runnable {
	private ReadWriteLock rWLock;
	private CommonResource res;

	WriteThread(ReadWriteLock lock,CommonResource res) {
		rWLock = lock;
		this.res = res;
	}
	
	@Override
	public void run() {
		Lock writeLock = null;
		try {
			writeLock = rWLock.writeLock(); // берем у ReadWriteLock замок для записи
			writeLock.lock();  // ставим замок на запись
			res.setX(res.getX()+1);							
			System.out.println("Thread recorded " + res.getX()+" in CommonResource");
		} finally {
			writeLock.unlock(); // отпускаем замок на запись
		}

	}

}
