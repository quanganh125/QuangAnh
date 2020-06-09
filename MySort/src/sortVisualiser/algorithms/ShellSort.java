package sortVisualiser.algorithms;

import sortVisualier.BubbleSortVisualiser;
import sortVisualier.SortArray;

public class ShellSort implements Runnable {
	private SortArray array;

	public ShellSort(SortArray array) {
		// TODO Auto-generated constructor stub
		this.array = array;
	}

	@Override
	public void run() {
		int n = array.arraySize();
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = array.getValue(i), j;
				for (j = i; j >= gap && array.getValue(j - gap) > temp; j -= gap) {
					try {
						Thread.sleep(BubbleSortVisualiser.delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					array.setUpdate(j, array.getValue(j-gap));
				}
				try {
					Thread.sleep(BubbleSortVisualiser.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				array.setUpdate(j, temp);
			}
		}
		array.completeSort();
	}
	
}