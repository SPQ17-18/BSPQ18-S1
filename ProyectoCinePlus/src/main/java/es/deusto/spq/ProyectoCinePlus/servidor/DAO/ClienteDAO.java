	package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


//Tiene la funcion de DAO + JDO
public class ClienteDAO {
	private PersistenceManagerFactory pmf; 
	private int id_cliente;
	private String nombre;
	private String password;
	private String apellidos;
	private Date fecha_nacimiento;
	private String calle;
	private String ciudad;
	private String pais;
	
	public ClienteDAO(int id_cliente, String nombre,String password, String apellidos, Date fecha_nacimiento, String calle, String ciudad,
			String pais) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.password = password;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	
	
	
	public ClienteDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storeAlquiler(ClienteDAO cliente) {
		this.storeObject(cliente);
	}
	
	private void storeObject(ClienteDAO cliente) {
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
	
	

	
	public List<ClienteDAO> getClientes() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<ClienteDAO> Clientes = new ArrayList<ClienteDAO>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<ClienteDAO> extent = pm.getExtent(ClienteDAO.class, true);
			
			for (ClienteDAO Cliente : extent) {
				Clientes.add(Cliente);
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
	    				
		return Clientes;
	}

	
	@SuppressWarnings("unchecked")
	/**
	 * Para un alquiler concreto
	 * @param condicion de la WHERE
	 * @return lista de alquileres que cumpla la condicion
	 */
	public List<ClienteDAO> getClientes(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
	    Transaction tx = pm.currentTransaction();
	    List<ClienteDAO> Clientes = new ArrayList<ClienteDAO>();
	        
	    try {
	    	System.out.println("   * Ejecutando Query para Clientes bajo la condicion: " + condition);
	    	
	    	tx.begin();	    	
			Extent<ClienteDAO> extent = pm.getExtent(ClienteDAO.class, true);
			Query<ClienteDAO> query = pm.newQuery(extent, condition);

			for (ClienteDAO cliente : (List<ClienteDAO>)query.execute()) {
				Clientes.add(cliente);
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
    
	    return Clientes;
	}
	
	public ClienteDAO getCliente(String username){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		ClienteDAO cliente = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + username);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + ClienteDAO.class.getName() + " WHERE id_cliente == '" + username + "'");
	    	query.setUnique(true);
	    	cliente = (ClienteDAO)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return cliente;
	}	
	
	
	public void updateCliente(ClienteDAO cliente) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(cliente);
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
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getPassword() {
		return password;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
