/** @package  es.deusto.spq.ProyectoCinePlus.servidor.DAO
*   @brief DAO de las PelisPerfil. May 17, 2018
*
*   Se trata del DAO que almacena las peliculas de cada usuario en la BD.
*   Este sera el tercer nivel del servidor
*   
*/

package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
 * 
 * @author Fercol
 * @package es.deusto.spq.ProyectoCinePlus.servidor.DAO
 * @version 3.0.1
 * @since May 17, 2018
 * 
 * Clase PelisPerfilDAO que realiza las consultas a la base de datos
 * de los objetos de PelisPerfil.
 *
 */
public class PelisPerfilDAO {
	private PersistenceManagerFactory pmf;
	static Logger logger = Logger.getLogger(PeliculaDAO.class.getName());

	/**
	 * Constructor de la clase PelisPerfilDAO
	 */
	public PelisPerfilDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	/**
	 * Metodo que comprueba si existe un objeto PelisPerfil en la base de datos y en caso 
	 * de no existir lo almacena devolviendo un true. 
	 * 
	 * @param PelisPerfil - PelisPerfil
	 * @return <code>true</code> si almacena correctamente el objeto PelisPerfil
	 */
	public boolean storePelisPerfil(PelisPerfil PelisPerfil) {

		if (!this.checkPelis(PelisPerfil)) {
			this.storeObject(PelisPerfil);
			logger.info("usuario almacenado: "+PelisPerfil.toString());
			return true;
		} else {
			
			logger.info("The user mail " + PelisPerfil.getEmail() + "and the respective film already exists");
			return false;
		}
	}
	
	
	
	
	/**
	 * Metodo que inserta en la base de datos un objeto PelisPerfil.
	 * 
	 * @param PelisPerfil - PelisPerfil
	 */
	private void storeObject(PelisPerfil PelisPerfil) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
	       logger.info("   * Storing an object: " + PelisPerfil);
	       
	       pm.makePersistent(PelisPerfil);
	       tx.commit();
	       logger.info("   * Pelicula a email: " + PelisPerfil.getEmail() + " insertada con exito");
	    } catch (Exception ex) {
	    	logger.info("La pelicula " + PelisPerfil.getId_pelicula()+ " ya existe");
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }

	}
	
	/**
	 * Metodo que consulta a la base de datos por un email, y te devuelve una lista con las peliculas con ese email.
	 * 
	 * @param email - String
	 * @return Peliculas - List<PelisPerfil>
	 */
	@SuppressWarnings("unchecked")
	public List<PelisPerfil> getPeliUsuario(String email){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		List<PelisPerfil> Peliculas = new ArrayList<PelisPerfil>();
	    
		try {
			logger.info ("   * Querying a Product: " + email);
	    	tx.begin();
	    	Query<Integer> query=null;
    		query = pm.newQuery("SELECT FROM "+PelisPerfil.class.getName());
	    	Peliculas= (List<PelisPerfil>)query.execute();
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
	 * Metodo que comprueba en la base de datos si existe un PelisPerfil igual al que se le pasa.
	 * 
	 * @param PelisPerfil  PelisPerfil
	 * @return <code>true</code> si encuentra un objeto PelisPerfil identico
	 */
	public boolean checkPelis(PelisPerfil PelisPerfil) {
		boolean resul = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Checking if " + PelisPerfil + " exists in the database");
			Extent<PelisPerfil> ex = pm.getExtent(PelisPerfil.class, true);
			for (PelisPerfil u : ex) {
				if (u.getEmail().equals(PelisPerfil.getEmail()) && u.getId_pelicula()==PelisPerfil.getId_pelicula()) {
					resul = true;
				}
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error during the checking of user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			
			}

			pm.close();
		}
		return resul;
	}
	
	
	/**
	 * Metodo que se encarga de eliminar una pelicula del perfil de un usuario
	 * 
	 * @param pelisPerfil PelisPerfil
	 */
	
	public void deletePelisPerfil(PelisPerfil pelisPerfil) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<PelisPerfil> query = pm.newQuery(PelisPerfil.class, "email =='" + pelisPerfil.getEmail() + "'");
			Collection<?> result = (Collection<?>) query.execute();
			PelisPerfil pelisP = (PelisPerfil) result.iterator().next();
			query.close(result);
			pm.deletePersistent(pelisP);
			tx.commit();
		} catch (Exception ex) {
			logger.error( "Error cleaning a film: " + ex.getMessage());
		
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	

}
