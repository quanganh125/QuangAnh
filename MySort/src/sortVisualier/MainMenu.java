package sortVisualier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {

	private JFrame frmMiniProjectGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmMiniProjectGroup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMiniProjectGroup = new JFrame();
		frmMiniProjectGroup.setForeground(Color.LIGHT_GRAY);
		frmMiniProjectGroup.setBackground(Color.LIGHT_GRAY);
		frmMiniProjectGroup.setTitle("Mini Project group 4");
		frmMiniProjectGroup.setBounds(100, 100, 398, 214);
		frmMiniProjectGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel main = new JPanel();
		frmMiniProjectGroup.getContentPane().add(main, BorderLayout.CENTER);
		
		JButton bubble = new JButton("Bubble Sort");
		bubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bubble.setForeground(Color.RED);
		bubble.setBackground(Color.GRAY);
		main.add(bubble);
		
		JButton shell = new JButton("Shell Sort");
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		shell.setForeground(Color.RED);
		shell.setBackground(Color.GRAY);
		main.add(shell);
		
		JButton tower = new JButton("HaNoi Tower");
		tower.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tower.setForeground(Color.RED);
		tower.setBackground(Color.GRAY);
		main.add(tower);
	}

}
