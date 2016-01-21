import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ViewListPanel extends JPanel{
	Container c = getRootPane();
	ListItemDAO itemDAO = new ListItemDAO();
	JLabel title = new JLabel("VIEW SHOPPING LIST");
	
	ArrayList<ListItem> listModel = new ArrayList<ListItem>();
	ListItem abc = new ListItem("Sample store", "Sample Item");
	JList list = new JList(listModel.toArray());
	
	
	JScrollPane scroll = new JScrollPane(list);
	JButton back = new JButton("Back");
	JButton remove = new JButton("Remove item");
	
	
	
	public ViewListPanel(){
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		listModel.add(abc);
	    
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(350, 100));
		
		
		add(title);
		add(scroll);
		
		
		ButtonListener l = new ButtonListener();
		back.addActionListener(l);
		remove.addActionListener(l);
		
		
		add(back);
		add(remove);
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
            removeAll();
            JPanel newPanel=new MainPanel();
            add(newPanel);
            revalidate();
            newPanel.repaint();
		}
		
		if(e.getSource()==remove){
			System.out.println("Remove selected object");
		}
            
			
		}
		
	}
	
	
}

