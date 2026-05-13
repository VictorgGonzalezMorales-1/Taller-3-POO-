package dominio;

public abstract class Hechizo {

	protected String nombreHechizo;
	protected String tipoHechizo;
	protected int daño;

	public Hechizo(String nombreHechizo, String tipoHechizo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipoHechizo = tipoHechizo;
		this.daño = daño;
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public String getTipoHechizo() {
		return tipoHechizo;
	}

	public int getDaño() {
		return daño;
	}

	public abstract int entregarPuntaje();

	public abstract String formatoArchivo();

}