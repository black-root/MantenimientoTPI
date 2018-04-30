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

import ues.fmoocc.ingenieria.tpi2018.Entities.OrdenTrabajo;


/**
 *
 * @author viktor
 */

public class OrdenTrabajoRestTest {
    final OrdenTrabajoRest mokOrdenTrabajoRest = Mockito.mock(OrdenTrabajoRest.class);
    final OrdenTrabajo mokOrdenTrabajo = Mockito.mock(OrdenTrabajo.class);
    public OrdenTrabajoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(OrdenTrabajo.class).withAnyArguments().thenReturn(mokOrdenTrabajo);
        Mockito.when(mokOrdenTrabajoRest.count()).thenReturn(1);
        OrdenTrabajo or = new OrdenTrabajo(1);
        OrdenTrabajo or1 = new OrdenTrabajo(2);
        List<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<>();
        listaOrdenTrabajo.add(or);
        listaOrdenTrabajo.add(or1);
        Mockito.when(mokOrdenTrabajoRest.findall()).thenReturn(listaOrdenTrabajo);
        Mockito.when(mokOrdenTrabajoRest.findById(1)).thenReturn(or1);
        Mockito.when(mokOrdenTrabajoRest.create(mokOrdenTrabajo)).thenReturn(Response.status(Response.Status.CREATED).entity(or).build());
        Mockito.when(mokOrdenTrabajoRest.edit(mokOrdenTrabajo)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokOrdenTrabajoRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class OrdenTrabajoRest.
     */
    @Test
    public void testFindall() {
        OrdenTrabajoRest rest = mokOrdenTrabajoRest;
        List<OrdenTrabajo> result = rest.findall();
        OrdenTrabajo oT = new OrdenTrabajo(1);
        assertThat(result, CoreMatchers.hasItems(oT));
    }

    /**
     * Test of count method, of class OrdenTrabajoRest.
     */
    @Test
    public void testCount() {
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class OrdenTrabajoRest.
     */
    @Test
    public void testFindById() {
        Integer id = 1;
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        OrdenTrabajo expResult = new OrdenTrabajo(2);
        OrdenTrabajo result = instance.findById(id);
        assertEquals(expResult, result);
    }
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokOrdenTrabajoRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokOrdenTrabajo);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokOrdenTrabajoRest, times(1)).create(mokOrdenTrabajo);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        OrdenTrabajoRest instance = mokOrdenTrabajoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokOrdenTrabajo);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokOrdenTrabajoRest, times(1)).edit(mokOrdenTrabajo);

    }

    
}
