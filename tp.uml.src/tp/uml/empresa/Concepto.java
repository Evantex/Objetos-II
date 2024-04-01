package tp.uml.empresa;

public class Concepto 
{
	
	private String nombre;
	private double monto;
	
	public String nombre()
	{
		return this.nombre;
	}
	
	
	public double monto()
	{
		return this.monto;
	}
	
	
	public Concepto(String nombre, double monto)
	{
		this.nombre = nombre;
		this.monto = monto;
	}
	

}
