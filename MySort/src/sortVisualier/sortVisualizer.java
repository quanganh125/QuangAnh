package sortVisualier;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sortVisualiser.algorithms.BubbleSort;

public class sortVisualizer extends JFrame {

	private static Thread sortingThread;
	private JPanel window;
	private SortArray sortArray;
	public static int sleep = 10;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sortVisualizer frame = new sortVisualizer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sortVisualizer() {
		setTitle("sort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(300, 50, SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT+70);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		window = new JPanel();
		window.setBounds(1, 1, SortArray.WIN_WIDTH-2,SortArray.WIN_HEIGHT);
		window.setBackground(Color.black);
		sortArray = new SortArray();
		window.add(sortArray);
		sortArray.repaint();
		sortingThread = new Thread(new BubbleSort(sortArray));
    	sortingThread.start();
		contentPane.add(window);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(1,SortArray.WIN_HEIGHT , SortArray.WIN_WIDTH-2, SortArray.WIN_HEIGHT+70);
		controlPanel.setBackground(Color.red);
		contentPane.add(controlPanel);
	}
}
