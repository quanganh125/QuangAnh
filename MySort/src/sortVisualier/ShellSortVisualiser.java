package sortVisualier;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ShellSortVisualiser {

	private JFrame window;
	private SortArray sortArray;

	public ShellSortVisualiser() {
		window = new JFrame("Shell Sort");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		window.setVisible(true);
		window.setLocationRelativeTo(null);

		sortArray = new SortArray();
		sortArray.runShellSort();
		window.add(sortArray);
		sortArray.repaint();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new ShellSortVisualiser();
            }
        });
    }
	
}