import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeView extends JFrame implements TicTacToeListener {

	private TicTacToeModel model;
	private JButton[][] board;
	private int size = TicTacToeModel.SIZE;

	public TicTacToeView(TicTacToeModel model) {
		this.model = model;
		board = new JButton[size][size];
		setLayout(new GridLayout(size, size));
		setSize(300, 300);
		initializeButtons();
		model.addTicTacToeListener(this);
		setVisible(true);

	}

	private void initializeButtons() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new JButton("");
				board[i][j].setVisible(true);
				board[i][j].addActionListener(new TicTacToeController(i, j, model));
				add(board[i][j]);
			}
		}
	}

	@Override
	public void handleTTTEvent(TicTacToeEvent e) {
		
		int i = e.getX();
		int j = e.getY();
		
		String symbol = e.getSTurn();
		Status status = e.getStatus();
		board[i][j].setText(symbol);
		
		if (status.compareTo(Status.IN_PROGRESS) != 0) {
			endGame(status);
		}
		
	}

	private void endGame(Status status) {
		JOptionPane.showMessageDialog(this, "Game Over. Winner: " + status.toString());
		this.dispose();
	}
	
	public static void main(String[] args) {
		TicTacToeModel model = new TicTacToeModel();
		TicTacToeView view = new TicTacToeView(model);
	}
}
