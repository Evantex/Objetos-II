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
	private Map<Empleado, List<Recibo>> mapEmpleadoRecibos = new HashMap<>();
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
	
	
	public Empresa(String nombre, int cuit)
	{
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	
}

