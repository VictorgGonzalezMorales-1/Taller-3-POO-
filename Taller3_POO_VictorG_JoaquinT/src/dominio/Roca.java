package dominio;

public class Roca extends Hechizo {

	private int mejoraDefensa;

	public Roca(String nombreHechizo, String tipoHechizo, int daño, int mejoraDefensa) {
		super(nombreHechizo, tipoHechizo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	@Override
	public int entregarPuntaje() {
		return (this.daño * this.mejoraDefensa) / 2;
	}

	@Override
	public String formatoArchivo() {
		return nombreHechizo + ";" + tipoHechizo + ";" + daño + ";" + mejoraDefensa;
	}

	@Override
	public String toString() {
		return "Roca [mejoraDefensa=" + mejoraDefensa + "]";
	}

}