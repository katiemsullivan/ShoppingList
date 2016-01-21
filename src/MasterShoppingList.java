import javax.swing.JFrame;
import javax.swing.JPanel;

public class MasterShoppingList {

	public static void main(String[] args) {
		
		JFrame master = new JFrame();
		JPanel mainPanel = new MainPanel();
		master.add(mainPanel);
		
		master.setSize(400, 250);
		master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		master.setVisible(true);

	}

}
