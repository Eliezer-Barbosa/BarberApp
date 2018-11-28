package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ServiceProviderDao;
import model.ServiceProvider;

public class PanelRegisterServiceProviderView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelServiceProviderName, labelServiceProviderMobilePhone, labelServiceProviderEmail, labelServiceProviderPassword;
	private JTextField txtServiceProviderName, txtServiceProviderMobilePhone, txtServiceProviderEmail, txtServiceProviderPassword;
	private JButton btnServiceProviderCancel, btnServiceProviderRegister;
	
	private FramePrincipal framePrincipal;
	private ServiceProvider serviceProvider;
	private ServiceProviderDao serviceProviderDao;
	
	public PanelRegisterServiceProviderView(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		initComponents();
		setEvents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		labelServiceProviderName = new JLabel("Name");
		labelServiceProviderMobilePhone = new JLabel("Mobile phone");
		labelServiceProviderEmail = new JLabel("Email");
		labelServiceProviderPassword = new JLabel("Password");
		
		txtServiceProviderName = new JTextField(30);
		txtServiceProviderMobilePhone = new JTextField(30);
		txtServiceProviderEmail = new JTextField(30);
		txtServiceProviderPassword = new JTextField(30);
		
		btnServiceProviderCancel = new JButton("Cancel");
		btnServiceProviderRegister = new JButton("Register");
		
		this.add(labelServiceProviderName);
		this.add(txtServiceProviderName);
		
		this.add(labelServiceProviderMobilePhone);
		this.add(txtServiceProviderMobilePhone);
		
		this.add(labelServiceProviderEmail);
		this.add(txtServiceProviderEmail);
		
		this.add(labelServiceProviderPassword);
		this.add(txtServiceProviderPassword);
		
		this.add(btnServiceProviderCancel);
		this.add(btnServiceProviderRegister);
		
	}
	
	private void setEvents() {
		// TODO Auto-generated method stub
		
		setListeners();
		
		setActionCommands();
	}

	private void setListeners() {
		btnServiceProviderCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(true);
				framePrincipal.setTitle("Barber Application Version 6");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelPrincipal().getName());
				
			}
		});
		btnServiceProviderRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name = framePrincipal.getPanelRegisterServiceProviderView().getTxtServiceProviderName().getText();
				String mobilePhone = framePrincipal.getPanelRegisterServiceProviderView().getTxtServiceProviderMobilePhone().getText();
				String email = framePrincipal.getPanelRegisterServiceProviderView().getTxtServiceProviderEmail().getText();
				String password =framePrincipal.getPanelRegisterServiceProviderView().getTxtServiceProviderPassword().getText();
				
				serviceProvider = new ServiceProvider(name, mobilePhone, email, password);
				
				serviceProviderDao = new ServiceProviderDao();
				serviceProviderDao.add(serviceProvider);
				
			}
		});
	}

	private void setActionCommands() {
		btnServiceProviderCancel.setActionCommand(btnServiceProviderCancel.getName());
		btnServiceProviderRegister.setActionCommand(btnServiceProviderRegister.getName());
	}
	
	public void showMessage(String message, String title, int type) {
		JOptionPane.showMessageDialog(null, message, title, type);
		
	}

	public JTextField getTxtServiceProviderName() {
		return txtServiceProviderName;
	}

	public JTextField getTxtServiceProviderMobilePhone() {
		return txtServiceProviderMobilePhone;
	}

	public JTextField getTxtServiceProviderEmail() {
		return txtServiceProviderEmail;
	}

	public JTextField getTxtServiceProviderPassword() {
		return txtServiceProviderPassword;
	}

	public JButton getBtnServiceProviderCancel() {
		return btnServiceProviderCancel;
	}

	public JButton getBtnServiceProviderRegister() {
		return btnServiceProviderRegister;
	}

}
