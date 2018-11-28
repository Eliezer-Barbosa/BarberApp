package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import model.Admin;
import view.FramePrincipal;
import view.MenuBarAdmin;

public class AdminDao {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	FramePrincipal framePrincipal;
	
	public AdminDao() {
		// TODO Auto-generated constructor stub
		
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
		this.framePrincipal = new FramePrincipal();
		
	}
	
	public void add(Admin admin) {
		if(isAdminValid(admin)) {
			String sql = "INSERT INTO admin(email, password) VALUES(?,?)";
			try { 
	            preparedStatement = connection.prepareStatement(sql);
	            
	            preparedStatement.setString(1, admin.getEmail());
	            preparedStatement.setString(2, admin.getPassword());

	            preparedStatement.execute();
	            preparedStatement.close();
	            
	            // mensagem admin adicionado com sucesso
	            //framePrincipalController.showServiceProviderAddedMessage();
	           
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        } 
		} else {
			// mensagem de erro admin invalido
			//framePrincipalController.showAdminNotAddedMessage();
		}
	}

	private boolean isAdminValid(Admin admin) {
		// TODO Auto-generated method stub
		
		if(admin.getEmail().isEmpty() || admin.getPassword().isEmpty()) {
			return false;
		}
		
		if(admin.getEmail().equals(" ") || admin.getPassword().equals(" ")) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public boolean validateAdminLogin(Admin admin) {
		
		String sql = "SELECT * FROM admin";
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery(sql);
			
			ArrayList<Admin> admins = new ArrayList<>();
			
			while(resultSet.next()) {
				
				admins.add(new Admin(resultSet.getString("email"), resultSet.getString("password")));
				
				for (Admin ad : admins) {
					
					if(admin.getEmail().equals(resultSet.getString("email"))) {
						System.out.println(admin.getEmail() + "\t" + resultSet.getString("email"));
						System.out.println("admin " + resultSet.getString("nome") + " has been found!" + "\n");
						
						framePrincipal.getJMenuBar().setVisible(false);
						framePrincipal.setTitle("Admin Home");
						framePrincipal.setJMenuBar(new MenuBarAdmin(framePrincipal));
						framePrincipal.getCardLayout().
							show(framePrincipal.getCardPanel(), 
									framePrincipal.getPanelAdminHome().getName());
						
						return true;
					} 
					break; // se admin encontrado retorna true, sai do laço. senão, retorna false
				}
				
			}
			
		} catch (SQLException e) {
	
			System.out.println("SQL error!!");
			e.printStackTrace();
			
			return false;
		}
		System.out.println("not found");
		framePrincipal.showAdminNotFoundMessage();
		return false;
	}	

}
