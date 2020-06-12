package Algorithms;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import Visualizer.SortVisualizer;

public class SortArray extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public static final int BAR_WIDTH = 7;
	public static final int NUM_BARS = (SortVisualizer.WIN_WIDTH - 100) / (2 * BAR_WIDTH);

	private JPanel arrayWrapper;
	private JPanel[] squarePanels;
	private final int[] barColours;
	private int[] array;
	private int xLocation, yLocation, width, height;
	private int delay = 15;
	public boolean sortCompleted = false;

	public SortArray(JPanel sortJPanel) {
		arrayWrapper = sortJPanel;
		arrayWrapper.removeAll();
		barColours = new int[NUM_BARS];
		array = new int[NUM_BARS];
		squarePanels = new JPanel[NUM_BARS];

		for (int i = 0; i < NUM_BARS; i++) {
			array[i] = i;
			barColours[i] = 0;
		}
		shuffleArray();
		firstDraw();
	}

	public void firstDraw() {
		arrayWrapper.removeAll();
		for (int i = 0; i < NUM_BARS; i++) {
			squarePanels[i] = new JPanel();
			Draw(i);
			arrayWrapper.add(squarePanels[i]);
		}
		repaint();
		validate();
	}

	public void reDraw() {
		for (int i = 0; i < NUM_BARS; i++) {
			Draw(i);
		}
	}

	public void Draw(int i) {
		xLocation = 2 * i * BAR_WIDTH + 30;
		yLocation = SortVisualizer.SPANEL_HEIGHT - array[i] * 8 - 10;
		width = BAR_WIDTH;
		height = array[i] * 8;
		squarePanels[i].setBounds(xLocation, yLocation, width, height);

		if (sortCompleted == false) {
			int val = barColours[i] * 2;
			if (barColours[i] > 0)
				barColours[i] -= 10;
			squarePanels[i].setBackground(Color.white);
			squarePanels[i].setBackground(new Color(255, 255 - val, 255 - val));
		} else {
			squarePanels[i].setBackground(Color.green);
		}
	}

	public void swapUpdate(int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		squarePanels[firstIndex].removeAll();
		squarePanels[secondIndex].removeAll();
		for (int i = 0; i < NUM_BARS; i++) {
			squarePanels[i].removeAll();
		}
		barColours[firstIndex] = 50;
		barColours[secondIndex] = 50;
		reDraw();
		repaint();
		validate();
	}

	public void setUpdate(int index, int value) {
		array[index] = value;
		squarePanels[index].removeAll();
		barColours[index] = 50;
		reDraw();
		repaint();
		validate();
	}

	public void shuffleArray() {
		arrayWrapper.removeAll();
		Random rnd = new Random();
		for (int i = 0; i < NUM_BARS; i++) {
			int swapWithIndex = rnd.nextInt(NUM_BARS - 1);
			int temp = array[i];
			array[i] = array[swapWithIndex];
			array[swapWithIndex] = temp;
		}
	}

	public void checkArray() {
		for (int i = 0; i < NUM_BARS; i++) {
			barColours[i] = 0;
		}

		for (int i = 0; i < NUM_BARS; i++) {
			barColours[i] = 50;
			reDraw();
		}
	}
	
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public int arraySize() {
		return array.length;
	}

	public int getValue(int index) {
		return array[index];
	}
}
