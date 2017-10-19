package controllers;

import java.io.IOException;
import java.util.ArrayList;

import model.Indicador;

public interface DAOIndicador {
	public void add (Indicador indicador) throws IOException ;
	public void delete(Indicador indicador) ;
	public ArrayList<Indicador> getAllIndicadores( String user ) throws IOException;
	/*
	 *El método update se va a utilizar cuando quiera hacer uso de
	 *un identificador que tenga el mismo nombre del que estoy
	 *tratando de crear si cumple con todas las condiciones para su
	 *creación.
	 */
	public void update(Indicador indicador) ;
}
