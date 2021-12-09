package logic.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logic.clases.Artista;
import logic.clases.Usuario;
import persistencia.Conexion;

public class ManejadorUsuario {
	
	private static ManejadorUsuario instancia = null;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if(instancia == null) {
			instancia = new ManejadorUsuario();
		}
		return instancia;
	}
	
	public void add(Usuario usu) {
		usuarios.add(usu);
		Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
			
		em.getTransaction().begin();			
		em.persist(usu);			
		em.getTransaction().commit();
	}
	
	public boolean buscarUsuarioNickname(String nickname) {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        
        Query query = em.createQuery("select u from usuario u where u.nickname = '" + nickname + "'");
        @SuppressWarnings("unchecked")
		List<Usuario> retorno = query.getResultList();
        
        if (retorno.isEmpty()) return false;
        
        return true;
	}
	
	public boolean buscarUsuarioEmail(String email) {
		Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        
        Query query = em.createQuery("select u from usuario u where u.correo = '" + email + "'");
        @SuppressWarnings("unchecked")
		List<Usuario> retorno = query.getResultList();
        
        if (retorno.isEmpty()) return false;
        
        return true;
	}
	
	public boolean esArtista(String nickUsuario) {
		Usuario usuario = this.buscarUsuario(nickUsuario);
		return (usuario != null) && (usuario instanceof Artista);
	}
	
	public Usuario buscarUsuario(String nickUsuario) {
        Usuario  retorno = null;
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        
        retorno = em.find(Usuario.class, nickUsuario);
        
        return retorno;
	}
	
	public ArrayList<String> listarNombresArtistas() {
		Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
	    
	    Query query = em.createQuery("from usuario where dtype = 'A'");
	    //Query query = em.createQuery("select a from usuario a  where a.dtype = 'A'");
	    
	    @SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
	    
	    ArrayList<String> retorna = new ArrayList<>();
	    
	    for (Usuario u: lista) {
	    	retorna.add(u.getNombre());
	    }
	    return retorna;
	}
	
	public List<String> listarNombresArtistasList() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("from usuario where dtype = 'A'");
		
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
		
		List<String> listaResultado = new ArrayList<>();
		
		for(Usuario u: lista) {
			listaResultado.add(u.getNickname());
		}
		
		return listaResultado;
	}
}
