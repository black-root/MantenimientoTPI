/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ues.fmoocc.ingenieria.tpi2018.Entities.Equipodetalle;

/**
 *
 * @author viktor
 */
public class Equipo_detalleRestTest {
    
    public Equipo_detalleRestTest() {
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
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class Equipo_detalleRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Equipo_detalleRest instance = (Equipo_detalleRest)container.getContext().lookup("java:global/classes/Equipo_detalleRest");
        List<Equipodetalle> expResult = null;
        List<Equipodetalle> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class Equipo_detalleRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Equipo_detalleRest instance = (Equipo_detalleRest)container.getContext().lookup("java:global/classes/Equipo_detalleRest");
        Equipodetalle expResult = null;
        Equipodetalle result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarEquipodetalle method, of class Equipo_detalleRest.
     */
    @Test
    public void testBorrarEquipodetalle() throws Exception {
        System.out.println("borrarEquipodetalle");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Equipo_detalleRest instance = (Equipo_detalleRest)container.getContext().lookup("java:global/classes/Equipo_detalleRest");
        Response expResult = null;
        Response result = instance.borrarEquipodetalle(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEquipodetalle method, of class Equipo_detalleRest.
     */
    @Test
    public void testGuardarEquipodetalle() throws Exception {
        System.out.println("guardarEquipodetalle");
        Equipodetalle ed = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Equipo_detalleRest instance = (Equipo_detalleRest)container.getContext().lookup("java:global/classes/Equipo_detalleRest");
        Response expResult = null;
        Response result = instance.guardarEquipodetalle(ed);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarEquipodetalle method, of class Equipo_detalleRest.
     */
    @Test
    public void testEditarEquipodetalle() throws Exception {
        System.out.println("editarEquipodetalle");
        Integer id = null;
        Equipodetalle ed = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Equipo_detalleRest instance = (Equipo_detalleRest)container.getContext().lookup("java:global/classes/Equipo_detalleRest");
        Response expResult = null;
        Response result = instance.editarEquipodetalle(id, ed);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
