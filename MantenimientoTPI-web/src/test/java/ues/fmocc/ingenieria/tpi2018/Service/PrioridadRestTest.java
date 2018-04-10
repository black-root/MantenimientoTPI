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
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ues.fmoocc.ingenieria.tpi2018.Entities.Prioridad;

/**
 *
 * @author sergio
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PrioridadRest.class)
public class PrioridadRestTest {
    final PrioridadRest mokPrioridadRest = Mockito.mock(PrioridadRest.class);
    final Prioridad mokPrioridad = Mockito.mock(Prioridad.class);
    public PrioridadRestTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Prioridad.class).withAnyArguments().thenReturn(mokPrioridad);
        Mockito.when(mokPrioridadRest.count()).thenReturn(1);
        Prioridad p = new Prioridad(1, "1");    
        Prioridad p1 = new Prioridad(2);
        List<Prioridad> listaprioridad = new ArrayList<>();   
        listaprioridad.add(p);
        listaprioridad.add(p1);
        Mockito.when(mokPrioridadRest.findall()).thenReturn(listaprioridad);
        Mockito.when(mokPrioridadRest.findById(1)).thenReturn(p1);     
     
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class PrioridadRest.
     */
    @Test
    public void testFindall() {

        System.out.println("findall");      
        PrioridadRest rest = mokPrioridadRest;
        List<Prioridad> result = rest.findall();
        Prioridad prioridad = new Prioridad(1, "1");
        assertThat(result, CoreMatchers.hasItems(prioridad));
    }

    /**
     * Test of count method, of class PrioridadRest.
     * @throws java.lang.Exception
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        PrioridadRest instance = mokPrioridadRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class PrioridadRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        PrioridadRest instance = mokPrioridadRest;
        Prioridad expResult = new Prioridad(1);
        Prioridad result = instance.findById(id);
        assertEquals(expResult, result);
        
    }

  
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokPrioridadRest).remove((Integer) Matchers.anyObject());
        
        mokPrioridadRest.remove(Integer.SIZE);
        Mockito.verify(mokPrioridadRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokPrioridadRest).remove(Integer.SIZE);
    }
       
    
    @Test
    public void testCreate() {
        Mockito.doNothing().when(mokPrioridadRest).create(mokPrioridad);
        mokPrioridadRest.create(mokPrioridad);
        Mockito.verify(mokPrioridadRest, times(1)).create(mokPrioridad);
        Mockito.doThrow(Exception.class).when(mokPrioridadRest).create(mokPrioridad);
        
    }
   
    @Test
    public void testEdit() {
       Mockito.doNothing().when(mokPrioridadRest).edit(Integer.SIZE, mokPrioridad);
        mokPrioridadRest.edit(Integer.SIZE, mokPrioridad);
        Mockito.verify(mokPrioridadRest, times(1)).edit(Integer.SIZE, mokPrioridad);
        Mockito.doThrow(Exception.class).when(mokPrioridadRest).edit(Integer.SIZE, mokPrioridad);
       
    }
    
}
    

