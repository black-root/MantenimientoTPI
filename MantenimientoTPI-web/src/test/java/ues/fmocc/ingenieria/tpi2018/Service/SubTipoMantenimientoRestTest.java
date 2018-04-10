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
import ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento;

/**
 *
 * @author viktor
 */
public class SubTipoMantenimientoRestTest {
    
    public SubTipoMantenimientoRestTest() {
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
     * Test of findall method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        List<SubTipoMantenimiento> expResult = null;
        List<SubTipoMantenimiento> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        SubTipoMantenimiento expResult = null;
        SubTipoMantenimiento result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByDescripcion method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        String descripcion = "";
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        List<SubTipoMantenimiento> expResult = null;
        List<SubTipoMantenimiento> result = instance.findByDescripcion(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        SubTipoMantenimiento entity = null;
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        SubTipoMantenimiento entity = null;
        SubTipoMantenimientoRest instance = new SubTipoMantenimientoRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
