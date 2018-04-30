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
import ues.fmoocc.ingenieria.tpi2018.Entities.Unidad;

/**
 *
 * @author viktor
 */

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
        Mockito.when(mokUnidadRest.create(mokUnidad)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokUnidadRest.edit(mokUnidad)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokUnidadRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
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
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        UnidadRest instance = mokUnidadRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokUnidadRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        UnidadRest instance = mokUnidadRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokUnidad);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        UnidadRest instance = mokUnidadRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokUnidad);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokUnidadRest, times(1)).edit(mokUnidad);

    }
}
