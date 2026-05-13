package Taller3;

public abstract class Hechizo {

	// Declaración de atributos
	protected String nombreHechizo;
	protected String tipoHechizo;
	protected int daño;

	// Generar Constructor
	public Hechizo(String nombreHechizo, String tipoHechizo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipoHechizo = tipoHechizo;
		this.daño = daño;
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	//Método abstracto generado para que todos sus hijos calculen su puntaje
	public abstract int entregarPuntaje();

}
