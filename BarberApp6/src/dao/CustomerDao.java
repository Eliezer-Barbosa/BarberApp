package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectionFactory;
import model.Customer;
import view.FramePrincipal;
import view.MenuBarCustomer;

public class CustomerDao {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	FramePrincipal framePrincipal;
	
	public CustomerDao() {
		
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
		this.framePrincipal = new FramePrincipal();
	}
	
	public List<Customer> getCustomers() {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			
			preparedStatement = connection.prepareStatement("SELECT * FROM customer");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();

				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setMobilePhone(resultSet.getString("mobilePhone"));
				customer.setEmail(resultSet.getString("email"));
				customers.add(customer);
			}
			//FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
		}
		return customers;
	}
	
	public void remover(int id) {
		
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE ID =?");

			preparedStatement.setInt(1, id);

			preparedStatement.execute();
			preparedStatement.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de"
					+ "dados " + e.getMessage());
		}
	}
	
	
	public void add(Customer customer) {
		if(isCustomerValid(customer)) {
			String sql = "INSERT INTO customer(first_name, last_name, mobile_phone, email, password) VALUES(?,?,?,?,?)";
			try { 
	            preparedStatement = connection.prepareStatement(sql);
	            
	            preparedStatement.setString(1, customer.getFirstName());
	            preparedStatement.setString(2, customer.getLastName());
	            preparedStatement.setString(3, customer.getMobilePhone());
	            preparedStatement.setString(4, customer.getEmail());
	            preparedStatement.setString(5, customer.getPassword());

	            preparedStatement.execute();
	            preparedStatement.close();
	            
	            // mensagem usuario adicionado com sucesso
	            framePrincipal.showCustomerAddedMessage();
	            System.out.println("add");
	           
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        } 
		} else {
			// mensagem de erro customer invalido
			framePrincipal.showCustomerNotAddedMessage();
			System.out.println("not add");
		}
	}

	private boolean isCustomerValid(Customer customer) {
		// TODO Auto-generated method stub
		
		if(customer.getFirstName().isEmpty() || customer.getLastName().isEmpty() || 
				customer.getEmail().isEmpty() || customer.getPassword().isEmpty()) {
			return false;
		}
		
		if(customer.getFirstName().equals(" ") || customer.getLastName().equals(" ") || 
				customer.getEmail().equals(" ") || customer.getPassword().equals(" ")) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public boolean validateCustomerLogin(Customer customer) {
		
		String sql = "SELECT * FROM customer";
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery(sql);
			
			ArrayList<Customer> customers = new ArrayList<>();
			
			while(resultSet.next()) {
				
				customers.add(new Customer(resultSet.getString("email"), resultSet.getString("password")));
				
				for (Customer c : customers) {
					
					if(customer.getEmail().equals(resultSet.getString("email"))) {
						System.out.println(customer.getEmail() + "\t" + resultSet.getString("email"));
						System.out.println("Customer " + resultSet.getString("first_name") + " has been found!" + "\n");
						
						// Customer found
						framePrincipal.getJMenuBar().setVisible(false);
						framePrincipal.setTitle(resultSet.getString("first_name") + " " + "Home");
						framePrincipal.setJMenuBar(new MenuBarCustomer());
						framePrincipal.getCardLayout().
							show(framePrincipal.getCardPanel(), 
									framePrincipal.getPanelCustomerHome().getName());
						
						return true;
					} 
					break; // se cliente encontrado retorna true, sai do laço. senão, retorna false
				}
				
			}
			
		} catch (SQLException e) {
			// SQL Error
			System.out.println("SQL error!!");
			e.printStackTrace();
			
			return false;
		}
		// Customer not found
		framePrincipal.showCustomerNotFoundMessage();
		return false;
	}

}
