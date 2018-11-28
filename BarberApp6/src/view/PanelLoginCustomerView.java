package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BtnCustomerLoginCancelListener;
import dao.CustomerDao;
import model.Customer;

public class PanelLoginCustomerView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelCustomerEmail, labelCustomerPassword;
	private JTextField txtCustomerLoginEmail, txtCustomerLoginPassword;
	private JButton btnCustomerLoginCancel, btnCustomerLoginLogin;
	
	private FramePrincipal framePrincipal;
	private Customer customer;
	private CustomerDao customerDao;
	
	public PanelLoginCustomerView(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		initComponents();
		setEvents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		labelCustomerEmail = new JLabel("Email");
		labelCustomerPassword = new JLabel("Password");
		
		txtCustomerLoginEmail = new JTextField(30);
		txtCustomerLoginPassword = new JTextField(30);
		
		btnCustomerLoginCancel = new JButton("Cancel");
		btnCustomerLoginLogin = new JButton("Login");
		
		this.add(labelCustomerEmail);
		this.add(txtCustomerLoginEmail);
		
		this.add(labelCustomerPassword);
		this.add(txtCustomerLoginPassword);
		
		this.add(btnCustomerLoginCancel);
		this.add(btnCustomerLoginLogin);
		
	}
	
	private void setEvents() {
		// TODO Auto-generated method stub
		
		setListeners();
		
		setActionCommands();
	}

	private void setListeners() {
		/*btnCustomerLoginCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(true);
				framePrincipal.setTitle("Barber Application Version 6");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelPrincipal().getName());
				
			}
		});*/
		btnCustomerLoginCancel.addActionListener(new BtnCustomerLoginCancelListener());
		
		btnCustomerLoginLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String email = framePrincipal.getPanelLoginCustomerView().getTxtCustomerLoginEmail().getText();
				String password = framePrincipal.getPanelLoginCustomerView().getTxtCustomerLoginPassword().getText();
				
				customer = new Customer(email, password);
				customerDao = new CustomerDao();
				customerDao.validateCustomerLogin(customer);
				
			}
		});
	}

	private void setActionCommands() {
		btnCustomerLoginCancel.setActionCommand(btnCustomerLoginCancel.getName());
		btnCustomerLoginLogin.setActionCommand(btnCustomerLoginLogin.getName());
	}

	public JTextField getTxtCustomerLoginEmail() {
		return txtCustomerLoginEmail;
	}

	public JTextField getTxtCustomerLoginPassword() {
		return txtCustomerLoginPassword;
	}

	public JButton getBtnCustomerLoginCancel() {
		return btnCustomerLoginCancel;
	}

	public JButton getBtnCustomerLoginLogin() {
		return btnCustomerLoginLogin;
	}

}
