import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SortListPanel extends JPanel{
	JLabel title = new JLabel("SORT SHOPPING LIST BY STORE");
	String[] stores = {"Target", "Hyvee", "PetSmart", "Home Depot"};
	JComboBox store = new JComboBox(stores);
	JTextArea list = new JTextArea(5,15);
	JButton back = new JButton("Back");
	
	ListItemDAO itemDAO = new ListItemDAO();
	
	public SortListPanel(){
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		setMinimumSize(new Dimension(400,250));
		list.append(itemDAO.getCurrentListFromStore(stores[0]));
		list.setLineWrap(true);
	    list.setEditable(true);
	    list.setVisible(true);
	    
	    JScrollPane scroll = new JScrollPane(list);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
        ButtonAndStoreSelectorListener ss = new ButtonAndStoreSelectorListener();
        store.addActionListener(ss);
        back.addActionListener(ss);
        
		add(title);
		add(store);
		add(scroll);
		add(back);
		
		
		
	}
	
	class ButtonAndStoreSelectorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = store.getSelectedItem().toString();
			list.setText(itemDAO.getCurrentListFromStore(s));
			
			System.out.println("noted change");
			
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
