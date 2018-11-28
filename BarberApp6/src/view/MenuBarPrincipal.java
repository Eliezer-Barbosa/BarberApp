/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ItemLoginAdminListener;
import controller.ItemLoginCustomerListener;
import controller.ItemLoginServiceProviderListener;
import controller.ItemRegisterCustomerListener;
import controller.ItemRegisterServiceProviderListener;

/**
 * @author Eliezer
 *
 */
public class MenuBarPrincipal extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu menuPrincipal, menuLogin, menuRegister;
	private JMenuItem itemLoginCustomer, itemLoginServiceProvider, itemLoginAdmin;
	private JMenuItem itemRegisterCustomer, itemRegisterServiceProvider;
	
	private FramePrincipal framePrincipal;
	
	public MenuBarPrincipal(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		setup();
		
		this.setVisible(true);
	}

	private void setup() {
		// TODO Auto-generated method stub
		
		menuPrincipal = new JMenu("Menu");
		menuLogin = new JMenu("Login");
		menuRegister = new JMenu("Register");
		
		itemLoginCustomer = new JMenuItem("Customer");
		itemLoginServiceProvider = new JMenuItem("Service Provider");
		itemLoginAdmin = new JMenuItem("Admin");
		
		itemRegisterCustomer = new JMenuItem("New Customer");
		itemRegisterServiceProvider = new JMenuItem("New Service Provider");
		
		menuLogin.add(itemLoginCustomer);
		menuLogin.add(itemLoginServiceProvider);
		menuLogin.add(itemLoginAdmin);
		
		menuRegister.add(itemRegisterCustomer);
		menuRegister.add(itemRegisterServiceProvider);
		
		menuPrincipal.add(menuLogin);
		menuPrincipal.add(menuRegister);
		
		this.add(menuPrincipal);
		
		setEvents();
		
	}

	private void setEvents() {
		
		setListeners();
		
		setActionCommands();
	}
	
	private void setListeners() {
		
		/*itemLoginCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(false);
				framePrincipal.setTitle("Login Customer");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelLoginCustomerView().getName());
				
			}
		});*/
		itemLoginCustomer.addActionListener(new ItemLoginCustomerListener());
		
		/*itemLoginServiceProvider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(false);
				framePrincipal.setTitle("Login Service Provider");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelLoginServiceProviderView().getName());
				
			}
		});*/
		itemLoginServiceProvider.addActionListener(new ItemLoginServiceProviderListener());
		
		/*itemLoginAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(false);
				framePrincipal.setTitle("Login Admin");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelLoginAdminView().getName());
				
			}
		});*/
		itemLoginAdmin.addActionListener(new ItemLoginAdminListener());
		
		/*itemRegisterCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(false);
				framePrincipal.setTitle("Register a new Customer");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelRegisterCustomerView().getName());
				
			}
		});*/
		itemRegisterCustomer.addActionListener(new ItemRegisterCustomerListener());
		
		/*itemRegisterServiceProvider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(false);
				framePrincipal.setTitle("Register a new Service Provider");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelRegisterServiceProviderView().getName());
				
			}
		});*/
		itemRegisterServiceProvider.addActionListener(new ItemRegisterServiceProviderListener());
	}

	private void setActionCommands() {
		
		itemLoginCustomer.setActionCommand(itemLoginCustomer.getName());
		itemLoginServiceProvider.setActionCommand(itemLoginServiceProvider.getName());
		itemLoginAdmin.setActionCommand(itemLoginAdmin.getName());
		
		itemRegisterCustomer.setActionCommand(itemRegisterCustomer.getName());
		itemRegisterServiceProvider.setActionCommand(itemRegisterServiceProvider.getName());
	}

	public JMenuItem getItemLoginCustomer() {
		return itemLoginCustomer;
	}

	public JMenuItem getItemLoginServiceProvider() {
		return itemLoginServiceProvider;
	}

	public JMenuItem getItemLoginAdmin() {
		return itemLoginAdmin;
	}

	public JMenuItem getItemRegisterCustomer() {
		return itemRegisterCustomer;
	}

	public JMenuItem getItemRegisterServiceProvider() {
		return itemRegisterServiceProvider;
	}
	
}
