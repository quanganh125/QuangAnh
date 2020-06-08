package Algorithms;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import Visualizer.SortVisualizer;

public class SortArray extends JPanel {
	/**
	 * 
	 */
	private static Thread sortingThread;
	private static final long serialVersionUID = 1L;
	public static final int BAR_WIDTH = 7;
	public static final int NUM_BARS = (SortVisualizer.WIN_WIDTH - 100) / (2 * BAR_WIDTH);

	private JPanel arrayWrapper;
	private JPanel[] squarePanels;
	private int[] array;
	private int xLocation, yLocation, width, height;
	private boolean insort = false;

	public SortArray(JPanel sortJPanel) {
		arrayWrapper = sortJPanel;
		arrayWrapper.removeAll();

		array = new int[NUM_BARS];
		squarePanels = new JPanel[NUM_BARS];

		for (int i = 0; i < NUM_BARS; i++) {
			array[i] = i;
		}
		shuffleArray();
		reDraw();
		sortingThread = new Thread(new ShellSort(this));
    	sortingThread.start();
		//new BubbleSort(this);
	}

	public void reDraw() {
		arrayWrapper.removeAll();
		for (int i = 0; i < NUM_BARS; i++) {
			squarePanels[i] = new JPanel();
			Draw(i);
		}
		repaint();
	}
	
	public void Draw(int i) {
		
		xLocation = 2 * i * BAR_WIDTH + 30;
		yLocation = SortVisualizer.SPANEL_HEIGHT - array[i] * 8 - 10;
		width = BAR_WIDTH;
		height = array[i] * 8;
		squarePanels[i].setBounds(xLocation, yLocation, width, height);
		if(insort)
			squarePanels[i].setBackground(Color.blue);
		else squarePanels[i].setBackground(Color.white);
		
		arrayWrapper.add(squarePanels[i]);
	}

	public int arraySize() {
		return array.length;
	}

	public int getValue(int index) {
		return array[index];
	}

	public void swapUpdate(int firstIndex, int secondIndex) {
		insort = true;
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		
		squarePanels[firstIndex].removeAll();
		squarePanels[secondIndex].removeAll();
		Draw(firstIndex);
		Draw(secondIndex);
		repaint();
		insort = false;
	}

	public void setUpdate(int index, int value) {
		insort = true;
		array[index] = value;
		squarePanels[index].removeAll();
		Draw(index);
		repaint();
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
}
