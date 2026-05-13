package Taller3;

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

	@Override
	public String toString() {
		return "Mago [nombreMago=" + nombreMago + ", hechizosMago=" + hechizosMago + "]";
	}

}
