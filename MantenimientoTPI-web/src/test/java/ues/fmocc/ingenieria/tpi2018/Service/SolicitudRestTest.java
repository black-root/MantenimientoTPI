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
import ues.fmoocc.ingenieria.tpi2018.Entities.Solicitud;

/**
 *
 * @author viktor
 */
public class SolicitudRestTest {
    final SolicitudRest mokSolicitudRest = Mockito.mock(SolicitudRest.class);
    final Solicitud mokSolicitud = Mockito.mock(Solicitud.class);    
    public SolicitudRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Solicitud.class).withAnyArguments().thenReturn(mokSolicitud);
        Mockito.when(mokSolicitudRest.count()).thenReturn(1);
        Solicitud s = new Solicitud(1);
        Solicitud s1 = new Solicitud(2);
        List<Solicitud> listaSol = new ArrayList<>();
        listaSol.add(s);
        listaSol.add(s1);
        Mockito.when(mokSolicitudRest.findall()).thenReturn(listaSol);
        Mockito.when(mokSolicitudRest.findById(1)).thenReturn(s);
        Mockito.when(mokSolicitudRest.findBySolicitud("nombre")).thenReturn(listaSol);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class SolicitudRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        SolicitudRest rest = mokSolicitudRest;
        List<Solicitud> result = rest.findall();
        Solicitud sol = new Solicitud(1);
        assertThat(result, CoreMatchers.hasItems(sol));
    }

    /**
     * Test of count method, of class SolicitudRest.
     */
    @Test
    public void testCount() {
        SolicitudRest instance = mokSolicitudRest;
        int expResult =1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class SolicitudRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        SolicitudRest instance = mokSolicitudRest;
        Solicitud expResult = new Solicitud(1);
        Solicitud result = instance.findById(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findBySolicitud method, of class SolicitudRest.
     */
    @Test
    public void testFindBySolicitud() {
        System.out.println("findBySolicitud");
        SolicitudRest instance = mokSolicitudRest;
        Solicitud expResult = new Solicitud(1);
        List<Solicitud> result = instance.findBySolicitud("nombre");
        assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);             
    }

    /**
     * Test of remove method, of class SolicitudRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Mockito.doNothing().when(mokSolicitudRest).remove((Integer) Matchers.anyObject());
        mokSolicitudRest.remove(Integer.SIZE);
        Mockito.verify(mokSolicitudRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokSolicitudRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class SolicitudRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Mockito.doNothing().when(mokSolicitudRest).create(mokSolicitud);
        mokSolicitudRest.create(mokSolicitud);
        Mockito.verify(mokSolicitudRest, times(1)).create(mokSolicitud);
        
        Mockito.doThrow(Exception.class).when(mokSolicitudRest).create(mokSolicitud);
   
    }

    /**
     * Test of edit method, of class SolicitudRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Mockito.doNothing().when(mokSolicitudRest).edit(Integer.SIZE, mokSolicitud);
        mokSolicitudRest.edit(Integer.SIZE, mokSolicitud);
        Mockito.verify(mokSolicitudRest, times(1)).edit(Integer.SIZE, mokSolicitud);
        
        Mockito.doThrow(Exception.class).when(mokSolicitudRest).edit(Integer.SIZE, mokSolicitud);
   
    }
    
}
