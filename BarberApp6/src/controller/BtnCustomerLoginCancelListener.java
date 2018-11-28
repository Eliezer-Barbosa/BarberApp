package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FramePrincipal;

public class BtnCustomerLoginCancelListener implements ActionListener {
	
	private FramePrincipal framePrincipal;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		framePrincipal = new FramePrincipal();
		framePrincipal.getJMenuBar().setVisible(true);
		framePrincipal.setTitle("Barber Application Version 6");
		framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelPrincipal().getName());
	}

}
