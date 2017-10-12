package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.LoginModel;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import entities.Login;

public class LoginController {
	private Map <String, Object> model = new HashMap<>();
	
	public ModelAndView inicio(Request req, Response res)
	{
		/*
		 * ->Tengo que preguntar si el usuario existe y si la contraseña es correcta
		 * req.getParams("")
		 */
		String userName = req.queryParams("userName");
		String pass = req.queryParams("password");
		LoginModel modelLog = LoginModel.getInstance() ;
		List<Login> allUsersAndPass = modelLog.getAllLogins() ;
		
		List <Login> foundUserLst = allUsersAndPass.stream().filter(u -> 
			u.getUserName().equals(userName) && u.getPassword().equals(pass)
				).collect(Collectors.toList()) ;
		try
		{
			model.put ( "usuario" , foundUserLst.get(0).getUserName() ) ;
			System.out.println(foundUserLst.get(0).getUserName());
			System.out.println(foundUserLst.get(0).getPassword());
			/*
			 * welcome.hbs va a tener un text escondido que va a
			 * guardar el dato del nombre de usuario,
			 * va a tener tres form, donde cada uno va a llevar a 
			 * otro path
			 */
		}
		catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		return new ModelAndView ( model , "login.hbs" ) ;
	}
	
}














