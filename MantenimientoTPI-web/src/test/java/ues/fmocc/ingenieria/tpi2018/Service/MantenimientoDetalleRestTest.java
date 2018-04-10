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
import ues.fmoocc.ingenieria.tpi2018.Entities.Mantenimientodetalle;

/**
 *
 * @author viktor
 */
public class MantenimientoDetalleRestTest {
    
    public MantenimientoDetalleRestTest() {
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
     * Test of findall method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        MantenimientoDetalleRest instance = new MantenimientoDetalleRest();
        List<Mantenimientodetalle> expResult = null;
        List<Mantenimientodetalle> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        MantenimientoDetalleRest instance = new MantenimientoDetalleRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        MantenimientoDetalleRest instance = new MantenimientoDetalleRest();
        Mantenimientodetalle expResult = null;
        Mantenimientodetalle result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        MantenimientoDetalleRest instance = new MantenimientoDetalleRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Mantenimientodetalle entity = null;
        MantenimientoDetalleRest instance = new MantenimientoDetalleRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Mantenimientodetalle entity = null;
        MantenimientoDetalleRest instance = new MantenimientoDetalleRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
