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
import org.junit.Ignore;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.HistorialTrabajo;

/**
 *
 * @author viktor
 */
@Ignore
public class HistorialTrabajoRestTest {
    final HistorialTrabajoRest mokHistorialTrabajoRest = Mockito.mock(HistorialTrabajoRest.class);
    final HistorialTrabajo mokHistorialTrabajo = Mockito.mock(HistorialTrabajo.class);
    
    public HistorialTrabajoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(HistorialTrabajo.class).withAnyArguments().thenReturn(mokHistorialTrabajo);
        Mockito.when(mokHistorialTrabajoRest.count()).thenReturn(1);
        HistorialTrabajo h = new HistorialTrabajo(1);
        HistorialTrabajo h1 = new HistorialTrabajo(2);
        List<HistorialTrabajo> listaHistorialTrabajo = new ArrayList<>();
        listaHistorialTrabajo.add(h);
        listaHistorialTrabajo.add(h1);
        Mockito.when(mokHistorialTrabajoRest.findall()).thenReturn(listaHistorialTrabajo);
        Mockito.when(mokHistorialTrabajoRest.findById(1)).thenReturn(h);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class HistorialTrabajoRest.
     */
    @Test
    public void testFindall() {
     HistorialTrabajoRest rest = mokHistorialTrabajoRest;
     List<HistorialTrabajo> result = rest.findall();
     HistorialTrabajo histo = new HistorialTrabajo(1);
     assertThat(result, CoreMatchers.hasItems(histo));
    }

    /**
     * Test of count method, of class HistorialTrabajoRest.
     */
    @Test
    public void testCount() {
       HistorialTrabajoRest instance = mokHistorialTrabajoRest;
       int expResult = 1;
       int result = instance.count();
       assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class HistorialTrabajoRest.
     */
    @Test
    public void testFindById() {
        Integer id=1;
        HistorialTrabajoRest instance = mokHistorialTrabajoRest;
        HistorialTrabajo expResult = new HistorialTrabajo(1);
        HistorialTrabajo result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class HistorialTrabajoRest.
     */
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokHistorialTrabajoRest).remove((Integer) Matchers.anyObject());
        mokHistorialTrabajoRest.remove(Integer.SIZE);
        Mockito.verify(mokHistorialTrabajoRest, times(1)).remove(Integer.SIZE);
         Mockito.doThrow(Exception.class).when(mokHistorialTrabajoRest).remove(Integer.SIZE);

    }

    /**
     * Test of create method, of class HistorialTrabajoRest.
     */
    @Test
    public void testCreate() {
        Mockito.doNothing().when(mokHistorialTrabajoRest).create(mokHistorialTrabajo);
        mokHistorialTrabajoRest.create(mokHistorialTrabajo);
        Mockito.verify(mokHistorialTrabajoRest, times(1)).create(mokHistorialTrabajo);
        Mockito.doThrow(Exception.class).when(mokHistorialTrabajoRest).create(mokHistorialTrabajo);

    }

    /**
     * Test of edit method, of class HistorialTrabajoRest.
     */
    @Test
    public void testEdit() {
        Mockito.doNothing().when(mokHistorialTrabajoRest).edit(mokHistorialTrabajo);
        mokHistorialTrabajoRest.edit(mokHistorialTrabajo);
        Mockito.verify(mokHistorialTrabajoRest, times(1)).edit(mokHistorialTrabajo);
         Mockito.doThrow(Exception.class).when(mokHistorialTrabajoRest).edit(mokHistorialTrabajo);
    }
    
}
