package logica;

//Importar librerias necesarias
import java.util.Scanner;
import java.io.*;

public class Main {

	// Variable comunicadora entre Sistema y Main
	static Sistema S = new SistemaImplementado();

	public static void main(String[] args) {

		// Generar Scanner global
		Scanner scanner = new Scanner(System.in);

		lecturaHechizos();
		lecturaMagos();

		paneles(scanner);

		// Cerrar Scanner Global
		scanner.close();

	}

	// Método generado para leer y enviar al sistema implementado las lineas del txt
	// de Hechizos para que este trabaje con ellas
	private static void lecturaHechizos() {

		File file = new File("Hechizos.txt");
		Scanner lector;

		try {

			lector = new Scanner(file);

			while (lector.hasNextLine()) {

				String[] partes = lector.nextLine().split(";");
				S.trabajarHechizo(partes);

			}

			lector.close();

		} catch (Exception e) {
			P(e.getMessage());
		}

	}

	// Método generado para leer y enviar al sistema implementado las lineas del txt
	// de Magos para que este trabaje con ellas
	private static void lecturaMagos() {

		File file = new File("Magos.txt");
		Scanner lector;

		try {

			lector = new Scanner(file);

			while (lector.hasNextLine()) {

				String[] partes = lector.nextLine().split(";");
				S.trabajarMago(partes, true);

			}

			lector.close();

		} catch (Exception e) {
			P("No se encontró el archivo ....");
		}

	}

	// Menú generado para presentar los 2 paneles
	private static void paneles(Scanner scanner) {

		String respuesta = "";

		while (!respuesta.equals("3")) {

			P("Taller 3\n\n1) Ingresar al panel de Administrador \n2) Ingresar al panel de Analista\n3) Finalizar programa\n");

			respuesta = scanner.nextLine();

			switch (respuesta) {

			case "1":
				menuAdministrador(scanner);
				break;

			case "2":
				menuAnalista(scanner);
				break;

			case "3":
				P("Finalizando programa ...");
				break;

			default:
				P("Ingrese una opción valida\n");
				break;

			}

		}

	}

	// Método generado para presentar las opciones de menú administrador junto
	// a los resultados de las opciones
	private static void menuAdministrador(Scanner scanner) {

		S.ordenarHechizos();
		S.ordenarMagos();

		String respuesta = "";

		while (!respuesta.equals("7")) {

			P("Administrador \n" + "\n" + "1) Agregar Mago\r\n" + "2) Modificar Mago\r\n" + "3) Eliminar Mago\r\n"
					+ "4) Agregar Hechizo\r\n" + "5) Modificar Hechizo\r\n" + "6) Eliminar Hechizo\r\n"
					+ "7) Salir del Administrador");

			respuesta = scanner.nextLine();

			switch (respuesta) {

			case "1":

				P("Ingrese el Mago a agregar con el formato:");
				P("NombreMago;Hechizo1|Hechizo2|HechizoN");

				String[] m = scanner.nextLine().split(";");
				S.trabajarMago(m, false);

				P("Mago Agregado\n");

				break;

			case "2":

				P("Lista de Magos\n");
				P(S.solicitarMagos());
				P("-1) Devolverse\n");
				P("Ingrese la posición del Mago que desea modificar:");

				int posicionModificarMago = Integer.valueOf(scanner.nextLine());

				if (posicionModificarMago == -1) {
					P("Ningún Mago fue modificado\n");
					break;
				}

				P("Ingrese los nuevos datos del Mago con el formato:");
				P("NombreMago;Hechizo1|Hechizo2|HechizoN");

				String[] datosMago = scanner.nextLine().split(";");

				if (S.modificarMago(posicionModificarMago - 1, datosMago)) {
					P("Mago modificado correctamente\n");
				} else {
					P("No se pudo modificar el Mago\n");
				}

				break;

			case "3":

				P("Lista de Magos\n");
				P(S.solicitarMagos());
				P("-1) Devolverse\n");
				P("Ingrese la posición del Mago que desea eliminar");

				int posicion1 = Integer.valueOf(scanner.nextLine());

				if (S.eliminarMago(posicion1 - 1) == true) {
					P("Elemento removido\n");
				} else {

					if (posicion1 == -1) {
						P("Ningún Mago fue removido\n");
					} else {
						P("Ingrese una posición valida\n");
					}
				}

				break;

			case "4":

				P("Agregar Hechizo");
				menuAgregarHechizo(scanner);

				break;

			case "5":

				P("Lista de Hechizos\n");
				P(S.solicitarhechizos());
				P("-1) Devolverse\n");
				P("Ingrese la posición del Hechizo que desea modificar:");

				int posicionModificarHechizo = Integer.valueOf(scanner.nextLine());

				if (posicionModificarHechizo == -1) {
					P("Ningún Hechizo fue modificado\n");
					break;
				}

				P("Ingrese los nuevos datos del Hechizo con el formato:");
				P("NombreHechizo;Tipo;Daño;DatosExtra");
				P("Ejemplos:");
				P("Fuego: Lanzallamas;Fuego;80;5");
				P("Tierra: Tumba Rocas;Tierra;18;40");
				P("Planta: Polen Somnífero;Planta;81;3,10");
				P("Agua: Escaldar;Agua;110;45,360");

				String[] datosHechizo = scanner.nextLine().split(";");

				if (S.modificarHechizo(posicionModificarHechizo - 1, datosHechizo)) {
					P("Hechizo modificado correctamente\n");
				} else {
					P("No se pudo modificar el Hechizo\n");
				}

				break;

			case "6":

				P("Lista de Hechizos\n");
				P(S.solicitarhechizos());
				P("-1) Devolverse\n");
				P("Ingrese la posición del Hechizo que desea eliminar");

				int posicion2 = Integer.valueOf(scanner.nextLine());

				if (S.eliminarHechizo(posicion2 - 1) == true) {
					P("Elemento removido\n");
				} else {

					if (posicion2 == -1) {
						P("Ningún Hechizo fue removido\n");
					} else {
						P("Ingrese una posición valida\n");
					}
				}

				break;

			}

		}

	}

	// NombreHechizo;Tipo;Daño;...
	private static void menuAgregarHechizo(Scanner scanner) {

		String hechizo = "";

		P("Ingrese el nombre del Hechizo");
		hechizo += scanner.nextLine() + ";";
		P("Ingrese el tipo de Daño:\n1) Fuego\n2) Tierra\n3) Planta\n4) Agua");
		String tipo = scanner.nextLine();

		P("Ingrese el daño del Hechizo");
		String daño = scanner.nextLine();

		switch (tipo) {

		case "1":

			hechizo += "Fuego;";
			hechizo += daño + ";";
			P("Ingrese la duración de la quemadura");
			hechizo += scanner.nextLine();

			break;

		case "2":

			hechizo += "Tierra;";
			hechizo += daño + ";";
			P("Ingrese la mejora de defensa");
			hechizo += scanner.nextLine();

			break;

		case "3":

			hechizo += "Planta;";
			hechizo += daño + ";";
			P("Ingrese la DuracionStun");
			hechizo += scanner.nextLine() + ",";
			P("Ingrese la cantidad de plantas");
			hechizo += scanner.nextLine();

			break;

		case "4":

			hechizo += "Agua;";
			hechizo += daño + ";";
			P("Ingrese la CantidadHeal");
			hechizo += scanner.nextLine() + ",";
			P("Ingrese la Presión del Agua");
			hechizo += scanner.nextLine();

			break;

		default:
			P("Tipo no reconocido ...");
			break;
		}

		S.trabajarHechizo(hechizo.split(";"));
		S.guardarHechizos();
		P("Hechizo agregado correctamente\n");

	}

	// Método generado para presentar las opciones de menú Analista junto
	// a los resultados de las opciones
	private static void menuAnalista(Scanner scanner) {

		S.ordenarHechizos();
		S.ordenarMagos();

		String respuesta = "";

		while (!respuesta.equals("7")) {

			P("Analista \n" + "\n" + "1) Top 10 Mejores Hechizos\r\n" + "2) Top 3 Mejores Magos\r\n"
					+ "3) Mostrar todos los Hechizos\r\n" + "4) Mostrar todos los magos\r\n"
					+ "5) Mostrar todos los Hechizos junto a su puntuacion\r\n"
					+ "6) Mostrar todos los magos junto a su puntuacion\r\n" + "7) Salir del Analista");

			respuesta = scanner.nextLine();

			switch (respuesta) {

			case "1":
				P("Top 10 Mejores Hechizos\n");
				P(S.entregarTopHechizos());
				break;

			case "2":
				P("Top 3 Mejores Magos\n");
				P(S.entregarTopMago());
				break;

			case "3":
				P("Hechizos: \n");
				P(S.solicitarhechizos());
				break;

			case "4":
				P("Magos: \n");
				P(S.solicitarMagos());
				break;

			case "5":
				P("Hechizos\n");
				P(S.entregarHechizosPuntuacion());
				break;

			case "6":
				P("Magos\n");
				P(S.entregarMagosPuntuacion());
				break;

			case "7":
				P("Saliendo del Analista\n");
				break;

			default:
				P("Ingrese una opción valida ...\n");
				break;

			}

		}

	}

	// Método para imprimir bonito
	private static void P(String t) {
		System.out.println(t);
	}

}
