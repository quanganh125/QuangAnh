package Algorithms;

import javax.swing.JPanel;

public class Tower {
	private int[] layerSize;
	private int currentHeight;
	public JPanel[] squarePanels;

	public Tower(int maxHeight, int currentHeight) {
		this.layerSize = new int[maxHeight];
		this.currentHeight = currentHeight;
		this.squarePanels = new JPanel[maxHeight];
	}

	public int[] getLayer() {
		return layerSize;
	}

	public void setLayerSize(int[] layer) {
		this.layerSize = layer;
	}

	public int getCurrentHeight() {
		return currentHeight;
	}

	public void setCurrentHeight(int currentHeight) {
		this.currentHeight = currentHeight;
	}

	public int getLayerSize(int index) {
		return this.layerSize[index];
	}

	public void setLayerSize(int index, int value) {
		this.layerSize[index] = value;
	}

	public JPanel getSPIndex(int index) {
		return this.squarePanels[index];
	}
}
