import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {

	private TicTacToeModel model;
	private int i, j;

	public TicTacToeController(int i, int j, TicTacToeModel model) {
		this.model = model;
		this.i = i;
		this.j = j;
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
