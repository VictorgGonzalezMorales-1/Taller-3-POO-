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

	// Método generado para entregar el puntaje de los Hechizos tipo Roca
	public int entregarPuntaje() {
		return (this.daño * this.mejoraDefenza) / 2;
	}

}
