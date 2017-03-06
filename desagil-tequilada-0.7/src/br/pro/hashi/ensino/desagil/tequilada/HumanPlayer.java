package br.pro.hashi.ensino.desagil.tequilada;


public class HumanPlayer extends Player {
	private Board board;

	public HumanPlayer(Board board, int row, int col) {
		super(row, col);

		this.board = board;
	}

    public void move(int rowShift, int colShift) {
        if(board.isOpen(row + rowShift, col + colShift)) {
        	row += rowShift;
        	col += colShift;
        }
    }
}
