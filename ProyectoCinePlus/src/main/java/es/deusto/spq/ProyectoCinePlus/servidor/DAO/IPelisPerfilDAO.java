package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;

public interface IPelisPerfilDAO {

	public boolean storePelisPerfil(PelisPerfil PelisPerfil);
	public List<PelisPerfil> getPeliUsuario(String email);
	public boolean checkPelis(PelisPerfil PelisPerfil);
	public void deletePelisPerfil(PelisPerfil pelisPerfil);
}
