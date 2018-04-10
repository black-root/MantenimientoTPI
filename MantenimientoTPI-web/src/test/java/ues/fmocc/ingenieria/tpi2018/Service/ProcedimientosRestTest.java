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
import ues.fmoocc.ingenieria.tpi2018.Entities.Procedimientos;

/**
 *
 * @author viktor
 */
public class ProcedimientosRestTest {
    
    public ProcedimientosRestTest() {
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
     * Test of findAll method, of class ProcedimientosRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProcedimientosRest instance = (ProcedimientosRest)container.getContext().lookup("java:global/classes/ProcedimientosRest");
        List<Procedimientos> expResult = null;
        List<Procedimientos> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ProcedimientosRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProcedimientosRest instance = (ProcedimientosRest)container.getContext().lookup("java:global/classes/ProcedimientosRest");
        Procedimientos expResult = null;
        Procedimientos result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarProcedimiento method, of class ProcedimientosRest.
     */
    @Test
    public void testBorrarProcedimiento() throws Exception {
        System.out.println("borrarProcedimiento");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProcedimientosRest instance = (ProcedimientosRest)container.getContext().lookup("java:global/classes/ProcedimientosRest");
        Response expResult = null;
        Response result = instance.borrarProcedimiento(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarProcedimimento method, of class ProcedimientosRest.
     */
    @Test
    public void testGuardarProcedimimento() throws Exception {
        System.out.println("guardarProcedimimento");
        Procedimientos proc = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProcedimientosRest instance = (ProcedimientosRest)container.getContext().lookup("java:global/classes/ProcedimientosRest");
        Response expResult = null;
        Response result = instance.guardarProcedimimento(proc);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarProcedimiento method, of class ProcedimientosRest.
     */
    @Test
    public void testEditarProcedimiento() throws Exception {
        System.out.println("editarProcedimiento");
        Integer id = null;
        Procedimientos proc = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProcedimientosRest instance = (ProcedimientosRest)container.getContext().lookup("java:global/classes/ProcedimientosRest");
        Response expResult = null;
        Response result = instance.editarProcedimiento(id, proc);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
