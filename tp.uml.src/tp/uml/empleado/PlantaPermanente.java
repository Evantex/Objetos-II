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
	public double getSueldoBruto()
	{
		return this.sueldoBasico + this.getSalarioFamiliar();
	}
	
	
	private double getAsignacionPorHijo()
	{
		return 150 * this.cantidadDeHijos;
	}
	
	
	public double getSalarioFamiliar()
	{
		return this.getAsignacionPorHijo() + this.getAsignacionPorConyugue() + this.añosAntiguedad * 50;
	}
	
	
	private double getAsignacionPorConyugue()
	{
		if ( this.conyugue )
		{
			return 100;
		}
		else
		{
			return 0;
		}
	}
	
	
	@Override
	protected double getAporteObraSocial()
	{
		return (this.getSueldoBruto() * 10) / 100 + this.cantidadDeHijos * 20;
	}

	
	@Override
	protected double getAportesJubilatorios()
	{
		return (this.getSueldoBruto() * 15) / 100;
	}
	
	
	// Constructor
	public PlantaPermanente(String nombre, String direccion, String estadoCivil,
			LocalDate fechaNacimiento, double sueldoBasico, int cantidadDeHijos,
				int añosAntiguedad)
	{
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.cantidadDeHijos = cantidadDeHijos;
		this.añosAntiguedad = añosAntiguedad;
	}
	
	
		@Override
		public List<Concepto> getConceptos()
		{
			List<Concepto> conceptos = new ArrayList<>();
			conceptos.add( new Concepto("Monto bruto:", this.getSueldoBruto()));
			conceptos.add( new Concepto("Monto por sueldo basico", this.sueldoBasico));
			conceptos.add( new Concepto("Monto por salario familiar", this.getSalarioFamiliar()) );
			conceptos.add( new Concepto("Descuento por obra social", this.getAporteObraSocial()) );
			conceptos.add( new Concepto("Descuento por aportes jubilatorios", this.getAportesJubilatorios()) );
			conceptos.add( new Concepto("Monto neto:", this.getSueldoNeto()));
			return conceptos;
		}
}
