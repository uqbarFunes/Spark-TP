package junitTests;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import controllers.DAOJsonEmpresa;
import controllers.FilePath;
import controllers.RepositorioDeEmpresas;
import model.Empresa;

public class TestCuentasHandler {
	
	HashSet<String> cuentasHashSet ;
	FilePath filePath ;
	RepositorioDeEmpresas repoEmpresas ;
	
	@Before
	public void init()
	{
		filePath = FilePath.getInstance() ;
		DAOJsonEmpresa dao = new DAOJsonEmpresa() ; 
		repoEmpresas = RepositorioDeEmpresas.getInstance(dao) ;
		cuentasHashSet = new HashSet<>() ;
	}

	@Test
	public void testHashSetOfCuentasIsProperlySet()
	{
		List<Empresa> empresas;
		try {
			empresas = this.repoEmpresas.getAllEmpresas();
			
			List<String>cuentasList = empresas.stream()
					.map(empresa -> empresa.getCuentas())
					.flatMap(cuentas -> cuentas.stream())
					.map(cuenta -> cuenta.getNombre())
					.collect(Collectors.toList()) ;
			
			cuentasList.forEach(nombreCuenta -> cuentasHashSet.add(nombreCuenta));
			this.cuentasHashSet.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
