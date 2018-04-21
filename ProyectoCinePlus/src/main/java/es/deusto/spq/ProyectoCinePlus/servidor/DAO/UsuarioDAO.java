package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;



public class UsuarioDAO implements IUsuarioDAO{
	private PersistenceManagerFactory pmf; 
	private String username;
	private String usermail;
	
	public UsuarioDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	public boolean storeUsuario(Usuario usuario) {
		boolean resul = false;
		if (!this.checkUser(usuario)) {
			resul = this.storeObject(usuario);
		} else {
			System.out.println("The user mail " + usuario.getEmail() + " already exists");
		}
		System.out.println("usuario almacenado: "+usuario.toString());
		return resul;
	}
	
	public boolean storeObject(Usuario usuario) {
		boolean resul =false;
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + usuario);
	       pm.makePersistent(usuario);
	       tx.commit();
	       resul =true;
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}		
    		pm.close();
	    }
	    return resul;
	}
	
	
	public List<Usuario> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		
		try {
			System.out.println("   * Sacando un Extent para Usuarios.");
			
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			
			for (Usuario Usuario : extent) {
				Usuarios.add(Usuario);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
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
	 * Para un alquiler concreto
	 * @param condicion de la WHERE
	 * @return lista de alquileres que cumpla la condicion
	 */
	public List<Usuario> getUsuarios(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<Usuario> Usuarios = new ArrayList<Usuario>();
	        
	    try {
	    	System.out.println("   * Ejecutando Query para Usuarios bajo la condicion: " + condition);
	    	
	    	tx.begin();	    	
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			Query<Usuario> query = pm.newQuery(extent, condition);

			for (Usuario usuario : (List<Usuario>)query.execute()) {
				Usuarios.add(usuario);
			}
			
	        tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
			
    		pm.close();
	    }
    
	    return Usuarios;
	}
	
	public Usuario getUsuario(String username){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + username);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE usuario = '" + username + "'");
	    	query.setUnique(true);
	    	usuario = (Usuario)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return usuario;
	}	
	
	
	public void updateUsuario(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(usuario);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}


	public boolean loginUser(String email, String password) {
		// TODO Auto-generated method stub
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
			System.out.println("   $ Error login for user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return resul;
	}


	public boolean checkUser(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean resul = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Checking if " + usuario + " exists in the database");
			Extent<Usuario> ex = pm.getExtent(Usuario.class, true);
			for (Usuario u : ex) {
				if (u.getEmail().equals(usuario.getEmail())) {
					resul = true;
				}
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error during the checking of user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return resul;
	}


	public List<UsuarioDAO> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
