package sortVisualier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Test extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED));
		panel.setForeground(Color.PINK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jpanel", "Jrfame", "Jbutton"}));
		comboBox.setBounds(153, 5, 74, 21);
		comboBox.setToolTipText("");
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("bla bla");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 45, 13);
		panel.add(lblNewLabel);
	}
}
