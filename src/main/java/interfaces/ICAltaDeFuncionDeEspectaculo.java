package interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exepciones.NombreFuncionRepetido;
import exepciones.SinEspectaculosException;
import exepciones.SinPlataformasException;

public interface ICAltaDeFuncionDeEspectaculo {
	
	public ArrayList<String> listarPlataformas() throws SinPlataformasException; 
	
	//devuelve una lista de los espectaculos asociados a nomPlataforma
	public List<String> selectPlataforma(String nomPlataforma) throws SinEspectaculosException;
	
	public void ingresarDatos(String nomEspectaculo, String nomFuncion, Date fecha, int horaInicio, Date fechaAlta) throws NombreFuncionRepetido;

	public List<String> listarArtistas();

	//agregar a el nombre de un artista a una coleccion de nombres de artistas
	public void seleccionarArtista(String nickArtista);
	
	public void modificarDatosIngresados(String nomFuncion) throws NombreFuncionRepetido;
	
	public void altaFuncion();

	public void cancelar(); 
}
