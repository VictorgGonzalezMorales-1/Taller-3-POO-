package dominio;

public class Planta extends Hechizo {

	private int duracionStun;
	private int cantPlantas;

	public Planta(String nombreHechizo, String tipoHechizo, int daño, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipoHechizo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	@Override
	public int entregarPuntaje() {
		return this.daño + (this.cantPlantas * this.duracionStun);
	}

	@Override
	public String formatoArchivo() {
		return nombreHechizo + ";" + tipoHechizo + ";" + daño + ";" + duracionStun + "," + cantPlantas;
	}

	@Override
	public String toString() {
		return "Planta [duracionStun=" + duracionStun + ", cantPlantas=" + cantPlantas + "]";
	}

}