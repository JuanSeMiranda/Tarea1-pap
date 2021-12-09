package interfaces;

import java.util.Date;

import exepciones.UsuarioRepetidoException;

public interface ICAltaUsuario {
	
	public void ingresarDatos(String nickname, String correo, String nombre, String apellido, Date fechaNac) throws UsuarioRepetidoException;
	
	public void ingresarDatosArtista(String descripcion);
	
	public void linkPagina(String url);
	
	public void ingresarBiografia(String biografia);
	
	public void modificarMail(String email);
	
	public void modificarNickname(String nickname);
	
	public void altaUsuario();
}
