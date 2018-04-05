package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class AlquilerDAO {
	private PersistenceManagerFactory pmf; // hace falta? por que se crea uno nuevo por cada metodo
	private int id_alquiler;
	private Date fecha_alquiler;
	private Date fecha_devolucion;
	private int cliente;
	private int inventario;
	
	public AlquilerDAO(int id_alquiler, Date fecha_alquiler, Date fecha_devolucion, int cliente, int inventario) {
		this.id_alquiler = id_alquiler;
		this.fecha_alquiler = fecha_alquiler;
		this.fecha_devolucion = fecha_devolucion;
		this.cliente = cliente;
		this.inventario = inventario;
	}

	
	public AlquilerDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storeAlquiler(AlquilerDAO Alquiler) {
		this.storeObject(Alquiler);
	}
	
	private void storeObject(AlquilerDAO Alquiler) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + Alquiler);
	       pm.makePersistent(Alquiler);
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
	
	

	
	public List<AlquilerDAO> getAlquileres() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<AlquilerDAO> Alquileres = new ArrayList<AlquilerDAO>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<AlquilerDAO> extent = pm.getExtent(AlquilerDAO.class, true);
			
			for (AlquilerDAO Alquiler : extent) {
				Alquileres.add(Alquiler);
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
	    				
		return Alquileres;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un alquiler concreto
	 * @param condicion de la WHERE
	 * @return lista de alquileres que cumpla la condicion
	 */
	public List<AlquilerDAO> getAlquileres(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<AlquilerDAO> Alquileres = new ArrayList<AlquilerDAO>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Products given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<AlquilerDAO> extent = pm.getExtent(AlquilerDAO.class, true);
			Query<AlquilerDAO> query = pm.newQuery(extent, condition);

			for (AlquilerDAO Alquiler : (List<AlquilerDAO>)query.execute()) {
				Alquileres.add(Alquiler);
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
    
	    return Alquileres;
	}
	
	public AlquilerDAO getAlquiler(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		AlquilerDAO Alquiler = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + AlquilerDAO.class.getName() + " WHERE email == '" + name + "'");
	    	query.setUnique(true);
	    	Alquiler = (AlquilerDAO)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Alquiler;
	}	
	
	
	public void updateAlquiler(AlquilerDAO Alquiler) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(Alquiler);
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
	public int getId_alquiler() {
		return id_alquiler;
	}

	public void setId_alquiler(int id_alquiler) {
		this.id_alquiler = id_alquiler;
	}

	public Date getFecha_alquiler() {
		return fecha_alquiler;
	}

	public void setFecha_alquiler(Date fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
	
	
}
