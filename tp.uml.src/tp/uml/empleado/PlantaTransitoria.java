package tp.uml.empleado;
import tp.uml.empresa.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPlantaTemporaria extends Empleado
{
	private LocalDate fechaFinDegnacionPlantaTemp;
	private int cantidadHorasExtra;
	
	protected LocalDate fechaFinDegnacionPlantaTemp()
	{
		return fechaFinDegnacionPlantaTemp;
	}

	public int sueldoBruto()
	{
		return this.sueldoBasico + this.montoPorHorasExtra();
	}
	
	private int montoPorHorasExtra()
	{
		return this.cantidadHorasExtra * 40;
	}
	
	@Override
	protected int obraSocial()
	{
		return (this.sueldoBruto() * 10) / 100 + this.retorna_SiSuperaEdad_(25, 50);
	}
	

	@Override
	protected int aportesJubilatorios()
	{
		return (this.sueldoBruto() * 10) / 100 + this.cantidadHorasExtra * 5;
	}
	
	protected int retorna_SiSuperaEdad_(int retorno, int edad)
	{
		if( this.edad() >= edad )
		{
			return retorno;
		}
		else
		{
			return 0;
		}
	}
	
	// Constructor
	public EmpleadoPlantaTemporaria(String nombre, String direccion, String estadoCivil,
			LocalDate fechaNacimiento, int sueldoBasico, int cantidadHorasExtra)
	{
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	@Override
	public List<Concepto> getConceptos()
	{
		List<Concepto> conceptos = new ArrayList<>();
		conceptos.add( new Concepto("monto por sueldo basico", this.sueldoBasico));
		conceptos.add( new Concepto("monto por horas extra", this.montoPorHorasExtra()));
		conceptos.add( new Concepto("descuento por obra social", this.obraSocial()));
		conceptos.add( new Concepto("descuento por aportes jubilatorios", this.aportesJubilatorios()));	
		return conceptos;
	}
}
