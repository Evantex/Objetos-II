package tp.uml.empleado;
import tp.uml.empresa.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlantaPermanenteTest 
{
	
	public static void main( String[] args)
	{
		PlantaPermanente fran = new PlantaPermanente( "Juan", "Tucumán 3137", "Soltero", LocalDate.of(1996, 05, 03),  1000.0, 2, 5);
		Empresa edesur = new Empresa( "Pendorcho", "24396726838");
		Recibo sueldoAbril = fran.generarRecibo();
		
		List<String> listaPalabras = Arrays.asList("Jorge", "Roberto", "Julian");
		List<String> nombreConceptos = sueldoAbril.getConceptos().stream().map( n -> n.nombre() ).toList();
		
		// System.out.print( sueldoAbril.stringMasGrande(nombreConceptos) );
		
		sueldoAbril.imprimirConceptos();
		
		
		
	}
	
	
//	public PlantaPermanente(String nombre, String direccion, String estadoCivil,
//			LocalDate fechaNacimiento, int sueldoBasico, boolean conyugue, int cantidadDeHijos,
//				int añosAntiguedad)
//	
	
	
}
