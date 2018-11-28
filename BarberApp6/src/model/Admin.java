package model;

public class Admin {
	
	private String nome, email, password;
	
	public Admin(String emailLoginGiven, String passwordLoginGiven) {
		this.email = emailLoginGiven;
		this.password = passwordLoginGiven;
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
