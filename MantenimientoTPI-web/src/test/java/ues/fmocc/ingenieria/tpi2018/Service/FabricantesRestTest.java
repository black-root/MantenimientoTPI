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
import ues.fmoocc.ingenieria.tpi2018.Entities.Fabricantes;

/**
 *
 * @author viktor
 */
public class FabricantesRestTest {
    final FabricantesRest mokFabricantesRest = Mockito.mock(FabricantesRest.class);
    final Fabricantes mokFabricantes = Mockito.mock(Fabricantes.class);
    
    public FabricantesRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
       PowerMockito.whenNew(Fabricantes.class).withAnyArguments().thenReturn(mokFabricantes);
       Fabricantes d = new Fabricantes(1);
       Fabricantes d1 = new Fabricantes(2);
       List<Fabricantes> listaFabricantes =new ArrayList<>();
       listaFabricantes.add(d);
       listaFabricantes.add(d1);
       Mockito.when(mokFabricantesRest.findall()).thenReturn(listaFabricantes);
       Mockito.when(mokFabricantesRest.findById(1)).thenReturn(d);
       Mockito.when(mokFabricantesRest.findByDescripcion("descripcion")).thenReturn(listaFabricantes);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class FabricantesRest.
     */
    @Test
    public void testFindall() throws Exception {
        FabricantesRest rest = mokFabricantesRest;
        List<Fabricantes> result = rest.findall();
        Fabricantes fab = new Fabricantes(1);
        assertThat(result, CoreMatchers.hasItem(fab));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class FabricantesRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id=1;
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes expResult = new Fabricantes(1);
        Fabricantes result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

 
    /**
     * Test of count method, of class FabricantesRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        FabricantesRest instance = mokFabricantesRest;
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class FabricantesRest.
     */
    @Test
    public void testFindByDescripcion() {
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes expResult = new Fabricantes(1);
        List<Fabricantes> result = instance.findByDescripcion("descripcion");
        assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);
    }

    /**
     * Test of remove method, of class FabricantesRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
          Mockito.doNothing().when(mokFabricantesRest).remove((Integer) Matchers.anyObject());
        
        mokFabricantesRest.remove(Integer.SIZE);
        Mockito.verify(mokFabricantesRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokFabricantesRest).remove(Integer.SIZE);
    
    }

    /**
     * Test of create method, of class FabricantesRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Mockito.doNothing().when(mokFabricantesRest).create(mokFabricantes);
        mokFabricantesRest.create(mokFabricantes);
        Mockito.verify(mokFabricantesRest, times(1)).create(mokFabricantes);
        Mockito.doThrow(Exception.class).when(mokFabricantesRest).create(mokFabricantes);
    
    }

    /**
     * Test of edit method, of class FabricantesRest.
     */
    @Test
    public void testEdit() {
         Mockito.doNothing().when(mokFabricantesRest).edit(Integer.SIZE, mokFabricantes);
        
        mokFabricantesRest.edit(Integer.SIZE, mokFabricantes);
        Mockito.verify(mokFabricantesRest, times(1)).edit(Integer.SIZE, mokFabricantes);
        
        Mockito.doThrow(Exception.class).when(mokFabricantesRest).edit(Integer.SIZE, mokFabricantes);
    
    }
    
}
