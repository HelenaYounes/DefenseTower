import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingEnemy extends TowerDefenseObject {
  public double velocityX;
  public double velocityY;

  public MovingEnemy(){
    super();
    this.velocityX = 1;
    this.velocityY = 0;
  }

    public MovingEnemy(int x, int y, BufferedImage image, double velocityX, double velocityY){
      super(x, y, image);
      this.velocityX = velocityX;
      this.velocityY = velocityY;
  }

  public MovingEnemy(int x, int y, BufferedImage image, int width, int height, double velocityX, double velocityY){
    super( x, y, image, width, height);
    this.velocityX = velocityX;
    this.velocityY = velocityY;
  }

  @Override
  public void drawTheImage(Graphics g){
    super.drawTheImage(g);
  }
  public void runLogic(){
    this.x += velocityX;
    this.y += velocityY;
  }


  public void setVelocityXE (double velocityX){
    this.velocityX = velocityX;
  }

  public void setVelocityYE(double velocityY){
    this.velocityY = velocityY;
  }

  public double getVelocityXE(){
    return velocityX;
  }

  public double getVelocityYE(){
    return velocityY;
  }
}
