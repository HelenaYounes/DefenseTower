import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel {
	private BufferedImage background;
	private TowerDefenseObject tower;
	
	public Game(){
		super();		
		
		try {
			this.background = ImageIO.read(new File("background.png"));
			BufferedImage towerImage = ImageIO.read(new File("singetower.jpg"));
			this.tower = new MovingTowerDefenseObject(50,0,towerImage, 200, 200);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(background, 
				0, 0, 580, 500,
				null
		);
		this.tower.drawTheImage(g);
		
	}
}
