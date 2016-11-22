import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel {
	private BufferedImage background;
	
	public Game(){
		super();
		try {
			this.background = ImageIO.read(new File("barker_nathan.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(background, 118, 128, null);
		g.drawRect(20, 20,10,10);
		g.setColor(Color.RED);
		g.fillRect(20, 20, 10, 10);
		
	}
}
