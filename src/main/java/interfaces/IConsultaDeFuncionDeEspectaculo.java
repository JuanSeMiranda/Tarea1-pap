package interfaces;


import java.util.ArrayList;

import datatypes.DtFuncion;
import exepciones.SinPlataformasException;

public interface IConsultaDeFuncionDeEspectaculo {


	public String[] listarPlataformas() throws SinPlataformasException;
	//devuelve una lista con los nombres de los espectaculos asociados a la plataforma de nombre "nomPlataforma"
	public String[] selectPlataforma(String nomPlataforma);
	//devuelve una lista con los nombres de las funciones asociadas a el espectaculo "nomEspectaculo"
	public String[] selectEspectaculo(String nomEspectaculo);
	
	public DtFuncion selectFuncion(String nomFuncion);
}
