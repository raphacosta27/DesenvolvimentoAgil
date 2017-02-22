package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class View extends JPanel {
	private static final long serialVersionUID = 1L;

	/* NAO PRECISA ENTENDER AS LINHAS ACIMA POR ENQUANTO */


	private int cellSize;

	private Image humanPlayerImage;
	private Image cpuPlayerImage;

	private Board board;

	private Player humanPlayer;
	private Player cpuPlayer;


	public View() {
		cellSize = 50;

		board = new Board("board.txt");

		int width = board.getWidth();
		int height = board.getHeight();

		setPreferredSize(new Dimension(width * cellSize, height * cellSize));

		humanPlayerImage = loadImage("humanPlayer");
		cpuPlayerImage = loadImage("cpuPlayer");

		humanPlayer = new Player(0, 0);
		cpuPlayer = new Player(height - 1, width - 1);

		update();
	}


	private void update() {
		cpuPlayer.move(0, -1);
	}


	/* NAO PRECISA ENTENDER O METODO ABAIXO POR ENQUANTO */

	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	private void drawImage(Graphics g, Image image, int row, int col) {
    	g.drawImage(image, col * cellSize, row * cellSize, cellSize, cellSize, null);
	}


	/* NAO PRECISA ENTENDER OVERRIDE E PUBLIC POR ENQUANTO */

	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if(board.isOpen(i, j) == true) {
					g.setColor(Color.WHITE);
				}
				else {
					g.setColor(Color.BLACK);
				}

				g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
			}
		}

		drawImage(g, humanPlayerImage, humanPlayer.getRow(), humanPlayer.getCol());
		drawImage(g, cpuPlayerImage, cpuPlayer.getRow(), cpuPlayer.getCol());

		/* NAO PRECISA ENTENDER A LINHA ABAIXO POR ENQUANTO */

		getToolkit().sync();
    }
}
