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
	protected int sueldoBasico;
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

	
	public String nombre()
	{
		return nombre;
	}
	
	
	public String getDireccion()
	{
		return this.direccion;
	}
	
	
	public LocalDate fechaNacimiento()
	{
		return fechaNacimiento;
	}
	
	
	public int edad()
	{
		LocalDate fechaActual = LocalDate.now();
		Period diferencia = Period.between(fechaNacimiento, fechaActual);
		return diferencia.getYears();
	}
	
	
	public int retenciones()
	{
		return this.obraSocial() + this.aportesJubilatorios();
	}
	
	
	public abstract int sueldoBruto();
	protected abstract int obraSocial();
	protected abstract int aportesJubilatorios();
	protected abstract List<Concepto> getConceptos();
	
	
	public int sueldoNeto()
	{
		return this.sueldoBruto() - this.retenciones();
	}
	
	
	public Recibo  generarRecibo()
	{
		return new Recibo( this.nombre, this.direccion, LocalDate.now(), this.sueldoBruto(), this.sueldoNeto(), this.getConceptos() );
	}
	
	
	
}

