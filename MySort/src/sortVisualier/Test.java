package sortVisualier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Test extends JFrame {
	/**
	 * @wbp.nonvisual location=-53,28
	 */
	private final JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
	private final JButton btnBlaBla = new JButton("bla bla");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
			}
		});
		setResizable(false);
		internalFrame.getContentPane().setBackground(Color.YELLOW);
		
		JButton btnBloBlo = new JButton("blo blo");
		btnBloBlo.setBackground(Color.PINK);
		internalFrame.getContentPane().add(btnBloBlo, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 708);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.add(btnBlaBla);
	}
}
