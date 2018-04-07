package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class PeliculaDAO {

	private PersistenceManagerFactory pmf;


	public PeliculaDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storePelicula(PeliculaDAO Pelicula) {
		this.storeObject(Pelicula);
	}
	
	private void storeObject(PeliculaDAO Pelicula) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + Pelicula);
	       pm.makePersistent(Pelicula);
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
	
	
	public List<PeliculaDAO> getPeliculas() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<PeliculaDAO> Peliculas = new ArrayList<PeliculaDAO>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<PeliculaDAO> extent = pm.getExtent(PeliculaDAO.class, true);
			
			for (PeliculaDAO Pelicula : extent) {
				Peliculas.add(Pelicula);
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
	    				
		return Peliculas;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un Pelicula concreto
	 * @param condicion de la WHERE
	 * @return lista de Peliculas que cumpla la condicion
	 */
	public List<PeliculaDAO> getPeliculas(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<PeliculaDAO> Peliculas = new ArrayList<PeliculaDAO>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Products given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<PeliculaDAO> extent = pm.getExtent(PeliculaDAO.class, true);
			Query<PeliculaDAO> query = pm.newQuery(extent, condition);

			for (PeliculaDAO Pelicula : (List<PeliculaDAO>)query.execute()) {
				Peliculas.add(Pelicula);
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
    
	    return Peliculas;
	}
	
	public PeliculaDAO getPelicula(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		PeliculaDAO Pelicula = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	///////////////////////////////////////////////////  Esta query creo ke esta mal
	    	Query<?> query = pm.newQuery("SELECT FROM " + PeliculaDAO.class.getName() + " WHERE email = '" + name + "'");
	    	query.setUnique(true);
	    	Pelicula = (PeliculaDAO)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Pelicula;
	}	
	
	
	public void updatePelicula(PeliculaDAO Pelicula) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(Pelicula);
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
