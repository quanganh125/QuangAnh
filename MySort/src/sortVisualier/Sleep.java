package sortVisualier;

public class Sleep extends Thread {
	public void run() {
		super.run();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
