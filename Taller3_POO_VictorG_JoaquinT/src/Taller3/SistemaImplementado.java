package Taller3;

//Importar librerias necesarias
import java.util.ArrayList;

public class SistemaImplementado implements Sistema {

	// ArrayLis generada para almacenar los hechizos generados por la lectura
	// de archivos y opociones del menú
	private static ArrayList<Hechizo> H = new ArrayList<Hechizo>();

	// Método generado para recibir y gestionar el trabajo
	// Para la creación/ Almacenamiento de Hechizos
	public void trabajarHechizo(String[] partes) {

		Hechizo h = null;

		String[] partes2 = partes[3].split(",");

		switch (partes[1]) {

		case "Fuego":
			h = new Fuego(partes[0], partes[1], Integer.valueOf(partes[2]), Integer.valueOf(partes2[0]));
			break;

		case "Tierra":
			h = new Roca(partes[0], partes[1], Integer.valueOf(partes[2]), Integer.valueOf(partes2[0]));
			break;

		case "Planta":
			h = new Planta(partes[0], partes[1], Integer.valueOf(partes[2]), Integer.valueOf(partes2[0]),
					Integer.valueOf(partes2[1]));
			break;

		case "Agua":
			h = new Agua(partes[0], partes[1], Integer.valueOf(partes[2]), Integer.valueOf(partes2[0]),
					Integer.valueOf(partes2[1]));
			break;

		}

		if (revisarHechizoUnico(h) == false) {
			H.add(h);
		}

	}

	// Método generado para revisar que no se repita ningún hechizo
	// para solo tener lo necesario
	private boolean revisarHechizoUnico(Hechizo h) {

		if (H.size() == 0) {
			return false;
		}

		for (Hechizo h2 : H) {

			if (h2.getNombreHechizo().equals(h.nombreHechizo)) {
				return true;
			}

		}

		return false;

	}

	// Método generado para recibir y gestionar el trabajo
	// Para la creación/ Almacenamiento de Magos
	public void trabajarMago(String[] partes) {

	}

}
