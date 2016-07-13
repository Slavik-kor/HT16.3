package by.trepam.karotki.ht16_3.locks.condition;

public class Producer implements Runnable{
	private Store store;
	
	public Producer(Store store){
		this.store = store;
	}

	@Override
	public void run() {
	  for (int i = 1; i < 6;i++){
		  store.put();
	  }	
		
	}

}
