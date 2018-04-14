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

import ues.fmoocc.ingenieria.tpi2018.Entities.OrdenTrabajo;


/**
 *
 * @author viktor
 */
public class OrdenTrabajoRestTest {
    final OrdenTrabajoRest mokOrdenTrabajoRest = Mockito.mock(OrdenTrabajoRest.class);
    final OrdenTrabajo mokOrdenTrabajo = Mockito.mock(OrdenTrabajo.class);
    public OrdenTrabajoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(OrdenTrabajo.class).withAnyArguments().thenReturn(mokOrdenTrabajo);
        Mockito.when(mokOrdenTrabajoRest.count()).thenReturn(1);
        OrdenTrabajo or = new OrdenTrabajo(1);
        OrdenTrabajo or1 = new OrdenTrabajo(2);
        List<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<>();
        listaOrdenTrabajo.add(or);
        listaOrdenTrabajo.add(or1);
        Mockito.when(mokOrdenTrabajoRest.findall()).thenReturn(listaOrdenTrabajo);
        Mockito.when(mokOrdenTrabajoRest.findById(1)).thenReturn(or1);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class OrdenTrabajoRest.
     */
    @Test
    public void testFindall() {
        OrdenTrabajoRest rest = mokOrdenTrabajoRest;
        List<OrdenTrabajo> result = rest.findall();
        OrdenTrabajo oT = new OrdenTrabajo(1);
        assertThat(result, CoreMatchers.hasItems(oT));
    }

    /**
     * Test of count method, of class OrdenTrabajoRest.
     */
    @Test
    public void testCount() {
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class OrdenTrabajoRest.
     */
    @Test
    public void testFindById() {
        Integer id = 1;
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        OrdenTrabajo expResult = new OrdenTrabajo(2);
        OrdenTrabajo result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class OrdenTrabajoRest.
     */
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokOrdenTrabajoRest).remove((Integer) Matchers.anyObject());
        mokOrdenTrabajoRest.remove(Integer.SIZE);
        Mockito.verify(mokOrdenTrabajoRest, times(1)).remove(Integer.SIZE);
        Mockito.doThrow(Exception.class).when(mokOrdenTrabajoRest).remove(Integer.SIZE);
    }

    /**
     * Test of create method, of class OrdenTrabajoRest.
     */
    @Test
    public void testCreate() {
        Mockito.doNothing().when(mokOrdenTrabajoRest).create(mokOrdenTrabajo);
        mokOrdenTrabajoRest.create(mokOrdenTrabajo);
        Mockito.verify(mokOrdenTrabajoRest, times(1)).create(mokOrdenTrabajo);
        Mockito.doThrow(Exception.class).when(mokOrdenTrabajoRest).create(mokOrdenTrabajo);
    }

    /**
     * Test of edit method, of class OrdenTrabajoRest.
     */
    @Test
    public void testEdit() { 
       Mockito.doNothing().when(mokOrdenTrabajoRest).edit(Integer.SIZE, mokOrdenTrabajo);
        mokOrdenTrabajoRest.edit(Integer.SIZE, mokOrdenTrabajo);
        Mockito.verify(mokOrdenTrabajoRest, times(1)).edit(Integer.SIZE, mokOrdenTrabajo);
        Mockito.doThrow(Exception.class).when(mokOrdenTrabajoRest).edit(Integer.SIZE, mokOrdenTrabajo);
    }
    
}
