package by.trepam.karotki.ht16_3.locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import by.trepam.karotki.ht16_3.locks.lock.CommonResource;

public class ReadWriteLockDemo {
	private static final int READERS = 5;

	public static void main(String[] args) {
		CommonResource cr = new CommonResource();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		Thread thWrite = new Thread(new WriteThread(lock,cr));
		

		Thread[] thRead = new Thread[READERS];
		for (int i = 0;i < READERS; i++){
			thRead[i] = new Thread(new ReadThread(lock,cr));
		}
		
		thRead[0].start();
		thRead[1].start();
		thWrite.start();
		thRead[2].start();
		thRead[3].start();
		thRead[4].start();
		
	}

}
