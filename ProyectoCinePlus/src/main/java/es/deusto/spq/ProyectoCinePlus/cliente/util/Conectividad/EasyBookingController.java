package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;


public class EasyBookingController {
	private RMIServiceLocator rmi;

	public EasyBookingController(RMIServiceLocator rmi) {
		this.rmi = rmi;
	}
	

	public boolean signIn(String email, String auzth_system, String airport) {
		boolean signed = false;
		try {
			signed = rmi.getEasyBookingtService().signIn(email, auzth_system, airport);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(signed);
		return signed;
	}


	public void addPassenger(String name, String surname, int age, int seats) {
		try {
			rmi.getEasyBookingtService().addPassenger(name, surname, age, seats);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
