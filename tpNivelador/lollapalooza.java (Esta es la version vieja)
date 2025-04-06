package tpNivelador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lollapalooza {
	public static void main(String[] args) {
		final int MAX = 50, CANT_ATRIBUTOS = 8;
		String [][] artista = new String[MAX][CANT_ATRIBUTOS];
		final int ID_MIN = 1, ID_MAX = 999;
		int moverAlmacenamiento = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("¡Bienvenido a Lollapalooz!");
		System.out.println("Por favor, eliga una opción para continuar.");
		int opcion = s.nextInt();
		mostrarMenuYElegirOpcion(opcion);
	}
	
	public static void mostrarMenuYElegirOpcion(int opcion) {
		Scanner s = new Scanner(System.in);
		switch(opcion) {
		case 1:
			ingresarArtista(s);
			break;
		case 2:
			System.out.println("¡xd!");
			break;
		case 3:
			System.out.println("no xd");
			break;
		case 4:
			saliendo();
			break;
			default:
				System.out.println("Por favor, eliga una de las opciones correctas, gracias.");
		}
	}
	
	public static void ingresarArtista(Scanner s, String[][] artista) {
		final int CANTIDAD_UNICA = 1;
		//if(moverAlmacenamiento > MAX) {}
		System.out.println("Ingrese el artista/banda");
		System.out.println("Ingrese una ID (desde 1 hasta 999):");
		final int ID = s.nextInt();
		s.nextLine();
		System.out.println("Ingrese el nobmre de la banda o el artista que va a tocar:");
		final String NOMBRE_BANDA_ARTISTA = s.nextLine();
		System.out.println("Ingrese el genero musical que toca su artista:");
		System.out.println("1 \"Rock\" - 2  \"Pop\" - 3  \"Electrónica\" - 4  \"Hip Hop\" - 5  \"Indie\" - 6  \"Metal\" - 7  \"Otros\"");
		final int GENERO_MUSICAL = s.nextInt();
		System.out.println("Ingrese el dia de su presentación: (1 \"Dia 1\" - 2 \"Dia 2\" - 3 \"Dia 3\"");
		final int DIA_PRESENTACION = s.nextInt();
		System.out.println("En que escenario va a tocar su artista?? (1 Principal - 2 Alternativo - 3 Electronica - 4 Acustico):");
		final int ESCENARIO = s.nextInt();
		System.out.println("Ingrese la hora en que va a tocar su artista: (Entre las 12 de la mañana y las 23 de la noche):");
		final int HORA_INICIO = s.nextInt();
		System.out.println("Ingrese la duración del espectaculo de su banda en minutos: (Entre 30 minutos a 120 minutos):");
		final int DURACION = s.nextInt();
		System.out.println("Ingrese la popularidad de la banda: (Desde una escala del 1 al 10. Diez, representando la mas famosa):");
		final int POPULARIDAD = s.nextInt();
		
		artista[moverAlmacenamiento][0] = integer.ToString(ID);
		
		for(int i = 0; i < CANTIDAD_UNICA; i++) {
			
		}
	}
	
	public static void ingresarEntero(Scanner s, final int ID_MIN, final int ID_MAX) {
		if(ID_MIN > ID_MAX) {
			System.out.println("Error, el valor minimo no puede ser mayor al valor maximo");
			System.exit(1);
		}
	}
	
	public static void saliendo() {
		System.out.println("Saliendo . . .");
		System.exit(0);
	}
}
