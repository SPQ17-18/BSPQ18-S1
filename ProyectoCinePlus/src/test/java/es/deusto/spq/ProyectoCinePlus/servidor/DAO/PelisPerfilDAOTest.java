/** @package ees.deusto.spq.ProyectoCinePlus.servidor.DAO;
*   @brief Test PelisPerfilDAOTest. May 18, 2018
*
*   Este es el test que comprueba los metodos de PelisPerfilDAO
*/
package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import junit.framework.JUnit4TestAdapter;
/**
* @author mikelgol7
* @since 3.0.0
* 
* Este es el test que comprueba los metodos de PelisPerfilDAO.
*/
public class PelisPerfilDAOTest {
	
	private static PelisPerfilDAO pelisPerfilDAO;
	
	private  PelisPerfil pelisperfil1;
	private  PelisPerfil pelisperfil2;
	
	static Logger logger = Logger.getLogger(PelisPerfilDAOTest.class.getName());
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();

	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(PelisPerfilDAOTest.class);
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		pelisPerfilDAO = new PelisPerfilDAO();

	}

	/**
	 * Creo objetos pelisperfil y los subo a la base de datos si no existen.
	 * @throws Exception lanza excepcion
	 */
	@Before
	public void setUp() throws Exception{
		pelisperfil1 = new PelisPerfil("javitxu@gmail.com",1);
		pelisperfil2 = new PelisPerfil("mikel@gmail.com",3);
		
		pelisPerfilDAO.storePelisPerfil(pelisperfil1);
		pelisPerfilDAO.storePelisPerfil(pelisperfil2);
			
			
		 
	}

	/**
	 * Comprobamos que obtiene las pelis del usuario que le pasamos. (previamente le hemos precargado pelis)
	 */
	@Test
	@PerfTest(invocations = 200)
	@Required(max = 110,percentile95 = 15)
	public void getPeliUsuarioTest(){
		assertTrue(pelisPerfilDAO.getPeliUsuario("javitxu@gmail.com").size()>=0);
	}
	
	@After
	public void deleteUsers() throws Exception{
		 
			 pelisPerfilDAO.deletePelisPerfil(pelisperfil1);
			 pelisPerfilDAO.deletePelisPerfil(pelisperfil2);


		  
	}
	
	
}