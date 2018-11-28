package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.AdminDao;
import model.Admin;
import view.FramePrincipal;

public class BtnAdminLoginListener implements ActionListener {
	
	private FramePrincipal framePrincipal;
	private Admin admin;
	private AdminDao adminDao;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		framePrincipal = new FramePrincipal();
		String email = framePrincipal.getPanelLoginAdminView().getTxtAdminEmail().getText();
		String password = framePrincipal.getPanelLoginAdminView().getTxtAdminPassword().getText();
			
		admin = new Admin(email, password);
		adminDao = new AdminDao();
		adminDao.validateAdminLogin(admin);
		
	}

}
