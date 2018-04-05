package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class DireccionDAO {

	private int id_direccion;
	private String calle;
	private String ciudad;
	private String pais;
	private PersistenceManagerFactory pmf;
	
	public DireccionDAO(int id_direccion, String calle, String ciudad, String pais) {
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	public DireccionDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storeDireccion(DireccionDAO Direccion) {
		this.storeObject(Direccion);
	}
	
	private void storeObject(DireccionDAO Direccion) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + Direccion);
	       pm.makePersistent(Direccion);
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
	
	

	
	public List<DireccionDAO> getDirecciones() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<DireccionDAO> Direcciones = new ArrayList<DireccionDAO>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<DireccionDAO> extent = pm.getExtent(DireccionDAO.class, true);
			
			for (DireccionDAO Direccion : extent) {
				Direcciones.add(Direccion);
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
	    				
		return Direcciones;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un Direccion concreto
	 * @param condicion de la WHERE
	 * @return lista de Direcciones que cumpla la condicion
	 */
	public List<DireccionDAO> getDirecciones(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<DireccionDAO> Direcciones = new ArrayList<DireccionDAO>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Products given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<DireccionDAO> extent = pm.getExtent(DireccionDAO.class, true);
			Query<DireccionDAO> query = pm.newQuery(extent, condition);

			for (DireccionDAO Direccion : (List<DireccionDAO>)query.execute()) {
				Direcciones.add(Direccion);
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
    
	    return Direcciones;
	}
	
	public DireccionDAO getDireccion(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		DireccionDAO Direccion = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + DireccionDAO.class.getName() + " WHERE email == '" + name + "'");
	    	query.setUnique(true);
	    	Direccion = (DireccionDAO)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Direccion;
	}	
	
	
	public void updateDireccion(DireccionDAO Direccion) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(Direccion);
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
	
	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
