package sortVisualier;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BubbleSortVisualiser {

	private JFrame window;
	private SortArray sortArray;

	public BubbleSortVisualiser() {
		window = new JFrame("Bubble Sort");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		window.setVisible(true);
		window.setLocationRelativeTo(null);

		sortArray = new SortArray();
		sortArray.runBubbleSort();
		window.add(sortArray);
		sortArray.repaint();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new BubbleSortVisualiser();
            }
        });
    }
	
}
