package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;



public class CategoriaDAO {

	private PersistenceManagerFactory pmf; // Es necesario? No sigo por si acaso LOL
	private int id_categoria;
	private String nombre;
	
	public CategoriaDAO(int id_categoria, String nombre) {
		
		this.id_categoria = id_categoria;
		this.nombre = nombre;
	}
	
	public CategoriaDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storeCategoria(CategoriaDAO Categoria) {
		this.storeObject(Categoria);
	}
	
	private void storeObject(CategoriaDAO Categoria) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + Categoria);
	       pm.makePersistent(Categoria);
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
	
	

	
	public List<CategoriaDAO> getCategoriaes() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<CategoriaDAO> Categoriaes = new ArrayList<CategoriaDAO>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<CategoriaDAO> extent = pm.getExtent(CategoriaDAO.class, true);
			
			for (CategoriaDAO Categoria : extent) {
				Categoriaes.add(Categoria);
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
	    				
		return Categoriaes;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un Categoria concreto
	 * @param condicion de la WHERE
	 * @return lista de Categoriaes que cumpla la condicion
	 */
	public List<CategoriaDAO> getCategorias(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<CategoriaDAO> Categoriaes = new ArrayList<CategoriaDAO>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Products given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<CategoriaDAO> extent = pm.getExtent(CategoriaDAO.class, true);
			Query<CategoriaDAO> query = pm.newQuery(extent, condition);

			for (CategoriaDAO Categoria : (List<CategoriaDAO>)query.execute()) {
				Categoriaes.add(Categoria);
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
    
	    return Categoriaes;
	}
	
	public CategoriaDAO getCategoria(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		CategoriaDAO Categoria = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + CategoriaDAO.class.getName() + " WHERE email == '" + name + "'");
	    	query.setUnique(true);
	    	Categoria = (CategoriaDAO)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Categoria;
	}	
	
	
	public void updateCategoria(CategoriaDAO Categoria) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(Categoria);
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

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
