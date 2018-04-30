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
import org.junit.Ignore;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Estado;

/**
 *
 * @author viktor
 */
public class EstadoRestTest {
    final EstadoRest mokEstadoRest = Mockito.mock(EstadoRest.class);
    final Estado mokEstado = Mockito.mock(Estado.class);
    public EstadoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Estado.class).withAnyArguments().thenReturn(mokEstado);
        Estado d= new Estado(0, 0, 0, 0);
        Estado d1= new Estado(1, 1, 1, 1);
        List<Estado> listaEstado = new ArrayList<>();
        listaEstado.add(d);
        listaEstado.add(d1);
        Mockito.when(mokEstadoRest.findAll()).thenReturn(listaEstado);
        Mockito.when(mokEstadoRest.findById(1)).thenReturn(d);
        Mockito.when(mokEstadoRest.create(mokEstado)).thenReturn(Response.status(Response.Status.CREATED).entity(d).build());
        Mockito.when(mokEstadoRest.edit(mokEstado)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokEstadoRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class EstadoRest.
     */
    @Test
    public void testFindAll() throws Exception {
        EstadoRest rest = mokEstadoRest;
        List<Estado> result = rest.findAll();
        Estado estado = new Estado(0, 0, 0, 0);
        assertThat(result, CoreMatchers.hasItem(estado));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class EstadoRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id=1;
        EstadoRest instance = mokEstadoRest;
        Estado expResult = new Estado(0, 0, 0, 0);
        Estado result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarEstado method, of class EstadoRest.
     */
    @Test
    public void testBorrarDiagnosticoparte() throws Exception {
        System.out.println("borrarDiagnosticoparte");
        Integer id = 1;
        EstadoRest instance = mokEstadoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokEstadoRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardarDiagnosticoparte() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        EstadoRest instance = mokEstadoRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokEstado);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokEstadoRest, times(1)).create(mokEstado);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditarDiagnosticoparte() throws Exception {
        int id = 1;
        EstadoRest instance = mokEstadoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokEstado);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokEstadoRest, times(1)).edit(mokEstado);

    }
    
}
