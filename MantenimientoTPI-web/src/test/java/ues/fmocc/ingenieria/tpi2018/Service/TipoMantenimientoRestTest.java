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
import ues.fmoocc.ingenieria.tpi2018.Entities.TipoMantenimiento;

/**
 *
 * @author viktor
 */
public class TipoMantenimientoRestTest {
    
    public TipoMantenimientoRestTest() {
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
     * Test of findall method, of class TipoMantenimientoRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        List<TipoMantenimiento> expResult = null;
        List<TipoMantenimiento> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class TipoMantenimientoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class TipoMantenimientoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        TipoMantenimiento expResult = null;
        TipoMantenimiento result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByDescripcion method, of class TipoMantenimientoRest.
     */
    @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        String descripcion = "";
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        List<TipoMantenimiento> expResult = null;
        List<TipoMantenimiento> result = instance.findByDescripcion(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class TipoMantenimientoRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class TipoMantenimientoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        TipoMantenimiento entity = null;
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class TipoMantenimientoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        TipoMantenimiento entity = null;
        TipoMantenimientoRest instance = new TipoMantenimientoRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
