package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;

public class PeliculaDAO implements IPeliculaDAO{

	private PersistenceManagerFactory pmf;


	public PeliculaDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storePelicula(Pelicula Pelicula) {
		this.storeObject(Pelicula);
	}
	
	public void storeObject(Pelicula Pelicula) {
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
	
	
	public List<Pelicula> getPeliculas() {
//		PersistenceManager pm = pmf.getPersistenceManager();
//		/* By default only 1 level is retrieved from the db
//		 * so if we wish to fetch more than one level, we must indicate it
//		 */
//		pm.getFetchPlan().setMaxFetchDepth(3);
//		
//		Transaction tx = pm.currentTransaction();
//		List<Pelicula> Peliculas = new ArrayList<Pelicula>();
//		
//		try {
//			System.out.println("   * Retrieving an Extent for Products.");
//			
//			tx.begin();			
//			Extent<Pelicula> extent = pm.getExtent(Pelicula.class, true);
//			
//			for (Pelicula Pelicula : extent) {
//				Peliculas.add(Pelicula);
//			}
//
//			tx.commit();			
//		} catch (Exception ex) {
//	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
//	    } finally {
//	    	if (tx != null && tx.isActive()) {
//	    		tx.rollback();
//	    	}
//
//    		pm.close();    		
//	    }
//	    				
//		return Peliculas;
		List<Pelicula> Peliculas = new ArrayList<Pelicula>();
		Pelicula e=new Pelicula(1,"C",30,"A",1997,"Ce",12,null);
		Peliculas.add(e);
		return Peliculas;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un Pelicula concreto
	 * @param condicion de la WHERE
	 * @return lista de Peliculas que cumpla la condicion
	 */
	public List<Pelicula> getPeliculassss(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<Pelicula> Peliculas = new ArrayList<Pelicula>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Products given a condition: " + condition);
	    	tx.begin();	    	
			Extent<Pelicula> extent = pm.getExtent(Pelicula.class, true);
			Query<Pelicula> query = pm.newQuery(extent, condition);
			for (Pelicula Pelicula : (List<Pelicula>)query.execute()) {
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

	@SuppressWarnings("unchecked")
	public List<Pelicula> getPeliculas(String nombre,String anyo,String genero){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Pelicula> Peliculas = new ArrayList<Pelicula>();
	    
		try {
			System.out.println ("   * Querying a Product: " + nombre+anyo+genero);
			
	    	tx.begin();
	    	Extent<Pelicula> extent = pm.getExtent(Pelicula.class, true);
	    	Query<Pelicula> query=null;
	    	if(anyo.equals("a") && genero.equals("a")) {query = pm.newQuery(extent,"SELECT FROM pelicula WHERE nombre LIKE '%" + nombre +"%'");}
	    	else if(anyo.equals("a")) {query = pm.newQuery(extent,"SELECT FROM pelicula WHERE nombre LIKE '%" + nombre + "%' AND categoria='"+genero+"'");}
	    	else if(genero.equals("a")) {query = pm.newQuery(extent,"SELECT FROM pelicula WHERE nombre LIKE '%" + nombre + "%' AND categoria='"+genero+"'");}
	    	
	    	else {    	
	    	query = pm.newQuery(extent,"SELECT FROM pelicula WHERE nombre LIKE '%" + nombre + "%' AND anyo ='" + anyo + "' AND categoria='"+genero+"'");
	    	}
	    	//query.setUnique(true);	    
			for (Pelicula Pelicula : (List<Pelicula>)query.execute()) {
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
	public Pelicula getPelicula(String name){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Pelicula Pelicula = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Pelicula.class.getName() + " WHERE nombre = '" + name + "'");
	    	query.setUnique(true);
	    	Pelicula = (Pelicula)query.execute();	    
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
	
	
	public void updatePelicula(Pelicula Pelicula) {
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

	@Override
	public List<Pelicula> getPeliculas(String condition) {
		// TODO Auto-generated method stub
		return null;
	}


}
