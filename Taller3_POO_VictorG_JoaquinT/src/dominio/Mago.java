package dominio;

import java.util.LinkedList;

public class Mago {

	private String nombreMago;
	private LinkedList<Hechizo> hechizos;

	public Mago(String nombreMago) {
		this.nombreMago = nombreMago;
		this.hechizos = new LinkedList<Hechizo>();
	}

	public String getNombreMago() {
		return nombreMago;
	}

	
	public LinkedList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void almacenarHechizos(Hechizo h) {
		if (h != null) {
			hechizos.add(h);
		}
	}

	public void olvidarHechizo(Hechizo h) {
		hechizos.remove(h);
	}

	public int entregarPuntaje() {
		int puntaje = 0;

		for (Hechizo h : hechizos) {
			puntaje += h.entregarPuntaje();
		}

		return puntaje;
	}

	public String formatoArchivo() {
		String texto = nombreMago + ";";

		for (int i = 0; i < hechizos.size(); i++) {
			texto += hechizos.get(i).getNombreHechizo();

			if (i < hechizos.size() - 1) {
				texto += "|";
			}
		}

		return texto;
	}

	@Override
	public String toString() {
		return nombreMago + " - Puntaje: " + entregarPuntaje();
	}

}