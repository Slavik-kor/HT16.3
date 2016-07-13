package by.trepam.karotki.ht16_3.locks.exhanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> ex = new Exchanger<String>();
		
       Thread put =  new Thread(new PutThread(ex));
       Thread get = new Thread(new GetThread(ex));
       
       put.start();
       get.start();

	}

}
