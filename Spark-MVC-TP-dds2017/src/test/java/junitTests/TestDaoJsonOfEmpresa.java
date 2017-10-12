package junitTests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.*;
import entities.Cuenta;
import entities.Empresa;
import entities.Periodo;


public class TestDaoJsonOfEmpresa {
	
	private ArrayList<Empresa> empresas ;
	private RepositorioDeEmpresas repoEmpresas ;
	private String filePath ;
	private DAOJsonEmpresa dao ;
	
	@Before
	public void init()
	{
		FilePath path = FilePath.getInstance() ;
		this.filePath = path.getEmpresasJsonPath() ;
		dao = new DAOJsonEmpresa() ;
		repoEmpresas = RepositorioDeEmpresas.getInstance(dao) ;
	}
	
	@Test
	public void archivosJsonEstanEnActualSistema()
	{
		File currentDir = new File (filePath) ;
		//TODO \\indicadores.json , etc...
		Assert.assertTrue(currentDir.exists());
	}
	
	@Test
	public void escriboEmpresasDummy()
	{
		
		List<Empresa> empresas = TestDaoJsonOfEmpresa.createDummyEmpresas();
		try {
			//el DAOJsonEmpresa se encarga de persistir las empresas en arch json
			//este no es trabajo del repo, es coherente delegárselo al dao
			dao.empresasToJsonFile(empresas);
			//
			List<Empresa> empresasQueMeDioElRepo = repoEmpresas.getAllEmpresas();
			TestDaoJsonOfEmpresa.showEmpresaObjects(empresasQueMeDioElRepo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//SOLO MUESTRA TODOS LOS OBJETOS
	public static void showEmpresaObjects(List<Empresa> empresas)
	{
		empresas.forEach(e -> e.showEmployeeDetails());
	}
	
	public static List<Empresa> createDummyEmpresas()
	{
		Empresa e_1 = new Empresa("Facebook");
        Empresa e_2 = new Empresa("Nike");
        Empresa e_3 = new Empresa("Dolce&Gabbana");
        Empresa e_4 = new Empresa("Twitter") ;
        Empresa e_5 = new Empresa ("Snapchat") ;
        Empresa e_6 = new Empresa ("YouTube") ;
        
        //PERIODOS
        Periodo per_1 = new Periodo
        		(LocalDate.of(2013,1,1),LocalDate.of(2013,6,30),152140) ;
        Periodo per_2 = new Periodo
        		(LocalDate.of(2013, 7, 1),LocalDate.of(2013, 12, 31) , 944420) ;
        Periodo per_3 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 14587) ;
        
        List<Periodo> periodos_1 = new ArrayList<>() ;
        periodos_1.add(per_1) ;
        periodos_1.add(per_2) ;
        periodos_1.add(per_3) ;
        
        List<Periodo> periodos_2 = new ArrayList<> () ;
        List<Periodo> periodos_3 = new ArrayList<> () ;
        List<Periodo> periodos_4 = new ArrayList<> () ;
        periodos_1.forEach(e -> {
        							periodos_2.add(e) ;
        							periodos_3.add(e) ;
        							periodos_4.add(e) ;
        						});
        
        Periodo per_4 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 74546) ;
        Periodo per_5 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 23566) ;
        Periodo per_6 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 89563) ;
        
        periodos_2.add(per_4) ;
        periodos_3.add(per_5) ;
        periodos_4.add(per_6) ;
        
        //CUENTAS
        Cuenta c_1 = new Cuenta( "EBITDA" , periodos_1 ) ;
        Cuenta c_2 = new Cuenta ( "FDS" , periodos_1 ) ;
        Cuenta c_3 = new Cuenta ( "Free Cash Flow" , periodos_1 ) ;
        Cuenta c_4 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_2 ) ;
        Cuenta c_5 = new Cuenta ("Ingreso Neto en Operaciones Discontinuadas", periodos_3) ;
        Cuenta c_6 = new Cuenta ( "EBIT" , periodos_4 ) ;
        
        
        
        List<Cuenta> cuentas_1 = new ArrayList<>();
        cuentas_1.add(c_1);
        cuentas_1.add(c_2);
        cuentas_1.add(c_3);

        List<Cuenta> cuentas_2 = new ArrayList<>();
        cuentas_2.add(c_1) ;
        cuentas_2.add(c_3) ;
        cuentas_2.add(c_4) ;
        cuentas_2.add(c_5) ;
        
        List<Cuenta> cuentas_3 = new ArrayList<>();
        cuentas_3.add(c_2) ;
        cuentas_3.add(c_3) ;
        cuentas_3.add(c_5) ;
        cuentas_3.add(c_6) ;
        
        List<Cuenta> cuentas_4 = new ArrayList<>();
        cuentas_4.add(c_4) ;
        cuentas_4.add(c_3) ;
        cuentas_4.add(c_1) ;
        cuentas_4.add(c_6) ;
        
        List<Cuenta> cuentas_5 = new ArrayList<>();
        cuentas_5.add(c_4) ;
        cuentas_5.add(c_3) ;
        cuentas_5.add(c_1) ;
        cuentas_5.add(c_6) ;
        
        List<Cuenta> cuentas_6 = new ArrayList<> () ;
        cuentas_6.add(c_1) ;
        cuentas_6.add(c_5) ;
        cuentas_6.add(c_6) ;
        
        e_1.setCuentas(cuentas_1);
        e_2.setCuentas(cuentas_2);
        e_3.setCuentas(cuentas_3);
        e_4.setCuentas(cuentas_4);
        e_5.setCuentas(cuentas_5);
        e_6.setCuentas(cuentas_6);
        
        List<Empresa> empresas = new ArrayList<>();
        empresas.add( e_2 ) ;
        empresas.add( e_1 ) ;
        empresas.add( e_3 ) ;
        empresas.add( e_4 ) ;
        empresas.add( e_5 ) ;
        empresas.add( e_6 ) ;
        
        return empresas ;
	}

	
	@Test
	public void leoEmpresasYNombresSonCorresctos()
	{
		try{
			this.empresas = repoEmpresas.getAllEmpresas() ;
			Assert.assertEquals("Nike", empresas.get(0).getName());
			Assert.assertEquals("Facebook", empresas.get(1).getName());
			Assert.assertEquals("Dolce&Gabbana", empresas.get(2).getName());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
