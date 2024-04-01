package tp.uml.empleado;
import tp.uml.empresa.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlantaTransitoria extends Empleado
{
	private LocalDate fechaFinDegnacionPlantaTemp;
	private int cantidadHorasExtra;
	
	
	protected LocalDate fechaFinDegnacionPlantaTemp()
	{
		return fechaFinDegnacionPlantaTemp;
	}

	
	public double getSueldoBruto()
	{
		return this.sueldoBasico + this.getMontoPorHorasExtra();
	}
	
	
	private double getMontoPorHorasExtra()
	{
		return this.cantidadHorasExtra * 40;
	}
	
	
	@Override
	protected double getAporteObraSocial()
	{
		return (this.getSueldoBruto() * 10) / 100 + this.retorna_SiSuperaEdad_(25, 50);
	}
	

	@Override
	protected double getAportesJubilatorios()
	{
		return (this.getSueldoBruto() * 10) / 100 + this.cantidadHorasExtra * 5;
	}
	
	
	protected double retorna_SiSuperaEdad_(double retorno, int edad)
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
	public PlantaTransitoria(String nombre, String direccion, String estadoCivil,
			LocalDate fechaNacimiento, double sueldoBasico, int cantidadHorasExtra)
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
		conceptos.add( new Concepto("monto por sueldo basico", this.sueldoBasico) );
		conceptos.add( new Concepto("monto por horas extra", this.getMontoPorHorasExtra()) );
		conceptos.add( new Concepto("descuento por obra social", this.getAporteObraSocial()) );
		conceptos.add( new Concepto("descuento por aportes jubilatorios", this.getAportesJubilatorios()) );	
		return conceptos;
	}
}
