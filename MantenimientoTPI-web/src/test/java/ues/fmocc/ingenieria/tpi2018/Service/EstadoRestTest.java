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
import ues.fmoocc.ingenieria.tpi2018.Entities.Estado;

/**
 *
 * @author viktor
 */
public class EstadoRestTest {
    
    public EstadoRestTest() {
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
     * Test of findAll method, of class EstadoRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EstadoRest instance = (EstadoRest)container.getContext().lookup("java:global/classes/EstadoRest");
        List<Estado> expResult = null;
        List<Estado> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class EstadoRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EstadoRest instance = (EstadoRest)container.getContext().lookup("java:global/classes/EstadoRest");
        Estado expResult = null;
        Estado result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarEstado method, of class EstadoRest.
     */
    @Test
    public void testBorrarEstado() throws Exception {
        System.out.println("borrarEstado");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EstadoRest instance = (EstadoRest)container.getContext().lookup("java:global/classes/EstadoRest");
        Response expResult = null;
        Response result = instance.borrarEstado(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEstado method, of class EstadoRest.
     */
    @Test
    public void testGuardarEstado() throws Exception {
        System.out.println("guardarEstado");
        Estado estado = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EstadoRest instance = (EstadoRest)container.getContext().lookup("java:global/classes/EstadoRest");
        Response expResult = null;
        Response result = instance.guardarEstado(estado);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarEstado method, of class EstadoRest.
     */
    @Test
    public void testEditarEstado() throws Exception {
        System.out.println("editarEstado");
        Integer id = null;
        Estado estado = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EstadoRest instance = (EstadoRest)container.getContext().lookup("java:global/classes/EstadoRest");
        Response expResult = null;
        Response result = instance.editarEstado(id, estado);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
