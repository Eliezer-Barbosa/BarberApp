package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelCustomerTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JScrollPane scrollPane;
	private Object [][] data;
	private String [] Columns;
	
	public PanelCustomerTable() {
		
		data = getCustomers();
		
		Columns = new String[] {
				"ID", "First Name", "Last Name", "Email"
		};
		
		table = new JTable(data, Columns);
		scrollPane = new JScrollPane(table);
		add(scrollPane);

	}

	private Object[][] getCustomers() {
		Object[][] data = null;
		
		final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		final String CONNECTION_URL = "jdbc:mysql://localhost/barberapp?useSSL=false";
		final String USERNAME = "root";
		final String PASSWORD = "root";

		final String QUERY = "SELECT id, first_name, last_name, email FROM customer";

		try {

			// Loading the Driver
			Class.forName(DRIVER_NAME);

			// Getting Database Connection Object by Passing URL, Username and Password
			Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(QUERY);

			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getInt("id");
				data[i][j++] = rs.getString("first_name");
				data[i][j++] = rs.getString("last_name");
				data[i][j++] = rs.getString("email");

				i++;
			}

			// Closing the Resources;
			statement.close();
			connection.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

	// Method to get Row Count from ResultSet Object
	private int getRowCount(ResultSet rs) {

		try {
			
			if(rs != null) {
				
				rs.last();
				
				return rs.getRow(); 
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}

	// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) {

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}
}

