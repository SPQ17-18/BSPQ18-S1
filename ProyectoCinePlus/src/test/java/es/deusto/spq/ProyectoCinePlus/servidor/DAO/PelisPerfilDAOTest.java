package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.databene.contiperf.Required;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;

public class PelisPerfilDAOTest {
	
	private static PelisPerfilDAO pelisPerfilDAO;
	private static PelisPerfil pelisperfil1;
	private static PelisPerfil pelisperfil2;
	private static PelisPerfil pelisperfil3;
	private static String javi;
	
	static Logger logger = Logger.getLogger(PelisPerfilDAOTest.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		javi= "javitxu@gmail.com";
		pelisperfil1 = new PelisPerfil(javi,1);
		pelisperfil2 = new PelisPerfil("mikel@gmail.com",3);
		pelisperfil3 = new PelisPerfil(javi,5);
		
		pelisPerfilDAO = new PelisPerfilDAO();
	}

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void StorePelisPerfiltest() {
		assertTrue(pelisPerfilDAO.storePelisPerfil(pelisperfil1));
	}

	@Test
	public void StoreObjetcttest() {
		pelisPerfilDAO.storeObject(pelisperfil2);
		assertTrue(pelisPerfilDAO.checkPelis(pelisperfil2));
	}

	@Test
	@Required(max = 30, average = 5)
	public void getPeliUsuarioTest() {
		assertTrue(pelisPerfilDAO.getPeliUsuario(javi).size()>0);
	}
	

	
}
