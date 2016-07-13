package by.trepam.karotki.ht16_3.locks.lock;

// Общий ресурс для потоков программы
public class CommonResource {
	private int x = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
