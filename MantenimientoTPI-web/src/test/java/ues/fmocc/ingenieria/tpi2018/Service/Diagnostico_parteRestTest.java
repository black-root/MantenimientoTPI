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
import ues.fmoocc.ingenieria.tpi2018.Entities.Dianosticoparte;

/**
 *
 * @author viktor
 */
public class Diagnostico_parteRestTest {
    
    public Diagnostico_parteRestTest() {
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
     * Test of findAll method, of class Diagnostico_parteRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Diagnostico_parteRest instance = (Diagnostico_parteRest)container.getContext().lookup("java:global/classes/Diagnostico_parteRest");
        List<Dianosticoparte> expResult = null;
        List<Dianosticoparte> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class Diagnostico_parteRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Diagnostico_parteRest instance = (Diagnostico_parteRest)container.getContext().lookup("java:global/classes/Diagnostico_parteRest");
        Dianosticoparte expResult = null;
        Dianosticoparte result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testBorrarDiagnosticoparte() throws Exception {
        System.out.println("borrarDiagnosticoparte");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Diagnostico_parteRest instance = (Diagnostico_parteRest)container.getContext().lookup("java:global/classes/Diagnostico_parteRest");
        Response expResult = null;
        Response result = instance.borrarDiagnosticoparte(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardarDiagnosticoparte() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        Dianosticoparte dp = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Diagnostico_parteRest instance = (Diagnostico_parteRest)container.getContext().lookup("java:global/classes/Diagnostico_parteRest");
        Response expResult = null;
        Response result = instance.guardarDiagnosticoparte(dp);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditarDiagnosticoparte() throws Exception {
        System.out.println("editarDiagnosticoparte");
        Integer id = null;
        Dianosticoparte dp = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Diagnostico_parteRest instance = (Diagnostico_parteRest)container.getContext().lookup("java:global/classes/Diagnostico_parteRest");
        Response expResult = null;
        Response result = instance.editarDiagnosticoparte(id, dp);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
