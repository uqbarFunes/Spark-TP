package controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Cuenta;
import model.Empresa;

public class CuentaController {
	
	HashSet<String> nombresDeCuentasSinRepetir ;
	HashSet<String> unrepeatedNombresDeIndicadres ;
	RepositorioDeEmpresas repo ;
	
	public CuentaController(  ) {
		DAOEmpresa dao = new DAOJsonEmpresa() ;
		repo = RepositorioDeEmpresas.getInstance(dao) ;
		try {
			this.setCuentasSinRepetir
						( repo.getAllEmpresas () );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					//don't forget getIndicadores!!!
					//getCuentas() -> devuelve cuentas
					//--------------------------------
	}
	
	public void setCuentasSinRepetir( List <Empresa> empresas )
	{
		this.nombresDeCuentasSinRepetir = new HashSet<>(); 
		Stream <Cuenta>cuentas = empresas.stream()
								.map(e -> e.getCuentas())
								.flatMap(x -> x.stream());
		List<String> nombresDeCuentas = cuentas
								.map(e -> e.getNombre())
								.collect(Collectors.toList());
		nombresDeCuentas.forEach(e -> nombresDeCuentasSinRepetir.add(e));
	}

	public boolean existeLaCuenta(String nombreDeCuenta)
	{
		return this.getNombresDeCuentasSinRepetir().contains(nombreDeCuenta);
	}

	public HashSet<String> getNombresDeCuentasSinRepetir() {
		return this.nombresDeCuentasSinRepetir;
	}

	public List<String> getNombresDeCuentasSinRepetirAsList() {
		return this.getNombresDeCuentasSinRepetir()
				.stream().collect(Collectors.toList());
	}
	
	public void setNombresDeCuentasSinRepetir(HashSet<String> nombresDeCuentasSinRepetir) {
		this.nombresDeCuentasSinRepetir = nombresDeCuentasSinRepetir;
	}
	
}





















