/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
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
        Mockito.when(mokSolicitudRest.findBySolicitud("nombre")).thenReturn(listaSol);Mockito.when(mokSolicitudRest.create(mokSolicitud)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokSolicitudRest.edit(mokSolicitud)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokSolicitudRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
        
        
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
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        SolicitudRest instance = mokSolicitudRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokSolicitudRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        SolicitudRest instance = mokSolicitudRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokSolicitud);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokSolicitudRest, times(1)).create(mokSolicitud);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        SolicitudRest instance = mokSolicitudRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokSolicitud);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokSolicitudRest, times(1)).edit(mokSolicitud);

    }
    
}
