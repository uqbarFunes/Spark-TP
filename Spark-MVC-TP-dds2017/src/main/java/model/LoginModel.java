package model;
import entities.Login;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class LoginModel 
{
	private List <Login> logins ;
	private static LoginModel instance = null ;
	
	public static LoginModel getInstance()
	{
		if ( instance == null )
		{
			instance = new LoginModel () ;
		}
		return instance ;
	}
	
	private LoginModel () 
	{
		this.logins = new LinkedList<>() ;
		this.dummyUsers();
	}
	
	private void dummyUsers()
	{
		Login log1 = new Login("admin", "admin") ;
		Login log2 = new Login("gas", "ton") ;
		
		logins.add(log1) ;
		logins.add(log2) ;
	}
	
	public void addLogin (Login log)
	{
		this.logins.add(log) ;
	}
	
	public List<Login> getAllLogins()
	{
		return this.logins ;
	}
	
	public Login get(String myUserName)
	{
		List<Login> users = this.logins.stream().filter(u -> u.getUserName()
				.equals(myUserName)).collect(Collectors.toList()) ;
		return users.get(0) ;
	}
	
}
