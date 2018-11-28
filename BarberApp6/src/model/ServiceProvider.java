package model;

public class ServiceProvider {
	
	private int id;
	private String name, mobilePhone, email, password;

	public ServiceProvider(String name, String mobilePhone, String email, String password) {
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.password = password;
	}
	
	public ServiceProvider(String emailLoginGiven, String passwordLoginGiven) {
		this.email = emailLoginGiven;
		this.password = passwordLoginGiven;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
}
