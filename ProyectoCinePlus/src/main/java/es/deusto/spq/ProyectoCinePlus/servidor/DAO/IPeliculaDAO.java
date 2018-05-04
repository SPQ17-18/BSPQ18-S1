package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;

public interface IPeliculaDAO {
	
	public void storePelicula(Pelicula Pelicula);
	public void storeObject(Pelicula Pelicula);
	public List<Pelicula> getPeliculas(String nombre,String anyo,String genero);

}

