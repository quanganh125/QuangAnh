package sortVisualier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class SortArray extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIN_WIDTH = 800;
	public static final int WIN_HEIGHT = 500;
	private static final int BAR_WIDTH = 5;
	private static final int NUM_BARS = (WIN_WIDTH-110) / (BAR_WIDTH*2);
	private int[] array;
	private final int[] barColours;
	int delay;

	public void perform() {
		repaint();
	}

	public int arraySize() {
		return array.length;
	}

	public int getValue(int index) {
		return array[index];
	}

	public void swapUpdate(int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		barColours[firstIndex] = 50;
		barColours[secondIndex] = 50;
		repaint();
	}

	public void setUpdate(int firstIndex, int value) {
		array[firstIndex] = value;
		barColours[firstIndex] = 50;
		repaint();
	}

	public void shuffleArray() {
		Random rnd = new Random();
		for (int i = 0; i < NUM_BARS; i++) {
			int swapWithIndex = rnd.nextInt(NUM_BARS - 1);
			int temp = array[i];
			array[i] = array[swapWithIndex];
			array[swapWithIndex] = temp;
		}

		setBackground(Color.darkGray);
	}

	public SortArray() {
		array = new int[NUM_BARS];
		barColours = new int[NUM_BARS];
		for (int i = 0; i < NUM_BARS; i++) {
			array[i] = i;
			barColours[i] = 0;
		}
		setBackground(Color.darkGray);
		shuffleArray();

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		super.paintComponent(graphics);
		for (int x = 0; x < NUM_BARS; x++) {
			int height = array[x] * 6;
			int xBegin = 10 + x + (2* BAR_WIDTH) * x;
			int yBegin = WIN_HEIGHT - height - 50;

			int val = barColours[x] * 2;
			if (barColours[x] > 0)
				barColours[x] -= 10;
			graphics.setColor(Color.white);
			graphics.setColor(new Color(255, 255 - val, 255 - val));
			graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);

			graphics.setColor(Color.red);
			graphics.drawRect(0, 0, WIN_WIDTH + 10, WIN_HEIGHT + 10);
		}
	}
}
