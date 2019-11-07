import java.util.ArrayList;
import java.util.List;

/**
 * Simple model for TicTacToe (ie. game logic)
 * 
 * 
 * @author Mariam 
 * @version 1.0
 */
public class TicTacToeModel {

	public static final int SIZE = 3;
	private String[][] grid;
	private boolean turn;
	private List<TicTacToeListener> tttmodels;

	public TicTacToeModel() {
		grid = new String[SIZE][SIZE];
		tttmodels = new ArrayList<>();
		turn = true;

	}

	public void play(int x, int y) {
		grid[x][y] = turn ? "X" : "O";

		Status status = checkWinner();
		
		if (status.compareTo(Status.IN_PROGRESS) !=0 ) {
			//System.out.println("Game over. Winner: " + status);
		}

		TicTacToeEvent e = new TicTacToeEvent(this, x, y, grid[x][y], status);

		for (TicTacToeListener tttl : tttmodels) {
			tttl.handleTTTEvent(e);
		}

		turn = !turn;

	}

	public void addTicTacToeListener(TicTacToeListener tttl) {
		tttmodels.add(tttl);
	}

	private Status checkWinner() {
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
				return Status.X;
			} else if (line.equals("OOO")) {
				return Status.O;
			}
		}

		return isDraw();
	}

	/**
	 * A draw occurs if there are no more empty spaces in the grid 
	 * and no winner
	 * @return
	 */
	private Status isDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (grid[i][j] == null)
					return Status.IN_PROGRESS;
			}
		}
		return Status.DRAW;
	}

}
