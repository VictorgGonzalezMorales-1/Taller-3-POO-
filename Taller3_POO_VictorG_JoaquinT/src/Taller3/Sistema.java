package Taller3;

public interface Sistema {

	void trabajarHechizo(String[] partes);
	void trabajarMago(String[] partes, boolean agregarHechizos);
	void ordenarHechizos();
	
	//Analista
	String solicitarhechizos();
	String solicitarMagos();

}
