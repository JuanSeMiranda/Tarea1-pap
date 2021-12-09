package logic.controladores;

import java.util.Date;

import javax.persistence.EntityManager;

import exepciones.UsuarioRepetidoException;
import interfaces.ICAltaUsuario;
import logic.clases.Artista;
import logic.clases.Espectador;
import logic.manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class CAltaUsuario implements ICAltaUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNac;
	private String descripcion;
	private String url;
	private String biografia;
	
	public void ingresarDatos(String nickname, String correo, String nombre, String apellido, Date fechaNac) throws UsuarioRepetidoException{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		
		if(mU.buscarUsuarioNickname(nickname)) {
			throw new UsuarioRepetidoException("Ya hay un usuario con Nickname '" + nickname + "' en el sistema");
		}
		this.nickname = nickname;
		
		if(mU.buscarUsuarioEmail(correo)) {
			throw new UsuarioRepetidoException("Ya hay un usuario con Email '" + correo + "' en el sistema");
		}
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	
	public void ingresarDatosArtista(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void linkPagina(String url) {
		this.url = url;
	}
	
	public void ingresarBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public void modificarMail(String email){
		this.correo = email;
	}
	
	public void modificarNickname(String nickname){
		this.nickname = nickname;
	}
	
	public void altaUsuario() {
		if(this.descripcion == null || this.descripcion.isBlank()) {
			Espectador esp = new Espectador(nickname, correo, nombre, apellido, fechaNac);
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			mU.add(esp);/*
			Conexion conexion = Conexion.getInstancia();
		    EntityManager em = conexion.getEntityManager();
				
			em.getTransaction().begin();
				
			em.persist(esp);
				
			em.getTransaction().commit();*/
		}else {
			Artista art = new Artista(nickname, correo, nombre, apellido, fechaNac, descripcion, url, biografia);
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			mU.add(art);/*
			Conexion conexion = Conexion.getInstancia();
		    EntityManager em = conexion.getEntityManager();
				
			em.getTransaction().begin();
				
			em.persist(art);
				
			em.getTransaction().commit();*/
		}
		borrarDatosGuardados();
	}
	
	private void borrarDatosGuardados() {
		this.nombre = null; 
		this.apellido = null; 
		this.nickname = null;
		this.url = null;
		this.biografia = null;
		this.descripcion = null;
		this.fechaNac = null;
		this.correo = null;
	}
}
