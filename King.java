public class King extends PieceClass {
	private String type = "KING";
	public King(int HP, int xCord, int yCord){
		super(HP, xCord, yCord);
	}
	public void Update(PieceClass[][] board){
		if (super.getHP() <= 0){
			board[yCord][xCord] = null;
		}
	}

	public void Movement(PieceClass[][] board, String instructions){
		int xCord = super.getXCord();
		int yCord = super.getYCord();
		String attackCords = instructions.substring(instructions.length()-2);
		int attackYCord = (int) attackCords.charAt(0) - (int) 'a';
		int attackXCord = (int) attackCords.charAt(1) - (int) '1';

		int dx = attackXCord - xCord;
		int dy = attackYCord - yCord;
		int xStep = 0;
		int yStep = 0;
		if ((Math.abs(dx) > 1) || (Math.abs(dy) > 1) || (dx == 0 && dy == 0)){
			System.out.println("Invalid Move");
			return;
		}
		if (dx != 0){
			xStep = dx / Math.abs(dx);
		}
		if (dy != 0){
			yStep = dy / Math.abs(dy);
		}
		int checkX = xCord + xStep;
		int checkY = yCord + yStep;

		if (board[attackYCord][attackXCord] == null){
			board[yCord][xCord] = null;
			super.setXCord(attackXCord);
			super.setYCord(attackYCord);
			board[attackYCord][attackXCord] = this;
			return;
		} else {
			board[attackYCord][attackXCord].setHP(board[attackYCord][attackXCord].getHP() - 1);
			board[attackYCord][attackXCord].Update(board);
			if (board[attackYCord][attackXCord] == null){
				board[yCord][xCord] = null;
				super.setXCord(attackXCord);
				super.setYCord(attackYCord);
				board[attackYCord][attackXCord] = this;
				return;
			}
		}
		System.out.println("Invalid Move");
	}
	public String toString(){
		return "KING";
	}
}
