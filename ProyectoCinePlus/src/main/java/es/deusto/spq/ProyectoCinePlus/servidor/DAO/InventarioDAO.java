package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class InventarioDAO {

	private int id_inventario;
	private int disponibles;
	private int pelicula;
	private PersistenceManagerFactory pmf;
	
	public InventarioDAO(int id_inventario, int disponibles, int pelicula) {
		this.id_inventario = id_inventario;
		this.disponibles = disponibles;
		this.pelicula = pelicula;
	}
	
	public InventarioDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storeInventario(InventarioDAO Inventario) {
		this.storeObject(Inventario);
	}
	
	private void storeObject(InventarioDAO Inventario) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + Inventario);
	       pm.makePersistent(Inventario);
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
	
	

	
	public List<InventarioDAO> getInventarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<InventarioDAO> Inventarios = new ArrayList<InventarioDAO>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<InventarioDAO> extent = pm.getExtent(InventarioDAO.class, true);
			
			for (InventarioDAO Inventario : extent) {
				Inventarios.add(Inventario);
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
	    				
		return Inventarios;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un Inventario concreto
	 * @param condicion de la WHERE
	 * @return lista de Inventarios que cumpla la condicion
	 */
	public List<InventarioDAO> getInventarios(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<InventarioDAO> Inventarios = new ArrayList<InventarioDAO>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Products given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<InventarioDAO> extent = pm.getExtent(InventarioDAO.class, true);
			Query<InventarioDAO> query = pm.newQuery(extent, condition);

			for (InventarioDAO Inventario : (List<InventarioDAO>)query.execute()) {
				Inventarios.add(Inventario);
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
    
	    return Inventarios;
	}
	
	public InventarioDAO getInventario(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		InventarioDAO Inventario = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + InventarioDAO.class.getName() + " WHERE email == '" + name + "'");
	    	query.setUnique(true);
	    	Inventario = (InventarioDAO)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Inventario;
	}	
	
	
	public void updateInventario(InventarioDAO Inventario) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(Inventario);
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
	
	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public int getPelicula() {
		return pelicula;
	}

	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
}
