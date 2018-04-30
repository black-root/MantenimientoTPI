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
import ues.fmoocc.ingenieria.tpi2018.Entities.HistorialTrabajo;

/**
 *
 * @author viktor
 */
public class HistorialTrabajoRestTest {
    final HistorialTrabajoRest mokHistorialTrabajoRest = Mockito.mock(HistorialTrabajoRest.class);
    final HistorialTrabajo mokHistorialTrabajo = Mockito.mock(HistorialTrabajo.class);
    
    public HistorialTrabajoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(HistorialTrabajo.class).withAnyArguments().thenReturn(mokHistorialTrabajo);
        Mockito.when(mokHistorialTrabajoRest.count()).thenReturn(1);
        HistorialTrabajo h = new HistorialTrabajo(1);
        HistorialTrabajo h1 = new HistorialTrabajo(2);
        List<HistorialTrabajo> listaHistorialTrabajo = new ArrayList<>();
        listaHistorialTrabajo.add(h);
        listaHistorialTrabajo.add(h1);
        Mockito.when(mokHistorialTrabajoRest.findall()).thenReturn(listaHistorialTrabajo);
        Mockito.when(mokHistorialTrabajoRest.findById(1)).thenReturn(h);
        Mockito.when(mokHistorialTrabajoRest.create(mokHistorialTrabajo)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokHistorialTrabajoRest.edit(mokHistorialTrabajo)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokHistorialTrabajoRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class HistorialTrabajoRest.
     */
    @Test
    public void testFindall() {
     HistorialTrabajoRest rest = mokHistorialTrabajoRest;
     List<HistorialTrabajo> result = rest.findall();
     HistorialTrabajo histo = new HistorialTrabajo(1);
     assertThat(result, CoreMatchers.hasItems(histo));
    }

    /**
     * Test of count method, of class HistorialTrabajoRest.
     */
    @Test
    public void testCount() {
       HistorialTrabajoRest instance = mokHistorialTrabajoRest;
       int expResult = 1;
       int result = instance.count();
       assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class HistorialTrabajoRest.
     */
    @Test
    public void testFindById() {
        Integer id=1;
        HistorialTrabajoRest instance = mokHistorialTrabajoRest;
        HistorialTrabajo expResult = new HistorialTrabajo(1);
        HistorialTrabajo result = instance.findById(id);
        assertEquals(expResult, result);
    }

   /**
     * Test of borrarEstado method, of class EstadoRest.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        HistorialTrabajoRest instance = mokHistorialTrabajoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokHistorialTrabajoRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        HistorialTrabajoRest instance = mokHistorialTrabajoRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokHistorialTrabajo);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokHistorialTrabajoRest, times(1)).create(mokHistorialTrabajo);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        HistorialTrabajoRest instance = mokHistorialTrabajoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokHistorialTrabajo);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokHistorialTrabajoRest, times(1)).edit(mokHistorialTrabajo);

    }
    
}
