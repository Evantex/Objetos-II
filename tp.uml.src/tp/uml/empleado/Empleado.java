package tp.uml.empleado;
import tp.uml.empresa.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.time.Period;

public abstract class Empleado
{
	protected String nombre;
	protected String direccion;
	protected String estadoCivil;
	protected LocalDate fechaNacimiento;
	protected double sueldoBasico;
	// protected List<Recibo> recibosDeHaberes = new ArrayList<>();
	

	/*
	public void agregarRecibo(Recibo recibo)
	{
		this.recibosDeHaberes.add(recibo);
	}
	*/
	
	/*
	public Recibo verRecibo(int nroRecibo)
	{
		if( this.recibosDeHaberes.size() < nroRecibo )
		{
			throw new IllegalArgumentException("Indice invalido");
		}
		return this.recibosDeHaberes.get(nroRecibo);
	}
	*/
	
	public boolean tieneConyugue()
	{
		return !estadoCivil.equals("Soltero");
	}

	
	public String getNombre()
	{
		return nombre;
	}
	
	
	public String getDireccion()
	{
		return this.direccion;
	}
	
	
	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}
	
	
	public int edad()
	{
		LocalDate fechaActual = LocalDate.now();
		Period diferencia = Period.between(fechaNacimiento, fechaActual);
		return diferencia.getYears();
	}
	
	
	public double getRetenciones()
	{
		return this.getAporteObraSocial() + this.getAportesJubilatorios();
	}
	
	
	public abstract double getSueldoBruto();
	
	protected abstract double getAporteObraSocial();
	
	protected abstract double getAportesJubilatorios();
	
	protected abstract List<Concepto> getConceptos(); // Por cada tipo de empleado hay una lista de conceptos distinta que conforman al recibo.
	
	
	public double getSueldoNeto()
	{
		return this.getSueldoBruto() - this.getRetenciones();
	}
	
	
	public Recibo  generarRecibo()
	{
		return new Recibo( this.nombre, this.direccion, LocalDate.now(), this.getSueldoBruto(), this.getSueldoNeto(), this.getConceptos() );
	}
	
//	 public Recibo(String nombreEmpleado, String direccionEmpleado, LocalDate fechaEmision,	double sueldoBruto,
//				int sueldoNeto, List<Concepto> conceptos)
	
	
}

