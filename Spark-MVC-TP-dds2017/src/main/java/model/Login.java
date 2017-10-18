package model;

public class Login {
	private String userName ;
	private String password ;
	
	public Login(String myUser, String myPass)
	{
		this.userName = myUser ;
		this.password = myPass ;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
