package logic.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import exepciones.SinPlataformasException;
import logic.clases.Plataforma;
import persistencia.Conexion;

public class ManejadorPlataforma {
	
	private ArrayList<Plataforma> plataformas = new ArrayList<Plataforma>();
	private static ManejadorPlataforma instance = null;
	private ManejadorPlataforma(){}
	
	public static ManejadorPlataforma getInstance() {
	    if (instance == null) {
	          instance = new ManejadorPlataforma();
	    }
	    return instance;
	}
	
	public void agregaraPlataforma(Plataforma plataforma) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(plataforma);
		em.getTransaction().commit();
	}	

	public Plataforma buscarPlataforma(String nombre) {
		Plataforma  retorno = null;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		retorno = em.find(Plataforma.class, nombre);
		return retorno;
	}
	  
	/*public ArrayList<String> listarPlataformas(){    	  
		ArrayList<String>  retorno= new ArrayList<>();
		for(Plataforma p: plataformas) {
			retorno.add(p.getNombre());
		}
		return retorno;
	}*/	


	public boolean eliminarPlataforma(Plataforma plataforma) {		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();	      
		Plataforma p = this.buscarPlataforma(plataforma.getNombre());

		if (p == null) {
			return false;
		}	    	  
		em.getTransaction().begin();
		em.remove(plataforma);
		em.getTransaction().commit();
		return true;
	}
		  
	public ArrayList<Plataforma> listaDePlataformas(){    	  
		Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
	    
	    Query query = em.createQuery("from plataforma");
	    
	    @SuppressWarnings("unchecked")
		List<Plataforma> lista = query.getResultList();
	    
	    ArrayList<Plataforma> retorna = new ArrayList<>();
	    
	    for (Plataforma p: lista) {
	    	retorna.add(p);
	    }
	    return retorna;
	}
	
	public ArrayList<String> listarNombresPlataformas() {    	  
		List<Plataforma> lista = this.listaDePlataformas();
	    ArrayList<String> retorna = new ArrayList<>();
	    
	    for (Plataforma p: lista) {
	    	retorna.add(p.getNombre());
	    }
	    return retorna;
	}
	
	 public boolean sinPlataformas() {
		 Conexion conexion = Conexion.getInstancia();
		 EntityManager em = conexion.getEntityManager();

		 Query query = em.createQuery("from plataforma");

		 @SuppressWarnings("unchecked")
		 List<Plataforma> lista = query.getResultList();
		 
		 return lista.isEmpty();
	 }
}
