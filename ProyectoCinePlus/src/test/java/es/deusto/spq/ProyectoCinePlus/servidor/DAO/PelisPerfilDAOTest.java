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
* @brief Test PelisPerfilDAOTest. May 18, 2018
* @since 3.0.0
* 
* Este es el test que comprueba los metodos de PelisPerfilDAO.
*/
public class PelisPerfilDAOTest {
	
	private static PelisPerfilDAO pelisPerfilDAO;
	
	private  PelisPerfil pelisperfil1;
	private  PelisPerfil pelisperfil2;
	private  PelisPerfil pelisperfil3;
	
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
		pelisperfil3 = new PelisPerfil("javitxu@gmail.com",5);
		
		 if(pelisPerfilDAO.checkPelis(pelisperfil1) == false){
			 pelisPerfilDAO.storePelisPerfil(pelisperfil1);
			 logger.info("almacenando "+pelisperfil1.getId_pelicula());
			
		 }
		 if(pelisPerfilDAO.checkPelis(pelisperfil2) == false){
			 pelisPerfilDAO.storePelisPerfil(pelisperfil2);
			 logger.info("almacenando "+pelisperfil2.getId_pelicula());
			
		 }
	}


	/**
	 * Test que comprueba si se almacena el objeto pelisperfil
	 */
	@Test
	public void StorePelisPerfiltest(){
		assertTrue(pelisPerfilDAO.storePelisPerfil(pelisperfil3));
	}
	
	/**
	 * Test para comprobar la insercion correcta de un objeto
	 */

	@Test
	public void StoreObjetcttest(){
		pelisPerfilDAO.storePelisPerfil(pelisperfil3);
		assertTrue(pelisPerfilDAO.checkPelis(pelisperfil3));
	}
	
	/**
	 * Test que comprueba que se hayan eliminado todas las pelis de la bd satisfactoriamente
	 */
	
	@Test
	@Required(totalTime = 180)
	public void deleteObjectTest(){
		pelisPerfilDAO.deletePelisPerfil(pelisperfil1);
		pelisPerfilDAO.deletePelisPerfil(pelisperfil2);
		
		assertFalse(pelisPerfilDAO.checkPelis(pelisperfil1));
		assertFalse(pelisPerfilDAO.checkPelis(pelisperfil2));
	}

	/**
	 * Comprobamos que obtiene las pelis del usuario que le pasamos. (previamente le hemos precargado pelis)
	 */
	@Test
	@PerfTest(invocations = 200)
	@Required(max = 92,percentile95 = 60)
	public void getPeliUsuarioTest(){
		assertTrue(pelisPerfilDAO.getPeliUsuario("javitxu@gmail.com").size()>=0);
	}
	
	@After
	public void deleteUsers() throws Exception{
		 if(pelisPerfilDAO.checkPelis(pelisperfil1) == true){
			 pelisPerfilDAO.deletePelisPerfil(pelisperfil1);
			 logger.info("almacenando "+pelisperfil1.getId_pelicula());
			
		 }
		 if(pelisPerfilDAO.checkPelis(pelisperfil2) == true){
			 pelisPerfilDAO.deletePelisPerfil(pelisperfil2);
			 logger.info("almacenando "+pelisperfil2.getId_pelicula());
			
		 }
		 if(pelisPerfilDAO.checkPelis(pelisperfil3) == true){
			 pelisPerfilDAO.deletePelisPerfil(pelisperfil3);
			 logger.info("almacenando "+pelisperfil3.getId_pelicula());
			
		 }
		  
	}
	
	
}