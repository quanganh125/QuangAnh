package Algorithms;

import Visualizer.HTVisualizer;

public class HanoiTower implements Runnable {
	private DrawTower tower;

	public HanoiTower(DrawTower tower) {
		this.tower = tower;
	}

	@Override
	public void run() {
		move(HTVisualizer.TOWER_HEIGHT, tower.towerA, tower.towerB, tower.towerC);
	}

	public void move(int number, Tower from, Tower inner, Tower to) {
		if (number == 1) {
			// TODO reDraw
			tower.reDraw(from, to);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			move(number - 1, from, to, inner);
			// TODO reDraw
			tower.reDraw(from, to);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move(number - 1, inner, from, to);
		}
	}
}