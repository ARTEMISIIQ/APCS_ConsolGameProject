import java.util.Scanner;

public class ChessRPG{

  public static PieceClass[][] board = new PieceClass[8][8];
  public static int turn;
  public static boolean finished = false;

  public static void main(String[] args){
    for (int i = 0; i < 8; i++){
      board[1][i] = new Pawn(i, 1, 0);
    }
    board[0][0] = new Rook(0,0,0);
    board[0][1] = new Knight(1,0,0);
    board[0][2] = new Bishop(2,0,0);
    board[0][3] = new Queen(3,0,0);
    board[0][4] = new King(4,0,0);
    board[0][5] = new Bishop(5,0,0);
    board[0][6] = new Knight(6,0,0);
    board[0][7] = new Rook(7,0,0);

    for (int i = 0; i < 8; i++){
      board[6][i] = new Pawn(i, 6, 1);
    }
    board[7][0] = new Rook(0,7,1);
    board[7][1] = new Knight(1,7,1);
    board[7][2] = new Bishop(2,7,1);
    board[7][3] = new Queen(3,7,1);
    board[7][4] = new King(4,7,1);
    board[7][5] = new Bishop(5,7,1);
    board[7][6] = new Knight(6,7,1);
    board[7][7] = new Rook(7,7,1);

    showBoard(board);

    Scanner reader = new Scanner(System.in);

    System.out.println("WELCOME to CHESS RPG!");
    System.out.println("By: Ethan T. and Emily L.");
    System.out.println("This is a recreation of chess with several changes to spice things up!");
    System.out.println("Of course we could not fully implement all of Chess so certain changes had to be made.");
    System.out.println("Each piece has a certain amount of health which is the amount of damage they deal.");
    System.out.println("Instead of automatically capturing pieces, health must be drained to 0.");
    System.out.println("As in regular chess, capturing the KING will guarantee victory!");
    System.out.println("Pawn (P) - 1 HP");
    System.out.println("Bishop (B) - 3 HP");
    System.out.println("Knight (N) - 3 HP");
    System.out.println("Rook (R) - 5 HP");
    System.out.println("Queen (Q) - 9 HP");
    System.out.println("King (K) - 10 HP");
    System.out.println("In order to play moves, type the coordinates of the piece you want move using chess notation (a1) and the coordinates of the destination into the terminal.");
    System.out.println("Note: You cannot capture your own pieces and if you are unable to capture an opponent's piece, your attacking piece does not move.");
    System.out.println("A 'legal' move would be <<e2e3>>, given a piece from your team is on that square and is able to perform that move.");
    System.out.println("To start the game, insert 'Start' into the terminal.");

    if (reader.next().equals("Start")){
      StartGame(board, reader);
    }
  }

  public static void StartGame(PieceClass[][] board, Scanner reader){
    while (!finished){
      String instruction = reader.nextLine();
      try {
        PieceClass piece = board[(int) instruction.charAt(1) - (int) '1'][instruction.charAt(0) - (int) 'a'];
        if (piece.getTeam() == turn) {
          if (piece.Movement(board, instruction)){
            turn++;
          }
        }
        else{
          System.out.println("Move one of YOUR pieces");
        }
      }
      catch (Exception e){
        System.out.println("Invalid Move");
      }
      finished = checkWin(board);
      showBoard(board);
    }
  }

  public static void showBoard(PieceClass[][] board){
    for (int i = 7; i >= 0; i--){
      System.out.print((char) ((int) '1' + i) + ":  ");
      for (int j = 0; j < 8; j++){
        if (board[i][j] != null) {
          System.out.print("\033[" + (40 + 7 * ((i + j) % 2)) + "m" + board[i][j] + "\033[0m");
        }
        else{
          System.out.print("\033[" + (40 + 7 * ((i + j) % 2)) + "m    \033[0m");
        }
      }
      System.out.println();
    }
    System.out.println("     a   b   c   d   e   f   g   h  ");
    turn = turn % 2;
    if (!finished) {
      System.out.println("Player " + turn + "'s Turn");
    }
  }

  public static boolean checkWin(PieceClass[][] board){
    boolean king0 = false;
    boolean king1 = false;
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        try{
          PieceClass piece = board[i][j];
          if (piece.getType().equals("King")){
            if (piece.getTeam() == 0){
              king0 = true;
            }
            else{
              king1 = true;
            }
          }
        }
        catch (Exception e){}
      }
    }
    if (!king0){
      System.out.println("Player 0's forces have been vanquished!");
    }
    if (!king1){
      System.out.println("Player 1's forces have been vanquished!");
    }
    return !king0 || !king1;
  }

  public static void InvalidMove(){
    System.out.println(turn);
    turn--;
    System.out.println(turn);
  }
}
