package ejerciciosJava;
import java.util.InputMismatchException;
import java.util.Scanner;

public class loQueDiosCreo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		final int CANT_ACCIONES_MIN = 0, CANT_ACCIONES_MAX = 100;
		final int ID_MIN = 1, ID_MAX = 1000;
		final int CANT_ATRIBUTOS = 5;
		
		int cantAccionesEmpresas = 0;
		
		final String[][] ACCIONES = new String[CANT_ACCIONES_MAX][CANT_ATRIBUTOS];
		

		do {
			System.out.println("---------------------------------------------------");
		System.out.println("Bienvenido, quiere hacer alguna accion en la empresa?");
		System.out.println("Comprar empresas (1)");
		System.out.println("Vender empresas (2)");
		System.out.println("Cambiar valor actual de una accion(3)");
		System.out.println("Mostrar las acciones que hay(4)");
		System.out.println("Salir (5)");
		System.out.println("-----------------------------------------------------");
		int opcion = s.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("Ingrese la cantidad de acciones que desea comprar ("+CANT_ACCIONES_MIN+"-"+CANT_ACCIONES_MAX+")");
			final int CANT_ACCIONES_INICIALES = ingresarEntero(s,CANT_ACCIONES_MIN, CANT_ACCIONES_MAX);
			
			for (int i = 0; i < CANT_ACCIONES_INICIALES; i++) {
				int indiceId = -1; 
				int id = -1;
				do {
					System.out.println("Ingrese el ID de la acción");
					id = ingresarEntero(s,ID_MIN,ID_MAX);
					indiceId = buscarEntero(ACCIONES,0, id, cantAccionesEmpresas);
					if(indiceId!=-1) {
						System.out.println("El ID de la acción ingresada ya existe");
						System.out.println("Vuelva a ingresar");
					}
				} while(indiceId!=-1);
				
				System.out.println("Ingrese nombre de la empresa");
				final String NOMBRE_EMPRESA = s.nextLine();
				//Comprobar que el nombre no exista en la matriz
				//Comprobar que no me ingrese algo vacío
				
				System.out.println("Ingrese valor de compra");
				final int VALOR_COMPRA = ingresarEntero(s,1,Integer.MAX_VALUE); 
				int precioActual = VALOR_COMPRA;
				
				System.out.println("Ingrese la cantidad de acciones que desea comprar");
				final int CANT_ACCIONES = ingresarEntero(s,1,Integer.MAX_VALUE);
				
				ACCIONES[i][0] = Integer.toString(id);
				ACCIONES[i][1] = NOMBRE_EMPRESA;
				ACCIONES[i][2] = Integer.toString(VALOR_COMPRA);
				ACCIONES[i][3] = Integer.toString(precioActual);
				ACCIONES[i][4] = Integer.toString(CANT_ACCIONES);			
				cantAccionesEmpresas++;			
			}
			
			for (int i = 0; i < cantAccionesEmpresas; i++) {
				System.out.println((i+1)+". ID: " +ACCIONES[i][0] + " NOMBRE: " + ACCIONES[i][1] + " PRECIO DE COMPRA $ " + ACCIONES[i][2] + " PRECIO ACTUAL $" + ACCIONES[i][3] + " CANTIDAD COMPRADAS " + ACCIONES[i][4] );
			}
		case 2:
		    if (cantAccionesEmpresas == 0) {
		        System.out.println("No hay empresas para vender.");
		        break;
		    }
			System.out.println("Que es lo que queire vender?");
			int idEliminar = ingresarEntero(s, ID_MIN, ID_MAX);
			cantAccionesEmpresas = borrando(s, ACCIONES, idEliminar, cantAccionesEmpresas);
			break;
		case 3:
			System.out.println("Que id quiere actualizar su valor?");
			//actualizandoValores(ACCIONES[i][3] = precioActual);
			break;
		case 4:
			mostrando(ACCIONES, cantAccionesEmpresas);
			break;
		case 5:
			System.out.println("Saliendo...");
			saliendo();
			break;
		default:
			System.out.println("No hagas eso");
			break;
		}
		} while(true);
	}
	
	public static int buscarEntero(final String[][] MATRIZ, final int IND_CAMPO_BUSCADO ,final int NRO_BUSCADO, final int LONGITUD) {
		int i = 0;
		while(i<LONGITUD) {
			if(Integer.parseInt(MATRIZ[i][IND_CAMPO_BUSCADO]) == NRO_BUSCADO) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	public static int ingresarEntero(Scanner s, final int MIN ,final int MAX) {
		
		if(MIN>MAX) {
			System.out.println("Error, el valor minimo no puede ser mayor al valor maximo");
			System.exit(1);
		}
		
		boolean error = false;
		
		int nro =0;		
		do {
			error = false;
			try {
				nro = s.nextInt();
				if(nro < MIN || nro > MAX) {
					System.out.println("Error." + ((MAX==MIN)?("ingresar el numero " + MIN):(" El numero debe estar entre "+MIN+" y " + MAX)));
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
		
		return nro;
	}
	
	
	
	public static int borrando(Scanner s, String[][] ACCIONES, int id, int cantAccionesEmpresas) {
		int almacenamiento = 0;
	    int indice = buscarEntero(ACCIONES, almacenamiento, id, cantAccionesEmpresas);
	    if (indice == -1) {
	        System.out.println("No existe esa empresa");
	        return cantAccionesEmpresas;
	    }
	    for (int i = indice; i < cantAccionesEmpresas - 1; i++) {
	        ACCIONES[i] = ACCIONES[i + 1]; 
	    }
	    ACCIONES[cantAccionesEmpresas - 1] = new String[ACCIONES[0].length];
	    System.out.println("Empresa con id " + id + " eliminada");
	    return cantAccionesEmpresas - 1;
	}
	
	public static void saliendo() {
		System.exit(0);
	}

	public static int actualizandoValores(Scanner s, int precioActual) {
		System.out.println("Usted esta cambinado el valor de la empresa");
		System.out.println("Ponga el precio que vale actualmente");
		do {
		precioActual = s.nextInt();
		if(precioActual <= 0) {
			System.out.println("Dale... Como va a valer menos de 0 una accion?");
		}
		} while(precioActual <= 0); 
		return precioActual;
	}
	
	public static int mostrando(String ACCIONES[][], int cantAccionesEmpresas) {
		for (int i = 0; i < cantAccionesEmpresas; i++) {
			System.out.println((i+1)+"ID: " +ACCIONES[i][0] + "Nombre: " + ACCIONES[i][1] + "Precio de la compra: " + ACCIONES[i][2] + "Precio en la actualidad: " + ACCIONES[i][3] + "Cantidad de accioens: " + ACCIONES[i][4] );
		}
		return cantAccionesEmpresas;
	}
}
