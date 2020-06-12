package Algorithms;

public class InsertionSort implements Runnable {
	private SortArray array;

	public InsertionSort(SortArray array) {
		// TODO Auto-generated constructor stub
		this.array = array;
	}

	@Override
	public void run() {
		int len = array.arraySize();
		for (int i = 0; i < len; i++) {{
			int key = array.getValue(i);
			int j = i - 1;
			
			while (j >= 0 && array.getValue(j) > key) {
				array.setUpdate(j + 1, array.getValue(j));
				try {
					Thread.sleep(array.getDelay());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				j--;
			}
			array.setUpdate(j + 1, key);
			try {
				Thread.sleep(array.getDelay());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}}
		array.sortCompleted = true;
		array.reDraw();
		array.sortCompleted = false;
	}
}