package logica;

//Importar librerias necesarias
import java.util.ArrayList;

import dominio.*;

public class SistemaImplementado implements Sistema {

	// ArrayLis generada para almacenar los hechizos generados por la lectura
	// de archivos y opciones del menú
	private static ArrayList<Hechizo> H = new ArrayList<Hechizo>();

	// ArrayLis generada para almacenar los Magos generados por la lectura
	// de archivos y opciones del menú
	private static ArrayList<Mago> M = new ArrayList<Mago>();

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
	public boolean revisarHechizoUnico(Hechizo h) {

		if (H.size() == 0) {
			return false;
		}

		for (Hechizo h2 : H) {

			if (h2.getNombreHechizo().equals(h.getNombreHechizo())) {
				return true;
			}

		}

		return false;

	}

	// Método generado para recibir y gestionar el trabajo
	// Para la creación/ Almacenamiento de Magos
	public void trabajarMago(String[] partes, boolean agregarHechizos) {

		Mago m = new Mago(partes[0]);
		M.add(m);

		if (agregarHechizos == true) {
			agregarHechizo(partes[1], m);
		}

	}

	// Método generado para almacenar los hechizos del mago en su
	// ArrayList de hechizos
	public void agregarHechizo(String string, Mago mago) {

		String[] hechizos = string.split("\\|");

		for (int a = 0; a < hechizos.length; a++) {

			Hechizo h = buscarHechizo(hechizos[a]);

			if (h != null) {
				mago.almacenarHechizos(h);
			}

		}

	}

	// Método generado para buscar un hechizo con su nombre
	public Hechizo buscarHechizo(String nombreHechizo) {

		for (Hechizo h : H) {

			if (h.getNombreHechizo().equals(nombreHechizo)) {
				return h;
			}

		}

		return null;

	}

	// Método generado para entregar en orden todos los Hechizos del ArrayList H
	public String solicitarhechizos() {

		String texto = "";

		for (int a = 0; a < H.size(); a++) {

			texto += (a + 1) + ") " + H.get(a).getNombreHechizo() + "\n";

		}

		return texto;

	}

	// Método generado para entregar en orden todos los Magos del ArrayList M
	public String solicitarMagos() {

		String texto = "";

		for (int a = 0; a < M.size(); a++) {

			texto += (a + 1) + ") " + M.get(a).getNombreMago() + "\n";

		}

		return texto;

	}

	// Método generado para ordenar la ArrayList de Hechizos de mayor a menor
	public void ordenarHechizos() {

		Hechizo h;

		for (int a = 0; a < H.size() - 1; a++) {

			for (int b = 0; b < H.size() - a - 1; b++) {

				if (H.get(b).entregarPuntaje() < H.get(b + 1).entregarPuntaje()) {

					h = H.get(b);
					H.set(b, H.get(b + 1));
					H.set(b + 1, h);

				}

			}

		}

	}

	// Método generado para ordenar la ArrayList de Magos de mayor a menor
	public void ordenarMagos() {

		Mago m;

		for (int a = 0; a < M.size() - 1; a++) {

			for (int b = 0; b < M.size() - a - 1; b++) {

				if (M.get(b).entregarPuntaje() < M.get(b + 1).entregarPuntaje()) {

					m = M.get(b);
					M.set(b, M.get(b + 1));
					M.set(b + 1, m);

				}

			}

		}

	}

	// Método generado para entregar los 10 hechizos con mayor puntuación
	public String entregarTopHechizos() {

		String texto = "";

		for (int a = 0; a < 10; a++) {

			texto += (a + 1) + ") " + H.get(a).getNombreHechizo() + "\n";

		}

		return texto;
	}

	// Método generado para entregar todos los hechizos junto a su puntuación
	public String entregarHechizosPuntuacion() {

		String texto = "";

		for (int a = 0; a < H.size(); a++) {

			texto += (a + 1) + ") " + H.get(a).getNombreHechizo() + " - Puntaje: " + H.get(a).entregarPuntaje() + "\n";

		}

		return texto;
	}

	// Método generado para entregar los 3 mejores magos
	public String entregarTopMago() {

		String texto = "";

		for (int a = 0; a < 3; a++) {

			texto += (a + 1) + ") " + M.get(a).getNombreMago() + "\n";

		}

		return texto;
	}

	// Método generado para entregar todos los magos junto a su puntuación
	public String entregarMagosPuntuacion() {

		String texto = "";

		for (int a = 0; a < M.size(); a++) {

			texto += (a + 1) + ") " + M.get(a).getNombreMago() + " - Puntaje: " + M.get(a).entregarPuntaje() + "\n";

		}

		return texto;

	}

}
