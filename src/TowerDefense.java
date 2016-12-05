
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
		this.menu.setVisible(true);

		this.add(mainPanel);
		mainPanel.add(this.menu);
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
