package tp.uml.empresa;
import tp.uml.empleado.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Empresa 
{
	private String nombre;
	private int cuit;
	private Collection<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
	private Map<Empleado, List<Recibo>> recibos = new HashMap<>();
	// Prueba
	
	public Collection<Empleado> getListaDeEmpleados()
	{
		return this.listaDeEmpleados;
	}
	
	
	public void agregarEmpleado(Empleado empleado)
	{
		this.listaDeEmpleados.add(empleado);
	}

	
	
	public void generarRecibos()
	// Hacerlo todo en el mismo hash, utilizando containkey.
	{
		for( Empleado empleado: listaDeEmpleados )
		{
			List<Recibo> listaRecibos = recibos.get(empleado);
			
			recibos.get(empleado).add(empleado.generarRecibo());
			// recibos.put( empleado, empleado.generarRecibo() );
			recibos.
		}
	}
	
	public int getTotalSueldosNeto()
	{
		int monto = 0;
		for( Empleado empleado: listaDeEmpleados )
		{
			monto += empleado.sueldoNeto();
		}
		return monto;
	}
	
	public int getTotalSueldosBruto()
	{
		int monto = 0;
		for( Empleado empleado: listaDeEmpleados )
		{
			monto += empleado.sueldoBruto();
		}
		return monto;
	}
	
	public int getTotalRetenciones()
	{
		int monto = 0;
		for( Empleado empleado: listaDeEmpleados )
		{
			monto += empleado.retenciones();
		}
		return monto;
	}
	
	public Empresa(String nombre, int cuit)
	{
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	
}
