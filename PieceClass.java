public abstract class PieceClass{
  public int HP;
  public int xCord;
  public int yCord;

  public PieceClass(int HP, int xCord, int yCord){
    this.HP = HP;
    this.xCord = xCord;
    this.yCord = yCord;
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

  public void setXCord(int xCord){
    this.xCord = xCord;
  }

  public void setYCord(int yCord){
    this.yCord = yCord;
  }

  public void setHP(int HP){
    this.HP = HP;
  }

  public void Movement(PieceClass[][] board, String instructions){}

  public void Update(PieceClass[][] board){}
}
