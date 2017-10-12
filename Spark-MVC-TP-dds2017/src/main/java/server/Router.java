package server;

import controllers.*;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
	public static void configure(){
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();

		Spark.staticFiles.location("/public");
		
		InicioController inicioController = new InicioController() ;
		LoginController loginController = new LoginController () ;
		DragAndDropController dragController = new DragAndDropController() ;
//		EmpresasController empresasController = new EmpresasController () ;
		testDOMController testDOMController = new testDOMController();
		Spark.get("/testDOM", testDOMController::inicio, engine);
		
		Spark.get("/", inicioController::inicio, engine);
		Spark.post("/login", loginController::inicio, engine);
		Spark.get("/drag", dragController::inicio, engine);
//		Spark.post("/empresas", empresasController::mostrar);
//		Spark.post... oindicadores
	// ... metodlogias
	}
}
