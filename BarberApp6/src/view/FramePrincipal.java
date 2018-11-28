/**
 * 
 */
package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Eliezer
 *
 */
@SuppressWarnings("serial")
public class FramePrincipal extends JFrame {
	
	// this menu shows up every time the app is initialized
	private MenuBarPrincipal menuBarPrincipal;
	
	private CardLayout cardLayout; 
	private JPanel cardPanel;
	
	// panels home
	private PanelAdminHome panelAdminHome;
	private PanelCustomerHome panelCustomerHome;
	private PanelServiceProviderHome panelServiceProviderHome;
	private PanelPrincipal panelPrincipal;
	
	// panels login
	private PanelLoginAdminView panelLoginAdminView;
	private PanelLoginCustomerView panelLoginCustomerView;
	private PanelLoginServiceProviderView panelLoginServiceProviderView;
	
	// panels register
	private PanelRegisterCustomerView panelRegisterCustomerView;
	private PanelRegisterServiceProviderView panelRegisterServiceProviderView;
	
	// panels tables
	private PanelCustomerTable panelCustomerTable;
	
	// the constructor of this frame has a controller
	public FramePrincipal() {
		
		// calling setup method
		setup();
		
		// calling initComponents method
		initComponents();
		
		// setting visibility of this frame true
		this.setVisible(true);
	}

	private void setup() {
		
		this.setTitle("Barber Application Version 6");
		this.setSize(440, 500);
		this.setLocationRelativeTo(null); // place the frame on the center of the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponents() {
		
		menuBarPrincipal = new MenuBarPrincipal(this);
		
		this.setJMenuBar(menuBarPrincipal);
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		setPanelsName();
		
		addPanelsToCardPanel();
		
		this.add(cardPanel);
	}

	private void setPanelsName() {
		
		panelPrincipal = new PanelPrincipal();
		panelPrincipal.setName("panelPrincipal");
		
		panelAdminHome = new PanelAdminHome();
		panelAdminHome.setName("panelAdminHome");
		
		panelCustomerHome = new PanelCustomerHome();
		panelCustomerHome.setName("panelCustomerHome");
		
		panelServiceProviderHome = new PanelServiceProviderHome();
		panelServiceProviderHome.setName("panelServiceProviderHome");
		
		panelLoginAdminView = new PanelLoginAdminView(this);
		panelLoginAdminView.setName("panelLoginAdminView");
		
		panelLoginCustomerView = new PanelLoginCustomerView(this);
		panelLoginCustomerView.setName("panelLoginCustomerView");
		
		panelLoginServiceProviderView = new PanelLoginServiceProviderView(this);
		panelLoginServiceProviderView.setName("panelLoginServiceProviderView");
		
		panelRegisterCustomerView = new PanelRegisterCustomerView(this);
		panelRegisterCustomerView.setName("panelRegisterCustomerView");
		
		panelRegisterServiceProviderView = new PanelRegisterServiceProviderView(this);
		panelRegisterServiceProviderView.setName("panelRegisterServiceProviderView");
		
		panelCustomerTable = new PanelCustomerTable();
		panelCustomerTable.setName("panelCustomerTable");
		
	}
	
	private void addPanelsToCardPanel() {
		
		cardPanel.add(panelPrincipal, panelPrincipal.getName());
		
		cardPanel.add(panelAdminHome, panelAdminHome.getName());
		cardPanel.add(panelCustomerHome, panelCustomerHome.getName());
		cardPanel.add(panelServiceProviderHome, panelServiceProviderHome.getName());
		
		cardPanel.add(panelLoginAdminView, panelLoginAdminView.getName());
		cardPanel.add(panelLoginCustomerView, panelLoginCustomerView.getName());
		cardPanel.add(panelLoginServiceProviderView, panelLoginServiceProviderView.getName());
		
		cardPanel.add(panelRegisterCustomerView, panelRegisterCustomerView.getName());
		cardPanel.add(panelRegisterServiceProviderView, panelRegisterServiceProviderView.getName());
		
		cardPanel.add(panelCustomerTable, panelCustomerTable.getName());
	}
	
	// UTILS METHODS
	
	public void showCustomerNotFoundMessage() {
		
		JOptionPane.showMessageDialog(null, "Customer not found" , "Customer Not Found", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void showServiceProviderNotFoundMessage() {
		
		JOptionPane.showMessageDialog(null, "Service Provider not found" , "Service Provider Not Found", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showAdminNotFoundMessage() {
		
		JOptionPane.showMessageDialog(null, "Admin not found" , "Admin Not Found", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showCustomerAddedMessage() {
		
		JOptionPane.showMessageDialog(null, "Customer Registed" , "Customer Registered", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showCustomerNotAddedMessage() {
		
		JOptionPane.showMessageDialog(null, "Customer Not Registed" , "Customer Not Registered", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showServiceProviderAddedMessage() {
		
		JOptionPane.showMessageDialog(null, "Service ProviderRegisted" , "Service Provider Registered", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showServiceProviderNotAddedMessage() {
		
		JOptionPane.showMessageDialog(null, "Service Provider Not Registed" , "Service Provider Not Registered", JOptionPane.WARNING_MESSAGE);
	}
	
	// GETTERS METHODS

	public MenuBarPrincipal getMenuBarPrincipal() {
		return menuBarPrincipal;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

	public PanelAdminHome getPanelAdminHome() {
		return panelAdminHome;
	}

	public PanelCustomerHome getPanelCustomerHome() {
		return panelCustomerHome;
	}

	public PanelServiceProviderHome getPanelServiceProviderHome() {
		return panelServiceProviderHome;
	}

	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}

	public PanelLoginAdminView getPanelLoginAdminView() {
		return panelLoginAdminView;
	}

	public PanelLoginCustomerView getPanelLoginCustomerView() {
		return panelLoginCustomerView;
	}

	public PanelLoginServiceProviderView getPanelLoginServiceProviderView() {
		return panelLoginServiceProviderView;
	}

	public PanelRegisterCustomerView getPanelRegisterCustomerView() {
		return panelRegisterCustomerView;
	}

	public PanelRegisterServiceProviderView getPanelRegisterServiceProviderView() {
		return panelRegisterServiceProviderView;
	}

	public PanelCustomerTable getPanelCustomerTable() {
		return panelCustomerTable;
	}

}
