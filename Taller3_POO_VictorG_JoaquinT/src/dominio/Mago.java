package dominio;

//Importar librerias necesarias
import java.util.LinkedList;

public class Mago {

	// Declaración de atributos
	private String nombreMago;
	private LinkedList<Hechizo> hechizosMago;

	// Generar Constructor
	public Mago(String nombreMago) {

		this.nombreMago = nombreMago;
		this.hechizosMago = new LinkedList<Hechizo>();

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

	public LinkedList<Hechizo> getHechizosMago() {
		return hechizosMago;
	}

	// Método generado para olvidar un hechizo
	public void olvidarHechizo(Hechizo h) {

		this.hechizosMago.remove(h);

	}

}
