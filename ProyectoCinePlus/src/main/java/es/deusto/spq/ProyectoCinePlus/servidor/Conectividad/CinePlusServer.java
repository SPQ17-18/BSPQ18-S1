package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;

public class CinePlusServer extends UnicastRemoteObject implements ICinePlus{
	//Maantener esto para unir sesion de usuario/servidor para los metodos o(?)
	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;
	
	public CinePlusServer () throws RemoteException {
    	dao=new UsuarioDAO();
	}
	

	public synchronized int UsuarioRegistrado(String nombre, String contrasenya){
		
		//MIRA LAS FUNCIONES DE LA CLASE BASES DE DATOS PARA PONERLAS AHI, YA QUE EL FUNCIONAMIENTO ESTA EN ESA CLASE
		//SINO METE EL MISMO CODIGO EN ESTA CLASE Y ASI PODEMOS PRESCINDIR DE LA CLASE BASEDEDATOS
		
		
    	List<UsuarioDAO> users = dao.getClientes();
    	for(int i=0; i<users.size(); i++){
    		//if(users.get(i).getEmail().equals(email)){//Hay que cambiar el getEmail por el metodo de comprobacion que haya
    			System.out.println("Usuario existente y logueado");
    			return 0;
    		//}
    	}
		return 0;
	}
public synchronized void registrarUsuario(String nombre,String contrasenya,String correo){

	}


}