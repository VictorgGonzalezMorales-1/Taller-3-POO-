package dominio;

//Importar librerias necesarias
import java.util.ArrayList;

public class Mago {

	// Declaración de atributos
	private String nombreMago;
	private ArrayList<Hechizo> hechizosMago;

	// Generar Constructor
	public Mago(String nombreMago) {

		this.nombreMago = nombreMago;
		this.hechizosMago = new ArrayList<Hechizo>();

	}

	// Método generado para almacenar hechizos en el ArrayList
	// De Hechizos
	public void almacenarHechizos(Hechizo h) {
		hechizosMago.add(h);
	}

	public String getNombreMago() {
		return nombreMago;
	}

	// Método generado para calcular la puntuación de cada mago
	public int entregarPuntaje() {

		int puntuacion = 0;

		for (Hechizo h : hechizosMago) {

			puntuacion += h.entregarPuntaje();

		}

		return puntuacion;

	}

	@Override
	public String toString() {
		return "Mago [nombreMago=" + nombreMago + ", hechizosMago=" + hechizosMago + "]";
	}

	// La puntuacion de cada mago se calcula sumando las puntuaciones de cada
	// hechizo que domina.

}
