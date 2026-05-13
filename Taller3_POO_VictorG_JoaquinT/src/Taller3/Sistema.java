package Taller3;

public interface Sistema {

	void trabajarHechizo(String[] partes);
	void trabajarMago(String[] partes, boolean agregarHechizos);
	void ordenarHechizos();
	void ordenarMagos();
	
	//Analista
	String entregarTopHechizos();
	String solicitarhechizos();
	String solicitarMagos();
	String entregarHechizosPuntuacion();
	
}
