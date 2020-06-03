package sortVisualier;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SortVisualiser {

	private JFrame window;
	private SortArray sortArray;

	public SortVisualiser() {
		window = new JFrame("Visualiser Bubble Sort");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		window.setVisible(true);
		window.setLocationRelativeTo(null);

		sortArray = new SortArray();
		window.add(sortArray);
		sortArray.repaint();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new SortVisualiser();
            }
        });
    }
	
}
