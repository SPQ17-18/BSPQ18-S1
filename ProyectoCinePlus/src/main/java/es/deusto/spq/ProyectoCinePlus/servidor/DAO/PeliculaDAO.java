package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;

public class PeliculaDAO implements IPeliculaDAO{

	private PersistenceManagerFactory pmf;
	static Logger logger = Logger.getLogger(PeliculaDAO.class.getName());

	public PeliculaDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storePelicula(Pelicula Pelicula) {
		this.storeObject(Pelicula);
	}
	
	public void storeObject(Pelicula Pelicula) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       logger.info("   * Storing an object: " + Pelicula);
	       
	       pm.makePersistent(Pelicula);
	       tx.commit();
	       logger.info("   * Pelicula: " + Pelicula.getNombre() + " insertada con exito");
	    } catch (Exception ex) {
	    	logger.info("La pelicula " + Pelicula.getNombre()+ " ya existe");
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}
	
//FIXME este es el metodo que he intentado pero da error
	@SuppressWarnings("unchecked")
	public List<String> getPeliUsuario(String email){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		List<String> Peliculas = new ArrayList<String>();
	    
		try {
			logger.info ("   * Querying a Product: " + email);
	    	tx.begin();
	    	Query<String> query=null;
    		query = pm.newQuery("SELECT FROM usuario_peliculaslist");// WHERE email == '" + email + "'");
	    	Peliculas= (List<String>)query.execute();
	        tx.commit();        
	     } catch (Exception ex) {
	    	 logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Peliculas;
	}	
//FIXME
	@SuppressWarnings("unchecked")
	public List<Pelicula> getPeliculas(String nombre,String anyo,String genero){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		List<Pelicula> Peliculas = new ArrayList<Pelicula>();
	    
		try {
			logger.info ("   * Querying a Product: " + nombre+anyo+genero);
	    	tx.begin();
	    	Query<Pelicula> query=null;
    		query = pm.newQuery("SELECT FROM " + Pelicula.class.getName());//}
	    	Peliculas= (List<Pelicula>)query.execute();
	        tx.commit();
   	    
	     } catch (Exception ex) {
	    	 logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Peliculas;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<String> Anyos(){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		List<String> Anyos = new ArrayList<String>();
	    
		try {
	    	tx.begin();
	    	Query<String> query=null;
	    	query = pm.newQuery("SELECT DISTINCT anyo FROM " + Pelicula.class.getName());
	    	Anyos= (List<String>)query.execute();
	    	tx.commit();
   	    
	     } catch (Exception ex) {
	    	 logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Anyos;
	}	
	
	@SuppressWarnings("unchecked")
	public List<String> Generos(){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		List<String> Generos = new ArrayList<String>();
	    
		try {
	    	tx.begin();
	    	Query<String> query=null;
	    	query = pm.newQuery("SELECT DISTINCT categoria FROM " + Pelicula.class.getName());
	    	Generos= (List<String>)query.execute();
	    	tx.commit();
   	    
	     } catch (Exception ex) {
	    	logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Generos;
	}	
	
	
	
	
	public void updatePelicula(Pelicula Pelicula) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(Pelicula);
	    	tx.commit();
	     } catch (Exception ex) {
	    	 logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}



}
