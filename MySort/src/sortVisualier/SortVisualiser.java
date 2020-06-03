package sortVisualier;

import javax.swing.JFrame;

public class SortVisualiser {

	private JFrame window;
	private SortArray sortArray;

	public SortVisualiser() {
		window = new JFrame("Sort Visualiser");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		window.setVisible(true);

		sortArray = new SortArray();
		window.add(sortArray);
		sortArray.repaint();
	}

	public static void main(String[] args) {
		SortVisualiser sortVisualiser = new SortVisualiser();
	}
}
