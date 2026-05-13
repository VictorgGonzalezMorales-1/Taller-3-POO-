package dominio;

public class Fuego extends Hechizo {

	private int duracionQuemadura;

	public Fuego(String nombreHechizo, String tipoHechizo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipoHechizo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}

	@Override
	public int entregarPuntaje() {
		return this.daño * this.duracionQuemadura;
	}

	@Override
	public String formatoArchivo() {
		return nombreHechizo + ";" + tipoHechizo + ";" + daño + ";" + duracionQuemadura;
	}

	@Override
	public String toString() {
		return "Fuego [duracionQuemadura=" + duracionQuemadura + "]";
	}

}