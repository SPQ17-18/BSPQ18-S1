package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEasyBooking extends Remote {
	public String makePayment(String cuenta) throws RemoteException;
	public boolean signIn(String email, String auzht_service, String airport) throws RemoteException;
	public boolean login(String email) throws RemoteException;
	public void addPassenger(String name, String surname, int age, int seats) throws RemoteException;
	
}
