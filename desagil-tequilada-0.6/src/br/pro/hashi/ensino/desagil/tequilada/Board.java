package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Board {
	private int height;
	private int width;

	private boolean[][] open;


	public Board(String fileName) {

		/* NAO PRECISA ENTENDER TRY POR ENQUANTO */

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();

			StringTokenizer tokenizer = new StringTokenizer(line);

			height = Integer.valueOf(tokenizer.nextToken());
			width = Integer.valueOf(tokenizer.nextToken());

			open = new boolean[height][width];

			for(int i = 0; i < height; i++) {
				line = reader.readLine();

				for(int j = 0; j < width; j++) {
					if(line.charAt(j) == ' ') {
						open[i][j] = true;
					}
					else {
						open[i][j] = false;
					}
				}
			}

			reader.close();
		}

		/* NAO PRECISA ENTENDER CATCH POR ENQUANTO */

		catch(IOException exception) {
			System.err.println("exception while loading board");
			System.exit(1);
		}
	}


	public boolean isOpen(int row, int col) {
		return open[row][col];
	}


	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
}
