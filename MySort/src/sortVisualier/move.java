package sortVisualier;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class move extends JPanel {

	int amount, actual;

	public move(int amount) {
		this.amount = amount;
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//repaint();
				if (++actual >= amount) {
					Timer t = (Timer) evt.getSource();
					t.stop();
				}
			}
		});

		timer.setRepeats(true);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
	}

}