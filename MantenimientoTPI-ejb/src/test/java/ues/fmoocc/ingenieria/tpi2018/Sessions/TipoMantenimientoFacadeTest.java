/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;


import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.powermock.reflect.Whitebox;
import ues.fmoocc.ingenieria.tpi2018.Entities.TipoMantenimiento;

/**
 *
 * @author sergio
 */
public class TipoMantenimientoFacadeTest extends EntityManagerProvider{
    
    public TipoMantenimientoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
  

    /**
     * Test of find method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testFind() throws Exception {
        
    }

    /**
     * Test of crear method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testCrear() throws Exception {
        EntityManager em = EntityManagerProvider.em;
        TipoMantenimiento tipo1 = new TipoMantenimiento(1, "esto es una descripcion");
        TipoMantenimiento tipo2 = new TipoMantenimiento(2, "esto es una prueba");
        TipoMantenimiento tipo3 = new TipoMantenimiento();
        
        TipoMantenimientoFacade tmf = new TipoMantenimientoFacade();
        Whitebox.setInternalState(tmf, "em", em);
        
        tmf.getEntityManager().getTransaction().begin();
        
        boolean test1 = tmf.crear(tipo3);
        boolean test2 = tmf.crear(tipo1);
        boolean test3 = tmf.crear(tipo2);
        
        
        
        assertFalse(test1);
        assertTrue(test2);
        assertTrue(test3);
        assertEquals(2, tmf.findAll().size());
   }

    /**
     * Test of modificar method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testModificar() throws Exception {
        
    }

    /**
     * Test of eliminar method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testEliminar() throws Exception {
        
    }

    /**
     * Test of findAll method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        
    }

    /**
     * Test of findRange method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        
    }

    /**
     * Test of count method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testCount() throws Exception {
       
    }
    
}
