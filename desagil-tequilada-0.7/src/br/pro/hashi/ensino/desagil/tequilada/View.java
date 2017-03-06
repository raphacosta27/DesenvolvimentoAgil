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
	private Image targetImage;

	private Board board;

	private HumanPlayer humanPlayer;
	private CpuPlayer cpuPlayer;
	
	private Target target;


	public View() {
		cellSize = 50;

		board = new Board("board.txt");

		int width = board.getWidth();
		int height = board.getHeight();

		setPreferredSize(new Dimension(width * cellSize, height * cellSize));

		humanPlayerImage = loadImage("humanPlayer");
		cpuPlayerImage = loadImage("cpuPlayer");
		targetImage = loadImage("target");

		humanPlayer = new HumanPlayer(board, 0, 0);
		cpuPlayer = new CpuPlayer(height - 1, width - 1);
		
		 target = new Target(4, 14);

	}


	public void update() {
		cpuPlayer.move(0, -1);
		repaint();
	}


	/* NAO PRECISA ENTENDER O METODO ABAIXO POR ENQUANTO */

	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	private void drawImage(Graphics g, Image image, Element element) {
		g.drawImage(image, element.getCol() * cellSize, element.getRow() * cellSize, cellSize, cellSize, null);
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

		drawImage(g, humanPlayerImage, humanPlayer);
		drawImage(g, cpuPlayerImage, cpuPlayer);
		drawImage(g, targetImage, target);
		/* NAO PRECISA ENTENDER A LINHA ABAIXO POR ENQUANTO */

		getToolkit().sync();
    }
}
