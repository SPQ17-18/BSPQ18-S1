package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;

public class PelisPerfilDAO {
	private PersistenceManagerFactory pmf;
	static Logger logger = Logger.getLogger(PeliculaDAO.class.getName());

	public PelisPerfilDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	public boolean storePelisPerfil(PelisPerfil PelisPerfil) {

		if (!this.checkPelis(PelisPerfil)) {
			this.storeObject(PelisPerfil);
			logger.info("usuario almacenado: "+PelisPerfil.toString());
			return true;
		} else {
			
			logger.info("The user mail " + PelisPerfil.getEmail() + "and the respective film already exists");
			return false;
		}
	}
	
	
	
	
	
	public void storeObject(PelisPerfil PelisPerfil) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
	       logger.info("   * Storing an object: " + PelisPerfil);
	       
	       pm.makePersistent(PelisPerfil);
	       tx.commit();
	       logger.info("   * Pelicula a email: " + PelisPerfil.getEmail() + " insertada con exito");
	    } catch (Exception ex) {
	    	logger.info("La pelicula " + PelisPerfil.getId_pelicula()+ " ya existe");
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }

	}
	
	@SuppressWarnings("unchecked")
	public List<PelisPerfil> getPeliUsuario(String email){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		List<PelisPerfil> Peliculas = new ArrayList<PelisPerfil>();
	    
		try {
			logger.info ("   * Querying a Product: " + email);
	    	tx.begin();
	    	Query<Integer> query=null;
    		query = pm.newQuery("SELECT FROM "+PelisPerfil.class.getName());
	    	Peliculas= (List<PelisPerfil>)query.execute();
	        tx.commit();        
	     } catch (Exception ex) {
	    	 logger.error("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return Peliculas;
	}	
	
	
	public boolean checkPelis(PelisPerfil PelisPerfil) {
		boolean resul = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Checking if " + PelisPerfil + " exists in the database");
			Extent<PelisPerfil> ex = pm.getExtent(PelisPerfil.class, true);
			for (PelisPerfil u : ex) {
				if (u.getEmail().equals(PelisPerfil.getEmail()) && u.getId_pelicula()==PelisPerfil.getId_pelicula()) {
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
	
	
	
}
