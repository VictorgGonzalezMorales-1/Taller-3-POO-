package dominio;

public class Planta extends Hechizo {

	// Declaración de atributos
	private int duracionStun;
	private int cantPlantas;

	// Generar Constructor
	public Planta(String nombreHechizo, String tipoHechizo, int daño, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipoHechizo, daño);

		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;

	}

	@Override
	public String toString() {
		return "Planta [duracionStun=" + duracionStun + ", cantPlantas=" + cantPlantas + "]";
	}

	// Método generado para entregar el puntaje de los hechizos tipo Planta
	public int entregarPuntaje() {
		return this.daño + (this.cantPlantas * this.duracionStun);
	}

}
