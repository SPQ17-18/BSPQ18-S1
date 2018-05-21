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

/**
*
* @version 1.0.0
* @since May 17, 2018
* @author Fercol
* 
* Clase PeliculaDAO que implemneta la intefaz IPeliculaDAO para realizar las consultas a la base de datos
* de los objetos de Pelicula.
*
*/
public class PeliculaDAO implements IPeliculaDAO{

	private PersistenceManagerFactory pmf;
	static Logger logger = Logger.getLogger(PeliculaDAO.class.getName());

	/**
	 * Constructor de la clase PeliculaDAO.
	 */
	public PeliculaDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	/**
	 * Metodo que realiza una consulta a la base de datos para aniadir una pelicula y 
	 * devuelve un true si la pelicula se ha podido almacenar.
	 * 
	 * @param Pelicula - Pelicula
	 */
	public void storePelicula(Pelicula Pelicula) {
		this.storeObject(Pelicula);
	}
	
	/**
	 * Metodo que realiza una consulta a la base de datos para almacenar un objeto, 
	 * y devuelve un true si se ha podido almacenar. 
	 *  
	 * @param Pelicula - Pelicula
	 */
	private void storeObject(Pelicula Pelicula) {
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
	
	/**
	 * Metodo que realiza una consulta a la base de datos con los parametros nombre, anyo y genero
	 * para comprobar si existe una pelicula en la base de datos que cumple con estas condiciones.
	 * En caso de que exista, devolvera un true. 
	 * 
	 * @param nombre - String
	 * @param anyo - String
	 * @param genero - String
	 * @return <code>true</code> si exsite la pelicula que cumple con las condiciones.
	 */
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
	
	/**
	 * Metodo que realiza una consulta a la base de datos y devuelve una lista con los anyos de las pelicula de la base de datos en formato String.
	 * 
	 * @return lista de anios
	 */
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
	
	/**
	 * Metodo que realiza una consulta a la base de datos y devuelve una lista con los generos de las peliculas de la Base de datos en formato String.
	 * 
	 * @return lista de generos
	 */
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
	
	/**
	 * Metodo que realiza una consulta a la base de datos y actualiza una pelicula que se le pasa por parametro. 
	 * @param Pelicula - Pelicula
	 */
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
