package logic.manejadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logic.clases.Espectaculo;
import logic.clases.Paquete;
import logic.clases.Plataforma;
import persistencia.Conexion;

public class ManejadorPaquete {
      
      private static ManejadorPaquete instance = null;

      private ManejadorPaquete(){}

      public static ManejadorPaquete getInstance() {
            if (instance == null) {
                  instance = new ManejadorPaquete();
            }

            return instance;
      }

      //private ArrayList<Paquete> paquetes; ya no seria necesario

      public void agregarPaquete(Paquete paquete) {
    	  Conexion conexion = Conexion.getInstancia();
	      EntityManager em = conexion.getEntityManager();
	   
			
		  em.getTransaction().begin();
			
		  em.persist(paquete);
			
		  em.getTransaction().commit();
      }

      public boolean eliminarPaquete(Paquete paquete) {
    	  Conexion conexion = Conexion.getInstancia();
	      EntityManager em = conexion.getEntityManager();
	      
	      Paquete p = this.buscarPaquete(paquete.getNombre());
	   
	      if (p == null) {
	    	  return false;
	      }
	    	  
	      em.getTransaction().begin();
	      em.remove(p);
	      em.getTransaction().commit();
	      return true;
      }

      public Paquete buscarPaquete(String nombre) {
            
    	  Paquete  retorno = null;
    	  Conexion conexion = Conexion.getInstancia();
    	  EntityManager em = conexion.getEntityManager();
    	  
    	  retorno = em.find(Paquete.class, nombre);
    	  
    	  return retorno;
      }

      public ArrayList<String> listarNombresPaquetes(){    	  
  		Conexion conexion = Conexion.getInstancia();
  	    EntityManager em = conexion.getEntityManager();
  	    
  	    Query query = em.createQuery("from paquete");
  	    
  	    @SuppressWarnings("unchecked")
  		List<Paquete> lista = query.getResultList();
  	    
  	    ArrayList<String> retorna = new ArrayList<>();
  	    
  	    for (Paquete p: lista) {
  	    	retorna.add(p.getNombre());
  	    }
  	    return retorna;
  	}
}
