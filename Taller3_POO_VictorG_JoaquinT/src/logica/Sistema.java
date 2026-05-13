package logica;

public interface Sistema {

	void trabajarHechizo(String[] partes);
	void trabajarMago(String[] partes, boolean agregarHechizos);
	void ordenarHechizos();
	void ordenarMagos();
	
	//Administrador()
	//trabajarMago(String[] partes, boolean agregarHechizos);
	boolean eliminarMago(int i);
	boolean eliminarHechizo(int n);
	
	//Analista
	String entregarTopHechizos();
	String entregarTopMago();
	String solicitarhechizos();
	String solicitarMagos();
	String entregarHechizosPuntuacion();
	String entregarMagosPuntuacion();

}
