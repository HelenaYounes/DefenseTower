import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingEnemy extends TowerDefenseObject {
  public double velocityXE;
  public double velocityYE;

  public MovingEnemy(){
    super();
    this.velocityXE = -1;
    this.velocityYE = 0;
  }

    public MovingEnemy(int x, int y, BufferedImage image, double velocityXE, double velocityYE){
      super(x, y, image);
      this.velocityXE = velocityXE;
      this.velocityYE = velocityYE;
  }

  public MovingEnemy(int x, int y, BufferedImage image, int width, int height, double velocityXE, double velocityYE){
    super( x, y, image, width, height);
    this.velocityXE = velocityXE;
    this.velocityYE = velocityYE;
  }

  @Override
  public void drawTheImage(Graphics g){
    super.drawTheImage(g);
  }
  public void runLogic(){
    this.x += velocityXE;
    this.y += velocityYE;
  }


  public void setVelocityXE (double velocityXE){
    this.velocityXE = velocityXE;
  }

  public void setVelocityYE(double velocityYE){
    this.velocityYE = velocityYE;
  }

  public double getVelocityXE(){
    return velocityXE;
  }

  public double getVelocityYE(){
    return velocityYE;
  }
}
