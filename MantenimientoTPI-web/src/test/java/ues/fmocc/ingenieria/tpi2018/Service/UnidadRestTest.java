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
import ues.fmoocc.ingenieria.tpi2018.Entities.Unidad;

/**
 *
 * @author viktor
 */
@Ignore
public class UnidadRestTest {
    final UnidadRest mokUnidadRest = Mockito.mock(UnidadRest.class);
    final Unidad mokUnidad = Mockito.mock(Unidad.class);
    
    public UnidadRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Unidad.class).withAnyArguments().thenReturn(mokUnidad);
        Mockito.when(mokUnidadRest.count()).thenReturn(1);
        Unidad u = new Unidad(1);
        Unidad u1 = new Unidad(2);
        List<Unidad> listaU = new ArrayList<>();
        listaU.add(u);
        listaU.add(u1);
        Mockito.when(mokUnidadRest.findall()).thenReturn(listaU);
        Mockito.when(mokUnidadRest.findById(1)).thenReturn(u);
        Mockito.when(mokUnidadRest.findByNombre("nombre")).thenReturn(listaU);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class UnidadRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        UnidadRest rest = mokUnidadRest;
        List<Unidad> result = rest.findall();
        Unidad un = new Unidad(1);
        assertThat(result, CoreMatchers.hasItems(un));
        
    }

    /**
     * Test of count method, of class UnidadRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        UnidadRest instance = mokUnidadRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findById method, of class UnidadRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        UnidadRest instance = mokUnidadRest;
        Unidad expResult = new Unidad(1);
        Unidad result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByNombre method, of class UnidadRest.
     */
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        UnidadRest instance = mokUnidadRest;
        Unidad expResult = new Unidad(1);
        List<Unidad> result = instance.findByNombre("nombre");
         assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);
    }

    /**
     * Test of remove method, of class UnidadRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Mockito.doNothing().when(mokUnidadRest).remove((Integer) Matchers.anyObject());
        mokUnidadRest.remove(Integer.SIZE);
        Mockito.verify(mokUnidadRest, times(1)).remove(Integer.SIZE);
        Mockito.doThrow(Exception.class).when(mokUnidadRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class UnidadRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
         Mockito.doNothing().when(mokUnidadRest).create(mokUnidad);
        mokUnidadRest.create(mokUnidad);
        Mockito.verify(mokUnidadRest, times(1)).create(mokUnidad);
        Mockito.doThrow(Exception.class).when(mokUnidadRest).create(mokUnidad);
   
    }

    /**
     * Test of edit method, of class UnidadRest.
     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        Mockito.doNothing().when(mokUnidadRest).edit(Integer.SIZE, mokUnidad);
//        mokUnidadRest.edit(Integer.SIZE, mokUnidad);
//        Mockito.verify(mokUnidadRest, times(1)).edit(Integer.SIZE, mokUnidad);
//        Mockito.doThrow(Exception.class).when(mokUnidadRest).edit(Integer.SIZE, mokUnidad);
//   
//    }
    
}
