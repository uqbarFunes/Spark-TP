package controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Cuenta;
import entities.Empresa;

public class CuentasHandler {
	
	HashSet<String> unrepeatedNombresDeCuentas ;
	HashSet<String> unrepeatedNombresDeIndicadres ;
	RepositorioDeEmpresas repo ;
	
	public CuentasHandler(  ) {
		DAOEmpresa dao = new DAOJsonEmpresa() ;
		repo = RepositorioDeEmpresas.getInstance(dao) ;
		try {
			this.setUnrepeatedCuentasEIndicadores
						( repo.getAllEmpresas () );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					//don't forget getIndicadores!!!
					//getCuentas() -> devuelve cuentas
					//--------------------------------
	}
	
	public void setUnrepeatedCuentasEIndicadores( List <Empresa> empresas )
	{
		this.unrepeatedNombresDeCuentas = new HashSet<>(); 
		Stream <Cuenta>cuentas = empresas.stream()
								.map(e -> e.getCuentas())
								.flatMap(x -> x.stream());
		List<String> nombresDeCuentas = cuentas
								.map(e -> e.getNombre())
								.collect(Collectors.toList());
		nombresDeCuentas.forEach(e -> unrepeatedNombresDeCuentas.add(e));
	}

	public boolean existeLaCuenta(String nombreDeCuenta)
	{
		return this.getUnrepeatedNombresDeCuentas().contains(nombreDeCuenta);
	}

	public HashSet<String> getUnrepeatedNombresDeCuentas() {
		return this.unrepeatedNombresDeCuentas;
	}

	public List<String> getUnrepeatedNombresDeCuentasAsList() {
		return this.getUnrepeatedNombresDeCuentas()
				.stream().collect(Collectors.toList());
	}
	
	public void setUnrepeatedNombresDeCuentas(HashSet<String> unrepeatedNombresDeCuentas) {
		this.unrepeatedNombresDeCuentas = unrepeatedNombresDeCuentas;
	}
	
}





















