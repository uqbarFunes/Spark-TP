package controllers;

import java.util.HashMap;
import java.util.Map;

import model.LoginModel;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class InicioController {
	private Map <String,Object>model = new HashMap<>();
	
	public ModelAndView inicio(Request req, Response res)
	{
		LoginModel modelLog = LoginModel.getInstance() ;
		model.put("usuarios", modelLog.getAllLogins()) ;
		return new ModelAndView(model, "inicio.hbs") ;
	}
}
