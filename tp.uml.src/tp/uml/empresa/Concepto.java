package tp.uml.empresa;

public class Concepto 
{
	
	private String nombre;
	private int monto;
	
	public String nombre()
	{
		return this.nombre;
	}
	
	
	public int monto()
	{
		return this.monto;
	}
	
	
	Concepto(String nombre, int monto)
	{
		this.nombre = nombre;
		this.monto = monto;
	}
	

}
