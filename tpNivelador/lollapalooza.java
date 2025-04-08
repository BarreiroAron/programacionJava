package tpNivelador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lollapalooza {
	public static void main(String[] args) {
		final int MAX = 50, CANT_ATRIBUTOS = 8;
		String [][] artista = new String[MAX][CANT_ATRIBUTOS];
		final int ID_MIN = 1, ID_MAX = 999;
		int mueveAlmacenamiento = 0;
		Scanner s = new Scanner(System.in);
		boolean salir = true;
		
		final boolean MODO_PRUEBA = true;
		if(MODO_PRUEBA == true) {
			mueveAlmacenamiento = cargarDatosPrueba(artista, mueveAlmacenamiento);
		}
		
		do {
		System.out.println("-----------------------------------------------");
		System.out.println("¡Bienvenido a Lollapalooza!");
		System.out.println("Por favor, eliga una opción para continuar.");
		System.out.println("-          -          -          -          -");
		System.out.println("Registrar Artista/Banda (1)"); //hecho
		System.out.println("Consultar Artista/Banda (2)"); //hecho
		System.out.println("Modificar datos de Artista/Banda (3)");
		System.out.println("Eliminar Artista/Banda (4)");
		System.out.println("Lista de Artistas/Bandas (5)"); //hecho
		System.out.println("Cronograma en el dia (6)");
		System.out.println("Cronograma por escenario (7)");
		System.out.println("Buscar Artista/Banda por Genero (8)"); //en progreso
		System.out.println("Buscar Artista/Banda pro Popularidad (9)"); //hecho
		System.out.println("Estadisticas del festival (10)");
		System.out.println("Salir (11)"); //en progreso
		System.out.println("------------------------------------------------");
		int opcion = s.nextInt();
		mueveAlmacenamiento = mostrarMenuYElegirOpcion(opcion, s, artista, mueveAlmacenamiento);
		} while(salir);
	}
	
	public static int mostrarMenuYElegirOpcion(int opcion, Scanner s, String[][] artista, int mueveAlmacenamiento) {
		switch(opcion) {
		case 1:
			mueveAlmacenamiento = ingresarArtista(s, artista, mueveAlmacenamiento);
			break;
		case 2:
			buscarArtista(s, artista, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 3:
			System.out.println("No hecha");
			break;
		case 4:
			System.out.println("No hecha");
			break;
		case 5:
			listarArtistas(artista, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 6:
			verCronogramaPorDia(artista);
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			buscarArtistasPorPopularidad(s, artista, mueveAlmacenamiento, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 10:
			break;
		case 11:
			saliendo();
			break;
			default:
				System.out.println("Por favor, eliga una de las opciones correctas, gracias.");
		}
		return mueveAlmacenamiento;
	}
	
	public static int ingresarArtista(Scanner s, String[][] artista, int mueveAlmacenamiento) {
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
		
		artista[mueveAlmacenamiento][0] = Integer.toString(ID);
		artista[mueveAlmacenamiento][1] = NOMBRE_BANDA_ARTISTA;
		artista[mueveAlmacenamiento][2] = Integer.toString(GENERO_MUSICAL);
		artista[mueveAlmacenamiento][3] = Integer.toString(DIA_PRESENTACION);
		artista[mueveAlmacenamiento][4] = Integer.toString(ESCENARIO);
		artista[mueveAlmacenamiento][5] = Integer.toString(HORA_INICIO);
		artista[mueveAlmacenamiento][6] = Integer.toString(DURACION);
		artista[mueveAlmacenamiento][7] = Integer.toString(POPULARIDAD);
		
		mueveAlmacenamiento++;
		return mueveAlmacenamiento;
	}
	
	public void generarAccion() {
		//No tengo ni la mas palida idea de que tengo que hacer en esta funcion
	}
	
	public static void ingresarEntero(Scanner s, final int ID_MIN, final int ID_MAX) {
		//Creo que aca tengo que usar los try catch pero realmente no se como avanzar con esta funcion
	}
	
	public void validarID(int ID, final int ID_MIN, final int ID_MAX) {
		//Creo que aca tengo que usar los try catch pero realmente no se como avanzar con esta funcion
		if(ID_MIN > ID_MAX) {
			System.out.println("Error, el valor minimo no puede ser mayor al maximo");
			System.exit(1);
		}
	}
	
	public static void buscarArtista(Scanner s, String[][] artista, int ID, int mueveAlmacenamiento) {
		System.out.println("Perfecto! Por favor, ingrese la ID que tiene su Artista/Banda musical:");
		ID = s.nextInt();
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(Integer.parseInt(artista[i][0]) == ID) {
				/*for(int j = 0; j < artista[i].length; j++) {
					System.out.println(" " + artista[i][j]);
				}*/
				System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
				System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
			}
		}
	}
	
	public static void listarArtistas(String[][] artista, final int ID, int mueveAlmacenamiento) {
		for(int i = 0; i < mueveAlmacenamiento; i++) {
				/*for(int j = 0; j < artista[i].length; j++) {
					System.out.println(" " + artista[i][j]);
				}*/
				System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
				System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
				System.out.println(" ");
		}
	}
	
	public static void verCronogramaPorDia(String[][] artsita) {
		
	}
	
	/*public static void buscarArtistasPorGenero(Scanner s, String[][] artista, final int GENERO_MUSICAL, int generoMomentaneo, int mueveAlmacenamiento) {
		System.out.println("Por favor, ingrese el genero de su banda: ");
		System.out.println("Recuerde que: 1 \\\"Rock\\\" - 2  \\\"Pop\\\" - 3  \\\"Electrónica\\\" - 4  \\\"Hip Hop\\\" - 5  \\\"Indie\\\" - 6  \\\"Metal\\\" - 7  \\\"Otros\\");
		generoMomentaneo = s.nextInt();
			for(int i = 0; i < mueveAlmacenamiento; i++ ) {
				if(generoMomentaneo == Integer.parseInt(artista[i][GENERO_MUSICAL])) {
			System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
			System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
			System.out.println(" ");
			}
		}
	}              ESTA FUNCION AUN TIRA ERROR*/
	
	public static void buscarArtistasPorPopularidad(Scanner s, String[][] artista, final int POPULARIDAD, int popularidadMomentanea, int mueveAlmacenamiento) {
		System.out.println("Por favor, ingrese la popularidad que tiene su banda: ");
		popularidadMomentanea = s.nextInt();
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(popularidadMomentanea == Integer.parseInt(artista[i][7])) {
		System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
		System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
		System.out.println(" ");
			}
		}
	}
	
	public static boolean saliendo() { //tampoco anda bien por ahora
		boolean salir = false;
		System.out.println("Saliendo . . .");
		return salir;
	}
	
    // Método para cargar datos de prueba precargados
    public static int cargarDatosPrueba(String[][] artista, int mueveAlmacenamiento) {
        // Los datos precargados se generaron con IA para simular datos realistas
        artista[mueveAlmacenamiento++] = new String[] {"101", "The Rockers", "1", "1", "1", "20", "90", "9"};
        artista[mueveAlmacenamiento++] = new String[] {"102", "Pop Sensation", "2", "2", "2", "19", "75", "8"};
        artista[mueveAlmacenamiento++] = new String[] {"103", "Electro Beats", "3", "3", "3", "21", "60", "7"};
        artista[mueveAlmacenamiento++] = new String[] {"104", "Hip Hop Crew", "4", "1", "2", "22", "85", "10"};
        artista[mueveAlmacenamiento++] = new String[] {"105", "Indie Vibes", "5", "2", "1", "18", "70", "6"};
        artista[mueveAlmacenamiento++] = new String[] {"106", "Metal Mayhem", "6", "3", "2", "20", "95", "9"};
        artista[mueveAlmacenamiento++] = new String[] {"107", "Alternative Waves", "7", "1", "3", "19", "65", "8"};
        artista[mueveAlmacenamiento++] = new String[] {"108", "Acoustic Souls", "1", "2", "4", "17", "80", "7"};
        artista[mueveAlmacenamiento++] = new String[] {"109", "Rock Legends", "1", "3", "1", "23", "100", "10"};
        artista[mueveAlmacenamiento++] = new String[] {"110", "Pop Icons", "2", "1", "2", "16", "75", "8"};
        return mueveAlmacenamiento;
        //todo esto lo genero chatgpt xd
    }
}
