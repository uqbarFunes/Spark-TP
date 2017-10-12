package controllers;


import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;

public interface DAOEmpresa {
	
	public void add (Empresa empresa) throws IOException ;
	public void delete(Empresa empresa) ;
	public ArrayList<Empresa> getAllEmpresas() throws IOException;
	/*
	 * acerca de update:
	 * �ste m�todo va a recibir una empresa que va a ser
	 * diferente o en el peor de los casos igual a una empresa
	 * que tiene el mismo nombre que una empresa que ya est� en
	 * el repositorio de empresas, �c�mo lo s�? well... antes de
	 * hacer un update voy a hacer un getAllEmpersas(), y voy a modificar
	 * una de las empresas que estoy modificando. Sino, simplmente
	 * hago add(Empresa empresa)
	 * 
	 */
	public void update(Empresa empresa) ;
	
}
