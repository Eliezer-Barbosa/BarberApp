package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelServiceProviderHome extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	
	public PanelServiceProviderHome() {
		// TODO Auto-generated constructor stub
				
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		this.label = new JLabel("Service Provider Home");
		
		this.add(label);
		
	}

}
