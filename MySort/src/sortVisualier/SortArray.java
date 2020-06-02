package sortVisualier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class SortArray extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIN_WIDTH = 1000;
	public static final int WIN_HEIGHT = 600;
	private static final int BAR_WIDTH = 5;
	private static final int NUM_BARS = (WIN_WIDTH -110) / (BAR_WIDTH*2);
	private int[] array;

	public void shuffleArray() {
		Random rnd = new Random();
		for (int i = 0; i < NUM_BARS; i++) {
			int swapWithIndex = rnd.nextInt(NUM_BARS -1 );
			int temp = array[i];
			array[i] = array[swapWithIndex];
			array[swapWithIndex] = temp;
		}

		setBackground(Color.darkGray);
	}
	
	public SortArray() {
		array = new int[NUM_BARS];
		for (int i = 0; i < NUM_BARS; i++) {
			array[i] = i;
		}

		setBackground(Color.darkGray);
	} 

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		super.paintComponent(graphics);

		graphics.setColor(Color.white);
		for (int x = 0; x < NUM_BARS; x++) {
			int height = array[x] * 5;
			int xBegin =  10+ x + (2*BAR_WIDTH) * x;
			int yBegin = WIN_HEIGHT - height - 50;

			graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
		}

		graphics.setColor(Color.red);
		graphics.drawRect(0, 0, WIN_WIDTH+10, WIN_HEIGHT+10);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIN_WIDTH, WIN_HEIGHT);
	}
}
