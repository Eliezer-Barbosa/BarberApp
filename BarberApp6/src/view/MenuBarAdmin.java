package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ItemListCustomersListener;

public class MenuBarAdmin extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu menu, menuCustomers, menuServiceProviders;
	private JMenuItem itemListCustomers, itemListServiceProviders, itemCurrentBookings, itemPendingApproval, itemComplaints;
	
	private FramePrincipal framePrincipal;
	
	public MenuBarAdmin(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		setup();
		
		this.setVisible(true);
	}

	private void setup() {
		// TODO Auto-generated method stub
		
		menu = new JMenu("menu");
		menuCustomers = new JMenu("Customers");
		menuServiceProviders = new JMenu("Service Providers");
		
		itemListCustomers = new JMenuItem("List Customers");
		itemListServiceProviders = new JMenuItem("List Service Providers");
		itemCurrentBookings = new JMenuItem("Current Bookings");
		itemPendingApproval = new JMenuItem("Pending Approval");
		itemComplaints = new JMenuItem("Handle Complaints");
		
		menuCustomers.add(itemListCustomers);
		menuCustomers.add(itemComplaints);
		
		menuServiceProviders.add(itemListServiceProviders);
		menuServiceProviders.add(itemCurrentBookings);
		menuServiceProviders.add(itemPendingApproval);
		
		menu.add(menuCustomers);
		menu.add(menuServiceProviders);
		
		this.add(menu);
		
		/*itemListCustomers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				framePrincipal.getJMenuBar().setVisible(false);
				framePrincipal.setTitle("Customers table");
				framePrincipal.setSize(540, 500);
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelCustomerTable().getName());
				
			}
		});*/
		itemListCustomers.addActionListener(new ItemListCustomersListener());
		
		itemListServiceProviders.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		itemCurrentBookings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		itemPendingApproval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		itemComplaints.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		itemListCustomers.setActionCommand(itemListCustomers.getName());
		itemListServiceProviders.setActionCommand(itemListServiceProviders.getName());
		itemCurrentBookings.setActionCommand(itemCurrentBookings.getName());
		itemPendingApproval.setActionCommand(itemPendingApproval.getName());
		itemComplaints.setActionCommand(itemComplaints.getName());
		
	}

}
