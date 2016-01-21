import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemsPanel extends JPanel{
	
	String[] stores = {"Target", "Hyvee", "PetSmart", "Home Depot"};
	
	JLabel title = new JLabel("ADD ITEMS TO SHOPPING LIST");
	JLabel storeLabel = new JLabel("Store");
	JComboBox store = new JComboBox(stores);
	JLabel itemLabel = new JLabel("Item");
	JTextField item = new JTextField(25);
	JButton submit = new JButton("Add to List");
	JButton back = new JButton("Back to Main");
	JButton viewList = new JButton("View List");
	JButton viewAllItems = new JButton("View all items");
	ListItemDAO itemDAO = new ListItemDAO();
	
	
	public AddItemsPanel(){
		
		
		ButtonListener b = new ButtonListener();
		submit.addActionListener(b);
		viewList.addActionListener(b);
		viewAllItems.addActionListener(b);
		back.addActionListener(b);
		
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		add(title);
		
		add(storeLabel);
		
		add(store);
		add(itemLabel);
		add(item);
	
		add(submit);
		add(viewList);
		add(viewAllItems);
		add(back);
		
		
		
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == submit) {
				System.out.println("Add new item to database");
			}
			
			if (e.getSource() == viewList){
				removeAll();
                JPanel newPanel=new SortListPanel();
                add(newPanel);
                revalidate();
                newPanel.repaint();
			}
			
			if(e.getSource() == viewAllItems){

            	removeAll();
                JPanel newPanel=new ViewListPanel();
                add(newPanel);
                revalidate();
                newPanel.repaint();
			}
			
			if(e.getSource() == back){
				removeAll();
                JPanel newPanel=new MainPanel();
                add(newPanel);
                revalidate();
                newPanel.repaint();
			}
		}
		
	}

}
