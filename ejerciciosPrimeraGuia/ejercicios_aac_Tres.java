package ejerciciosJava;

public class ejercicios_aac_Tres {
	public static void main(String[] args) {
		//Indique el valor de x = 3 > 2 && 6 < 10 ^ true 
		final int X = 3;
		final int DOS = 2;
		final int SEIS = 6;
		final int DIEZ = 10;
		boolean verdadero = false;
		if (X > DOS && SEIS < DIEZ ^ true) {
		  verdadero = true;
		}
		System.out.println("es " + verdadero);
	}
}
