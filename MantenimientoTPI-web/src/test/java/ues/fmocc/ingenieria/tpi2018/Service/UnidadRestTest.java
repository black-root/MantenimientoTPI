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
import ues.fmoocc.ingenieria.tpi2018.Entities.Unidad;

/**
 *
 * @author viktor
 */
public class UnidadRestTest {
    
    public UnidadRestTest() {
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
     * Test of findall method, of class UnidadRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        UnidadRest instance = new UnidadRest();
        List<Unidad> expResult = null;
        List<Unidad> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class UnidadRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        UnidadRest instance = new UnidadRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class UnidadRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        UnidadRest instance = new UnidadRest();
        Unidad expResult = null;
        Unidad result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNombre method, of class UnidadRest.
     */
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "";
        UnidadRest instance = new UnidadRest();
        List<Unidad> expResult = null;
        List<Unidad> result = instance.findByNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UnidadRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        UnidadRest instance = new UnidadRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UnidadRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Unidad entity = null;
        UnidadRest instance = new UnidadRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UnidadRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Unidad entity = null;
        UnidadRest instance = new UnidadRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
