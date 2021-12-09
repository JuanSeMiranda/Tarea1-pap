package interfaces;


import java.util.ArrayList;

import exepciones.NombrePlataformaRepetidoException;
import exepciones.SinPlataformasException;
import logic.clases.Plataforma;



public interface ICAltaEspectaculo {
	
	public String[] listarPlataformas() throws SinPlataformasException;
	
	public void selectPlataforma(String plataforma);
	
	public void ingresarDatos(String nombre, String descripcion, int duracion, int minEspec, int maxEspec, String url,float costo) throws NombrePlataformaRepetidoException;
	
	public void reingresarNombre(String nombre);
	
	public void altaEspectaculo();

	

}
