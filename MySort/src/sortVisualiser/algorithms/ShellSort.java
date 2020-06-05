package sortVisualiser.algorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import sortVisualier.SortArray;

public class ShellSort implements ISortAlgorithms {
	static int index, value, count;

	@Override
	public void runSort(SortArray array) {
		int n = array.arraySize();
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = array.getValue(i), j;
				for (j = i; j >= gap && array.getValue(j - gap) > temp; j -= gap) {
					index = j;
					value = array.getValue(j - gap);
					runDelayTime(array);
					//array.setUpdate(j, j - gap);
				}
				index = j;
				value = temp;
				//array.setUpdate(j, temp);
				runDelayTime(array);
			}
		}
	}

	public void runDelayTime(SortArray array) {
		ActionListener taskPerformer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				array.setUpdate(index, value);
				((Timer) e.getSource()).stop();
			}
		};
		Timer timer = new Timer(1000, taskPerformer);
		timer.start();
	}
}