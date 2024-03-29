package tp.uml.empleado;
import tp.uml.empresa.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlantaPermanente extends Empleado
{
	private int añosAntiguedad;
	private int cantidadDeHijos;
	private boolean conyugue;
	
	@Override
	public int sueldoBruto()
	{
		return this.sueldoBasico + this.salarioFamiliar();
	}
	
	private int asignacionPorHijo()
	{
		return 150 * this.cantidadDeHijos;
	}
	
	public int salarioFamiliar()
	{
		return this.asignacionPorHijo() + this.asignacionPorConyugue() + this.añosAntiguedad * 50;
	}
	
	private int asignacionPorConyugue()
	{
		if( this.conyugue )
		{
			return 100;
		}
		else
		{
			return 0;
		}
	}
	
	@Override
	protected int obraSocial()
	{
		return (this.sueldoBruto() * 10) / 100 + this.cantidadDeHijos * 20;
	}

	@Override
	protected int aportesJubilatorios()
	{
		return (this.sueldoBruto() * 15) / 100;
	}
	
	// Constructor
	public PlantaPermanente(String nombre, String direccion, String estadoCivil,
			LocalDate fechaNacimiento, int sueldoBasico, boolean conyugue, int cantidadDeHijos,
				int añosAntiguedad)
	{
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.conyugue = conyugue;
		this.cantidadDeHijos = cantidadDeHijos;
		this.añosAntiguedad = añosAntiguedad;
	}
	
		@Override
		public List<Concepto> getConceptos()
		{
			List<Concepto> conceptos = new ArrayList<>();
			conceptos.add( new Concepto("monto por sueldo basico", this.sueldoBasico));
			conceptos.add( new Concepto("monto por salario familiar", this.salarioFamiliar()));
			conceptos.add( new Concepto("descuento por obra social", this.obraSocial()));
			conceptos.add( new Concepto("descuento por aportes jubilatorios", this.aportesJubilatorios()));	
			return conceptos;
		}
}
