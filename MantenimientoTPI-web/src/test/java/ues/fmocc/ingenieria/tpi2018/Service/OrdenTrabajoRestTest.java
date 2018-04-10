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
import ues.fmoocc.ingenieria.tpi2018.Entities.OrdenTrabajo;

/**
 *
 * @author viktor
 */
public class OrdenTrabajoRestTest {
    
    public OrdenTrabajoRestTest() {
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
     * Test of findall method, of class OrdenTrabajoRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        OrdenTrabajoRest instance = new OrdenTrabajoRest();
        List<OrdenTrabajo> expResult = null;
        List<OrdenTrabajo> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class OrdenTrabajoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        OrdenTrabajoRest instance = new OrdenTrabajoRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class OrdenTrabajoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        OrdenTrabajoRest instance = new OrdenTrabajoRest();
        OrdenTrabajo expResult = null;
        OrdenTrabajo result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class OrdenTrabajoRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        OrdenTrabajoRest instance = new OrdenTrabajoRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class OrdenTrabajoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        OrdenTrabajo entity = null;
        OrdenTrabajoRest instance = new OrdenTrabajoRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class OrdenTrabajoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        OrdenTrabajo entity = null;
        OrdenTrabajoRest instance = new OrdenTrabajoRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
