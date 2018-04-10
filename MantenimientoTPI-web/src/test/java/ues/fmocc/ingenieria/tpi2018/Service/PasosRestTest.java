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
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;

/**
 *
 * @author viktor
 */
public class PasosRestTest {
    final PasosRest mokPasosRest = Mockito.mock(PasosRest.class);
    final Pasos mokPasos = Mockito.mock(Pasos.class);
    
    public PasosRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Pasos.class).withAnyArguments().thenReturn(mokPasos);
        Pasos p = new Pasos(1);
        Pasos p1 = new Pasos(2);
        List<Pasos> listaPasos = new ArrayList<>();
        listaPasos.add(p);
        listaPasos.add(p1);
        Mockito.when(mokPasosRest.findall()).thenReturn(listaPasos);
        Mockito.when(mokPasosRest.findById(1)).thenReturn(p);
        Mockito.when(mokPasosRest.findByDescripcion("descripcion")).thenReturn(listaPasos);
            
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class PasosRest.
     */
    @Test
    public void testFindall() throws Exception {
        PasosRest rest = mokPasosRest;
        List<Pasos> result = rest.findall();
        Pasos pas = new Pasos(1);
        assertThat(result, CoreMatchers.hasItem(pas));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class PasosRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id = 1;
        PasosRest instance = mokPasosRest;
        Pasos expResult = new Pasos(1);
        Pasos result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

   @Test
    public void testCount() {
        System.out.println("count");
        PasosRest instance = mokPasosRest;
        int expResult =0;
        int result = instance.count();
         assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class PasosRest.
     */
    @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        PasosRest instance = mokPasosRest;
        Pasos expResult = new Pasos(1);
        List<Pasos> result = instance.findByDescripcion("descripcion");
        assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);
    }

    /**
     * Test of remove method, of class PasosRest.
     */
    @Test
    public void testRemove() {
         System.out.println("remove");
          Mockito.doNothing().when(mokPasosRest).remove((Integer) Matchers.anyObject());
        
        mokPasosRest.remove(Integer.SIZE);
        Mockito.verify(mokPasosRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokPasosRest).remove(Integer.SIZE);
    
    }

    /**
     * Test of create method, of class PasosRest.
     */
    @Test
    public void testCreate() {
           Mockito.doNothing().when(mokPasosRest).create(mokPasos);
        
        mokPasosRest.create(mokPasos);
        Mockito.verify(mokPasosRest, times(1)).create(mokPasos);
        
        Mockito.doThrow(Exception.class).when(mokPasosRest).create(mokPasos);
    
    }

    /**
     * Test of edit method, of class PasosRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
          Mockito.doNothing().when(mokPasosRest).edit(Integer.SIZE, mokPasos);
        
        mokPasosRest.edit(Integer.SIZE, mokPasos);
        Mockito.verify(mokPasosRest, times(1)).edit(Integer.SIZE, mokPasos);
        
        Mockito.doThrow(Exception.class).when(mokPasosRest).edit(Integer.SIZE, mokPasos);
    
    }
    
}
