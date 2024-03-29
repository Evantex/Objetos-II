package tp.uml.empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Recibo
{
	private String nombreEmpleado;
	private String direccionEmpleado;
	private LocalDate fechaEmision;
	private int sueldoBruto;
	private int sueldoNeto;
	private List<Concepto> conceptos = new ArrayList<>();
	
	public String nombreEmpleado()
	{
		return this.nombreEmpleado;
	}
	
	public String direccionEmpleado()
	{
		return this.direccionEmpleado;
	}
	
	public LocalDate fechaEmision()
	{
		return this.fechaEmision;
	}
	
	public int sueldoBruto()
	{
		return this.sueldoBruto;
	}
	
	public int sueldoNeto()
	{
		return this.sueldoNeto;
	}
	
	
	 public Recibo(String nombreEmpleado, String direccionEmpleado, LocalDate fechaEmision,	int sueldoBruto,
				int sueldoNeto, List<Concepto> conceptos)
	{
		this.nombreEmpleado = nombreEmpleado;
		this.direccionEmpleado = direccionEmpleado;
		this.fechaEmision = fechaEmision;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
		this.conceptos = conceptos;
	}	
	/*
	public String desgloseConceptos()
	{
	    return "Salario bruto: " + "sueldo basico ($" + Integer.toString(this.sueldoBasico) + "), + monto por horas extra ($"
	    		+ Integer.toString(this.montoPorHorasExtra) + "), + monto por salario familiar ($"
	    			+ Integer.toString(this.montoSalarioFamiliar) + ").\nRetenciones: " + "monto retenciones obra social ($"
	    				+ Integer.toString(this.montoRetencionesObraSocial) + "), + monto retenciones aportes jubilatorios ($"
	    					+ Integer.toString(this.montoRetencionesAportesJubilatorios) + ").";
	}
	*/
	 
	 public void getConceptos()
	 {
		 System.out.printf("%s %60s %n", "Concepto", "Monto");
		 for( int indice = 0; indice < this.conceptos.size(); indice++ )
		 {
			 final String nombre = this.conceptos.get(indice).nombre();
			 final int monto = this.conceptos.get(indice).monto();
			 System.out.printf("%s %27d$ %n", nombre, monto);
		 }
	 }
}
