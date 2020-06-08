package sortVisualier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import sortVisualiser.algorithms.BubbleSort;

public class BubbleSortVisualiser{

	private static Thread sortingThread;
	private JFrame window;
	private SortArray sortArray;
	public static int sleep = 10;
	
	public BubbleSortVisualiser() {
		window = new JFrame("Bubble Sort");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(400, 100, SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		//window.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout(0, 0));
		window.setEnabled(false);
		//window.setUndecorated(true);
		
		JFrame controlFrame = new JFrame();
    	controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//controlFrame.setSize(SortArray.WIN_WIDTH, 50);
		controlFrame.setBounds(400, 150, SortArray.WIN_WIDTH,50);
		controlFrame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				controlFrame.setBounds(400, 150, SortArray.WIN_WIDTH,50);
			}
		});
		controlFrame.setVisible(true);
		controlFrame.getContentPane().setBackground(Color.darkGray);
		controlFrame.setResizable(false);
		
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
