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
import ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento;

/**
 *
 * @author viktor
 */
public class SubTipoMantenimientoRestTest {
    final SubTipoMantenimientoRest mokSTMRest = Mockito.mock(SubTipoMantenimientoRest.class);
    final SubTipoMantenimiento mokSTM = Mockito.mock(SubTipoMantenimiento.class);
    
    public SubTipoMantenimientoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(SubTipoMantenimiento.class).withAnyArguments().thenReturn(mokSTM);
        Mockito.when(mokSTMRest.count()).thenReturn(1);
        SubTipoMantenimiento st = new SubTipoMantenimiento(1);
        SubTipoMantenimiento st1 = new SubTipoMantenimiento(2);
        List<SubTipoMantenimiento> listaSTM = new ArrayList<>();
        listaSTM.add(st);
        listaSTM.add(st1);
        Mockito.when(mokSTMRest.findall()).thenReturn(listaSTM);
        Mockito.when(mokSTMRest.findById(1)).thenReturn(st);
        //Mockito.when(mokSTMRest.findByDescripcion("descripcion")).thenReturn(listaSTM);
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
        SubTipoMantenimientoRest rest = mokSTMRest;
        List<SubTipoMantenimiento> result = rest.findall();
        SubTipoMantenimiento stm = new SubTipoMantenimiento(1);
        assertThat(result, CoreMatchers.hasItems(stm));
               
    }

    /**
     * Test of count method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        SubTipoMantenimientoRest instance = mokSTMRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findById method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        SubTipoMantenimientoRest instance = mokSTMRest;
        SubTipoMantenimiento expResult = new SubTipoMantenimiento(1);
        SubTipoMantenimiento result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class SubTipoMantenimientoRest.
     */
//    @Test
//    public void testFindByDescripcion() {
//        System.out.println("findByDescripcion");
//        SubTipoMantenimientoRest instance = mokSTMRest;
//        SubTipoMantenimiento expResult = new SubTipoMantenimiento(1);
//        List<SubTipoMantenimiento> result = instance.findByDescripcion("descripcion");
//        assertThat(result, CoreMatchers.hasItem(expResult));
//        assertNotNull(result);
//    }

    /**
     * Test of remove method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Mockito.doNothing().when(mokSTMRest).remove((Integer) Matchers.anyObject());
        mokSTMRest.remove(Integer.SIZE);
        Mockito.verify(mokSTMRest, times(1)).remove(Integer.SIZE);
        Mockito.doThrow(Exception.class).when(mokSTMRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Mockito.doNothing().when(mokSTMRest).create(mokSTM);
        mokSTMRest.create(mokSTM);
        Mockito.verify(mokSTMRest, times(1)).create(mokSTM);
        Mockito.doThrow(Exception.class).when(mokSTMRest).create(mokSTM);
   
    }

    /**
     * Test of edit method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Mockito.doNothing().when(mokSTMRest).edit(Integer.SIZE, mokSTM);
        mokSTMRest.edit(Integer.SIZE, mokSTM);
        Mockito.verify(mokSTMRest, times(1)).edit(Integer.SIZE, mokSTM);
        Mockito.doThrow(Exception.class).when(mokSTMRest).edit(Integer.SIZE, mokSTM);
   
    }
    
}
