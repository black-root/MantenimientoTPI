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
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;

/**
 *
 * @author viktor
 */
public class PasosRestTest {
    
    public PasosRestTest() {
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
     * Test of findAll method, of class PasosRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PasosRest instance = (PasosRest)container.getContext().lookup("java:global/classes/PasosRest");
        List<Pasos> expResult = null;
        List<Pasos> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class PasosRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PasosRest instance = (PasosRest)container.getContext().lookup("java:global/classes/PasosRest");
        Pasos expResult = null;
        Pasos result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPaso method, of class PasosRest.
     */
    @Test
    public void testBorrarPaso() throws Exception {
        System.out.println("borrarPaso");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PasosRest instance = (PasosRest)container.getContext().lookup("java:global/classes/PasosRest");
        Response expResult = null;
        Response result = instance.borrarPaso(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarPaso method, of class PasosRest.
     */
    @Test
    public void testGuardarPaso() throws Exception {
        System.out.println("guardarPaso");
        Pasos paso = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PasosRest instance = (PasosRest)container.getContext().lookup("java:global/classes/PasosRest");
        Response expResult = null;
        Response result = instance.guardarPaso(paso);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarPaso method, of class PasosRest.
     */
    @Test
    public void testEditarPaso() throws Exception {
        System.out.println("editarPaso");
        Integer id = null;
        Pasos paso = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PasosRest instance = (PasosRest)container.getContext().lookup("java:global/classes/PasosRest");
        Response expResult = null;
        Response result = instance.editarPaso(id, paso);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
