/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Personal;

/**
 *
 * @author viktor
 */
public class PersonalRestTest {
    final PersonalRest mokPersonalRest = Mockito.mock(PersonalRest.class);
    final Personal mokPersonal = Mockito.mock(Personal.class);
    
    public PersonalRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Personal.class).withAnyArguments().thenReturn(mokPersonal);
        Mockito.when(mokPersonalRest.count()).thenReturn(1);
        Personal p = new Personal(1);
        Personal p1 = new Personal(2);
        List<Personal> listaPersonal = new ArrayList<>();
        listaPersonal.add(p);
        listaPersonal.add(p1);
        Mockito.when(mokPersonalRest.findall()).thenReturn(listaPersonal);
        Mockito.when(mokPersonalRest.findById(1)).thenReturn(p1);
        Mockito.when(mokPersonalRest.findByNombre("nombre")).thenReturn(listaPersonal);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class PersonalRest.
     */
    @Test
    public void testFindall() {
      PersonalRest rest = mokPersonalRest;
      List<Personal> result = rest.findall();
      Personal per = new Personal(1);
      assertThat(result, CoreMatchers.hasItems(per));
    }

    /**
     * Test of count method, of class PersonalRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        PersonalRest instance = mokPersonalRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class PersonalRest.
     */
    @Test
    public void testFindById() {
        Integer id = 1;
        PersonalRest instance = mokPersonalRest;
        Personal expResult = new Personal(2);
        Personal result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByNombre method, of class PersonalRest.
     */
    @Test
    public void testFindByNombre() {
      
        PersonalRest instance = mokPersonalRest;
        Personal expResult = new Personal(1);
        List<Personal> result = instance.findByNombre("nombre");
        assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);
    }

    /**
     * Test of remove method, of class PersonalRest.
     */
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokPersonalRest).remove((Integer) Matchers.anyObject());
        mokPersonalRest.remove(Integer.SIZE);
        Mockito.verify(mokPersonalRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokPersonalRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class PersonalRest.
     */
    @Test
    public void testCreate() {
        Mockito.doNothing().when(mokPersonalRest).create(mokPersonal);
        mokPersonalRest.create(mokPersonal);
        Mockito.verify(mokPersonalRest, times(1)).create(mokPersonal);
        Mockito.doThrow(Exception.class).when(mokPersonalRest).create(mokPersonal);
       
    }

    /**
     * Test of edit method, of class PersonalRest.
     */
    @Test
    public void testEdit() {
       Mockito.doNothing().when(mokPersonalRest).edit(Integer.SIZE, mokPersonal);
        mokPersonalRest.edit(Integer.SIZE, mokPersonal);
        Mockito.verify(mokPersonalRest, times(1)).edit(Integer.SIZE, mokPersonal);
        Mockito.doThrow(Exception.class).when(mokPersonalRest).edit(Integer.SIZE, mokPersonal);
       
    }
    
}
