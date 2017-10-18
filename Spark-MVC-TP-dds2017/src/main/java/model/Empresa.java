package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String name ;
	List<Cuenta> cuentas ;
	
	public void showEmployeeDetails()
	{
		System.out.println("Empresa name: "+this.name);
		System.out.println("Cuentas: ");
		this.cuentas.forEach(e -> {
			System.out.println(e.getNombre());
			Iterator<Periodo> periodos = e.getPeriodos().iterator();
			while (periodos.hasNext()) {
				Periodo periodo = periodos.next();
				System.out.println("Fecha Inicial: "+periodo.getFechaInicial());
				System.out.println("Fecha Final: "+periodo.getFechaFinal());
				System.out.println("Cotizacion: "+periodo.getCotizacion());
			}
		});
		System.out.println();
	}
	
	public Empresa(String myName)
	{
		this.name = myName ;
		this.cuentas = new ArrayList<> ();
	}
	
	public Empresa(String myName, List<Cuenta> myCuentas )
	{
		this.cuentas = myCuentas ;
	}

	public String getNombre() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void addCuenta (Cuenta cuenta )
	{
		this.cuentas.add(cuenta) ;
 	}
	
}
