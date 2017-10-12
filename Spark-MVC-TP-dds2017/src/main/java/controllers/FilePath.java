package controllers;

import java.nio.file.Paths;

public class FilePath {
	
	public String filePath ;
	private static FilePath instance ;
	
	private FilePath ()
	{
		this.filePath = Paths.get(".").toAbsolutePath().normalize().toString(); 
	}
		
	public static FilePath getInstance()
	{
		if ( instance == null )
		{
			instance = new FilePath ();
		}
		return instance ;
	}
	
	public String getEmpresasJsonPath()
	{
		return this.filePath + "\\empresas.json" ;
	}
	
	public String getIndicadoresJsonPath()
	{
		return this.filePath + "\\indicadores.json" ;
	}
	
}
