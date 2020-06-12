package Algorithms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Visualizer.HTVisualizer;

public class DrawTower extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JPanel towerWrapper;
	
	Color[] colors = { Color.WHITE, Color.BLUE, Color.RED, Color.YELLOW, Color.CYAN, Color.GREEN, Color.PINK,
			Color.ORANGE };
	private int xLocation, yLocation, width, height;
	public Tower towerA,towerB,towerC;

	public DrawTower(JPanel mainMenu) {
		towerWrapper = mainMenu;
		drawFrame();
		firstCreate();
	}
	
	public void firstCreate() {
		System.out.println(HTVisualizer.TOWER_HEIGHT);
		towerA = new Tower(HTVisualizer.TOWER_HEIGHT, HTVisualizer.TOWER_HEIGHT);
		towerB = new Tower(HTVisualizer.TOWER_HEIGHT, 0);
		towerC = new Tower(HTVisualizer.TOWER_HEIGHT, 0);
		
		towerWrapper.removeAll();
		drawFrame();
		
		for (int i = 0; i < towerA.getCurrentHeight(); i++) {
			towerA.setLayerSize(i, i);
		}
		
		for (int index = 0; index < towerA.getCurrentHeight(); index++) {
			drawLayer(towerA, index);
			towerWrapper.add(towerA.squarePanels[index]);
		}
		
		repaint();
		validate();
	}
	
	public void createTower(Tower temp) {
		
		towerWrapper.removeAll();
		drawFrame();
		for (int i = 0; i < temp.getCurrentHeight(); i++) {
			temp.setLayerSize(i, i);
			temp.squarePanels[i] = new JPanel();
			drawLayer(temp,i);
			towerWrapper.add(temp.squarePanels[i]);
		}
		repaint();
		validate();
	}
	

	public void drawLayer(Tower tmp,int index) {
		tmp.squarePanels[index] = new JPanel();
		this.xLocation = 230 - 15 * (8 - tmp.getLayerSize(index));
		this.yLocation = 530 - 30 * tmp.getLayerSize(index);
		this.width = 240 - 15 * tmp.getLayerSize(index) *2;
		this.height = 25;
		
		tmp.squarePanels[index].setBackground(colors[index]);
		tmp.squarePanels[index].setBounds(xLocation, yLocation, width, height);
	}
	
	public void drawFrame() {
		JPanel fundamental = new JPanel();
		fundamental.setForeground(new Color(0, 0, 205));
		fundamental.setBackground(new Color(30, 144, 255));
		fundamental.setBounds(70, 550, HTVisualizer.WIN_WIDTH - 140, 20);
		towerWrapper.add(fundamental);
		
		JPanel TowerA = new JPanel();
		TowerA.setBounds(225, 240, 10, 310);
		towerWrapper.add(TowerA);
		
		JPanel TowerB = new JPanel();
		TowerB.setBounds(500, 240, 10, 310);
		towerWrapper.add(TowerB);
		
		JPanel TowerC = new JPanel();
		TowerC.setBounds(775, 240, 10, 310);
		towerWrapper.add(TowerC);
		
		JLabel TowerName1 = new JLabel("A");
		TowerName1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		TowerName1.setForeground(Color.PINK);
		TowerName1.setLabelFor(TowerA);
		TowerName1.setBounds(225, 210, 20, 15);
		towerWrapper.add(TowerName1);
		
		JLabel TowerName2 = new JLabel("B");
		TowerName2.setLabelFor(TowerB);
		TowerName2.setForeground(Color.PINK);
		TowerName2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		TowerName2.setBounds(500, 210, 20, 15);
		towerWrapper.add(TowerName2);
		
		JLabel TowerName3 = new JLabel("C");
		TowerName3.setLabelFor(TowerC);
		TowerName3.setForeground(Color.PINK);
		TowerName3.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		TowerName3.setBounds(775, 210, 20, 15);
		towerWrapper.add(TowerName3);
		repaint();
		validate();
	}
}
