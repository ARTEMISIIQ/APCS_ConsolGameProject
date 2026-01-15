public class Pawn extends PieceClass{
  private String type = "PAWN";

  public void Movement(String[][] board){
      int xCord = super.getXCord();
      int yCord = super.getYCord();
      if (board[yCord+1][xCord].equals(" ")){
        
      }
  }
}
