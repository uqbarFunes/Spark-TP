package controllers;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Empresa;

public class DAOJsonEmpresa implements DAOEmpresa {
	
	Gson gson ;
	String filePath ;
	BufferedReader bufferedReader ;
	BufferedWriter bufferedWriter ;
	
	public DAOJsonEmpresa()
	{
		FilePath filePath = FilePath.getInstance() ;
		String myFilePath = filePath.getEmpresasJsonPath() ;
		this.filePath = myFilePath ;
		this.gson = new Gson();
	}
	
	public void setFilePath(String myFilePath)
	{
		this.filePath = myFilePath;
	}
	
	@Override
	public void add(Empresa empresa) throws IOException {
		List<Empresa> empresas = this.getAllEmpresas() ;
		empresas.add(empresa) ;
		this.empresasToJsonFile(empresas);
	}
	
	@Override
	public void delete(Empresa empresa) {
		
		try {
			List<Empresa>empresas = getAllEmpresas();
			List<Empresa> empresasMenosEmpresaAEliminar = 
					empresas.stream()
						.filter(e -> !empresa.getNombre().equals(e.getNombre()))
						.collect(Collectors.toList()) ;
			this.empresasToJsonFile(empresasMenosEmpresaAEliminar);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		//TODO create delete
	}
	@Override
	public ArrayList<Empresa> getAllEmpresas() throws IOException {
		FileReader reader = new FileReader(this.filePath);
		this.bufferedReader = new BufferedReader(reader);
		ArrayList<Empresa> empresas = this.gson
				.fromJson(getJson(), new TypeToken<ArrayList<Empresa>>(){}.getType());
		return empresas;
	}
	
	public void empresasToJsonFile(List<Empresa> empresas)
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(this.filePath))
		{
			gson.toJson(empresas,writer);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getJson() throws IOException
	{
		StringBuilder empresaSerializada = new StringBuilder();
		String linea ;
		while( ( linea = this.bufferedReader.readLine()) != null ) 
		{
			empresaSerializada.append( linea ) ;
		}
		this.bufferedReader.close();
		return empresaSerializada.toString() ;
	}
	
	public int find(String nombreEmpresa) throws IOException
	{
		List<Empresa> empresas;
		try {
			empresas = this.getAllEmpresas();
			List<String> nombresDeEmpresas = new ArrayList<>() ;
			empresas.forEach(e -> nombresDeEmpresas.add(e.getNombre()));
			int index = nombresDeEmpresas.indexOf(nombreEmpresa) ;
			return index ;
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1 ;
		}
	}
	
	@Override
	public void update(Empresa empresa) {
		/*
		 * acerca de update:
		 * �ste m�todo va a recibir una empresa que va a ser
		 * diferente o en el peor de los casos igual a una empresa
		 * que tiene el mismo nombre que una empresa que ya est� en
		 * el repositorio de empresas, �c�mo lo s�? well... antes de
		 * hacer un update voy a hacer un getAllEmpersas(), y voy a modificar
		 * una de las empresas que estoy modificando. Si quisiera agregar, 
		 * simplmente hago add(Empresa empresa), y no estar�a usando �ste m�todo
		 * 
		 * En otras palabras, �ste m�todo pisa una empresa que tiene el mismo
		 * nombre y que indefectiblemente est� en la lista de todas las empresas
		 * que devuelve getAllEmpresas()
		 */
		try {
			ArrayList<Empresa> empresas = this.getAllEmpresas();
			int index = this.find(empresa.getNombre()) ;
			empresas.set(index, empresa) ;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
