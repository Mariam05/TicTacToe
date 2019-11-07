import java.util.List;

public class TicTacToeModel {

	public static final int SIZE = 3;
	private String[][] grid;
	private boolean turn;
	private List<TicTacToeListener> tttmodels;

	public TicTacToeModel() {
		grid = new String[SIZE][SIZE];
		turn = true;

	}

	public void play(int x, int y) {
		grid[x][y] = turn ? "X" : "O";
		String winner = checkWinner();
		if (winner != null) {
			System.out.println("Game over. Winner: " + winner);
		}
		TicTacToeEvent e = new TicTacToeEvent(this, x, y, turn);
		for (TicTacToeListener tttl : tttmodels) {
			tttl.handleTTTEvent(e);
		}

	}

	public void addTicTacToeListener(TicTacToeListener tttl) {
		tttmodels.add(tttl);
	}

	private String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = grid[0][0] + grid[0][1] + grid[0][2]; // first row
				break;
			case 1:
				line = grid[1][0] + grid[1][1] + grid[1][2]; // second row
				break;
			case 2:
				line = grid[2][0] + grid[2][1] + grid[2][2]; // third row
				break;
			case 3:
				line = grid[0][0] + grid[1][0] + grid[2][0]; // first col
				break;
			case 4:
				line = grid[0][1] + grid[1][1] + grid[2][1]; // second col
				break;
			case 5:
				line = grid[0][2] + grid[1][2] + grid[2][2]; // third col
				break;
			case 6:
				line = grid[0][0] + grid[1][1] + grid[2][2]; // diagonal top left to bottom right
				break;
			case 7:
				line = grid[0][2] + grid[1][1] + grid[2][0]; // diagonal top right to bottom left
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (grid[i][j] == null)
					break;
			}
			return "draw";
		}
		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	/**
	 * Put numbers on the board's squares that the player can references.
	 */
	private void populateEmptyBoard() {
		int a = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = String.valueOf(++a);
			}
		}
	}
}
