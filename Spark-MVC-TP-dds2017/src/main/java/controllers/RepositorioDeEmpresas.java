package controllers;

import java.io.IOException;
import java.util.ArrayList;

import model.Empresa;

public class RepositorioDeEmpresas {

	private DAOEmpresa daoEmpresa ;
	private static RepositorioDeEmpresas instance = null ;
	
	private RepositorioDeEmpresas(DAOEmpresa dao)
	{
		this.daoEmpresa = dao ;
	}
	
	public static RepositorioDeEmpresas getInstance(DAOEmpresa dao)
	{
		
		if ( instance == null )
		{
			instance = new RepositorioDeEmpresas(dao) ;
		}
		return instance ;
	}
	
	public void add(Empresa empresa) throws IOException
	{
		this.daoEmpresa.add(empresa);
	}
	
	public void delete(Empresa empresa)
	{
		this.daoEmpresa.delete(empresa);
	}
	
	public ArrayList<Empresa> getAllEmpresas() throws IOException
	{
		return this.daoEmpresa.getAllEmpresas();
	}
	
	public void update(Empresa empresa)
	{
		this.daoEmpresa.update(empresa);
	}
	
}
