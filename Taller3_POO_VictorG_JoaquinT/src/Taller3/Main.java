package Taller3;

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

		String respuesta = "";

		while (!respuesta.equals("7")) {

			P("Administrador \n" + "\n" + "1) Agregar Mago\r\n" + "2) Modificar Mago\r\n" + "3) Eliminar Mago\r\n"
					+ "4) Agregar Hechizo\r\n" + "5) Modificar Hechizo\r\n" + "6) Eliminar Hechizo\r\n"
					+ "7) Salir del Administrador");

			respuesta = scanner.nextLine();

			switch (respuesta) {

			case "1":
				P("Agregar Mago");
				break;

			case "2":
				P("Modificar Mago");
				break;

			case "3":
				P("Eliminar Mago");
				break;

			case "4":
				P("Agregar Hechizo");
				break;

			case "5":
				P("Modificar Hechizo");
				break;

			case "6":
				P("Eliminar Hechizo");
				break;

			case "7":
				P("Saliendo del Administrador\n");
				break;

			default:
				P("Ingrese una opción valida ...\n");
				break;

			}

		}

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
				P("Top 3 Mejores Magos");
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
				P("Mostrar todos los magos junto a su puntuacion");
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
