package controllers;

import entities.Indicador;

import java.io.IOException;
import java.util.ArrayList;

public class RepositorioDeIndicadores {
	
	private DAOIndicador daoIndicador ;
	private static RepositorioDeIndicadores instance = null ;
	
	private RepositorioDeIndicadores (DAOIndicador dao)
	{
		this.daoIndicador = dao ;
	}
	
	public static RepositorioDeIndicadores getInstance(DAOIndicador dao)
	{
		if (instance == null)
		{
			return new RepositorioDeIndicadores(dao) ;
		}
		return instance ;
	}
	

	public void add(Indicador indicador) throws IOException
	{
		this.daoIndicador.add(indicador);
	}
	
	public void delete(Indicador indicador)
	{
		this.daoIndicador.delete(indicador);
	}
	
	public void update(Indicador indicador)
	{
		this.daoIndicador.update(indicador);
	}
	
	public ArrayList<Indicador> getAllIndicadores () throws IOException
	{
		return this.daoIndicador.getAllIndicadores() ;
	}

}
