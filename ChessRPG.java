public class ChessRPG{
  public static void main(String[] args){
    PieceClass[][] board = new PieceClass[8][8];
    PieceClass p1 = new Pawn(1, 0, 1);
    PieceClass p2 = new Pawn(1, 1, 2);
    board[1][0] = p1;
    board[2][1] = p2;
    for (int i = 7; i >= 0; i--){
      for (int j = 0; j < 8; j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    p1.Movement(board, "hib2");
  }
}
