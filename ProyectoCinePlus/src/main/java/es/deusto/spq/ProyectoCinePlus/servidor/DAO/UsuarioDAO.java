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

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
*
* @version 1.0.0
* @since May 17, 2018
* @author Fercol
* 
* Clase UsuarioDAO que implemneta la intefaz IUsuarioDAO para realizar las consultas a la base de datos
* de los objetos de Usuario.
*
*/
public class UsuarioDAO implements IUsuarioDAO{
	
	private PersistenceManagerFactory pmf; 
	private String username;
	private String usermail;
	
	static Logger logger = Logger.getLogger(UsuarioDAO.class.getName());
	
	/**
	 * Constructor de la clase UsuarioDAO
	 */
	public UsuarioDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	/**
	 * Metodo que realiza una consulta a la base de datos para aniadir un usuario y 
	 * devuelve un true si el usuario se ha podido almacenar.
	 * 
	 * @param usuario - String
	 * @return true si se ha anyadido el usuario correctamente
	 */
	public boolean storeUsuario(Usuario usuario) {
		boolean resul = false;
		if (!this.checkUser(usuario)) {
			resul = this.storeObject(usuario);
			logger.info("usuario almacenado: "+usuario.toString());
		} else {
			logger.info("The user mail " + usuario.getEmail() + " already exists");
		}
		
		return resul;
	}
	
	/**
	 * Metodo que realiza una consulta a la base de datos para almacenar un objeto, 
	 * y devuelve un true si se ha podido almacenar. 
	 * 
	 * @param usuario - STring
	 * @return true si se ha anyadido el usuario correctamente
	 */
	private boolean storeObject(Usuario usuario) {
		boolean resul =false;
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       logger.info("   * Storing an object: " + usuario);
	       pm.makePersistent(usuario);
	       tx.commit();
	       resul =true;
	    } catch (Exception ex) {
	    	logger.error("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}		
    		pm.close();
	    }
	    return resul;
	}
	

	/**
	 * Metodo que realiza una consulta a la base de datos y obtiene todos los usuarios de la base de 
	 * datos devolvindolos en una lista. 
	 * @return Lista con usuarios que cumplen la condicion.
	 */
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		
		try {
			logger.info("   * Sacando un Extent para Usuarios.");
			
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			
			for (Usuario Usuario : extent) {
				Usuarios.add(Usuario);
			}

			tx.commit();			
		} catch (Exception ex) {
			logger.error("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    			
		return Usuarios;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Metodo que realiza una consulta a la base de datos y obtiene el objeto usuario que coincida con el 
	 * email que se le pasa. 
	 * 
	 * @param condition - String
	 * @return Usuario 
	 */
	public List<Usuario> getUsuarios(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<Usuario> Usuarios = new ArrayList<Usuario>();
	        
	    try {
	    	logger.info("   * Ejecutando Query para Usuarios bajo la condicion: " + condition);
	    	
	    	tx.begin();	    	
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			Query<Usuario> query = pm.newQuery(extent, condition);

			for (Usuario usuario : (List<Usuario>)query.execute()) {
				Usuarios.add(usuario);
			}
			
	        tx.commit();
	    } catch (Exception ex) {
	    	logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
			
    		pm.close();
	    }
    
	    return Usuarios;
	}
	

	/**
	 * Metodo que realiza una cnsulta a la base de datos y devuelve una lista con los usuarios en una lista.
	 * 
	 * @param email - Parametro por el que buscar.
	 */
	public Usuario getUsuario(String email){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usuario = new Usuario();

		try {
			logger.info("   * Querying a Product: " + email);
			
			tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + email + "'");
	    	query.setUnique(true);
	    	Usuario result = (Usuario)query.execute();
	    	usuario.copiarUsuario(result);
	    	
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
	    	 logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }
		
		logger.info("QUERY getUsuario: "+usuario);
		
	    return usuario;
	}	
	
	/**
	 * Metodo que recbe un usuario y lo actualiza en la base de datos. 
	 * 
	 * @param usuario - Usuario
	 */
	public void updateUsuario(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(usuario);
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

	/**
	 * Metodo que realiza una consulta a la base de datos con los parametros email y contrasenya
	 * para comprobar si existe un usuario en la base de datos que cumple con estas condiciones.
	 * En caso de que exista, devolvera un true. 
	 * 
	 * @param email - String
	 * @param password - String
	 * @return true si el usuario y la contrasenya coinciden con las de la Base de datos
	 */
	public boolean loginUser(String email, String password) {
		boolean resul = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Extent<Usuario> ex = pm.getExtent(Usuario.class, true);
			for (Usuario u : ex) {
				if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
					resul = true;
					this.username = u.getNombre();
					this.usermail = u.getEmail();
				}
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error login for user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resul;
	}

	/**
	 * Metodo que recbe un usuario y lo checkea que exista 
	 * @param usuario - usuario
	 * @return true si existe
	 */
	public boolean checkUser(Usuario usuario) {
		boolean resul = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Checking if " + usuario + " exists in the database");
			Extent<Usuario> ex = pm.getExtent(Usuario.class, true);
			for (Usuario u : ex) {
				if (u.getEmail().equals(usuario.getEmail())) {
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
	 * Metodo que realiza una consulta a la base de datos y obtiene todos los usuarios de la base de 
	 * datos devolvindolos en una lista. 
	 * 
	 * @return Lista con usuarios que cumplen la condicion.
	 */
	public List<UsuarioDAO> getClientes() {
		return null;
	}
	
	/**
	 * Metodo que recibe un objeto usuario y lo elimina de la base de datos. 
	 * 
	 * @param usuario Usuario
	 */
	public void deleteUsuario(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<Usuario> query = pm.newQuery(Usuario.class, "email =='" + usuario.getEmail() + "'");
			Collection<?> result = (Collection<?>) query.execute();
			Usuario user = (Usuario) result.iterator().next();
			query.close(result);
			pm.deletePersistent(user);
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
