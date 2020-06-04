package sortVisualiser.algorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import sortVisualier.SortArray;

public class BubbleSort implements ISortAlgorithms {
	int actual;

	@Override
	public void runSort(SortArray array) {

		int len = array.arraySize();
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				int x1 = j, x2 = len - i - 1;

				Timer timer = new Timer(1000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						if (array.getValue(x1) >= array.getValue(x1 + 1))
							array.swapUpdate(x1, x1 + 1);
						
						if (++actual >= x2) {
							Timer t = (Timer) evt.getSource();
							t.stop();
						}
					}
				});
				timer.setRepeats(true);
				timer.start();
			}

		}

	}
}
