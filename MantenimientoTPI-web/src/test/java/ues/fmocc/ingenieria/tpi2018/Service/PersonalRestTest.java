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
import ues.fmoocc.ingenieria.tpi2018.Entities.Personal;

/**
 *
 * @author viktor
 */
public class PersonalRestTest {
    
    public PersonalRestTest() {
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
     * Test of findall method, of class PersonalRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        PersonalRest instance = new PersonalRest();
        List<Personal> expResult = null;
        List<Personal> result = instance.findall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class PersonalRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        PersonalRest instance = new PersonalRest();
        Integer expResult = null;
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class PersonalRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        PersonalRest instance = new PersonalRest();
        Personal expResult = null;
        Personal result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNombre method, of class PersonalRest.
     */
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "";
        PersonalRest instance = new PersonalRest();
        List<Personal> expResult = null;
        List<Personal> result = instance.findByNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PersonalRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer id = null;
        PersonalRest instance = new PersonalRest();
        instance.remove(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PersonalRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Personal entity = null;
        PersonalRest instance = new PersonalRest();
        instance.create(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PersonalRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Integer id = null;
        Personal entity = null;
        PersonalRest instance = new PersonalRest();
        instance.edit(id, entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
