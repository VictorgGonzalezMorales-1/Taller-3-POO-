package logica;

public interface Sistema {

	// Gestión de hechizos y magos
	void trabajarHechizo(String[] partes);
	void trabajarMago(String[] partes, boolean agregarHechizos);

	// Ordenamiento
	void ordenarHechizos();
	void ordenarMagos();

	// Administrador
	boolean eliminarMago(int i);
	boolean eliminarHechizo(int n);

	boolean modificarMago(int posicion, String[] partes);
	boolean modificarHechizo(int posicion, String[] partes);

	void guardarMagos();
	void guardarHechizos();

	// Analista
	String entregarTopHechizos();
	String entregarTopMago();
	String solicitarhechizos();
	String solicitarMagos();
	String entregarHechizosPuntuacion();
	String entregarMagosPuntuacion();

}