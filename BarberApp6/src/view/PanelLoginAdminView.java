
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BtnAdminCancelListener;
import controller.BtnAdminLoginListener;
import dao.AdminDao;
import model.Admin;

public class PanelLoginAdminView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelAdminEmail, labelAdminPassword;
	private JTextField txtAdminEmail, txtAdminPassword;
	private JButton btnAdminCancel, btnAdminLogin;
	
	private FramePrincipal framePrincipal;
	private Admin admin;
	private AdminDao adminDao;
	
	public PanelLoginAdminView(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		initComponents();
		setEvents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		labelAdminEmail = new JLabel("Email");
		labelAdminPassword = new JLabel("Password");
		
		txtAdminEmail = new JTextField(30);
		txtAdminPassword = new JTextField(30);
		
		btnAdminCancel = new JButton("Cancel");
		btnAdminLogin = new JButton("Login");
		
		this.add(labelAdminEmail);
		this.add(txtAdminEmail);
		
		this.add(labelAdminPassword);
		this.add(txtAdminPassword);
		
		this.add(btnAdminCancel);
		this.add(btnAdminLogin);
		
	}
	
	private void setEvents() {
		// TODO Auto-generated method stub
		
		setListeners();
		
		setActionCommands();
	}

	private void setListeners() {
		/*btnAdminCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(true);
				framePrincipal.setTitle("Barber Application Version 6");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelPrincipal().getName());
				
			}
		});*/
		btnAdminCancel.addActionListener(new BtnAdminCancelListener());
		
		btnAdminLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String email = framePrincipal.getPanelLoginAdminView().getTxtAdminEmail().getText();
				String password = framePrincipal.getPanelLoginAdminView().getTxtAdminPassword().getText();
					
				admin = new Admin(email, password);
				adminDao = new AdminDao();
				adminDao.validateAdminLogin(admin);
				
			}
		});
		//btnAdminLogin.addActionListener(new BtnAdminLoginListener());
	}

	private void setActionCommands() {
		btnAdminCancel.setActionCommand("btnAdminCancel");
		btnAdminLogin.setActionCommand("btnAdminLogin");
	}

	public JTextField getTxtAdminEmail() {
		return txtAdminEmail;
	}

	public JTextField getTxtAdminPassword() {
		return txtAdminPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBtnAdminCancel() {
		return btnAdminCancel;
	}

	public JButton getBtnAdminLogin() {
		return btnAdminLogin;
	}

	public void setTxtAdminEmail(JTextField txtAdminEmail) {
		this.txtAdminEmail = txtAdminEmail;
	}

	public void setTxtAdminPassword(JTextField txtAdminPassword) {
		this.txtAdminPassword = txtAdminPassword;
	}
	
}
