package sortVisualier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sortVisualiser.algorithms.BubbleSort;

public class BubbleSortVisualiser{

	private static Thread sortingThread;
	private JFrame window;
	SortArray sortArray;
	public static int delay = 5;
	
	public BubbleSortVisualiser() {
		window = new JFrame("Bubble Sort");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(400, 100, SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		//window.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout(0, 0));

		//window.setEnabled(false);
		//window.setUndecorated(true);
				
		JPanel ctPanel = new JPanel();
		ctPanel.setBounds(0, 0, SortArray.WIN_WIDTH-1,SortArray.WIN_HEIGHT);
		ctPanel.setBackground(Color.darkGray);
		ctPanel.setLayout(null);
		window.add(ctPanel);		
		
		sortArray = new SortArray();
		window.add(sortArray);
		sortArray.repaint();
		sortingThread = new Thread(new BubbleSort(sortArray));
    	sortingThread.start();
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
