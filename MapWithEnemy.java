import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithEnemy extends JFrame {

	//private Enemy e1;
	//private Enemy e2;

	@SuppressWarnings("unused")
	public MapWithEnemy(){
		try{
			//Use this to test your first constructor
			BufferedImage enemyImage1 = ImageIO.read(new File("??"));
			//e1 = new Enemy(??);

			//Use this to test your second constructor
			BufferedImage enemyImage2 = ImageIO.read(new File("??"));
			//e2 = new Enemy(??);
		}catch (IOException e) {
			e.printStackTrace();

		}
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{

			//e1.drawTheImage(g);
			//e2.drawTheImage(g);

			
			Thread.sleep(1000);
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	public static void main (String [] args){
		MapWithEnemy m = new MapWithEnemy();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

