package ejerciciosJava;

public class ejercicios_aaf_Seis {
	public static void main(String[] args) {
		/* Indique el valor que tendrá x en cada una de las líneas 
		 x = 1;     
		 ++x;  
		 x += x++; 
		 --x; */
		int x = 1;
		System.out.println("La x original es: " + x);
		x++;
		System.out.println("Ahora x es: " + x);
		x += x++;
		System.out.println("Ahora ahora x es: " + x);
		--x;
		System.out.println("Ahora ahora ahora x es: " + x);
	}
}
