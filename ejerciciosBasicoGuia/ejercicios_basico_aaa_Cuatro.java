package ejerciciosJava;

public class ejercicios_basico_aaa_Cuatro {
	/*Crear un programa que muestre por consola los caracteres ASCII que se encuentran 
entre los valores 30 y 126 inclusive. Los caracteres se deben mostrar en 7 filas de 15 
columnas. */
	public static void main(String[] args) {
		tecladoASCII();
	}
	
	public static void tecladoASCII() {
		char letra = 30;
		int variableAgresiva = 0;
		for(letra = 30; letra <= 126; letra++ ) {
			System.out.print(" " + letra);
			variableAgresiva++;
			if(variableAgresiva == 13) {
				variableAgresiva = 0;
				System.out.println(" ");
			}
		}
	}
	
}
