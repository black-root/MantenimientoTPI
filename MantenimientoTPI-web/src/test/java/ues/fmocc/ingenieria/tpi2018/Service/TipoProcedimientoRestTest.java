/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.Response;
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
import ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento;

/**
 *
 * @author viktor
 */
public class TipoProcedimientoRestTest {
    final TipoProcedimientoRest mokTPRest = Mockito.mock(TipoProcedimientoRest.class);
    final Tipoprocedimiento mokTP = Mockito.mock(Tipoprocedimiento.class);
    
    public TipoProcedimientoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Tipoprocedimiento.class).withAnyArguments().thenReturn(mokTP);
        Tipoprocedimiento tp = new Tipoprocedimiento(1);
        Tipoprocedimiento tp1 = new Tipoprocedimiento(2);
        List<Tipoprocedimiento> listTp = new ArrayList<>();
        listTp.add(tp);
        listTp.add(tp1);
        Mockito.when(mokTPRest.findall()).thenReturn(listTp);
        Mockito.when(mokTPRest.findById(1)).thenReturn(tp);
        Mockito.when(mokTPRest.findByDescripcion("descripcion")).thenReturn(listTp);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindall() throws Exception {
        System.out.println("findAll");
        TipoProcedimientoRest rest = mokTPRest;
        List<Tipoprocedimiento> result = rest.findall();
        Tipoprocedimiento tp = new Tipoprocedimiento(1);
        assertThat(result, CoreMatchers.hasItem(tp));
        assertNotNull(result);
    }

    /**
     * Test of findById method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 1;
        TipoProcedimientoRest instance = mokTPRest;
        Tipoprocedimiento expResult = new Tipoprocedimiento(1);
        Tipoprocedimiento result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of count method, of class TipoProcedimientoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        TipoProcedimientoRest instance = mokTPRest;
        Integer expResult = 0;
        Integer result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        TipoProcedimientoRest instance = mokTPRest;
         Tipoprocedimiento expResult = new  Tipoprocedimiento(1);
        List<Tipoprocedimiento> result = instance.findByDescripcion("descripcion");
        assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);
    }

    /**
     * Test of remove method, of class TipoProcedimientoRest.
     */
    @Test
    public void testRemove() {
           System.out.println("remove");
          Mockito.doNothing().when(mokTPRest).remove((Integer) Matchers.anyObject());
        
        mokTPRest.remove(Integer.SIZE);
        Mockito.verify(mokTPRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokTPRest).remove(Integer.SIZE);
    
    }

    /**
     * Test of create method, of class TipoProcedimientoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
         Mockito.doNothing().when(mokTPRest).create(mokTP);
        
        mokTPRest.create(mokTP);
        Mockito.verify(mokTPRest, times(1)).create(mokTP);
        
        Mockito.doThrow(Exception.class).when(mokTPRest).create(mokTP);
    
    }

    /**
     * Test of edit method, of class TipoProcedimientoRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
         Mockito.doNothing().when(mokTPRest).edit(Integer.SIZE, mokTP);
        
        mokTPRest.edit(Integer.SIZE, mokTP);
        Mockito.verify(mokTPRest, times(1)).edit(Integer.SIZE, mokTP);
        
        Mockito.doThrow(Exception.class).when(mokTPRest).edit(Integer.SIZE, mokTP);
    
    }
    
}
