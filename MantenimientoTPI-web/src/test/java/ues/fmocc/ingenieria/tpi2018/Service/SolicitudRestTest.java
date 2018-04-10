/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;

/**
 *
 * @author viktor
 */
public class SolicitudRestTest {
    
    public SolicitudRestTest() {
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
     * Test of findall method, of class SolicitudRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        SolicitudRest instance = new SolicitudRest();
        List<Solicitud> expResult = null;
        List<Solicitud> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class SolicitudRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        SolicitudRest instance = new SolicitudRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class SolicitudRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        SolicitudRest instance = new SolicitudRest();
        Solicitud expResult = null;
        Solicitud result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBySolicitud method, of class SolicitudRest.
     */
    @Test
    public void testFindBySolicitud() {
        System.out.println("findBySolicitud");
        String nombre = "";
        SolicitudRest instance = new SolicitudRest();
        List<Solicitud> expResult = null;
        List<Solicitud> result = instance.findBySolicitud(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SolicitudRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        SolicitudRest instance = new SolicitudRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SolicitudRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Solicitud entity = null;
        SolicitudRest instance = new SolicitudRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class SolicitudRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Solicitud entity = null;
        SolicitudRest instance = new SolicitudRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
