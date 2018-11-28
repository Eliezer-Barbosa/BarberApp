package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarServiceProvider extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu menu;
	private JMenuItem itemEnterSlot, itemBookingsToConfirm;
	
	public MenuBarServiceProvider() {
		// TODO Auto-generated constructor stub
		
		setup();
		
		this.setVisible(true);
	}

	private void setup() {
		// TODO Auto-generated method stub
		
		menu = new JMenu("Menu");
		itemEnterSlot = new JMenuItem("input new slot");
		itemBookingsToConfirm = new JMenuItem("bookings to confirm");
		
		menu.add(itemEnterSlot);
		menu.add(itemBookingsToConfirm);
		
		this.add(menu);
		
		itemEnterSlot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		itemBookingsToConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		itemEnterSlot.setActionCommand(itemEnterSlot.getName());
		itemBookingsToConfirm.setActionCommand(itemBookingsToConfirm.getName());
		
	}

	public JMenuItem getItemEnterSlot() {
		return itemEnterSlot;
	}

	public JMenuItem getItemBookingsToConfirm() {
		return itemBookingsToConfirm;
	}

}
