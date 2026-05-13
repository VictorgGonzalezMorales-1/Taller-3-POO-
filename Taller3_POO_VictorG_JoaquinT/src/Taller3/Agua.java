package Taller3;

public class Agua extends Hechizo {

	// Declaración de atributos
	private int cantidadHeal;
	private int presionDelAgua;

	// Generar Constructor
	public Agua(String nombreHechizo, String tipoHechizo, int daño, int cantidadHeal, int presionDelAgua) {
		super(nombreHechizo, tipoHechizo, daño);
		this.cantidadHeal = cantidadHeal;
		this.presionDelAgua = presionDelAgua;
	}

}
