package sortVisualier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SortArray extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIN_WIDTH = 1280;
	public static final int WIN_HEIGHT = 720;
	private static final int BAR_WIDTH = 5;
	private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
	private int[] array;

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
			int height = array[x] * 3;
			int xBegin = x + (BAR_WIDTH - 1) * x;
			int yBegin = WIN_HEIGHT - height;

			graphics.drawLine(xBegin, yBegin, BAR_WIDTH, height);
		}

		graphics.setColor(Color.red);
		graphics.drawRect(0, 0, WIN_WIDTH, WIN_HEIGHT);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIN_WIDTH, WIN_HEIGHT);
	}
}
