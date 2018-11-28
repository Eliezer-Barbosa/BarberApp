package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarCustomer extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu menuSearchBarber;
	private JMenuItem itemByName, itemByLocation;
	
	public MenuBarCustomer() {
		// TODO Auto-generated constructor stub
		
		setup();
		
		this.setVisible(true);
	}

	private void setup() {
		// TODO Auto-generated method stub
		
		menuSearchBarber = new JMenu("Search Barber");
		itemByName = new JMenuItem("by name");
		itemByLocation = new JMenuItem("by location");
		
		menuSearchBarber.add(itemByName);
		menuSearchBarber.add(itemByLocation);
		
		this.add(menuSearchBarber);
		
		itemByName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		itemByLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		itemByName.setActionCommand(itemByName.getName());
		itemByLocation.setActionCommand(itemByLocation.getName());
		
	}

	public JMenuItem getItemByName() {
		return itemByName;
	}

	public JMenuItem getItemByLocation() {
		return itemByLocation;
	}

}
