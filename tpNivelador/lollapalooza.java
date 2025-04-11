package tpNivelador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lollapalooza {
	private static final int ID = 0;

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
		System.out.println("Modificar datos de Artista/Banda (3)"); //hecho
		System.out.println("Eliminar Artista/Banda (4)"); //hecho (solo hay un pequeño inconveniente)
		System.out.println("Lista de Artistas/Bandas (5)"); //hecho
		System.out.println("Cronograma en el dia (6)"); //HECHO
		System.out.println("Cronograma por escenario (7)"); //HECHOOO
		System.out.println("Buscar Artista/Banda por Genero (8)"); //hecho
		System.out.println("Buscar Artista/Banda pro Popularidad (9)"); //hecho
		System.out.println("Estadisticas del festival (10)"); //O B J E T I V O  A C T U A L
		System.out.println("Salir (11)"); //hecho
		System.out.println("------------------------------------------------");
		int opcion = s.nextInt();
		if(opcion == 11) {
			salir = false;
		}
		mueveAlmacenamiento = mostrarMenuYElegirOpcion(opcion, s, artista, mueveAlmacenamiento, ID_MIN, ID_MAX);
		} while(salir);
	}
	
	public static int mostrarMenuYElegirOpcion(int opcion, Scanner s, String[][] artista, int mueveAlmacenamiento, int ID_MIN, int ID_MAX) {
		switch(opcion) {
		case 1:
			mueveAlmacenamiento = ingresarArtista(s, artista, mueveAlmacenamiento, ID_MIN, ID_MAX);
			break;
		case 2:
			consultarArtista(s, artista, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 3:
			if(mueveAlmacenamiento == 0) { 
				System.out.println("No podes usar esta funcion, aun no hay Artistas/Bandas ingresados"); }
			else {
			modificarArtista(s, artista, mueveAlmacenamiento);
			}
			break;
		case 4:
			if(mueveAlmacenamiento == 0) { 
				System.out.println("No podes usar esta funcion, aun no hay Artistas/Bandas ingresados"); }
			else {
			eliminarArtista(s, artista, mueveAlmacenamiento);
			}
			break;
		case 5:
			listarArtistas(artista, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 6:
			verCronogramaPorDia(s, artista, mueveAlmacenamiento, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 7:
			verCronogramaPorEscenario(s, artista, mueveAlmacenamiento);
			break;
		case 8:
			buscarArtistasPorGenero(s, artista, mueveAlmacenamiento, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 9:
			buscarArtistasPorPopularidad(s, artista, mueveAlmacenamiento, mueveAlmacenamiento, mueveAlmacenamiento);
			break;
		case 10:
			//calcularEstadisticas();
			break;
		case 11:
			System.out.println("Saliendo. . . ");
			break;
			default:
				System.out.println("Por favor, eliga una de las opciones correctas, gracias.");
		}
		return mueveAlmacenamiento;
	}
	
	public static int ingresarArtista(Scanner s, String[][] artista, int mueveAlmacenamiento, int ID_MIN, int ID_MAX) {
		final int GENERO_MAX = 7, GENERO_MIN = 1;
		final int DIA_MAX = 3, DIA_MIN = 1;
		final int ESCENARIO_MIN = 1, ESCENARIO_MAX = 4;
		final int HORA_MIN = 12, HORA_MAX = 23;
		final int DURACION_MIN = 30, DURACION_MAX = 120;
		final int POPULARIDAD_MIN = 1, POPULARIDAD_MAX = 10;
		System.out.println("Ingrese el artista/banda");
		System.out.println("Ingrese una ID (desde 1 hasta 999):");
		int ID = ingresarEntero(s, ID_MIN, ID_MAX);
		System.out.println("Ingrese el nombre de la banda o el artista que va a tocar:");
		final String NOMBRE_BANDA_ARTISTA = s.nextLine();
		System.out.println("Ingrese el genero musical que toca su artista:");
		System.out.println("1 \"Rock\" - 2  \"Pop\" - 3  \"Electrónica\" - 4  \"Hip Hop\" - 5  \"Indie\" - 6  \"Metal\" - 7  \"Otros\"");
		final int GENERO_MUSICAL = ingresarEntero(s, GENERO_MIN, GENERO_MAX);
		System.out.println("Ingrese el dia de su presentación: (1 \"Dia 1\" - 2 \"Dia 2\" - 3 \"Dia 3\"");
		final int DIA_PRESENTACION = ingresarEntero(s, DIA_MIN, DIA_MAX);
		System.out.println("En que escenario va a tocar su artista?? (1 Principal - 2 Alternativo - 3 Electronica - 4 Acustico):");
		final int ESCENARIO = ingresarEntero(s, ESCENARIO_MIN, ESCENARIO_MAX);
		System.out.println("Ingrese la hora en que va a tocar su artista: (Entre las 12 de la mañana y las 23 de la noche):");
		final int HORA_INICIO = ingresarEntero(s, HORA_MIN, HORA_MAX); //verificarSuperposicion(s, HORA_MIN, HORA_MAX, );
		System.out.println("Ingrese la duración del espectaculo de su banda en minutos: (Entre 30 minutos a 120 minutos):");
		final int DURACION = ingresarEntero(s, DURACION_MIN, DURACION_MAX);
		System.out.println("Ingrese la popularidad de la banda: (Desde una escala del 1 al 10. Diez, representando la mas famosa):");
		final int POPULARIDAD = ingresarEntero(s, POPULARIDAD_MIN, POPULARIDAD_MAX);
		
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
	
	public static int validarID(int id, String[][] artista, int mueveAlmacenamiento) {
	/*s	for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(Integer.parseInt(artista[i][0]) == ID) {
				System.out.println("Error, tiene que ingresar una ID diferente al resto.");
			}
		}
		ID = s.nextInt();*/
	    int indice = -1;
	    for (int i = 0; i < mueveAlmacenamiento; i++) {
	        if (Integer.parseInt(artista[i][0]) == id) {
	            indice = i;
	            break;
	        }
	    }
	    return indice;
	}
	
	public static int buscarArtitsa(Scanner s) {
		final int ID_MIN = 1, ID_MAX = 999;
		int elegir = ingresarEntero(s, ID_MIN, ID_MAX);
		return elegir;
		}
	
	public static void consultarArtista(Scanner s, String[][] artista, int ID, int mueveAlmacenamiento) {
		System.out.println("Perfecto! Por favor, ingrese la ID que tiene su Artista/Banda musical: ");
		ID = buscarArtitsa(s);
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(Integer.parseInt(artista[i][0]) == ID) {
				System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
				System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
			}
		}
	}
	
	public static void modificarArtista(Scanner s, String[][] artista, int mueveAlmacenamiento) {
	    System.out.println("Por favor, ingrese la ID de la banda que quiere modificar algo: ");
	    int ID_a_modificar = s.nextInt();
	    int indice_a_modificar = validarID(ID_a_modificar, artista, mueveAlmacenamiento);
	    s.nextLine();

	    if (indice_a_modificar == -1) {
	        System.out.println("ID de Artista/Banda no encontrado.");
	        return;
	    }

	    System.out.println("Ahora, ingrese que dato quiere modificar, por favor: ");
	    System.out.println("Recuerde que: (1 id) (2 Nombre) (3 genero) (4 dia) (5 escenario) (6 hora de inicio) (7 duracion) (8 popularidad)");
	    String cambiarCosaStr = s.nextLine();
	    int cambiarCosa;
	    try {
	        cambiarCosa = Integer.parseInt(cambiarCosaStr);
	    } catch (NumberFormatException e) {
	        System.out.println("Entrada inválida. Por favor, ingrese el número de la opción.");
	        return;
	    }

	    String campo = (cambiarCosa == 1) ? "ID" : (cambiarCosa == 2) ? "Nombre" : (cambiarCosa == 3) ? "Genero" : (cambiarCosa == 4) ? "Dia" : (cambiarCosa == 5) ? "Escenario" : (cambiarCosa == 6) ? "hora de inicio" : (cambiarCosa == 7) ? "Duracion" : (cambiarCosa == 8) ? "Popularidad" : "Dato invalido";
	    System.out.println("Ahora ingrese que es lo que quieren poner en " + campo);

	    if (campo.equals("Dato invalido")) {
	        System.out.println("No existe un dato como ese.");
	        return;
	    }

	    if (cambiarCosa == 1) { 
	        System.out.println("Ingrese la nueva ID para la banda:");
	        String nuevaIDStr = s.nextLine();
	        try {
	            int nuevaID = Integer.parseInt(nuevaIDStr);
	            if (validarID(nuevaID, artista, mueveAlmacenamiento) != -1) {
	                System.out.println("Ya existe un artista con la ID: " + nuevaID + ". No se puede modificar la ID.");
	            } else {
	                artista[indice_a_modificar][cambiarCosa - 1] = nuevaIDStr;
	                System.out.println("ID del artista modificada.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("ID inválida. Por favor, ingrese un número entero.");
	        }
	    } else if (cambiarCosa == 2) {
	        String respuestaNombre = s.nextLine();
	        artista[indice_a_modificar][cambiarCosa - 1] = respuestaNombre;
	        System.out.println("Nombre del artista modificado.");
	    } else {
	        String respuestaStr = s.nextLine();
	        try {
	            int respuesta = Integer.parseInt(respuestaStr);
	            artista[indice_a_modificar][cambiarCosa - 1] = Integer.toString(respuesta);
	            System.out.println("Dato del artista modificado.");
	        } catch (InputMismatchException e) {
	            System.out.println("Por favor, ingrese un valor numérico para este campo.");
	        }
	    }
	}
	
	public static int eliminarArtista(Scanner s, String[][] artista, int mueveAlmacenamiento) {
	    System.out.println("Por favor, ingrese la ID del Artista/Banda a eliminar: ");
	    int id = s.nextInt();
	    int indice = -1;
	    for (int i = 0; i < mueveAlmacenamiento && indice == -1; i++) {
			if (Integer.parseInt(artista[i][0]) == id) {
	            indice = i;
	        }
	    }
	    if (indice == -1) {
	        System.out.println("No existe ese artista.");
	        return mueveAlmacenamiento;
	    }
	    for (int i = indice; i < mueveAlmacenamiento - 1; i++) {
	        artista[i] = artista[i + 1];
	    }
	    artista[mueveAlmacenamiento - 1] = new String[artista[0].length];
	    System.out.println("Artista/Banda con id " + id + " eliminada.");
	    return mueveAlmacenamiento - 1;
	}

	
	public static void listarArtistas(String[][] artista, final int ID, int mueveAlmacenamiento) {
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			imprimir(i, artista);
		}
	}
	
	public static void verCronogramaPorDia(Scanner s, String[][] artista, final int ID, int mueveAlmacenamiento, final int DIA_PRESENTACION) {
		System.out.println("Por favor, ingrese el dia para ver las bandas que tocaran ahi:");
		final int DIA_MIN = 1, DIA_MAX = 3;
		int diaMomentaneo = ingresarEntero(s, DIA_MIN, DIA_MAX);
		System.out.println("Cronograma para el día " + diaMomentaneo + ":");
		for(int moverHoraParaOrdenar = 12; moverHoraParaOrdenar <= 23; moverHoraParaOrdenar++) {
			for(int i = 0; i < mueveAlmacenamiento; i++) {
	            if (Integer.parseInt(artista[i][3]) == diaMomentaneo && Integer.parseInt(artista[i][5]) == moverHoraParaOrdenar) {
	                    imprimir(i, artista);
	            }
			}
		}
	}
	
	public static void verCronogramaPorEscenario(Scanner s, String[][] artista, int mueveAlmacenamiento) {
		System.out.println("Por favor, ingrese el escenario para ver que bandas tocaran en ese lugar: ");
		final int ESCENARIO_MIN = 1, ESCENARIO_MAX = 4;
		int escenarioMomentaneo = ingresarEntero(s, ESCENARIO_MIN, ESCENARIO_MAX);
		System.out.println("Cronograma para el escenario " + escenarioMomentaneo);
		for(int moverDiaParaOrdenar = 1; moverDiaParaOrdenar <= 3; moverDiaParaOrdenar++) {
			for(int moverHoraParaOrdenar = 12; moverHoraParaOrdenar <= 23; moverHoraParaOrdenar++) {
				for(int i = 0; i < mueveAlmacenamiento; i++) {
					if(Integer.parseInt(artista[i][3]) == moverDiaParaOrdenar && Integer.parseInt(artista[i][5]) == moverHoraParaOrdenar && Integer.parseInt(artista[i][4]) == escenarioMomentaneo) {
						imprimir(i, artista);
					}
				}
			}
		}
	}
	
	public static void buscarArtistasPorGenero(Scanner s, String[][] artista, final int GENERO_MUSICAL, int generoMomentaneo, int mueveAlmacenamiento) {
		System.out.println("Por favor, ingrese el genero de su banda: ");
		System.out.println("Recuerde que: 1 \\\"Rock\\\" - 2  \\\"Pop\\\" - 3  \\\"Electrónica\\\" - 4  \\\"Hip Hop\\\" - 5  \\\"Indie\\\" - 6  \\\"Metal\\\" - 7  \\\"Otros\\");
		final int GENERO_MIN = 1, GENERO_MAX = 7;
		generoMomentaneo = ingresarEntero(s, GENERO_MIN, GENERO_MAX);
			for(int i = 0; i < mueveAlmacenamiento; i++ ) {
				if(generoMomentaneo == Integer.parseInt(artista[i][2])) {
					imprimir(i, artista);
			}
		}
	}
	
	public static void buscarArtistasPorPopularidad(Scanner s, String[][] artista, final int POPULARIDAD, int popularidadMomentanea, int mueveAlmacenamiento) {
		System.out.println("Por favor, ingrese la popularidad que tiene su banda: ");
		popularidadMomentanea = buscarArtitsa(s);
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(popularidadMomentanea == Integer.parseInt(artista[i][7])) {
				imprimir(i, artista);
			}
		}
	}
	
	public void calcularEstadisticas(String[][] artista) {
		
	}
	
	public static int ingresarEntero(Scanner s, final int ID_MIN, final int ID_MAX) {
		if(ID_MIN > ID_MAX) {
			System.out.println("Error, el valor minimo no puede ser mayor al valor maximo");
			System.exit(1);
		}
		boolean error = false;
		
		int numero = 0;		
		do {
			error = false;
			try {
				numero = s.nextInt();
				if(numero < ID_MIN || numero > ID_MAX) {
					System.out.println("Error." + ((ID_MAX == ID_MIN) ? ("ingresar el numero " + ID_MIN) : (" El numero debe estar entre " + ID_MIN + " y " + ID_MAX)));
					System.out.println("Vuelva a ingresar");
					error = true;
				}
			} catch(InputMismatchException e){
				System.out.println("Error. Tipo de dato mal ingresado");
				System.out.println("Vuelva a ingresar");
				error = true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				s.nextLine();
			}
		} while(error);
		return numero;
	}
	
	public int verificarSuperposicion(Scanner s, final int ID_MIN, final int ID_MAX, int mueveAlmacenamiento, String[][] artista, final int ESCENARIO, final int HORA_INICIO) {
		s.nextInt();
		if(ID_MIN > ID_MAX) {
			System.out.println("Error, el valor minimo no puede ser mayor al valor maximo");
			System.exit(1);
		}
		boolean error = false;
		
		int numero = 0;		
		do {
			error = false;
			try {
				numero = s.nextInt();
				if(numero < ID_MIN || numero > ID_MAX) {
					System.out.println("Error." + ((ID_MAX == ID_MIN) ? ("ingresar el numero " + ID_MIN) : (" El numero debe estar entre " + ID_MIN + " y " + ID_MAX)));
					System.out.println("Vuelva a ingresar");
					error = true;
				}
			} catch(InputMismatchException e){
				System.out.println("Error. Tipo de dato mal ingresado");
				System.out.println("Vuelva a ingresar");
				error = true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				s.nextLine();
			}
		} while(error);
		
		if(ESCENARIO == Integer.parseInt(artista[ID][4])) {
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(HORA_INICIO == Integer.parseInt(artista[i][5])) {
				
				}
			}
		}
		return numero;
	}
	
	public void formatearHora() {
	}
	
	public static void imprimir(int i, String[][] artista) {
		System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
		System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
		System.out.println(" ");
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
