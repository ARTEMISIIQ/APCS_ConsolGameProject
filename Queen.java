public class Queen extends PieceClass {
	public String type = "QUEEN";
	public Queen(int HP, int xCord, int yCord){
		super(HP, xCord, yCord);
	}
	
	public void update(PieceClass[][] board){
		if (super.getHP() <= 0){
			board[yCord][xCord] = null;
		}
	}

	public void Movement(PieceClass[][] board, String instructions){
		int xCord = super.getXCord();
		int yCord = super.getYCord();
		String attackCord = instructions.substring(instructions.length()-2);
		int attackYCord = (int) attackCords.charAt(0) - (int) 'a';
		int attackXCord = (int) attackCords.charAt(1) - (int) '1';
		int dx = attackXcord - xCord;
		int dy = attackYcord - yCord;
		int xStep = 0;
		int yStep = 0;
		if (dy == 0 && dx != 0){
			xStep = dx / Math.abs(dx);
		} else if (dx == 0 && dy != 0){
			yStep = dy / Math.abs(dy);
		} else if (Math.abs(dx) == Math.abs(dy)){
			xStep = dx / Math.abs(dx);
			yStep = dy / Math.abs(dy);
		} else {
			System.out.println("Invalid Move");
			return;
		}

		int checkX = xCord + xStep;
		int checkY = yCord + yStep;
		while (checkX != attackXCord || checkY != attackYCord){
			if (board[checkY][checkX] != null){
				System.out.println("Invalid Move");
				return;
			}
			checkX += xStep;
			checkY += yStep;
		}

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
		return "QUEEN";
	}
}
		

