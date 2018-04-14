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
import ues.fmoocc.ingenieria.tpi2018.Entities.Mantenimientodetalle;

/**
 *
 * @author viktor
 */
public class MantenimientoDetalleRestTest {
    final MantenimientoDetalleRest mokMantenimientoDetalleRest = Mockito.mock(MantenimientoDetalleRest.class);
    final Mantenimientodetalle mokMantenimientoDetalle = Mockito.mock(Mantenimientodetalle.class);
    
    public MantenimientoDetalleRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Mantenimientodetalle.class).withAnyArguments().thenReturn(mokMantenimientoDetalle);
        Mockito.when(mokMantenimientoDetalleRest.count()).thenReturn(1);
        Mantenimientodetalle m = new Mantenimientodetalle(1,1);
        Mantenimientodetalle m1 = new Mantenimientodetalle(2, 2);
        List<Mantenimientodetalle> listaMantenimientodetalle = new ArrayList<>();
        listaMantenimientodetalle.add(m);
        listaMantenimientodetalle.add(m1);
        Mockito.when(mokMantenimientoDetalleRest.findall()).thenReturn(listaMantenimientodetalle);
        Mockito.when(mokMantenimientoDetalleRest.findById(1)).thenReturn(m);
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testFindall() {
        MantenimientoDetalleRest rest = mokMantenimientoDetalleRest;
        List<Mantenimientodetalle> result = rest.findall();
        Mantenimientodetalle manDet = new Mantenimientodetalle(1, 1);
        assertThat(result, CoreMatchers.hasItems(manDet));
    }

    /**
     * Test of count method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testCount() {
        MantenimientoDetalleRest instance = mokMantenimientoDetalleRest;
        int expResult=1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testFindById() {
        int id = 1;
        MantenimientoDetalleRest instance = mokMantenimientoDetalleRest;
        Mantenimientodetalle expResult= new Mantenimientodetalle(1,1) ;
        Mantenimientodetalle result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokMantenimientoDetalleRest).remove((Integer) Matchers.anyObject());
        mokMantenimientoDetalleRest.remove(Integer.SIZE);
        Mockito.verify(mokMantenimientoDetalleRest, times(1)).remove(Integer.SIZE); 
        Mockito.doThrow(Exception.class).when(mokMantenimientoDetalleRest).remove(Integer.SIZE);
 
    }

    /**
     * Test of create method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testCreate() {
        Mockito.doNothing().when(mokMantenimientoDetalleRest).create(mokMantenimientoDetalle);
        mokMantenimientoDetalleRest.create(mokMantenimientoDetalle);
        Mockito.verify(mokMantenimientoDetalleRest, times(1)).create(mokMantenimientoDetalle);
        Mockito.doThrow(Exception.class).when(mokMantenimientoDetalleRest).create(mokMantenimientoDetalle);
     
    }

    /**
     * Test of edit method, of class MantenimientoDetalleRest.
     */
    @Test
    public void testEdit() {
        Mockito.doNothing().when(mokMantenimientoDetalleRest).edit(Integer.SIZE, mokMantenimientoDetalle);
        mokMantenimientoDetalleRest.edit(Integer.SIZE, mokMantenimientoDetalle);
        Mockito.verify(mokMantenimientoDetalleRest, times(1)).edit(Integer.SIZE, mokMantenimientoDetalle);
        Mockito.doThrow(Exception.class).when(mokMantenimientoDetalleRest).edit(Integer.SIZE, mokMantenimientoDetalle);
       
    }
    
}
