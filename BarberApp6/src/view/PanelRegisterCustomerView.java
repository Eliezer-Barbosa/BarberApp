package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CustomerDao;
import model.Customer;

public class PanelRegisterCustomerView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelCustomerFirstName, labelCustomerLastName, labelCustomerMobilePhone, labelCustomerEmail, labelCustomerPassword;
	private JTextField txtCustomerFirstName, txtCustomerLastName, txtCustomerMobilePhone, txtCustomerEmail, txtCustomerPassword;
	private JButton btnCustomerCancel, btnCustomerRegister;
	
	private FramePrincipal framePrincipal;
	private Customer customer;
	private CustomerDao customerDao;
	
	public PanelRegisterCustomerView(FramePrincipal framePrincipal) {
		// TODO Auto-generated constructor stub
		
		this.framePrincipal = framePrincipal;
		
		initComponents();
		setEvents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		labelCustomerFirstName = new JLabel("First name");
		labelCustomerLastName = new JLabel("Last name");
		labelCustomerMobilePhone = new JLabel("Mobile phone");
		labelCustomerEmail = new JLabel("Email");
		labelCustomerPassword = new JLabel("Password");
		
		txtCustomerFirstName = new JTextField(30);
		txtCustomerLastName = new JTextField(30);
		txtCustomerMobilePhone = new JTextField(30);
		txtCustomerEmail = new JTextField(30);
		txtCustomerPassword = new JTextField(30);
		
		btnCustomerCancel = new JButton("Cancel");
		btnCustomerRegister = new JButton("Register");
		
		this.add(labelCustomerFirstName);
		this.add(txtCustomerFirstName);
		
		this.add(labelCustomerLastName);
		this.add(txtCustomerLastName);
		
		this.add(labelCustomerMobilePhone);
		this.add(txtCustomerMobilePhone);
		
		this.add(labelCustomerEmail);
		this.add(txtCustomerEmail);
		
		this.add(labelCustomerPassword);
		this.add(txtCustomerPassword);
		
		this.add(btnCustomerCancel);
		this.add(btnCustomerRegister);
		
	}
	
	private void setEvents() {
		// TODO Auto-generated method stub
		
		setListeners();
		
		setActionCommands();
	}

	private void setListeners() {
		btnCustomerCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				framePrincipal.getJMenuBar().setVisible(true);
				framePrincipal.setTitle("Barber Application Version 6");
				framePrincipal.getCardLayout().show(framePrincipal.getCardPanel(), framePrincipal.getPanelPrincipal().getName());
				
			}
		});
		btnCustomerRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String firstName = framePrincipal.getPanelRegisterCustomerView().getTxtCustomerFirstName().getText();
				String lastName = framePrincipal.getPanelRegisterCustomerView().getTxtCustomerLastName().getText();
				String mobilePhone = framePrincipal.getPanelRegisterCustomerView().getTxtCustomerMobilePhone().getText();
				String email = framePrincipal.getPanelRegisterCustomerView().getTxtCustomerEmail().getText();
				String password = framePrincipal.getPanelRegisterCustomerView().getTxtCustomerPassword().getText();
						
				customer = new Customer(firstName, lastName, mobilePhone, email, password);
				
				customerDao = new CustomerDao();
				customerDao.add(customer);
				
			}
		});
	}

	private void setActionCommands() {
		btnCustomerCancel.setActionCommand("btnCustomerCancel");
		btnCustomerRegister.setActionCommand("btnCustomerRegister");
	}
	
	public void showMessage(String message, String title, int type) {
		JOptionPane.showMessageDialog(null, message, title, type);
	}

	public JTextField getTxtCustomerFirstName() {
		return txtCustomerFirstName;
	}

	public JTextField getTxtCustomerLastName() {
		return txtCustomerLastName;
	}

	public JTextField getTxtCustomerMobilePhone() {
		return txtCustomerMobilePhone;
	}

	public JTextField getTxtCustomerEmail() {
		return txtCustomerEmail;
	}

	public JTextField getTxtCustomerPassword() {
		return txtCustomerPassword;
	}

	public JButton getBtnCustomerCancel() {
		return btnCustomerCancel;
	}

	public JButton getBtnCustomerRegister() {
		return btnCustomerRegister;
	}

}
