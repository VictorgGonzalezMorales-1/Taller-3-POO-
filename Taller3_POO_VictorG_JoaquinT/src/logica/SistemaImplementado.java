package logica;

//Importar librerias necesarias


import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import dominio.*;

public class SistemaImplementado implements Sistema {

	// ArrayLis generada para almacenar los hechizos generados por la lectura
	// de archivos y opciones del menú
	private static LinkedList<Hechizo> H = new LinkedList<Hechizo>();

	// ArrayLis generada para almacenar los Magos generados por la lectura
	// de archivos y opciones del menú
	private static LinkedList<Mago> M = new LinkedList<Mago>();

	// Método generado para recibir y gestionar el trabajo

	@Override
	public void trabajarHechizo(String[] partes) {

		if (partes == null) {
			return;
		}

		if (partes.length < 4) {
			return;
		}

		if (partes[0].length() == 0 || partes[1].length() == 0 || partes[2].length() == 0 || partes[3].length() == 0) {
			return;
		}

		Hechizo h = crearHechizoDesdePartes(partes);

		if (h != null && revisarHechizoUnico(h) == false) {
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
	@Override
	public void trabajarMago(String[] partes, boolean agregarHechizos) {

		if (partes == null) {
			return;
		}

		if (partes.length < 1) {
			return;
		}

		if (partes[0].length() == 0) {
			return;
		}

		Mago m = new Mago(partes[0]);

		if (partes.length >= 2) {

			if (partes[1].length() > 0) {
				agregarHechizo(partes[1], m);
			}

		}

		M.add(m);

		if (agregarHechizos == false) {
			guardarMagos();
		}

	}
	// Método generado para almacenar los hechizos del mago en su
	public void agregarHechizo(String string, Mago mago) {

		if (string == null) {
			return;
		}

		if (mago == null) {
			return;
		}

		if (string.length() == 0) {
			return;
		}

		String[] hechizos = string.split("\\|");

		for (int a = 0; a < hechizos.length; a++) {

			if (hechizos[a].length() > 0) {

				Hechizo h = buscarHechizo(hechizos[a]);

				if (h != null) {
					mago.almacenarHechizos(h);
				}

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

			if (H.get(a) != null) {
				texto += (a + 1) + ") " + H.get(a).getNombreHechizo() + "\n";
			}
		}

		return texto;

	}

	// Método generado para entregar en orden todos los Magos del ArrayList M
	public String solicitarMagos() {

		String texto = "";

		for (int a = 0; a < M.size(); a++) {

			if (M.get(a) != null) {
				texto += (a + 1) + ") " + M.get(a).getNombreMago() + "\n";
			}
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

			if (H.get(a) != null) {
				texto += (a + 1) + ") " + H.get(a).getNombreHechizo() + "\n";
			}

		}

		return texto;
	}

	// Método generado para entregar todos los hechizos junto a su puntuación
	public String entregarHechizosPuntuacion() {

		String texto = "";

		for (int a = 0; a < H.size(); a++) {

			if (H.get(a) != null) {
				texto += (a + 1) + ") " + H.get(a).getNombreHechizo() + " - Puntaje: " + H.get(a).entregarPuntaje()
						+ "\n";
			}
		}

		return texto;
	}

	// Método generado para entregar los 3 mejores magos
	public String entregarTopMago() {

		String texto = "";

		for (int a = 0; a < 3; a++) {

			if (M.get(a) != null) {
				texto += (a + 1) + ") " + M.get(a).getNombreMago() + "\n";
			}

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

	// Método generado para eliminar un Hechizo del ArrayList
	@Override
	public boolean eliminarHechizo(int n) {

		if (n == -1) {
			return false;
		}

		if (n >= 0 && n < H.size()) {

			Hechizo h = H.get(n);
			H.remove(n);
			eliminarHechizoMago(h);

			guardarHechizos();
			guardarMagos();

			return true;
		}

		return false;
	}

	// Método generado para eliminar un hechizo de los magos en base a su nombre
	public void eliminarHechizoMago(Hechizo h) {

		for (Mago m : M) {

			m.olvidarHechizo(h);
		}

	}

	
	
	//Método generado para elimiar al mago del LinkedList
	@Override
	public boolean eliminarMago(int n) {

		if (n == -1) {
			return false;
		}

		if (n >= 0 && n < M.size()) {

			M.remove(n);
			guardarMagos();

			return true;
		}

		return false;
	}

	@Override
	public boolean modificarMago(int posicion, String[] partes) {

		if (posicion < 0 || posicion >= M.size()) {
			return false;
		}

		if (partes.length < 2) {
			return false;
		}

		Mago nuevoMago = new Mago(partes[0]);

		agregarHechizo(partes[1], nuevoMago);

		M.set(posicion, nuevoMago);

		guardarMagos();

		return true;
	}

	@Override
	public boolean modificarHechizo(int posicion, String[] partes) {

		if (posicion < 0 || posicion >= H.size()) {
			return false;
		}

		Hechizo hechizoAntiguo = H.get(posicion);
		Hechizo hechizoNuevo = crearHechizoDesdePartes(partes);

		if (hechizoNuevo == null) {
			return false;
		}

		H.set(posicion, hechizoNuevo);

		actualizarHechizoEnMagos(hechizoAntiguo, hechizoNuevo);

		guardarHechizos();
		guardarMagos();

		return true;
	}
	
	private void actualizarHechizoEnMagos(Hechizo hechizoAntiguo, Hechizo hechizoNuevo) {

		for (Mago m : M) {

			LinkedList<Hechizo> lista = m.getHechizos();

			for (int i = 0; i < lista.size(); i++) {

				if (lista.get(i).getNombreHechizo().equals(hechizoAntiguo.getNombreHechizo())) {
					lista.set(i, hechizoNuevo);
				}

			}

		}

	}

	@Override
	public void guardarMagos() {

		try {

			BufferedWriter escritor = new BufferedWriter(new FileWriter("Magos.txt"));

			boolean primeraLinea = true;

			for (Mago m : M) {

				if (m != null) {

					if (m.getNombreMago().length() > 0) {

						String linea = m.formatoArchivo();

						if (linea.length() > 0) {

							if (primeraLinea == false) {
								escritor.newLine();
							}

							escritor.write(linea);
							primeraLinea = false;

						}
					}
				}
			}

			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al guardar Magos.txt");
		}

	}

	@Override
	public void guardarHechizos() {

		try {

			BufferedWriter escritor = new BufferedWriter(new FileWriter("Hechizos.txt"));

			boolean primeraLinea = true;

			for (Hechizo h : H) {

				if (h != null) {

					String linea = h.formatoArchivo();

					if (linea.length() > 0) {

						if (primeraLinea == false) {
							escritor.newLine();
						}

						escritor.write(linea);
						primeraLinea = false;

					}
				}
			}

			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al guardar Hechizos.txt");
		}

	}

	private Hechizo crearHechizoDesdePartes(String[] partes) {

		try {

			if (partes == null) {
				return null;
			}

			if (partes.length < 4) {
				return null;
			}

			if (partes[0].length() == 0 || partes[1].length() == 0 || partes[2].length() == 0 || partes[3].length() == 0) {
				return null;
			}

			String nombre = partes[0];
			String tipo = partes[1];
			int daño = Integer.valueOf(partes[2]);

			String[] partes2 = partes[3].split(",");

			switch (tipo) {

			case "Fuego":

				if (partes2.length < 1 || partes2[0].length() == 0) {
					return null;
				}

				return new Fuego(nombre, tipo, daño, Integer.valueOf(partes2[0]));

			case "Tierra":

				if (partes2.length < 1 || partes2[0].length() == 0) {
					return null;
				}

				return new Roca(nombre, tipo, daño, Integer.valueOf(partes2[0]));

			case "Planta":

				if (partes2.length < 2 || partes2[0].length() == 0 || partes2[1].length() == 0) {
					return null;
				}

				return new Planta(nombre, tipo, daño, Integer.valueOf(partes2[0]), Integer.valueOf(partes2[1]));

			case "Agua":

				if (partes2.length < 2 || partes2[0].length() == 0 || partes2[1].length() == 0) {
					return null;
				}

				return new Agua(nombre, tipo, daño, Integer.valueOf(partes2[0]), Integer.valueOf(partes2[1]));

			default:
				return null;
			}

		} catch (NumberFormatException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}
}
