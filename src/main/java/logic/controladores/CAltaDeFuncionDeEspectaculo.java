package logic.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import exepciones.NombreFuncionRepetido;
import exepciones.SinEspectaculosException;
import exepciones.SinPlataformasException;
import interfaces.ICAltaDeFuncionDeEspectaculo;
import logic.clases.Artista;
import logic.clases.Espectaculo;
import logic.clases.Funcion;
import logic.clases.Plataforma;
import logic.clases.Usuario;
import logic.manejadores.ManejadorPlataforma;
import logic.manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class CAltaDeFuncionDeEspectaculo implements ICAltaDeFuncionDeEspectaculo{

	private String nomFuncion;
	private Date fechaAlta;
	private int horaInicio;
	private Date fecha;
	private ArrayList<String> artistas = new ArrayList<String>();
	private String nomEspectaculo;
	private String nomPlataforma;

	@Override
	public ArrayList<String> listarPlataformas() throws SinPlataformasException {
		ManejadorPlataforma mp = ManejadorPlataforma.getInstance();
		if(mp.listarNombresPlataformas().isEmpty())
				throw new SinPlataformasException("No hay Plataformas en el sistema");
		
		if(mp.sinPlataformas())
			throw new SinPlataformasException("Sin Plataformas");
		
		return mp.listarNombresPlataformas();
	}

	@Override
	public List<String> selectPlataforma(String nomPlataforma) throws SinEspectaculosException {
		Plataforma p = ManejadorPlataforma.getInstance().buscarPlataforma(nomPlataforma);
		
		this.nomPlataforma = nomPlataforma;
		if(p.listarEspectaculos().isEmpty())
			throw new SinEspectaculosException("Sin Espectaculos");
	
		return p.listarNombresEspectaculos();

	}

	@Override
	public void ingresarDatos(String nomEspectaculo, String nomFuncion, Date fecha, int horaInicio,
			Date fechaAlta) throws NombreFuncionRepetido {
		Plataforma p = ManejadorPlataforma.getInstance().buscarPlataforma(this.nomPlataforma);
		
		if(p.existeFuncion(nomEspectaculo ,nomFuncion)) {
			throw new NombreFuncionRepetido("Ya existe una funcion con el nombre" + nomFuncion + " en el sistema");
		}
		this.nomFuncion = nomFuncion;
		this.fecha = fecha;
		this.horaInicio = horaInicio; 
		this.fechaAlta = fechaAlta;
		this.nomEspectaculo = nomEspectaculo;
	}
	
	@Override
	public List<String> listarArtistas() {
		return ManejadorUsuario.getInstancia().listarNombresArtistasList();
	}
	
	@Override
	public void seleccionarArtista(String nickArtista) {
		this.artistas.add(nickArtista);
	}

	@Override
	public void modificarDatosIngresados(String nomFuncion) throws NombreFuncionRepetido {
		Plataforma p = ManejadorPlataforma.getInstance().buscarPlataforma(this.nomPlataforma);
				
		if(p.existeFuncion(nomEspectaculo ,nomFuncion)) {
			throw new NombreFuncionRepetido("Ya existe una funcion con el nombre" + nomFuncion + " en el sistema");
		}
		this.nomFuncion = nomFuncion;
	}

	@Override
	public void altaFuncion() {
		Funcion nuevaFuncion = new Funcion(this.nomFuncion, this.fecha, this.horaInicio, this.fechaAlta);
		Plataforma p = ManejadorPlataforma.getInstance().buscarPlataforma(this.nomPlataforma);
		Espectaculo e = p.buscarEspectaculo(this.nomEspectaculo);
		
		e.agregarFuncion(nuevaFuncion);
		
		for(String nomArtista: this.artistas) {
			nuevaFuncion.agregarArtista(nomArtista);
		}
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		em.getTransaction().begin();
		em.persist(nuevaFuncion); 
		em.getTransaction().commit();

		liberarMemoria();
	}
	
	private void liberarMemoria() {
		this.nomFuncion = null;
		this.fecha = null;
		this.fechaAlta = null; 
		this.nomEspectaculo = null;
		this.artistas.clear();
	}
	
	@Override
	public void cancelar() {
		liberarMemoria();
	}
}
