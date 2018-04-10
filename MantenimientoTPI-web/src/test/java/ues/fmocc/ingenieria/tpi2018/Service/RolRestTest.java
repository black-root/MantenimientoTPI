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
import ues.fmoocc.ingenieria.tpi2018.Entities.Rol;

/**
 *
 * @author viktor
 */
public class RolRestTest {
    
    public RolRestTest() {
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
     * Test of findall method, of class RolRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        RolRest instance = new RolRest();
        List<Rol> expResult = null;
        List<Rol> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class RolRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        RolRest instance = new RolRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class RolRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        RolRest instance = new RolRest();
        Rol expResult = null;
        Rol result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByDescripcion method, of class RolRest.
     */
    @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        String descripcion = "";
        RolRest instance = new RolRest();
        List<Rol> expResult = null;
        List<Rol> result = instance.findByDescripcion(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class RolRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        RolRest instance = new RolRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class RolRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Rol entity = null;
        RolRest instance = new RolRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class RolRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Rol entity = null;
        RolRest instance = new RolRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
