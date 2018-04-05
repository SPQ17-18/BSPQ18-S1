package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.util.ArrayList;
import java.util.List;


import es.deusto.spq.ProyectoCinePlus.servidor.DAO.ClienteDAO;

public class EasyBookingServer {

	private ClienteDAO dao;
	
	public EasyBookingServer() {
    	dao=new ClienteDAO();
	}
	

	public synchronized boolean login(String email){
    	List<ClienteDAO> users = dao.getClientes();
    	for(int i=0; i<users.size(); i++){
    		//if(users.get(i).getEmail().equals(email)){//Hay que cambiar el getEmail por el metodo de comprobacion que haya
    			System.out.println("Usuario existente y logueado");
    			return true;
    		//}
    	}
		return false;
	}

}