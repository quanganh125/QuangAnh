package sortVisualier;

import javax.swing.JFrame;

public class SortVisualiser {
	public static final int WIN_WIDTH = 1200;
	public static final int WIN_HEIGHT = 720;
	
	private JFrame windowFrame;
	
	public SortVisualiser() {
		windowFrame = new JFrame("Sort Visualiser");
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(WIN_WIDTH,WIN_HEIGHT);
		windowFrame.setVisible(true);
	}
	
	public static void main(String []args) {
		SortVisualiser sortVisualiser = new SortVisualiser();
		sortVisualiser.toString();
	}
}
