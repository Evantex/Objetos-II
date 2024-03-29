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
        for (Map.Entry<Empleado, List<Recibo>> entry : recibos.entrySet())
        {
            // Obtener la lista de recibos para la clave actual
            List<Recibo> recibosActualizado = entry.getValue();

            // Agregar un nuevo recibo a la lista de recibos
            Recibo nuevoRecibo = entry.getKey().generarRecibo();
            recibosActualizado.add(nuevoRecibo);

            // Actualizar la lista de recibos en el HashMap
            recibos.put(entry.getKey(), recibosActualizado);
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

