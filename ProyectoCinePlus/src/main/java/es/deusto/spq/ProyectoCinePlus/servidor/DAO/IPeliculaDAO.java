package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;

public interface IPeliculaDAO {
	
	public void storePelicula(Pelicula Pelicula);
	public void storeObject(Pelicula Pelicula);
	public Pelicula getPelicula(String name);
	public void updatePelicula(Pelicula Pelicula);


}

