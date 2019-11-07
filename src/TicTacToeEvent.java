import java.util.EventObject;

public class TicTacToeEvent extends EventObject{

	private int x, y;
	private boolean turn;
	
	public TicTacToeEvent(TicTacToeModel source, int x, int y, boolean turn) {
		super(source);
		this.x = x;
		this.y = y;
		this.turn = turn;
		
	}
	
	private int getX() {
		return x;
	}

	private int getY() {
		return y;
	}
	
	private boolean getTurn() {
		return turn;
	}
	
	

}
