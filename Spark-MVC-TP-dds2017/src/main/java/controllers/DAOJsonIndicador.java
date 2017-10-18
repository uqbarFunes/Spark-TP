package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Empresa;
import model.Indicador;

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
	
	public int find(String nombreEmpresa, String myUsuario) throws IOException
	{
		List<Indicador> indicadores;
		try {
			indicadores = this.getAllIndicadores();
			List<String> nombresDeIndicadores = new ArrayList<>() ;
			indicadores.forEach(e -> nombresDeIndicadores.add(e.getNombre()));
			int index = nombresDeIndicadores.indexOf(nombreEmpresa) ;
			return index ;
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1 ;
		}
	}

	@Override
	public ArrayList<Indicador> getAllIndicadores() throws IOException {
		return null;
	}

	@Override
	public void update(Indicador indicador) {
		
	}
	
	

}
