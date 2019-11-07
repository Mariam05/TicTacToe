import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToeView extends JFrame {

	private TicTacToeModel model;
	private JButton[][] board;
	private int size = TicTacToeModel.SIZE;
	
	
	public TicTacToeView(TicTacToeModel model) {
		this.model = model;
		board = new JButton[size][size];
		setLayout(new GridLayout(size, size));
		setSize(300, 300);
		initializeButtons();
		setVisible(true);
			
	}
	
	private void initializeButtons() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j< size; j++) {
				board[i][j] = new JButton("");
				board[i][j].setVisible(true);
				board[i][j].addActionListener(new TicTacToeController(i, j, model));
				add(board[i][j]);
			}
		}
	}
	

	public static void main(String[] args) {
		TicTacToeModel model = new TicTacToeModel();
		TicTacToeView view = new TicTacToeView(model);
	}
}
