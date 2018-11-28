package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import model.ServiceProvider;
import view.FramePrincipal;
import view.MenuBarServiceProvider;

public class ServiceProviderDao {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	FramePrincipal framePrincipal;
	
	public ServiceProviderDao() {
		// TODO Auto-generated constructor stub
		
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
		this.framePrincipal = new FramePrincipal();
		
	}
	
	public void add(ServiceProvider serviceProvider) {
		if(isServiceProviderValid(serviceProvider)) {
			String sql = "INSERT INTO service_provider(name, mobilePhone, email, password) VALUES(?,?,?,?)";
			try { 
	            preparedStatement = connection.prepareStatement(sql);
	            
	            preparedStatement.setString(1, serviceProvider.getName());
	            preparedStatement.setString(2, serviceProvider.getMobilePhone());
	            preparedStatement.setString(3, serviceProvider.getEmail());
	            preparedStatement.setString(4, serviceProvider.getPassword());

	            preparedStatement.execute();
	            preparedStatement.close();
	            
	            // mensagem service provider adicionado com sucesso
	            framePrincipal.showServiceProviderAddedMessage();
	            System.out.println("add");
	           
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        } 
		} else {
			// mensagem de erro customer invalido
			framePrincipal.showServiceProviderNotAddedMessage();
			System.out.println("not add");
		}
	}

	private boolean isServiceProviderValid(ServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		
		if(serviceProvider.getName().isEmpty() || serviceProvider.getMobilePhone().isEmpty() || 
				serviceProvider.getEmail().isEmpty() || serviceProvider.getPassword().isEmpty()) {
			return false;
		}
		
		if(serviceProvider.getName().equals(" ") ||  serviceProvider.getEmail().equals(" ") || serviceProvider.getPassword().equals(" ")) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public boolean validateServiceProviderLogin(ServiceProvider serviceProvider) {
		
		String sql = "SELECT * FROM service_provider";
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery(sql);
			
			ArrayList<ServiceProvider> serviceProviders = new ArrayList<>();
			
			while(resultSet.next()) {
				
				serviceProviders.add(new ServiceProvider(resultSet.getString("email"), resultSet.getString("password")));
				
				for (ServiceProvider sp : serviceProviders) {
					
					if(serviceProvider.getEmail().equals(resultSet.getString("email"))) {
						System.out.println(serviceProvider.getEmail() + "\t" + resultSet.getString("email"));
						System.out.println("service provider " + resultSet.getString("name") + " has been found!" + "\n");
						
						// Service Provider found
						framePrincipal.getJMenuBar().setVisible(false);
						framePrincipal.setTitle(resultSet.getString("name") + " " + "Home");
						framePrincipal.setJMenuBar(new MenuBarServiceProvider());
						framePrincipal.getCardLayout().
							show(framePrincipal.getCardPanel(), 
									framePrincipal.getPanelServiceProviderHome().getName());
						return true;
					} 
					break; // se service provider encontrado retorna true, sai do laço. senão, retorna false
				}
				
			}
			
		} catch (SQLException e) {
			// SQL Error
			System.out.println("SQL error!!");
			e.printStackTrace();
			
			return false;
		}
		// Service Provider not found
		framePrincipal.showServiceProviderNotFoundMessage();
		return false;
	}	

}
