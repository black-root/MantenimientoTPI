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
import ues.fmoocc.ingenieria.tpi2018.Entities.Fabricantes;

/**
 *
 * @author viktor
 */
public class FabricantesRestTest {
    
    public FabricantesRestTest() {
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
     * Test of findAll method, of class FabricantesRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FabricantesRest instance = (FabricantesRest)container.getContext().lookup("java:global/classes/FabricantesRest");
        List<Fabricantes> expResult = null;
        List<Fabricantes> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class FabricantesRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FabricantesRest instance = (FabricantesRest)container.getContext().lookup("java:global/classes/FabricantesRest");
        Fabricantes expResult = null;
        Fabricantes result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarFabricante method, of class FabricantesRest.
     */
    @Test
    public void testBorrarFabricante() throws Exception {
        System.out.println("borrarFabricante");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FabricantesRest instance = (FabricantesRest)container.getContext().lookup("java:global/classes/FabricantesRest");
        Response expResult = null;
        Response result = instance.borrarFabricante(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarFabricante method, of class FabricantesRest.
     */
    @Test
    public void testGuardarFabricante() throws Exception {
        System.out.println("guardarFabricante");
        Fabricantes fabricante = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FabricantesRest instance = (FabricantesRest)container.getContext().lookup("java:global/classes/FabricantesRest");
        Response expResult = null;
        Response result = instance.guardarFabricante(fabricante);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarFabricante method, of class FabricantesRest.
     */
    @Test
    public void testEditarFabricante() throws Exception {
        System.out.println("editarFabricante");
        Integer id = null;
        Fabricantes fabricante = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FabricantesRest instance = (FabricantesRest)container.getContext().lookup("java:global/classes/FabricantesRest");
        Response expResult = null;
        Response result = instance.editarFabricante(id, fabricante);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
