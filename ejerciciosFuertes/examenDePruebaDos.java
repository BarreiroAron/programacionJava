package ejerciciosJava;

import java.util.Scanner; 

public class examenDePruebaDos {
	public static void main(String[] Args) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		final int FILA = 10;
		final int COLUMNA = 6;
		String[][] asientos = new String[FILA][COLUMNA];
        poniendoAsientos(asientos);
        boolean seguir = true;
		do {
		System.out.println("------------------------------------------------------------------");
		System.out.println("Bienvenido! Por favor, eliga una de nuestras opcioens del menu");
		System.out.println("Mostrar asientos (1)");
		System.out.println("Reservart asiento (2)");
		System.out.println("Cancelar reserva (3)");
		System.out.println("Salir (4)");
		System.out.println("------------------------------------------------------------------");
		int opcion = s.nextInt();
		if(opcion == 4) {
			seguir  = false;
		}
		switch(opcion) {
		case 1:
		System.out.println(" 1 2 3   4 5 6");
		mostrandoAsientos(asientos);
			break;
		case 2:
			reservandoAsientos(asientos, s);
			break;
		case 3:
			sacandoReserva(asientos, s);
			break;
		case 4:
			System.out.print("Saliendo");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			break;
		default:
			System.out.println("Por favor, no salgas de las opciones mostradas en el menu");
		}
	} while(seguir);
}
	
	public static void poniendoAsientos(String[][] asientos) {
		final int FILA = 10;
		final int COLUMNA = 6;
		char letras = 65;
		for(int i = 0; i < FILA; i++) {
			for(int j = 0; j < COLUMNA; j++) {
				asientos[i][j] = "-";
			}
		}
	}
	
	public static void mostrandoAsientos(String asientos[][]) {
		final int FILA = 10;
		final int COLUMNA = 6;
		char letras = 65;
		asientos[0][0] = "X";asientos[2][0] = "X"; asientos[4][0] = "X"; asientos[5][0] = "X"; asientos[8][0] = "X";
		asientos[5][1] = "X";
		asientos[2][2] = "X"; asientos[3][2] = "X"; asientos[5][2] = "X"; asientos[6][2] = "X"; asientos[7][2] = "X";
		asientos[0][3] = "X"; asientos[1][3] = "X"; asientos[4][3] = "X"; asientos[5][3] = "X"; asientos[7][3] = "X"; asientos[9][3] = "X";
		asientos[1][4] = "X"; asientos[6][4] = "X"; asientos[7][4] = "X"; asientos[8][4] = "X"; 
		asientos[3][5] = "X"; asientos[4][5] = "X"; asientos[6][5] = "X"; asientos[7][5] = "X";
		
		for(int iDos = 0; iDos < FILA; iDos++) {
			letras+= iDos;
			System.out.print(""+letras);
			for(int j = 0; j < COLUMNA; j++) {
				if(j == 3) {
					System.out.print("  ");
				}
				System.out.print(" " + asientos[iDos][j]);
			}
			System.out.print(" "+letras);
			System.out.println(" ");
		}
	}
	public static void reservandoAsientos(String[][] asientos, Scanner s) {
	/*	System.out.println("Por favor, eliga uno de los asientos :)");
		System.out.println("Primero ponga en que fila quiere sentarse (A,B,C) etc.");
		System.out.println("(Esto por ahora va a ser representado con numeros del 1 al 6)");
		int fila = s.nextInt();
		System.out.println("Ahora ponga un asiento de esa fila que quiera agarrar");
		int columna = s.nextInt();
		fila --;
		columna --;
		System.out.println("Perfecto! Su asiento ya esta reservado!");
		return asientos[fila][columna]; */
		
		
	       System.out.println("Por favor, elija la fila donde quiere sentarse (A-J)");
	        char filaLetra = s.next().toUpperCase().charAt(0);
	        int fila = filaLetra - 'A';

	        System.out.println("Ahora elija un asiento de esa fila (1-6)");
	        int columna = s.nextInt() - 1;

	        if (fila < 0 || fila >= asientos.length || columna < 0 || columna >= asientos[0].length) {
	            System.out.println("Ese asiento no existe, por favor, elija otro asiento");
	            return;
	        }

	        if (asientos[fila][columna].equals("X")) {
	            System.out.println("Elija otro, por favor, ese asiento no se puede");
	        } else {
	            asientos[fila][columna] = "X";
	            System.out.println("Asiento reservado");
	        }
	}
	
    public static void sacandoReserva(String[][] asientos, Scanner s) {
        System.out.println("Elija de que fila es el asiento que quiere cancelar (A-J)");
        char filaLetra = s.next().toUpperCase().charAt(0);
        int fila = filaLetra - 'A';

        System.out.println("Elija que asiento quiere cancelar(1-6)");
        int columna = s.nextInt() - 1;

        if (fila < 0 || fila >= asientos.length || columna < 0 || columna >= asientos[0].length) {
            System.out.println("Ese asiento no existe");
            return;
        }

        if (asientos[fila][columna].equals("-")) {
            System.out.println("Ese asiento no se puede cancelar, por favor, elija su asiento correspondiente para cancelar");
        } else {
            asientos[fila][columna] = "-";
            System.out.println("Reserva removida");
        }
    }
}
