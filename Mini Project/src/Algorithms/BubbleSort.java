package Algorithms;



public class BubbleSort implements Runnable {
	private SortArray array;
	
	public BubbleSort(SortArray array) {
		// TODO Auto-generated constructor stub
		this.array = array;
	}
	
	@Override
	public void run() {
		int len = array.arraySize();
		for (int i = 0; i < len-1; i++) {
			for (int j = 0; j < len - i-1; j++) {
				if(array.getValue(j)  > array.getValue(j+1)) {
					array.swapUpdate(j, j+1);
				}
				
				try {
					Thread.sleep(array.getDelay());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		array.sortCompleted = true;
		array.reDraw();
		array.sortCompleted = false;
	}
}