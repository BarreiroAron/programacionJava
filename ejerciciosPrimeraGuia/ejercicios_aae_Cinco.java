package ejerciciosJava;

public class ejercicios_aae_Cinco {
	public static void main(String[] args) {
	/*Indique el valor de que tendrá x si se tiene que: 
	 x = 5;     
	 x *= x%2*3+2; */
	int x = 5;
	//Float.valueOf(x);
	x = x % 2 * 3 + 2;
	System.out.println("La x es: " + x);
	}
}
