package tp.uml.empresa;
import java.time.LocalDate;
import tp.uml.empleado.*;

public class EmpresaTest 
{

	public static void main(String[] args) 
	{

		PlantaPermanente fran = new PlantaPermanente( "Fran", "Tucumán 3137", "Soltero", LocalDate.of(1996, 05, 03),  1000.0, 2, 5);
		PlantaTransitoria jorge = new PlantaTransitoria( "Jorge", "Suipacha 152", "Casado", LocalDate.of(1992, 12, 18), 800.0, 15 ); 
		Empresa edesur = new Empresa( "Pendorcho", "24396726838");
		
		edesur.agregarEmpleado(jorge);
		edesur.agregarEmpleado(fran);
		
		
		System.out.println( fran.getSueldoBruto() );
		System.out.println( jorge.getSueldoBruto() );
		System.out.println( edesur.getTotalSueldosBruto() );
		System.out.println( edesur.getListaDeEmpleados() );
		System.out.println( edesur.getReciboEmpleado_(fran) );
		edesur.generarRecibos();
		System.out.println( edesur.getReciboEmpleado_(fran).get(0).getSueldoNeto() );
		

//		public PlantaTransitoria(String nombre, String direccion, String estadoCivil,
//				LocalDate fechaNacimiento, double sueldoBasico, int cantidadHorasExtra

	}

}
