package es.deusto.ingenieria.sd.easybooking.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.ingenieria.sd.easybooking.server.EasyBookingServer;
import es.deusto.ingenieria.sd.easybooking.server.data.Flight;
import es.deusto.ingenieria.sd.easybooking.server.data.dto.FlightAssembler;
import es.deusto.ingenieria.sd.easybooking.server.data.dto.FlightDTO;


public class EasyBookingFacade extends UnicastRemoteObject implements IEasyBooking{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasyBookingServer ebser;
	
	public EasyBookingFacade(EasyBookingServer ebser) throws RemoteException {
		super();
		this.ebser=ebser;
	}

	
//FIXME quitar de aqui tambien
	@Override
	public boolean login(String email) {
		return ebser.login(email);
	}

	@Override
	public boolean newReservation(FlightDTO flight, int seats) {
		FlightAssembler fa= new FlightAssembler();
		Flight f=fa.assemble(flight);
		return ebser.newReservation(f, seats);
	}

	@Override
	public void addPassenger(String name, String surname, int age, int seats) {
		ebser.addPassengers(name, surname, age, seats);
		
	}



	@Override
	public boolean signIn(String email, String auzht_service, String airport) {
		return ebser.signIn(email, auzht_service, airport);
	}
	
	@Override
	public String makePayment(String cuenta) {
		return ebser.makePayment(cuenta);
	}
	
}
