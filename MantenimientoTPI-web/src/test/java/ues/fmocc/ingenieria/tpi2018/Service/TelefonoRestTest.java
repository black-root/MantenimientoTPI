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
import ues.fmoocc.ingenieria.tpi2018.Entities.Telefono;

/**
 *
 * @author viktor
 */
public class TelefonoRestTest {
    
    public TelefonoRestTest() {
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
     * Test of findall method, of class TelefonoRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        TelefonoRest instance = new TelefonoRest();
        List<Telefono> expResult = null;
        List<Telefono> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class TelefonoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        TelefonoRest instance = new TelefonoRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class TelefonoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        TelefonoRest instance = new TelefonoRest();
        Telefono expResult = null;
        Telefono result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class TelefonoRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        TelefonoRest instance = new TelefonoRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class TelefonoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Telefono entity = null;
        TelefonoRest instance = new TelefonoRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class TelefonoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Telefono entity = null;
        TelefonoRest instance = new TelefonoRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
