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
import javax.swing.border.LineBorder;

import Algorithms.DrawTower;

public class HTVisualizer extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIN_WIDTH = 1000;
	public static final int WIN_HEIGHT = 700;
	public static final int CPANEL_WIDTH = 800;
	public static final int CPANEL_HEIGHT = 70;
	public static final int SPANEL_HEIGHT = WIN_HEIGHT - CPANEL_HEIGHT;
	public static int TOWER_HEIGHT = 4;

	private JPanel contentPane;
	public JPanel mainPanel;
	private JPanel controlPanel;

	private JButton generateTower;
	private JButton start;
	private DrawTower myTower;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HTVisualizer frame = new HTVisualizer();
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
	public HTVisualizer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 50, WIN_WIDTH, WIN_HEIGHT + 35);
		setResizable(false);
		setTitle("HaNoi Tower Visualier");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(0, 0, 996, 622);
		mainPanel.setBorder(new LineBorder(new Color(153, 180, 209)));
		mainPanel.setLayout(null);
		contentPane.add(mainPanel);
		myTower = new DrawTower(mainPanel);

		controlPanel = new JPanel();
		controlPanel.setBackground(Color.DARK_GRAY); // new Color(0, 139, 139));
		controlPanel.setBounds(0, 619, 996, 88);
		controlPanel.setBorder(new LineBorder(new Color(153, 180, 209)));
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);

		generateTower = new JButton("Generate Tower");
		generateTower.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTower = new DrawTower(mainPanel);
				repaint();
			}
		});
		generateTower.setBounds(450, 35, 150, 25);
		controlPanel.add(generateTower);

		start = new JButton("Start");
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		start.setBounds(671, 35, 90, 25);
		controlPanel.add(start);

		JComboBox<String> boxAmount = new JComboBox<String>();
		boxAmount.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
		boxAmount.addActionListener(e -> {
			if (boxAmount.getSelectedItem() == "1")
				this.TOWER_HEIGHT = 1;
			else if (boxAmount.getSelectedItem() == "2")
				this.TOWER_HEIGHT = 2;
			else if (boxAmount.getSelectedItem() == "3")
				this.TOWER_HEIGHT = 3;
			else if (boxAmount.getSelectedItem() == "4")
				this.TOWER_HEIGHT = 4;
			else if (boxAmount.getSelectedItem() == "5")
				this.TOWER_HEIGHT = 5;
			else if (boxAmount.getSelectedItem() == "6")
				this.TOWER_HEIGHT = 6;
			else if (boxAmount.getSelectedItem() == "7")
				this.TOWER_HEIGHT = 7;
			else
				this.TOWER_HEIGHT = 8;
		});
		boxAmount.setBounds(325, 35, 50, 25);
		controlPanel.add(boxAmount);

		JLabel lblNewLabel = new JLabel("Tower's height:");
		lblNewLabel.setBounds(215, 35, 100, 25);
		lblNewLabel.setForeground(Color.white);
		controlPanel.add(lblNewLabel);

	}
}
