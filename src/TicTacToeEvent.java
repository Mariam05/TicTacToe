import java.util.EventObject;

public class TicTacToeEvent extends EventObject{

	private int x, y;
	private boolean turn;
	private String sTurn;
	private Status status;
	
	public TicTacToeEvent(TicTacToeModel source, int x, int y, String sTurn, Status status) {
		super(source);
		this.x = x;
		this.y = y;
		this.status = status;
		this.sTurn = sTurn;
		
	}
	
	public Status getStatus() {
		return status;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public String getSTurn() {
		return sTurn;
	}

}
