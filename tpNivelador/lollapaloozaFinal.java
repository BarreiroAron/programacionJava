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
		
		final boolean MODO_PRUEBA = false;
		if(MODO_PRUEBA == true) {
			mueveAlmacenamiento = cargarDatosPrueba(artista, mueveAlmacenamiento);
		}
		
		do {
		System.out.println("-----------------------------------------------");
		System.out.println("¡Bienvenido a Lollapalooza!");
		System.out.println("Por favor, eliga una opción para continuar.");
		System.out.println("-          -          -          -          -");
		System.out.println("Registrar Artista/Banda (1)");
		System.out.println("Consultar Artista/Banda (2)");
		System.out.println("Modificar datos de Artista/Banda (3)");
		System.out.println("Eliminar Artista/Banda (4)");
		System.out.println("Lista de Artistas/Bandas (5)");
		System.out.println("Cronograma en el dia (6)");
		System.out.println("Cronograma por escenario (7)");
		System.out.println("Buscar Artista/Banda por Genero (8)");
		System.out.println("Buscar Artista/Banda pro Popularidad (9)");
		System.out.println("Estadisticas del festival (10)");
		System.out.println("Salir (11)");
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
			calcularEstadisticas(artista, mueveAlmacenamiento);
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
		final String HORA_INICIO = formatearHora(s);
		System.out.println("Ingrese la duración del espectaculo de su banda en minutos: (Entre 30 minutos a 120 minutos):");
		final int DURACION = ingresarEntero(s, DURACION_MIN, DURACION_MAX);
		System.out.println("Ingrese la popularidad de la banda: (Desde una escala del 1 al 10. Diez, representando la mas famosa):");
		final int POPULARIDAD = ingresarEntero(s, POPULARIDAD_MIN, POPULARIDAD_MAX);
		
		if (verificarSuperposicion(artista, mueveAlmacenamiento, DIA_PRESENTACION, ESCENARIO, HORA_INICIO, DURACION)) {
	        System.out.println("Error: El horario se superpone con otro artista.");
	        return mueveAlmacenamiento;
	    }

		
		artista[mueveAlmacenamiento][0] = Integer.toString(ID);
		artista[mueveAlmacenamiento][1] = NOMBRE_BANDA_ARTISTA;
		artista[mueveAlmacenamiento][2] = Integer.toString(GENERO_MUSICAL);
		artista[mueveAlmacenamiento][3] = Integer.toString(DIA_PRESENTACION);
		artista[mueveAlmacenamiento][4] = Integer.toString(ESCENARIO);
		artista[mueveAlmacenamiento][5] = HORA_INICIO;
		artista[mueveAlmacenamiento][6] = Integer.toString(DURACION);
		artista[mueveAlmacenamiento][7] = Integer.toString(POPULARIDAD);
		
		mueveAlmacenamiento++;
		return mueveAlmacenamiento;
	}
	
	public static int validarID(int id, String[][] artista, int mueveAlmacenamiento) {
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
	            int horaArtista = extraerHora(artista[i][5]);
	            if (Integer.parseInt(artista[i][3]) == diaMomentaneo && horaArtista == moverHoraParaOrdenar) {
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
	                int horaArtista = extraerHora(artista[i][5]);
	                if(Integer.parseInt(artista[i][3]) == moverDiaParaOrdenar && horaArtista == moverHoraParaOrdenar && Integer.parseInt(artista[i][4]) == escenarioMomentaneo) {
	                    imprimir(i, artista);
	                }
	            }
	        }
	    }
	}
	
	public static int extraerHora(String horaCompleta) {
	    char hora1 = horaCompleta.charAt(0);
	    char hora2 = horaCompleta.charAt(1);
	    return Integer.parseInt(String.valueOf(hora1) + String.valueOf(hora2));
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
	
	public static void calcularEstadisticas(String[][] artista, int mueveAlmacenamiento) {
		int bandasDiaUno = 0, bandasDiaDos = 0, bandasDiaTres = 0;
		int	rock = 0, pop = 0, electronica = 0, hip = 0, indie = 0, metal = 0, otros = 0;
		int escenarioUno = 0, escenarioDos = 0, escenarioTres = 0, escenarioCuatro = 0;
		int minutoTotal = 0, horaTotal = 0, segundoTotal = 0;
		int horaEnDiaUno = 0, horaEnDiaDos = 0, horaEnDiaTres = 0;
		/*Porcentaje de artistas/bandas por género musical SI
		Porcentaje de artistas/bandas por día SI
		Porcentaje de artistas/bandas por escenario SI
		Promedio de duración de los shows SI
		Horas totales de música por día*/
		System.out.println("Veamos algunas de las estadisticas del festival: ");
		System.out.println(" ");
		
		System.out.println("Estadistica de los generos: ");
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(Integer.parseInt(artista[i][2]) == 1 || Integer.parseInt(artista[i][2]) == 2 || Integer.parseInt(artista[i][2]) == 3 || Integer.parseInt(artista[i][2]) == 4 || Integer.parseInt(artista[i][2]) == 5 || Integer.parseInt(artista[i][2]) == 6 || Integer.parseInt(artista[i][2]) == 7) {
				if(Integer.parseInt(artista[i][2]) == 1) {
					rock++;
				} else if(Integer.parseInt(artista[i][2]) == 2) {
					pop++;
				} else if(Integer.parseInt(artista[i][2]) == 3) {
					electronica++;
				} else if(Integer.parseInt(artista[i][2]) == 4) {
					hip++;
				} else if(Integer.parseInt(artista[i][2]) == 5) {
					indie++;
				} else if(Integer.parseInt(artista[i][2]) == 6) {
					metal++;
				} else {
					otros++;
				}
			}
		}
		System.out.println("Hay " + rock + " En rock. " + " / " + pop + " En pop. " + " / " + electronica + " En electronica. " + " / " + hip + " En hip. " + " / " + indie + " En indie. " + " / " + metal + " En metal. " + " / " + otros + " En otros. ");
		System.out.println("Según la estadística hay: ");
		System.out.println((float)(rock * 100.0 / mueveAlmacenamiento) + "% en rock");
		System.out.println(((float)pop * 100.0 / mueveAlmacenamiento) + "% en pop");
		System.out.println(((float)electronica * 100.0 / mueveAlmacenamiento) + "% en electronica");
		System.out.println(((float)hip * 100.0 / mueveAlmacenamiento) + "% en hip");
		System.out.println(((float)indie * 100.0 / mueveAlmacenamiento) + "% en indie");
		System.out.println(((float)metal * 100.0 / mueveAlmacenamiento) + "% en metal");
		System.out.println(((float)otros * 100.0 / mueveAlmacenamiento) + "% en otros");
		System.out.println(" "); System.out.println(" "); System.out.println(" ");
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(Integer.parseInt(artista[i][3]) == 1 || Integer.parseInt(artista[i][3]) == 2 || Integer.parseInt(artista[i][3]) == 3) {
				if(Integer.parseInt(artista[i][3]) == 1) {
					bandasDiaUno++;
					horaEnDiaUno = horaEnDiaUno + Integer.parseInt(artista[i][6]);
				} else if(Integer.parseInt(artista[i][3]) == 2) {
					bandasDiaDos++;
					horaEnDiaDos = horaEnDiaDos + Integer.parseInt(artista[i][6]);
				} else {
					bandasDiaTres++;
					horaEnDiaTres = horaEnDiaTres + Integer.parseInt(artista[i][6]);
				}
			}
		}
		System.out.println("Hay " + bandasDiaUno + " Tocando en el dia 1. " + bandasDiaDos + " Tocando en el dia 2. Y " + bandasDiaTres + " Tocando en el dia 3.");
		System.out.println("Según la estadística hay: ");
		System.out.println((float)(bandasDiaUno * 100.0 / mueveAlmacenamiento) + "% en el día 1");
		System.out.println(((float)bandasDiaDos * 100.0 / mueveAlmacenamiento) + "% en el día 2");
		System.out.println(((float)bandasDiaTres * 100.0 / mueveAlmacenamiento) + "% en el día 3");
		System.out.println(" "); System.out.println(" "); System.out.println(" ");
		System.out.println("Estadistica por escneario: ");
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			if(Integer.parseInt(artista[i][4]) == 1 || Integer.parseInt(artista[i][4]) == 2 || Integer.parseInt(artista[i][4]) == 3 || Integer.parseInt(artista[i][4]) == 4) {
				if(Integer.parseInt(artista[i][4]) == 1) {
					escenarioUno++;
				} else if(Integer.parseInt(artista[i][4]) == 2) {
					escenarioDos++;
				} else if(Integer.parseInt(artista[i][4]) == 3) {
					escenarioTres++;
				} else {
					escenarioCuatro++;
				}
			}
		}
		System.out.println("Hay " + escenarioUno + " En el escenario 1.  / " + escenarioDos + " En el escenario 2.  / " + escenarioTres + " En el escenario 3.  / Y" + escenarioCuatro + " En el escenario 4.");
		System.out.println("Según la estadística hay: ");
		System.out.println((float)(escenarioUno * 100.0 / mueveAlmacenamiento) + "% en el primer escenario");
		System.out.println(((float)escenarioDos * 100.0 / mueveAlmacenamiento) + "% en el segundo escenario");
		System.out.println(((float)escenarioTres * 100.0 / mueveAlmacenamiento) + "% en el tercer escenario");
		System.out.println(((float)escenarioCuatro * 100.0 / mueveAlmacenamiento) + "% en el cuarto escenario");
		System.out.println(" "); System.out.println(" "); System.out.println(" ");
		for(int i = 0; i < mueveAlmacenamiento; i++) {
			minutoTotal = minutoTotal + Integer.parseInt(artista[i][6]);
			horaTotal = (minutoTotal / 60);
			segundoTotal = (minutoTotal * 60);
		}
		System.out.println("Segun la estadistica, contando en horas tocaron: " + horaTotal + " Horas. Tocaron " + minutoTotal + " Hablando de minutos. Y hablando de segundos tocaron: " + segundoTotal + ". ");
		System.out.println(" "); System.out.println(" "); System.out.println(" ");
		horaEnDiaUno = horaEnDiaUno / 60;
		horaEnDiaDos = horaEnDiaDos / 60;
		horaEnDiaTres = horaEnDiaTres / 60;
		System.out.println("Las horas que llevan cada dia son: ");
		System.out.println("Día 1: " + horaEnDiaUno + " Horas.  " + "Día 2: " + horaEnDiaDos+ " Horas.  " + "Día 3: " + horaEnDiaTres + " Horas");
		System.out.println(" "); System.out.println(" "); System.out.println(" ");
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
	
	public static boolean verificarSuperposicion(String[][] artista, int mueveAlmacenamiento, int dia, int escenario, String horaInicio, int duracionNuevaPresentacion) {
	    int inicioNuevo = convertirHoraAMinutos(horaInicio);
	    int finNuevo = inicioNuevo + duracionNuevaPresentacion;
	    
	    for (int i = 0; i < mueveAlmacenamiento; i++) {
	        if (Integer.parseInt(artista[i][3]) == dia && Integer.parseInt(artista[i][4]) == escenario) {
	            int inicioExistente = convertirHoraAMinutos(artista[i][5]);
	            int finExistente = inicioExistente + Integer.parseInt(artista[i][6]);

	            if (inicioNuevo < finExistente && finNuevo > inicioExistente) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public static int convertirHoraAMinutos(String hora) {
	    String[] partes = hora.split(":");
	    return Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
	}

	
	public static String formatearHora(Scanner s) {
	    int hora = 0;
	    boolean horaValida = false;

	    while (!horaValida) {
	        try {
	            System.out.println("Ingrese la hora (formato entero, 12-23):");
	            hora = s.nextInt();
	            if (hora >= 12 && hora <= 23) {
	                horaValida = true;
	            } else {
	                System.out.println("Hora inválida. Debe estar entre 12 y 23.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Entrada inválida. Debe ingresar un número entero.");
	            s.next();
	        }
	    }
	    return String.format("%02d:00", hora);
	}	
	public static void imprimir(int i, String[][] artista) {
		System.out.println("|Id: " + artista[i][0] + "| Nombre del Artista/Banda: " + artista[i][1] + " |Genero: " + artista[i][2] + " |Dia de presentacion: " + artista[i][3]);
		System.out.println("|Escenario: " + artista[i][4] + " |Hora de inicio " + artista[i][5] + " |Duracion en minutos: " + artista[i][6] + " |Popularidad de la banda: " + artista[i][7]);
		System.out.println(" ");
	}
	
    // Método para cargar datos de prueba precargados
	public static int cargarDatosPrueba(String[][] artista, int mueveAlmacenamiento) {
	    artista[mueveAlmacenamiento++] = new String[] {"101", "The Rockers", "1", "1", "1", "20:00", "90", "9"};
	    artista[mueveAlmacenamiento++] = new String[] {"102", "Pop Sensation", "2", "2", "2", "19:00", "75", "8"};
	    artista[mueveAlmacenamiento++] = new String[] {"103", "Electro Beats", "3", "3", "3", "21:00", "60", "7"};
	    artista[mueveAlmacenamiento++] = new String[] {"104", "Hip Hop Crew", "4", "1", "2", "22:00", "85", "10"};
	    artista[mueveAlmacenamiento++] = new String[] {"105", "Indie Vibes", "5", "2", "1", "18:00", "70", "6"};
	    artista[mueveAlmacenamiento++] = new String[] {"106", "Metal Mayhem", "6", "3", "2", "20:00", "95", "9"};
	    artista[mueveAlmacenamiento++] = new String[] {"107", "Alternative Waves", "7", "1", "3", "19:00", "65", "8"};
	    artista[mueveAlmacenamiento++] = new String[] {"108", "Acoustic Souls", "1", "2", "4", "17:00", "80", "7"};
	    artista[mueveAlmacenamiento++] = new String[] {"109", "Rock Legends", "1", "3", "1", "23:00", "100", "10"};
	    artista[mueveAlmacenamiento++] = new String[] {"110", "Pop Icons", "2", "1", "2", "16:00", "75", "8"};
	    return mueveAlmacenamiento;
	}
}
