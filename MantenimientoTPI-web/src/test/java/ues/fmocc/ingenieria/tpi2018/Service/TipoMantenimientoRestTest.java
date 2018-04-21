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
import ues.fmoocc.ingenieria.tpi2018.Entities.TipoMantenimiento;

/**
 *
 * @author viktor
 */
public class TipoMantenimientoRestTest {
    final TipoMantenimientoRest mokTMRest = Mockito.mock(TipoMantenimientoRest.class);
    final TipoMantenimiento mokTM = Mockito.mock(TipoMantenimiento.class);
    
    public TipoMantenimientoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(TipoMantenimiento.class).withAnyArguments().thenReturn(mokTM);
        Mockito.when(mokTMRest.count()).thenReturn(1);
        TipoMantenimiento tm = new TipoMantenimiento(1);
        TipoMantenimiento tm1 = new TipoMantenimiento(2);
        List<TipoMantenimiento> listaTM = new ArrayList<>();
        listaTM.add(tm);
        listaTM.add(tm1);
        Mockito.when(mokTMRest.findall()).thenReturn(listaTM);
        Mockito.when(mokTMRest.findById(1)).thenReturn(tm);
       // Mockito.when(mokTMRest.findByDescripcion("descripcion")).thenReturn(listaTM);
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
        TipoMantenimientoRest rest = mokTMRest;
        List<TipoMantenimiento> result = rest.findall();
        TipoMantenimiento tm = new TipoMantenimiento(1);
        assertThat(result, CoreMatchers.hasItems(tm));
                
    }

    /**
     * Test of count method, of class TipoMantenimientoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        TipoMantenimientoRest instance = mokTMRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class TipoMantenimientoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        TipoMantenimientoRest instance = mokTMRest;
        TipoMantenimiento expResult = new TipoMantenimiento(1);
        TipoMantenimiento result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class TipoMantenimientoRest.
     */
//    @Test
//    public void testFindByDescripcion() {
//        System.out.println("findByDescripcion");
//        TipoMantenimientoRest instance = mokTMRest;
//        TipoMantenimiento expResult = new TipoMantenimiento(1);
//        List<TipoMantenimiento> result = instance.findByDescripcion("descripcion");
//        assertThat(result, CoreMatchers.hasItem(expResult));
//        assertNotNull(result);
//    }

    /**
     * Test of remove method, of class TipoMantenimientoRest.
     */
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokTMRest).remove((Integer) Matchers.anyObject());
        mokTMRest.remove(Integer.SIZE);
        Mockito.verify(mokTMRest, times(1)).remove(Integer.SIZE);
        Mockito.doThrow(Exception.class).when(mokTMRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class TipoMantenimientoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Mockito.doNothing().when(mokTMRest).create(mokTM);
        mokTMRest.create(mokTM);
        Mockito.verify(mokTMRest, times(1)).create(mokTM);
        Mockito.doThrow(Exception.class).when(mokTMRest).create(mokTM);
  
    }

    /**
     * Test of edit method, of class TipoMantenimientoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Mockito.doNothing().when(mokTMRest).edit(Integer.SIZE, mokTM);
        mokTMRest.edit(Integer.SIZE, mokTM);
        Mockito.verify(mokTMRest, times(1)).edit(Integer.SIZE, mokTM);
        Mockito.doThrow(Exception.class).when(mokTMRest).edit(Integer.SIZE, mokTM);
  
        
    }
    
}
