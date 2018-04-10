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
import ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento;

/**
 *
 * @author viktor
 */
public class TipoProcedimientoRestTest {
    
    public TipoProcedimientoRestTest() {
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
     * Test of findAll method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoProcedimientoRest instance = (TipoProcedimientoRest)container.getContext().lookup("java:global/classes/TipoProcedimientoRest");
        List<Tipoprocedimiento> expResult = null;
        List<Tipoprocedimiento> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoProcedimientoRest instance = (TipoProcedimientoRest)container.getContext().lookup("java:global/classes/TipoProcedimientoRest");
        Tipoprocedimiento expResult = null;
        Tipoprocedimiento result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarTipoProcedimiento method, of class TipoProcedimientoRest.
     */
    @Test
    public void testBorrarTipoProcedimiento() throws Exception {
        System.out.println("borrarTipoProcedimiento");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoProcedimientoRest instance = (TipoProcedimientoRest)container.getContext().lookup("java:global/classes/TipoProcedimientoRest");
        Response expResult = null;
        Response result = instance.borrarTipoProcedimiento(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarTipoProcedimiento method, of class TipoProcedimientoRest.
     */
    @Test
    public void testGuardarTipoProcedimiento() throws Exception {
        System.out.println("guardarTipoProcedimiento");
        Tipoprocedimiento tipoP = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoProcedimientoRest instance = (TipoProcedimientoRest)container.getContext().lookup("java:global/classes/TipoProcedimientoRest");
        Response expResult = null;
        Response result = instance.guardarTipoProcedimiento(tipoP);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarFabricante method, of class TipoProcedimientoRest.
     */
    @Test
    public void testEditarFabricante() throws Exception {
        System.out.println("editarFabricante");
        Integer id = null;
        Tipoprocedimiento tipoP = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoProcedimientoRest instance = (TipoProcedimientoRest)container.getContext().lookup("java:global/classes/TipoProcedimientoRest");
        Response expResult = null;
        Response result = instance.editarFabricante(id, tipoP);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
