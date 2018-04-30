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
import ues.fmoocc.ingenieria.tpi2018.Entities.Procedimientos;

/**
 *
 * @author viktor
 */

public class ProcedimientosRestTest {
    final ProcedimientosRest mokProcedimientosRest = Mockito.mock(ProcedimientosRest.class);
    final Procedimientos mokProcedimientos = Mockito.mock(Procedimientos.class);
    public ProcedimientosRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Procedimientos.class).withAnyArguments().thenReturn(mokProcedimientos);
        Procedimientos p = new Procedimientos(1, 1, 1);
        Procedimientos p1 = new Procedimientos(2, 2, 2);
        List<Procedimientos> listaProcedimientos = new ArrayList<>();
        listaProcedimientos.add(p);
        listaProcedimientos.add(p1);
        Mockito.when(mokProcedimientosRest.findAll()).thenReturn(listaProcedimientos);
        Mockito.when(mokProcedimientosRest.findById(1)).thenReturn(p);
        Mockito.when(mokProcedimientosRest.create(mokProcedimientos)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokProcedimientosRest.edit(mokProcedimientos)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokProcedimientosRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class ProcedimientosRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
         ProcedimientosRest rest = mokProcedimientosRest;
        List<Procedimientos> result = rest.findAll();
        Procedimientos diagnostico = new Procedimientos(1, 1, 1);
        assertThat(result, CoreMatchers.hasItem(diagnostico));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class ProcedimientosRest.
     */
    @Test
    public void testFindById() throws Exception {
       int id = 1; 
       ProcedimientosRest instance = mokProcedimientosRest;
       Procedimientos expResult = new Procedimientos(1, 1, 1);
       Procedimientos result = instance.findById(id);
       assertNotNull(result);
       assertEquals(expResult, result);
    }

    /**
     * Test of borrarProcedimiento method, of class ProcedimientosRest.
     */
     @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        ProcedimientosRest instance = mokProcedimientosRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokProcedimientosRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        ProcedimientosRest instance = mokProcedimientosRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokProcedimientos);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokProcedimientosRest, times(1)).create(mokProcedimientos);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        ProcedimientosRest instance = mokProcedimientosRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokProcedimientos);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokProcedimientosRest, times(1)).edit(mokProcedimientos);

    }
    
}
