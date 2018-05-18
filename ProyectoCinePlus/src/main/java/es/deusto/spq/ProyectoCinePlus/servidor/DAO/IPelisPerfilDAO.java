/** @package  es.deusto.spq.ProyectoCinePlus.servidor.DAO
*   @brief Interfaz de PeliculasDAO. May 17, 2018
*
*   Se trata de la interfaz que ofrece los servicios de DAO de las peliculas de perfil
*   
*/

package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;

public interface IPelisPerfilDAO {

	public boolean storePelisPerfil(PelisPerfil PelisPerfil);
	public List<PelisPerfil> getPeliUsuario(String email);
	public boolean checkPelis(PelisPerfil PelisPerfil);
	public void deletePelisPerfil(PelisPerfil pelisPerfil);
}
