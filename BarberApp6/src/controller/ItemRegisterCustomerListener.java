package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FramePrincipal;

public class ItemRegisterCustomerListener implements ActionListener {
	
	private FramePrincipal framePrincipal;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		framePrincipal = new FramePrincipal();
		framePrincipal.getJMenuBar().setVisible(false);
		framePrincipal.setTitle("Register a new Customer");
		framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelRegisterCustomerView().getName());
		
	}

}
