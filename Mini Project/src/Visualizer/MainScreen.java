package Visualizer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainScreen extends JFrame {
	/**
	 * Quang Anh
	 */
	private static final long serialVersionUID = 1L;
	private JPanel homeView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 337);
		setUndecorated(true);
	
		homeView = new JPanel();	
		homeView.setBackground(new Color(47, 79, 79));
		homeView.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(homeView);
		homeView.setLayout(null);
		
		JPanel Color = new JPanel();
		Color.setBackground(new Color(0, 128, 128));
		Color.setBounds(2, 2, 167, 333);
		homeView.add(Color);
		
		JButton btnSort = new JButton("SORT VISUALISER");
		btnSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
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
		});
		btnSort.setForeground(new Color(220, 20, 60));
		btnSort.setBackground(new Color(222, 184, 135));
		btnSort.setBounds(180, 60, 150, 66);
		homeView.add(btnSort);
		
		
		JButton btnTower = new JButton("HANOI TOWER");
		btnTower.setForeground(new Color(178, 34, 34));
		btnTower.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SortVisualizer();
			}
		});
		btnTower.setBackground(new Color(222, 184, 135));
		btnTower.setBounds(179, 220, 150, 66);
		homeView.add(btnTower);
	}

}
