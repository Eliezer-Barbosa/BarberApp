package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ServiceProviderDao;
import model.ServiceProvider;

public class PanelLoginServiceProviderView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelServiceProviderEmail, labelServiceProviderPassword;
	private JTextField txtServiceProviderLoginEmail, txtServiceProviderLoginPassword;
	private JButton btnServiceProviderLoginCancel, btnServiceProviderLoginLogin;
	
	private FramePrincipal framePrincipal;
	private ServiceProvider serviceProvider;
	private ServiceProviderDao serviceProviderDao;
	
	public PanelLoginServiceProviderView(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		initComponents();
		setEvents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		labelServiceProviderEmail = new JLabel("Email");
		labelServiceProviderPassword = new JLabel("Password");
		
		txtServiceProviderLoginEmail = new JTextField(30);
		txtServiceProviderLoginPassword = new JTextField(30);
		
		btnServiceProviderLoginCancel = new JButton("Cancel");
		btnServiceProviderLoginLogin = new JButton("Login");
		
		this.add(labelServiceProviderEmail);
		this.add(txtServiceProviderLoginEmail);
		
		this.add(labelServiceProviderPassword);
		this.add(txtServiceProviderLoginPassword);
		
		this.add(btnServiceProviderLoginCancel);
		this.add(btnServiceProviderLoginLogin);
		
	}
	
	private void setEvents() {
		// TODO Auto-generated method stub
		
		setListeners();
		
		setActionCommands();
	}
	
	private void setListeners() {
		btnServiceProviderLoginCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(true);
				framePrincipal.setTitle("Barber Application Version 6");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelPrincipal().getName());
				
			}
		});
		btnServiceProviderLoginLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String email = framePrincipal.getPanelLoginServiceProviderView().getTxtServiceProviderLoginEmail().getText();
				String password = framePrincipal.getPanelLoginServiceProviderView().getTxtServiceProviderLoginPassword().getText();
				
				serviceProvider = new ServiceProvider(email, password);
				serviceProviderDao = new ServiceProviderDao();
				serviceProviderDao.validateServiceProviderLogin(serviceProvider);
				
			}
		});
	}

	private void setActionCommands() {
		btnServiceProviderLoginCancel.setActionCommand(btnServiceProviderLoginCancel.getName());
		btnServiceProviderLoginLogin.setActionCommand(btnServiceProviderLoginLogin.getName());
	}

	public JTextField getTxtServiceProviderLoginEmail() {
		return txtServiceProviderLoginEmail;
	}

	public JTextField getTxtServiceProviderLoginPassword() {
		return txtServiceProviderLoginPassword;
	}

	public JButton getBtnServiceProviderLoginCancel() {
		return btnServiceProviderLoginCancel;
	}

	public JButton getBtnServiceProviderLoginLogin() {
		return btnServiceProviderLoginLogin;
	}

}
