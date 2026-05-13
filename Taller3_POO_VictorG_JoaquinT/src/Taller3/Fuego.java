package Taller3;

public class Fuego extends Hechizo {

	// Declaración de atributos
	private int duracionQuemadura;

	// Generar Constructor
	public Fuego(String nombreHechizo, String tipoHechizo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipoHechizo, daño);

		this.duracionQuemadura = duracionQuemadura;

	}

	@Override
	public String toString() {
		return "Fuego [duracionQuemadura=" + duracionQuemadura + "]";
	}

}
