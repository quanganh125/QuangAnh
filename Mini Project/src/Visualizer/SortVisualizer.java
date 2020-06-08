package Visualizer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Algorithms.SortArray;

public class SortVisualizer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIN_WIDTH = 800;
	public static final int WIN_HEIGHT = 500;
	public static final int CPANEL_WIDTH = 800;
	public static final int CPANEL_HEIGHT = 70;
	public static final int SPANEL_HEIGHT = WIN_HEIGHT - CPANEL_HEIGHT;
	
	private JPanel contentPane;
	private JPanel sortPanel;
	private JPanel controlPanel ;

	private JButton generateArray;
	private JButton startSort;
	
	private SortArray sortArray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortVisualizer frame = new SortVisualizer();
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
	public SortVisualizer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, WIN_WIDTH, WIN_HEIGHT+35);
		setResizable(false);
		setTitle("Sort Visualier");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sortPanel = new JPanel();	
		sortPanel.setBackground(new Color(0, 128, 128));
		sortPanel.setBounds(0,0, WIN_WIDTH, SPANEL_HEIGHT);
		sortPanel.setLayout(null);
		contentPane.add(sortPanel);
		
		controlPanel = new JPanel();
		controlPanel.setBackground(new Color(0, 139, 139));
		controlPanel.setBounds(0, SPANEL_HEIGHT, WIN_WIDTH, CPANEL_HEIGHT);
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);
		
		generateArray = new JButton("Generate Array");
		generateArray.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sortArray = new SortArray(sortPanel);
				//new BubbleSort(sortArray);
				sortPanel.add(sortArray);
				repaint();
			}
		});
		generateArray.setBounds(140, 25, 120, 25);
		controlPanel.add(generateArray);	
		
		startSort = new JButton("Start Sort");
		startSort.setBounds(582, 25, 90, 25);
		controlPanel.add(startSort);

		
		JComboBox<String> boxSpeed = new JComboBox<String>();
		boxSpeed.setModel(new DefaultComboBoxModel<String>(new String[] {"Fast", "Medium", "Slow"}));
		boxSpeed.setBounds(348, 25, 90, 25);
		controlPanel.add(boxSpeed);
		
		JLabel lblNewLabel = new JLabel("Speed");
		lblNewLabel.setBounds(310, 25, 40, 25);
		controlPanel.add(lblNewLabel);
		
		JComboBox<String> boxAlgorithms = new JComboBox<String>();
		boxAlgorithms.setModel(new DefaultComboBoxModel<String>(new String[] {"Bubble Sort", "Shell Sort"}));
		boxAlgorithms.setBounds(480, 25, 100, 25);
		controlPanel.add(boxAlgorithms);
	}
}
