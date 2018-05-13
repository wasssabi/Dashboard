package com.softserve.academy.entity;


public class UserEntity extends BaseEntity {
	
	private String name;
    private String login;
    private String password;
    private String email;
    
    public UserEntity(String name,
			String login, String passwd, String email) {
		this.name = name;
		this.login = login;
		this.password = passwd;
		this.email = email;
	}
    

    
    public UserEntity(String login, String passwd) {
		super();
		this.login = login;
		this.password = passwd;
	}



	public UserEntity() {
	}



	//getters 
    
	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}

	public String getPasswd() {
		return password;
	}

	public String getEmail() {
		return email;
		
	}


	//setters
	
	public void setName(String name) {
		this.name = name;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPasswd(String passwd) {
		this.password = passwd;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", login=" + login + ", passwd=" + password + ", email=" + email + "]";
	}



	



	
    
}
