package by.trepam.karotki.ht16_3.locks.readwritelock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import by.trepam.karotki.ht16_3.locks.lock.CommonResource;

public class ReadThread implements Runnable {
	private ReadWriteLock rWLock;
	private CommonResource res;

	ReadThread(ReadWriteLock lock,CommonResource res) {
		rWLock = lock;
		this.res = res;
	}

	@Override
	public void run() {
		Lock readLock = null;
		try {
			readLock = rWLock.readLock(); // берем у ReadWriteLock замок для чтения	
			readLock.lock();         // ставим замок на чтение
			System.out.println("Thread read " + res.getX()+" from CommonResource");
		} finally {
			readLock.unlock(); // отпускаем замок на чтение
		}
	}

}
