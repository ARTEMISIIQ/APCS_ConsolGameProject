public class Pawn extends PieceClass{

  public Pawn(int xCord, int yCord, int team){
    super(1, xCord, yCord, team, "Pawn");
  }

  public boolean Movement(PieceClass[][] board, String instructions){
      int xCord = super.getXCord();
      int yCord = super.getYCord();
      String attackCords = instructions.substring(instructions.length()-2,instructions.length());
      int attackXCord = (int) attackCords.charAt(0) - (int) 'a';
      int attackYCord = (int) attackCords.charAt(1) - (int) '1';
      if (attackXCord < 0 || attackXCord > 7 || attackYCord < 0 || attackYCord > 7){
          System.out.println("Out of Bounds");
          ChessRPG.turn--;
          return false;
      }
      try {
          if (super.getTeam() != board[attackYCord][attackXCord].getTeam()){
              System.out.println("Invalid Move");
              return false;
          }
      }
      catch (Exception e){};
      if (team == 0) {
          if (board[yCord + 1][xCord] == null && attackYCord == yCord + 1 && attackXCord == xCord) {
              board[yCord][xCord] = null;
              super.setYCord(yCord + 1);
              board[yCord+1][xCord] = this;
              return true;
          }
          if (xCord < 7) {
              PieceClass diagonalRight = board[yCord + 1][xCord + 1];
              if (diagonalRight != null) {
                  if (attackYCord == yCord + 1 && attackXCord == xCord + 1) {
                      diagonalRight.setHP(diagonalRight.getHP() - 1);
                      diagonalRight.Update(board);
                      if (board[yCord + 1][xCord + 1] == null) {
                          board[super.getYCord()][super.getXCord()] = null;
                          super.setYCord(yCord + 1);
                          super.setXCord(xCord + 1);
                      }
                      board[super.getYCord()][super.getXCord()] = this;
                      return true;
                  }
              }
          }
          if (xCord > 0) {
              PieceClass diagonalLeft = board[yCord + 1][xCord - 1];
              if (diagonalLeft != null) {
                  if (attackYCord == yCord + 1 && attackXCord == xCord - 1) {
                      System.out.println(diagonalLeft);
                      diagonalLeft.setHP(diagonalLeft.getHP() - 1);
                      diagonalLeft.Update(board);
                      if (board[yCord + 1][xCord - 1] == null) {
                          board[super.getYCord()][super.getXCord()] = null;
                          super.setYCord(yCord + 1);
                          super.setXCord(xCord - 1);
                      }
                      board[super.getYCord()][super.getXCord()] = this;
                      return true;
                  }
              }
          }
      }
      else{
          System.out.println(board[yCord][xCord]);
          if (board[yCord - 1][xCord] == null && attackYCord == yCord - 1 && attackXCord == xCord) {
              board[yCord][xCord] = null;
              super.setYCord(yCord - 1);
              board[yCord-1][xCord] = this;
              return true;
          }
          if (xCord < 7) {
              PieceClass diagonalRight = board[yCord - 1][xCord + 1];
              if (diagonalRight != null) {
                  if (attackYCord == yCord - 1 && attackXCord == xCord - 1) {
                      diagonalRight.setHP(diagonalRight.getHP() - 1);
                      diagonalRight.Update(board);
                      if (board[yCord - 1][xCord + 1] == null) {
                          board[super.getYCord()][super.getXCord()] = null;
                          super.setYCord(yCord - 1);
                          super.setXCord(xCord + 1);
                      }
                      board[super.getYCord()][super.getXCord()] = this;
                      return true;
                  }
              }
          }
          if (xCord > 0) {
              PieceClass diagonalLeft = board[yCord - 1][xCord - 1];
              if (diagonalLeft != null) {
                  if (attackYCord == yCord - 1 && attackXCord == xCord - 1) {
                      System.out.println(diagonalLeft);
                      diagonalLeft.setHP(diagonalLeft.getHP() - 1);
                      diagonalLeft.Update(board);
                      if (board[yCord - 1][xCord - 1] == null) {
                          board[super.getYCord()][super.getXCord()] = null;
                          super.setYCord(yCord - 1);
                          super.setXCord(xCord - 1);
                      }
                      board[super.getYCord()][super.getXCord()] = this;
                      return true;
                  }
              }
          }
      }
      System.out.println("Invalid Move");
      return false;
  }

  public String toString(){
    return(" P" + super.getTeam() + " ");
  }
}
