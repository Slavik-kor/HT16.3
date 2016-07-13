package by.trepam.karotki.ht16_3.locks.condition;

public class ConditionDemo {

	public static void main(String[] args) {
		 Store store=new Store();
	        Thread thProducer = new Thread(new Producer(store));
	        Thread thConsumer = new Thread(new Consumer(store));

	        thProducer.start();
	        thConsumer.start();
	}

}
