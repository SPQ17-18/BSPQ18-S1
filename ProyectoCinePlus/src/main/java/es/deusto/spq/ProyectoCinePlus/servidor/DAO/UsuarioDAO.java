package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;



public class UsuarioDAO {
	private PersistenceManagerFactory pmf; 

	
	public UsuarioDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	public void storeUsuario(UsuarioDAO cliente) {
		this.storeObject(cliente);
	}
	
	private void storeObject(UsuarioDAO cliente) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + cliente);
	       pm.makePersistent(cliente);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}		
    		pm.close();
	    }
	}
	
	
	public List<UsuarioDAO> getUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<UsuarioDAO> Usuarios = new ArrayList<UsuarioDAO>();
		
		try {
			System.out.println("   * Sacando un Extent para Usuarios.");
			
			tx.begin();			
			Extent<UsuarioDAO> extent = pm.getExtent(UsuarioDAO.class, true);
			
			for (UsuarioDAO Usuario : extent) {
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
	public List<UsuarioDAO> getUsuarios(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<UsuarioDAO> Usuarios = new ArrayList<UsuarioDAO>();
	        
	    try {
	    	System.out.println("   * Ejecutando Query para Usuarios bajo la condicion: " + condition);
	    	
	    	tx.begin();	    	
			Extent<UsuarioDAO> extent = pm.getExtent(UsuarioDAO.class, true);
			Query<UsuarioDAO> query = pm.newQuery(extent, condition);

			for (UsuarioDAO usuario : (List<UsuarioDAO>)query.execute()) {
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
	
	public UsuarioDAO getUsuario(String username){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		UsuarioDAO usuario = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + username);
			
	    	tx.begin();
	    	////////////////////////////////////////// NO se si falla --> EL username no es un id
	    	Query<?> query = pm.newQuery("SELECT FROM " + UsuarioDAO.class.getName() + " WHERE usuario = '" + username + "'");
	    	query.setUnique(true);
	    	usuario = (UsuarioDAO)query.execute();	    
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
	
	
	public void updateUsuario(UsuarioDAO usuario) {
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
	

	
}
