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
	private double sueldoBruto;
	private double sueldoNeto;
	private List<Concepto> conceptos = new ArrayList<>();
	
	
	public String getNombreEmpleado()
	{
		return this.nombreEmpleado;
	}
	
	
	public String getDireccionEmpleado()
	{
		return this.direccionEmpleado;
	}
	
	
	public LocalDate getFechaEmision()
	{
		return this.fechaEmision;
	}
	
	
	public double getSueldoBruto()
	{
		return this.sueldoBruto;
	}
	
	
	public double getSueldoNeto()
	{
		return this.sueldoNeto;
	}
	
	public List<Concepto> getConceptos()
	{
		return this.conceptos;
	}
	
	
	 public Recibo(String nombreEmpleado, String direccionEmpleado, LocalDate fechaEmision,	double sueldoBruto,
				double sueldoNeto, List<Concepto> conceptos)
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
	 
	 public int stringMasGrande(List<String> listaString)
	 {
		 int stringMayor = 0;
		 for( int indice = 0; indice < listaString.size(); indice++ )
		 {
			 if( stringMayor < listaString.get(indice).length() )
			 {
				 stringMayor = listaString.get(indice).length();
			 }
		 }
		 return stringMayor;
	 }
	 
	 
	 public void imprimirConceptos()
	 {
		 List<String> nombreConceptos = this.conceptos.stream().map( n -> n.nombre() ).toList();
		 int distanciaColumna = this.stringMasGrande(nombreConceptos) + 1;
		 System.out.printf("%-" + (distanciaColumna + 5) + "s %-" + (distanciaColumna) + "s%n", "Concepto", "Monto");
		 for( int indice = 0; indice < this.conceptos.size(); indice++ )
		 {
			 System.out.printf("%-" + (distanciaColumna + 5) + "s %-" + (distanciaColumna) + ".2f%n", conceptos.get(indice).nombre(), conceptos.get(indice).monto());
		 }
	 }
}
