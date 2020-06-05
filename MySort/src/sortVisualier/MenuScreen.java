package sortVisualier;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuScreen extends JFrame {

	private JPanel homeView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuScreen frame = new MenuScreen();
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
	public MenuScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 337);
		setUndecorated(true);
		homeView = new JPanel();	
		//homeView.addMouseListener(new );
		homeView.setBackground(new Color(47, 79, 79));
		homeView.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(homeView);
		homeView.setLayout(null);
		
		JPanel Color = new JPanel();
		Color.setBackground(new Color(0, 128, 128));
		Color.setBounds(2, 2, 167, 333);
		homeView.add(Color);
		
		JButton btnBubble = new JButton("BUBBLE SORT");
		btnBubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SortVisualiser();
			}
		});
		btnBubble.setForeground(new Color(220, 20, 60));
		btnBubble.setBackground(new Color(222, 184, 135));
		btnBubble.setBounds(180, 60, 150, 66);
		homeView.add(btnBubble);
		
		JButton btnShell = new JButton("SHELL SORT");
		btnShell.setForeground(new Color(220, 20, 60));
		btnShell.setBackground(new Color(222, 184, 135));
		btnShell.setBounds(180, 140, 150, 66);
		homeView.add(btnShell);
		
		JButton btnTower = new JButton("HANOI TOWER");
		btnTower.setForeground(new Color(178, 34, 34));
		btnTower.setBackground(new Color(222, 184, 135));
		btnTower.setBounds(179, 220, 150, 66);
		homeView.add(btnTower);
	}

//	private class PanelButtonMouse extends MouseAdapter {
//		JPanel panel;
//
//		public PanelButtonMouse(JPanel panel) {
//			this.panel = panel;
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			panel.setBackground(new Color(112, 128, 144));
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			panel.setBackground(new Color(60, 179, 113));
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			panel.setBackground(new Color(112, 128, 144));
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			panel.setBackground(new Color(47, 79, 79));
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			panel.setBackground(new Color(60, 179, 113));
//		}
//	}
}
