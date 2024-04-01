package tp.uml.empleado;

import java.time.LocalDate;

public class PlantaPermanenteTest 
{
	
	public static void main( String[] args)
	{
		PlantaPermanente fran = new PlantaPermanente( "Juan", "Tucumán 3137", "Soltero", LocalDate.of(1996, 05, 03),  1000.0, 2, 5);
		
		System.out.print( fran.tieneConyugue() );
		
	}
	
	
//	public PlantaPermanente(String nombre, String direccion, String estadoCivil,
//			LocalDate fechaNacimiento, int sueldoBasico, boolean conyugue, int cantidadDeHijos,
//				int añosAntiguedad)
//	
	
	
}
