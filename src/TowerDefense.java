import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author
 * 
 */
// @SuppressWarnings({ "serial", "unused" })
public class TowerDefense extends JFrame {

	public TowerDefense() {
		super("TowerDefense");
		// MyCanvas myCanvas = null;
		// int numRows = 0;
		// int numCols = 0;

		// Scanner input = new Scanner(maze);
		// numRows= input.nextInt();
		// numCols= input.nextInt();
		// Use the first 2 integers in the file to make the following call work
		// myCanvas = new MyCanvas(numRows, numCols);
		// Now the hard part. Figure out what picture should be printed at each
		// position
		// Using a Scanner you can read in ints and doubles, and Strings
		// Note: loops are very good for this type of exercise
		// String s;
		// String path = "assets/";
		// for (int i=0; i<numRows; i++){
		// for(int j=0; j<numCols; j++){
		// s=input.next();
		// myCanvas.addPicture(i, j, s + ".png");
		// }
		// }
		//
		// You can change the size of the Frame if you want
		this.setSize(800, 800);

		// Do Not Make Any Changes Below This Line
		// if (myCanvas != null){
		// this.add(myCanvas);
		// }
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TowerDefense();
	}

}

//class MyCanvas extends JPanel {
//	private BufferedImage[][] imgs;
//	private int rows;
//	private int cols;
//	private final int tileSize = 64;
//
//	public MyCanvas(int rows, int cols) {
//		super();
//		this.rows = rows;
//		this.cols = cols;
//		imgs = new BufferedImage[rows][cols];
//	}
//
//	public void addPicture(int x, int y, String filename) {
//		if (x < 0 || x >= rows) {
//			System.err.println("There is no row " + x);
//		} else if (y < 0 || y >= cols) {
//			System.err.println("There is no col " + y);
//		} else {
//			try {
//				imgs[x][y] = ImageIO.read(new File(filename));
//			} catch (IOException e) {
//				System.err.println("Unable to read the file: " + filename);
//			}
//		}
//	}
//
//	public void paint(Graphics g) {
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				g.drawImage(imgs[i][j], j * tileSize, i * tileSize, null);
//			}
//		}
//	}
//}