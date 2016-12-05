
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


/**
 *
 * @authorHelena
 *
 */
// Where and How to put the KeyListener for start pause on press space event??

public class TowerDefense extends JFrame {
	public Game game;
	public Menu menu;
	public TowerDefense() {

		super("TowerDefense");

		JSplitPane mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPanel.setSize(580, 500);
		mainPanel.setDividerLocation(100);
		this.game = new Game();
		this.menu = new Menu(this.game);

		this.add(mainPanel);
		mainPanel.add(menu);
		mainPanel.add(this.game);

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		this.pack();

	}

	public static void main(String[] args) {
		new TowerDefense();

	}

}

// class MyCanvas extends JPanel {
// private BufferedImage[][] imgs;
// private int rows;
// private int cols;
// private final int tileSize = 64;
//
// public MyCanvas(int rows, int cols) {
// super();
// this.rows = rows;
// this.cols = cols;
// imgs = new BufferedImage[rows][cols];
// }
//
// public void addPicture(int x, int y, String filename) {
// if (x < 0 || x >= rows) {
// System.err.println("There is no row " + x);
// } else if (y < 0 || y >= cols) {
// System.err.println("There is no col " + y);
// } else {
// try {
// imgs[x][y] = ImageIO.read(new File(filename));
// } catch (IOException e) {
// System.err.println("Unable to read the file: " + filename);
// }
// }
// }
//
// public void paint(Graphics g) {
// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// g.drawImage(imgs[i][j], j * tileSize, i * tileSize, null);
// }
// }
// }
// }
