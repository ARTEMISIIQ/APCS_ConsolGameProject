public class Pawn extends PieceClass{
  private String type = "PAWN";

  public Pawn(int HP, int xCord, int yCord){
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
      String attackCords = instructions.substring(instructions.length()-2,instructions.length());
      int attackYCord = (int) attackCords.charAt(0) - (int) 'a';
      int attackXCord = (int) attackCords.charAt(1) - (int) '1';
      System.out.println(attackXCord + ":" + attackYCord);
      System.out.println(attackXCord + ":" + attackYCord);
      if (yCord < 7){
        if (board[yCord+1][xCord] == null && attackYCord == yCord + 1 && attackXCord == xCord){
          super.setYCord(yCord+1);
        }
        if (xCord < 7){
          if (board[yCord+1][xCord+1] != null){
            System.out.println(board[yCord+1][xCord+1]);
          if (board[yCord+1][xCord+1].getHP() > 0 && attackYCord == yCord + 1 && attackXCord == xCord + 1){
            board[yCord+1][xCord+1].setHP(board[yCord+1][xCord+1].getHP() - 1);
            board[yCord+1][xCord+1].Update(board);
            if (board[yCord+1][xCord+1] == null){
              super.setYCord(yCord+1);
              super.setXCord(xCord+1);
            }
          }
          }
        }
        if (xCord > 0){
          if (board[yCord+1][xCord-1] != null){
          if (board[yCord+1][xCord-1].getHP() != 0 && attackYCord == yCord + 1 && attackXCord == xCord - 1){
            board[yCord+1][xCord-1].setHP(board[yCord+1][xCord-1].getHP() - 1);
            board[yCord+1][xCord-1].Update(board);
            if (board[yCord+1][xCord-1] == null){
              super.setYCord(yCord+1);
              super.setXCord(xCord-1);
            }
          }
        }
      }
      }
      System.out.println("Invalid Move");
  }

  public String toString(){
    return("PAWN");
  }
}
