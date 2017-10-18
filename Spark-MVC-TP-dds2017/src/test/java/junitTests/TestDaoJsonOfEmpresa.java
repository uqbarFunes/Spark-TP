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
import model.Cuenta;
import model.Empresa;
import model.Periodo;


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
		Empresa facebook = new Empresa("Facebook");
        Empresa nike = new Empresa("Nike");
        Empresa dolce = new Empresa("Dolce&Gabbana");
        Empresa twitter = new Empresa("Twitter") ;
        Empresa snap = new Empresa ("Snapchat") ;
        Empresa yt = new Empresa ("YouTube") ;
        
        //PERIODOS
        List<Periodo> periodos_1 = new ArrayList<>() ;
        List<Periodo> periodos_2 = new ArrayList<> () ;
        List<Periodo> periodos_3 = new ArrayList<> () ;
        List<Periodo> periodos_4 = new ArrayList<> () ;
        List<Periodo> periodos_5 = new ArrayList<>() ;
        List<Periodo> periodos_6 = new ArrayList<> () ;
        List<Periodo> periodos_7 = new ArrayList<> () ;
        List<Periodo> periodos_8 = new ArrayList<> () ;
        List<Periodo> periodos_9 = new ArrayList<>() ;
        List<Periodo> periodos_10 = new ArrayList<> () ;
        List<Periodo> periodos_11 = new ArrayList<> () ;
        List<Periodo> periodos_12 = new ArrayList<> () ;
        List<Periodo> periodos_13 = new ArrayList<>() ;
        List<Periodo> periodos_14 = new ArrayList<> () ;
        List<Periodo> periodos_15 = new ArrayList<> () ;
        List<Periodo> periodos_16 = new ArrayList<> () ;
        List<Periodo> periodos_17 = new ArrayList<> () ;
        List<Periodo> periodos_18 = new ArrayList<> () ;
        List<Periodo> periodos_19 = new ArrayList<>() ;
        
        List<Periodo> periodos_20 = new ArrayList<> () ;
        List<Periodo> periodos_21 = new ArrayList<>() ;
        List<Periodo> periodos_22 = new ArrayList<> () ;
        List<Periodo> periodos_23 = new ArrayList<> () ;
        List<Periodo> periodos_24 = new ArrayList<> () ;
        List<Periodo> periodos_25 = new ArrayList<>() ;
        List<Periodo> periodos_26 = new ArrayList<> () ;
        List<Periodo> periodos_27 = new ArrayList<> () ;
        List<Periodo> periodos_28 = new ArrayList<> () ;
        List<Periodo> periodos_29 = new ArrayList<>() ;
        
        List<Periodo> periodos_30 = new ArrayList<> () ;
        List<Periodo> periodos_31 = new ArrayList<>() ;
        List<Periodo> periodos_32 = new ArrayList<> () ;
        List<Periodo> periodos_33 = new ArrayList<> () ;
        List<Periodo> periodos_34 = new ArrayList<> () ;
        List<Periodo> periodos_35 = new ArrayList<>() ;
        List<Periodo> periodos_36 = new ArrayList<> () ;
        List<Periodo> periodos_37 = new ArrayList<> () ;
        List<Periodo> periodos_38 = new ArrayList<> () ;
        List<Periodo> periodos_39 = new ArrayList<>() ;
        
        Periodo per_1 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 12, 31), 74546) ;
        Periodo per_2 = new Periodo
        		(LocalDate.of(2010, 1, 1),LocalDate.of(2010,  6, 30) , 152140) ;
        Periodo per_3 = new Periodo
        		(LocalDate.of(2010, 7, 1),LocalDate.of(2010, 12, 31) , 944420) ;
        Periodo per_4 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 14587) ;
        Periodo per_5 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 23566) ;
        Periodo per_6 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 800000) ;
        Periodo per_7 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 789456123) ;
        Periodo per_8 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 93331) ;
        Periodo per_9 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 64246) ;
        Periodo per_10 = new Periodo
        		(LocalDate.of(2008, 1, 1), LocalDate.of(2008, 12, 31), 89000) ;
        
        Periodo per_11 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 12, 31), 123456) ;
        Periodo per_12 = new Periodo
        		(LocalDate.of(2010, 1, 1),LocalDate.of(2010,  6, 30) , 789456) ;
        Periodo per_13 = new Periodo
        		(LocalDate.of(2010, 7, 1),LocalDate.of(2010, 12, 31) , 52896) ;
        Periodo per_14 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 49731) ;
        Periodo per_15 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 46791) ;
        Periodo per_16 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 6970) ;
        Periodo per_17 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 321678) ;
        Periodo per_18 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 13976) ;
        Periodo per_19 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 4646258) ;
        
        Periodo per_20 = new Periodo
        		(LocalDate.of(2007, 1, 1), LocalDate.of(2007, 12, 31), 794679) ;
        Periodo per_21 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 6, 30), 23462) ;
        Periodo per_22 = new Periodo
        		(LocalDate.of(2009, 7, 1), LocalDate.of(2009, 12, 31), 303456) ;
        Periodo per_23 = new Periodo
        		(LocalDate.of(2010, 1, 1),LocalDate.of(2010, 12, 31) , 666666) ;
        Periodo per_24 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 333666) ;
        Periodo per_25 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 11133) ;
        Periodo per_26 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 8000024) ;
        Periodo per_27 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 126798) ;
        Periodo per_28 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 1658) ;
        Periodo per_29 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 896241) ;
        
        Periodo per_30 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 98764531) ;
        Periodo per_31 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 948165) ;
        Periodo per_32 = new Periodo
        		(LocalDate.of(2010, 1, 1), LocalDate.of(2010, 12, 31), 98146) ;
        Periodo per_33 = new Periodo
        		(LocalDate.of(2007, 1, 1),LocalDate.of(2007, 12, 31) , 923165) ;
        Periodo per_34 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 12346) ;
        Periodo per_35 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 668763) ;
        Periodo per_36 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 3041656) ;
        Periodo per_37 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 20168) ;
        Periodo per_38 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 444666) ;
        Periodo per_39 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 77756) ;

        Periodo per_40 = new Periodo
        		(LocalDate.of(2008, 1, 1), LocalDate.of(2008, 12, 31), 446655) ;
        Periodo per_41 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 6, 30), 65558) ;
        Periodo per_42 = new Periodo
        		(LocalDate.of(2009, 7, 1), LocalDate.of(2009, 12, 31), 33315) ;
        Periodo per_43 = new Periodo
        		(LocalDate.of(2010, 1, 1),LocalDate.of(2010, 6, 30) , 15665) ;
        Periodo per_44 = new Periodo
        		(LocalDate.of(2010, 7, 1), LocalDate.of(2010, 12, 31), 198765) ;
        Periodo per_45 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 323232) ;
        Periodo per_46 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 239669) ;
        Periodo per_47 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 7765) ;
        Periodo per_48 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 5196851) ;
        Periodo per_49 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 19859) ;
        
        Periodo per_50 = new Periodo
        		(LocalDate.of(2008, 1, 1), LocalDate.of(2008, 12, 31), 525258) ;
        Periodo per_51 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 6, 30), 28282825) ;
        Periodo per_52 = new Periodo
        		(LocalDate.of(2009, 7, 1), LocalDate.of(2009, 12, 31), 369636) ;
        Periodo per_53 = new Periodo
        		(LocalDate.of(2010, 1, 1),LocalDate.of(2010, 12, 31) , 369663) ;
        Periodo per_54 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 88636) ;
        Periodo per_55 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 26969) ;
        Periodo per_56 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 3646469) ;
        Periodo per_57 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 97985) ;
        Periodo per_58 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 112355) ;
        Periodo per_59 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 222456) ;
        
        Periodo per_60 = new Periodo
        		(LocalDate.of(2008, 1, 1), LocalDate.of(2008, 12, 31), 335654) ;
        Periodo per_61 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 12, 31), 35468) ;
        Periodo per_62 = new Periodo
        		(LocalDate.of(2010, 1, 1), LocalDate.of(2010, 12, 31), 34225) ;
        Periodo per_63 = new Periodo
        		(LocalDate.of(2011, 1, 1),LocalDate.of(2011, 12, 31) , 223658) ;
        Periodo per_64 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 58798) ;
        Periodo per_65 = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 55897) ;
        Periodo per_66 = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 50546) ;
        Periodo per_67 = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 565468) ;
        Periodo per_68 = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 98799) ;
        Periodo per_69 = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 89879) ;
        Periodo per_70 = new Periodo
        		(LocalDate.of(2008, 1, 1), LocalDate.of(2008, 12, 31), 9879846) ;
        Periodo per_71 = new Periodo
        		(LocalDate.of(2009, 1, 1), LocalDate.of(2009, 12, 31), 98798) ;
        Periodo per_72 = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 669879) ;
        Periodo per_73 = new Periodo
        		(LocalDate.of(2010, 1, 1), LocalDate.of(2010, 12, 31), 4569) ;
        Periodo per_74 = new Periodo
        		(LocalDate.of(2007, 1, 1), LocalDate.of(2007, 12, 31), 4894984) ;
        Periodo per_7a = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 14587) ;
        periodos_3.add(per_7a) ;
        Periodo per_7b = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 70532) ;
        periodos_3.add(per_7b) ;
        Periodo per_7c = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2014, 12, 31), 100009) ;
        Periodo per_10a = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 887779) ;
        periodos_4.add(per_10a) ;
        Periodo per_10b = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 796524) ;
        periodos_4.add(per_10b) ;
        Periodo per_10c = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 997545) ;
        Periodo per_10d = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 556487) ;
        Periodo per_43a = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 97465) ;
        periodos_15.add(per_43a) ;
        Periodo per_43b = new Periodo
        		(LocalDate.of(2014, 1, 1), LocalDate.of(2014, 12, 31), 388346) ;
        periodos_15.add(per_43b) ;
        Periodo per_43c = new Periodo
        		(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 12, 31), 80064) ;
        periodos_15.add(per_43c) ;
        Periodo per_43d = new Periodo
        		(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 31), 721654) ;
        Periodo per_47a = new Periodo
        		(LocalDate.of(2013, 1, 1), LocalDate.of(2013, 12, 31), 54555) ;
        Periodo per_47b = new Periodo
        		(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 12, 31), 459876) ;
        Periodo per_12a = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 63648) ;
        periodos_25.add(per_12a) ;
        Periodo per_12b = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 63648) ;
        Periodo per_67a = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 63648) ;
        periodos_26.add(per_67a) ;
        Periodo per_67b = new Periodo
        		(LocalDate.of(2011, 1, 1), LocalDate.of(2011, 12, 31), 63648) ;
        

        periodos_1.add(per_1) ;
        periodos_1.add(per_2) ;
        periodos_1.add(per_3) ;
        
        periodos_2.add(per_4) ;
        periodos_2.add(per_5) ;
        periodos_2.add(per_6) ;
        periodos_3.add(per_7c) ;
        periodos_3.add(per_7) ;
        periodos_3.add(per_8) ;
        periodos_3.add(per_9) ;
        periodos_4.add(per_10c) ;
        periodos_4.add(per_10d) ;
        periodos_4.add(per_10) ;
        periodos_4.add(per_11) ;
        periodos_4.add(per_12) ;
        periodos_4.add(per_13) ;
        
        periodos_5.add(per_12) ;
        periodos_5.add(per_13) ;
        periodos_5.add(per_14) ;
        periodos_5.add(per_15) ;
        periodos_5.add(per_16) ;
        
        periodos_6.add(per_17) ;
        periodos_6.add(per_18) ;
        periodos_6.add(per_19) ;
        periodos_6.add(per_20) ;
        
        periodos_7.add(per_21) ;
        periodos_7.add(per_22) ;
        periodos_7.add(per_23) ;
        periodos_7.add(per_24) ;
        
        
        periodos_8.add(per_25) ;
        periodos_8.add(per_26) ;
        periodos_8.add(per_27) ;
        periodos_8.add(per_28) ;
        
        
        periodos_9.add(per_29) ;
        periodos_9.add(per_30) ;
        periodos_9.add(per_31) ;
        periodos_9.add(per_32) ;
        
        periodos_10.add(per_33) ;
        periodos_10.add(per_34) ;
        periodos_10.add(per_35) ;
        periodos_10.add(per_36) ;
        
        periodos_11.add(per_71) ;
        periodos_11.add(per_72) ;
        periodos_11.add(per_73) ;
        
        periodos_12.add(per_74) ;
        periodos_12.add(per_45) ;
        periodos_12.add(per_46) ;
        
        periodos_13.add(per_37) ;
        periodos_13.add(per_38) ;
        periodos_13.add(per_39) ;
        
        periodos_14.add(per_40) ;
        periodos_14.add(per_41) ;
        periodos_14.add(per_42) ;
        periodos_15.add(per_43d) ;
        periodos_15.add(per_43) ;
        periodos_15.add(per_44) ;
        periodos_15.add(per_45) ;
        periodos_15.add(per_46) ;
        
        periodos_16.add(per_47a) ;
        periodos_16.add(per_47b) ;
        periodos_16.add(per_47) ;
        periodos_16.add(per_48) ;
        periodos_16.add(per_49) ;
        periodos_16.add(per_50) ;
        
        periodos_17.add(per_51) ;
        periodos_17.add(per_52) ;
        periodos_17.add(per_53) ;
        periodos_17.add(per_54) ;
        
        
        periodos_18.add(per_55) ;
        periodos_18.add(per_56) ;
        periodos_18.add(per_57) ;
        periodos_18.add(per_58) ;
        
        
        periodos_19.add(per_59) ;
        periodos_19.add(per_60) ;
        periodos_19.add(per_61) ;
        periodos_19.add(per_62) ;
        
        periodos_20.add(per_63) ;
        periodos_20.add(per_64) ;
        periodos_20.add(per_65) ;
        periodos_20.add(per_66) ;
        
        periodos_21.add(per_71) ;
        periodos_21.add(per_72) ;
        periodos_21.add(per_73) ;
        
        periodos_22.add(per_74) ;
        periodos_22.add(per_70) ;
        periodos_22.add(per_6) ;
        
        periodos_23.add(per_37) ;
        periodos_23.add(per_38) ;
        periodos_23.add(per_39) ;
        
        periodos_24.add(per_10) ;
        periodos_24.add(per_11) ;
        periodos_24.add(per_12) ;
        periodos_24.add(per_13) ;
        periodos_25.add(per_12b) ;
        periodos_25.add(per_12) ;
        periodos_25.add(per_13) ;
        periodos_25.add(per_14) ;
        periodos_25.add(per_15) ;
        periodos_25.add(per_16) ;
        
        periodos_26.add(per_67b) ;
        periodos_26.add(per_67) ;
        periodos_26.add(per_68) ;
        periodos_26.add(per_69) ;
        periodos_26.add(per_70) ;
        
        periodos_27.add(per_21) ;
        periodos_27.add(per_22) ;
        periodos_27.add(per_23) ;
        periodos_27.add(per_24) ;
        
        periodos_28.add(per_25) ;
        periodos_28.add(per_26) ;
        periodos_28.add(per_27) ;
        periodos_28.add(per_28) ;
        
        periodos_29.add(per_29) ;
        periodos_29.add(per_30) ;
        periodos_29.add(per_31) ;
        periodos_29.add(per_32) ;
        
        periodos_30.add(per_33) ;
        periodos_30.add(per_34) ;
        periodos_30.add(per_35) ;
        periodos_30.add(per_36) ;
        
        periodos_31.add(per_21) ;
        periodos_31.add(per_22) ;
        periodos_31.add(per_23) ;
        
        periodos_32.add(per_43) ;
        periodos_32.add(per_44) ;
        periodos_32.add(per_45) ;
        periodos_32.add(per_46) ;
        
        periodos_33.add(per_47) ;
        periodos_33.add(per_48) ;
        periodos_33.add(per_49) ;
        
        periodos_34.add(per_30) ;
        periodos_34.add(per_31) ;
        periodos_34.add(per_32) ;
        
        periodos_35.add(per_33) ;
        periodos_35.add(per_34) ;
        periodos_35.add(per_35) ;
        periodos_35.add(per_36) ;
        
        periodos_36.add(per_67) ;
        periodos_36.add(per_68) ;
        periodos_36.add(per_69) ;
        periodos_36.add(per_60) ;
        
        periodos_37.add(per_51) ;
        periodos_37.add(per_52) ;
        periodos_37.add(per_53) ;
        periodos_37.add(per_54) ;
        
        
        periodos_38.add(per_55) ;
        periodos_38.add(per_56) ;
        periodos_38.add(per_57) ;
        periodos_38.add(per_58) ;
        
        periodos_39.add(per_59) ;
        periodos_39.add(per_60) ;
        periodos_39.add(per_1) ;
        periodos_39.add(per_2) ;
        periodos_39.add(per_3) ;
        //FACEBOOK
        Cuenta c_1 = new Cuenta( "EBITDA" , periodos_1 ) ;
        Cuenta c_2 = new Cuenta ( "FDS" , periodos_2 ) ;
        Cuenta c_3 = new Cuenta ( "Free Cash Flow" , periodos_3 ) ;
        Cuenta c_4 = new Cuenta ( "EBIT" , periodos_4 ) ;
        Cuenta c_5 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_5 ) ;
        Cuenta c_6 = new Cuenta( "Ingreso Neto en Operaciones Discontinuadas", periodos_6 ) ;
        //agregar 2011-2012 2012-2013 2013-2014 
        Cuenta c_6b = new Cuenta( "Dividendos", periodos_3 ) ;
        //agregar 2011-2012 2012-2013 2013-2014 2015-2016 
        Cuenta c_6c = new Cuenta( "Capital Total", periodos_4 ) ;
        //Nike
        Cuenta c_7 = new Cuenta( "EBITDA" , periodos_7 ) ;
        Cuenta c_8 = new Cuenta ( "FDS" , periodos_8 ) ;
        Cuenta c_9 = new Cuenta ( "Free Cash Flow" , periodos_9 ) ;
        Cuenta c_10 = new Cuenta ( "EBIT" , periodos_10 ) ;
        Cuenta c_11 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_11 ) ;
        Cuenta c_12 = new Cuenta( "Ingreso Neto en Operaciones Discontinuadas", periodos_12 ) ;
        //DOLCE
        Cuenta c_13 = new Cuenta( "EBITDA" , periodos_13 ) ;
        Cuenta c_14 = new Cuenta ( "FDS" , periodos_14 ) ;
        Cuenta c_15 = new Cuenta ( "Free Cash Flow" , periodos_15 ) ;
        Cuenta c_16 = new Cuenta ( "EBIT" , periodos_16 ) ;
        Cuenta c_17 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_17 ) ;
        Cuenta c_18 = new Cuenta( "Ingreso Neto en Operaciones Discontinuadas", periodos_18 ) ;
        //agregar 2014-2015 2015-2016 2016-2017 2011-2012
        Cuenta c_18b = new Cuenta( "Dividendos", periodos_15 ) ;
        //agregar 2013-2014 2012-2013
        Cuenta c_18c = new Cuenta( "Capital Total", periodos_16 ) ;
        
        //TWITTER
        Cuenta c_19 = new Cuenta( "EBITDA" , periodos_19 ) ;
        Cuenta c_20 = new Cuenta ( "FDS" , periodos_20 ) ;
        Cuenta c_21 = new Cuenta ( "Free Cash Flow" , periodos_21 ) ;
        Cuenta c_22 = new Cuenta ( "EBIT" , periodos_22 ) ;
        Cuenta c_23 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_23 ) ;
        Cuenta c_24 = new Cuenta( "Ingreso Neto en Operaciones Discontinuadas", periodos_24 ) ;
        
        //SNAPCHAT
        Cuenta c_25 = new Cuenta( "EBITDA" , periodos_25 ) ;
        Cuenta c_26 = new Cuenta ( "FDS" , periodos_26 ) ;
        Cuenta c_27 = new Cuenta ( "Free Cash Flow" , periodos_27 ) ;
        Cuenta c_28 = new Cuenta ( "EBIT" , periodos_28 ) ;
        Cuenta c_29 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_29 ) ;
        Cuenta c_30 = new Cuenta( "Ingreso Neto en Operaciones Discontinuadas", periodos_30 ) ;
        //agregar 2014-2015 2015-2016
        Cuenta c_30b = new Cuenta( "Dividendos", periodos_25) ;
        //agregar 2013-2014 2012-2013
        Cuenta c_30c = new Cuenta( "Capital Total", periodos_26 ) ;
        
        //YOUTUBE
        Cuenta c_31 = new Cuenta( "EBITDA" , periodos_31 ) ;
        Cuenta c_32 = new Cuenta ( "FDS" , periodos_32 ) ;
        Cuenta c_33 = new Cuenta ( "Free Cash Flow" , periodos_33 ) ;
        Cuenta c_34 = new Cuenta ( "EBIT" , periodos_34 ) ;
        Cuenta c_35 = new Cuenta( "Ingreso Neto en Operaciones Continuas", periodos_35 ) ;
        Cuenta c_36 = new Cuenta( "Ingreso Neto en Operaciones Discontinuadas", periodos_36 ) ;
        
        
        //CUENTAS
        
        List<Cuenta> cuentas_1 = new ArrayList<>();
        cuentas_1.add(c_1);
        cuentas_1.add(c_2);
        cuentas_1.add(c_3);
        cuentas_1.add(c_4) ;
        cuentas_1.add(c_5) ;
        cuentas_1.add(c_6) ;
        cuentas_1.add(c_6b) ;
        cuentas_1.add(c_6c) ;

        List<Cuenta> cuentas_2 = new ArrayList<>();
        cuentas_2.add(c_7) ;
        cuentas_2.add(c_8) ;
        cuentas_2.add(c_9) ;
        cuentas_2.add(c_10) ;
        cuentas_2.add(c_11) ;
        cuentas_2.add(c_12) ;
        
        List<Cuenta> cuentas_3 = new ArrayList<>();
        cuentas_3.add(c_13) ;
        cuentas_3.add(c_14) ;
        cuentas_3.add(c_15) ;
        cuentas_3.add(c_16) ;
        cuentas_3.add(c_17) ;
        cuentas_3.add(c_18) ;
        cuentas_3.add(c_18b) ;
        cuentas_3.add(c_18c) ;
        
        List<Cuenta> cuentas_4 = new ArrayList<>();
        cuentas_4.add(c_19) ;
        cuentas_4.add(c_20) ;
        cuentas_4.add(c_21) ;
        cuentas_4.add(c_22) ;
        cuentas_4.add(c_23) ;
        cuentas_4.add(c_24) ;
        
        List<Cuenta> cuentas_5 = new ArrayList<>();
        cuentas_5.add(c_25) ;
        cuentas_5.add(c_26) ;
        cuentas_5.add(c_27) ;
        cuentas_5.add(c_28) ;
        cuentas_5.add(c_29) ;
        cuentas_5.add(c_30) ;
        cuentas_5.add(c_30b) ;
        cuentas_5.add(c_30c) ;
        
        List<Cuenta> cuentas_6 = new ArrayList<> () ;
        cuentas_6.add(c_31) ;
        cuentas_6.add(c_32) ;
        cuentas_6.add(c_33) ;
        cuentas_6.add(c_34) ;
        cuentas_6.add(c_35) ;
        cuentas_6.add(c_36) ;
        
        nike.setCuentas(cuentas_2);
        facebook.setCuentas(cuentas_1);
        dolce.setCuentas(cuentas_3);
        twitter.setCuentas(cuentas_4);
        snap.setCuentas(cuentas_5);
        yt.setCuentas(cuentas_6);
        
        List<Empresa> empresas = new ArrayList<>();
        empresas.add( nike ) ;
        empresas.add( facebook ) ;
        empresas.add( dolce ) ;
        empresas.add( twitter ) ;
        empresas.add( snap ) ;
        empresas.add( yt ) ;
        
        return empresas ;
	}

	
	@Test
	public void leoEmpresasYNombresSonCorresctos()
	{
		try{
			this.empresas = repoEmpresas.getAllEmpresas() ;
			Assert.assertEquals("Nike", empresas.get(0).getNombre());
			Assert.assertEquals("Facebook", empresas.get(1).getNombre());
			Assert.assertEquals("Dolce&Gabbana", empresas.get(2).getNombre());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
