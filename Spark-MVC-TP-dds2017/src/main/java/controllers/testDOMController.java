package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class testDOMController {

private Map <String,Object>model = new HashMap<>();
	
	public ModelAndView inicio(Request req, Response res)
	{
		return new ModelAndView(model, "testDOM.hbs") ;
	}
}
