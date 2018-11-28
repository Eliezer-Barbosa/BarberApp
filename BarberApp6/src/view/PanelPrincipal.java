package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Font font;
	private JLabel label;
	
	public PanelPrincipal() {
		
		setup();
		
		initComponents();
		
		this.setVisible(true);
	}
	
	private void setup() {
		
		this.setBackground(Color.LIGHT_GRAY);
	}

	private void initComponents() {

		font = new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 25);
		label = new JLabel("Barber App");
		label.setFont(font);
		
		this.add(label);
	}

}
