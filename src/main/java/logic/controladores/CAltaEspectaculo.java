package logic.controladores;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import exepciones.NombrePlataformaRepetidoException;
import exepciones.SinPlataformasException;
import interfaces.ICAltaEspectaculo;
import logic.clases.Espectaculo;
import logic.clases.Plataforma;
import logic.manejadores.ManejadorPlataforma;
import persistencia.Conexion;

public class CAltaEspectaculo implements ICAltaEspectaculo{
	
	private String nombre;
	private String descripcion;
	private int duracion;
	private int minEspec;
	private int maxEspec;
	private String url;
	private float costo;
	private String nomPlataforma; 
	
	@Override
	public String[] listarPlataformas() throws SinPlataformasException {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstance();
		ArrayList<String> plataformas = mP.listarNombresPlataformas();
		if(plataformas.isEmpty())
			throw new SinPlataformasException("No existen Plataformas creadas.");
		
		String[] plat_ret = new String[plataformas.size()];
        int i=0;
        for(String p:plataformas) {
        	plat_ret[i]=p;
        	i++;
        }
        return plat_ret;
	}
	
	@Override
	public void selectPlataforma(String plataforma) {
		this.nomPlataforma = plataforma;
	}

	@Override
	public void ingresarDatos(String nombre, String descripcion, int duracion, 
			                  int minEspec, int maxEspec, String url, float costo) throws NombrePlataformaRepetidoException{
		ManejadorPlataforma mP = ManejadorPlataforma.getInstance();
		Plataforma p = mP.buscarPlataforma(this.nomPlataforma);
		Espectaculo e = p.buscarEspectaculo(nombre);
		if (e != null)
			throw new NombrePlataformaRepetidoException("Ya existe un Espectaculo \'"+ nombre +"\' registrado");
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.minEspec = minEspec;
		this.maxEspec = maxEspec;
		this.url = url;
		this.costo = costo;
	}

	@Override
	public void reingresarNombre(String nombre) {
		this.nombre = nombre;
		
	}

	@Override
	public void altaEspectaculo() {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstance();
		Date fecha = new Date();
		Espectaculo e = new Espectaculo(nombre, descripcion, duracion, minEspec, maxEspec, url, costo, fecha);
		
		Plataforma p = mP.buscarPlataforma(this.nomPlataforma);
		p.agregarEspectaculo(e);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		em.getTransaction().begin();
		em.persist(e); 
		em.getTransaction().commit();
	}
}
