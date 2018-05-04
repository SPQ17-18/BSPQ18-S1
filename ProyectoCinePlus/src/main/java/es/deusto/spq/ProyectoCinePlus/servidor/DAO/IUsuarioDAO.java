package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public interface IUsuarioDAO {

	public boolean storeUsuario(Usuario usuario);
	public boolean storeObject(Usuario usuario);
	
	public boolean loginUser(String email, String password);
	public boolean checkUser(Usuario usuario);
	
	public List<Usuario> getUsuarios();
	public List<Usuario> getUsuarios(String condition);
	public Usuario getUsuario(String username);
	public boolean updateUsuario(Usuario usuario);
	public void deleteUsuario(Usuario usuario);
	

	
}
