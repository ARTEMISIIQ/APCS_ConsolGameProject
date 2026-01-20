import java.lang.Math;

public abstract class PieceClass{
  public int HP;
  public int xCord;
  public int yCord;
  public int team;
  public String type;

  public PieceClass(int HP, int xCord, int yCord, int team, String type){
    this.HP = HP;
    this.xCord = xCord;
    this.yCord = yCord;
    this.team = team;
    this.type = type;
  }

  public int getXCord(){
    return this.xCord;
  }

  public int getYCord(){
    return this.yCord;
  }

  public int getHP(){
    return this.HP;
  }

  public int getTeam(){
    return this.team;
  }

  public String getType(){
    return this.type;
  }

  public void setXCord(int xCord){
    this.xCord = xCord;
  }

  public void setYCord(int yCord){
    this.yCord = yCord;
  }

  public void setHP(int HP){
    this.HP = HP;
  }

  public boolean Movement(PieceClass[][] board, String instructions){return false;}

  public void Update(PieceClass[][] board){
    if (getHP() <= 0){
      System.out.println("Player " + team + "'s " + type + " on " + (char) (yCord + (int) 'a') + (char) (xCord + (int) '1') + " was CAPTURED!");
      board[yCord][xCord] = null;
    }
    else{
      System.out.println("Player " + team + "'s " + type + " on " + (char) (yCord + (int) 'a') + (char) (xCord + (int) '1') + " was attacked and now has " + HP + " health!");
    }
  }
}
