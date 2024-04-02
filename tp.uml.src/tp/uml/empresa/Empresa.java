package tp.uml.empresa;
import tp.uml.empleado.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Empresa 
{
	private String nombre;
	private String cuit;
	private Collection<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
	private Map<Empleado, List<Recibo>> mapEmpleadoRecibos = new HashMap<>();
	// Prueba
	
	
	
	public Set<Empleado> getListaDeEmpleados()
	{
		return this.mapEmpleadoRecibos.keySet();
	}
	
	
	public List<Recibo> getReciboEmpleado_( Empleado empleado )
	{
		return this.mapEmpleadoRecibos.get(empleado);
	}
	
	
	public void agregarEmpleado(Empleado empleado)
	{
		if (this.mapEmpleadoRecibos.containsKey(empleado))
		{
			throw new RuntimeException( "El empleado especificado ya se encuentra en la lista" );
		}
		else
		{
			this.mapEmpleadoRecibos.put(empleado, new ArrayList<Recibo>());
		}
	}

	
	public void quitarEmpleado(Empleado empleado)
	{
		this.mapEmpleadoRecibos.remove(empleado);
	}
	

	public void generarRecibos()
	{
        for (Map.Entry<Empleado, List<Recibo>> entry : mapEmpleadoRecibos.entrySet())
        {
            // Obtener la lista de recibos para la clave actual
            List<Recibo> recibosActualizado = entry.getValue();

            // Agregar un nuevo recibo a la lista de recibos
            Recibo nuevoRecibo = entry.getKey().generarRecibo();
            recibosActualizado.add(nuevoRecibo);

            // Actualizar la lista de recibos en el HashMap
            mapEmpleadoRecibos.put(entry.getKey(), recibosActualizado);
        }
	}
	

	public double getTotalSueldosNeto()
	{
		double totalSueldosNeto = 0;
        for (Map.Entry<Empleado, List<Recibo>> entry : mapEmpleadoRecibos.entrySet())
        {
        	totalSueldosNeto += entry.getKey().getSueldoNeto();
        }
        return totalSueldosNeto;
	}
	
	
	public double getTotalSueldosBruto()
	{
		double[] totalSueldosBruto = {0};
		/** Usamos un array ya que las variables capturadas por la expresión lambda deben ser efectivamente finales 
				o estar "efectivamente finales", (es decir, no pueden ser modificadas después de la captura). 
		 @return Devuelve el monto total del sueldo bruto que deberá desembolar la empresa para pagarle a todos sus empleados.
		 */
		this.mapEmpleadoRecibos.forEach( (empleado, recibos) -> totalSueldosBruto[0] += empleado.getSueldoBruto() );
		return totalSueldosBruto[0];
	}
	
	
	public int getTotalRetenciones()
	{
		int monto = 0;
		for( Empleado empleado: listaDeEmpleados )
		{
			monto += empleado.getRetenciones();
		}
		return monto;
	}
	
	
	public Empresa(String nombre, String cuit)
	{
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	
}

