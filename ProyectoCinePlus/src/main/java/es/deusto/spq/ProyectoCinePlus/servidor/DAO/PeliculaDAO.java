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
	private int id_pelicula;
	private String nombre;
	private int duracion;
	private String descripcion;
	private int anyo;
	private String categoria;
	private int disponibles;
	private float precio;
	private PersistenceManagerFactory pmf;
	
	public PeliculaDAO(int id_pelicula, String nombre, int duracion, String descripcion, int anyo, String categoria,
		int disponibles, float precio) {
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.anyo = anyo;
		this.categoria = categoria;
		this.disponibles = disponibles;
		this.precio = precio;
	}

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
	    	Query<?> query = pm.newQuery("SELECT FROM " + PeliculaDAO.class.getName() + " WHERE email == '" + name + "'");
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
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

}
