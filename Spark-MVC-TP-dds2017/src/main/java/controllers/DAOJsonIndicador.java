package controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import entities.Indicador;

public class DAOJsonIndicador implements DAOIndicador {
	
	private Gson gson;
	private String filePath;

	public DAOJsonIndicador()
	{
		FilePath filePath = FilePath.getInstance() ;
		String myFilePath = filePath.getIndicadoresJsonPath() ;
		this.filePath = myFilePath ;
		this.gson = new Gson();
	}

	@Override
	public void add(Indicador indicador) throws IOException {
		
	}

	@Override
	public void delete(Indicador indicador) {
		
	}

	@Override
	public ArrayList<Indicador> getAllIndicadores() throws IOException {
		return null;
	}

	@Override
	public void update(Indicador indicador) {
		
	}
	
	

}
