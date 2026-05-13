package Taller3;

public class Roca extends Hechizo {

	// Declaración de atributos
	private int mejoraDefenza;

	// Generar Constructor
	public Roca(String nombreHechizo, String tipoHechizo, int daño, int mejoraDefenza) {
		super(nombreHechizo, tipoHechizo, daño);

		this.mejoraDefenza = mejoraDefenza;

	}

	@Override
	public String toString() {
		return "Roca [mejoraDefenza=" + mejoraDefenza + "]";
	}

}
