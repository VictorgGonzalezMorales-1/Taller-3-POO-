package dominio;

public class Agua extends Hechizo {

	private int cantidadHeal;
	private int presionDelAgua;

	public Agua(String nombreHechizo, String tipoHechizo, int daño, int cantidadHeal, int presionDelAgua) {
		super(nombreHechizo, tipoHechizo, daño);
		this.cantidadHeal = cantidadHeal;
		this.presionDelAgua = presionDelAgua;
	}

	@Override
	public int entregarPuntaje() {
		return (this.daño + this.cantidadHeal + this.presionDelAgua) * 2;
	}

	@Override
	public String formatoArchivo() {
		return nombreHechizo + ";" + tipoHechizo + ";" + daño + ";" + cantidadHeal + "," + presionDelAgua;
	}

	@Override
	public String toString() {
		return "Agua [cantidadHeal=" + cantidadHeal + ", presionDelAgua=" + presionDelAgua + "]";
	}

}