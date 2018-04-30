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
import ues.fmoocc.ingenieria.tpi2018.Entities.SubTipoMantenimiento;

/**
 *
 * @author viktor
 */

public class SubTipoMantenimientoRestTest {
    final SubTipoMantenimientoRest mokSTMRest = Mockito.mock(SubTipoMantenimientoRest.class);
    final SubTipoMantenimiento mokSTM = Mockito.mock(SubTipoMantenimiento.class);
    
    public SubTipoMantenimientoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(SubTipoMantenimiento.class).withAnyArguments().thenReturn(mokSTM);
        Mockito.when(mokSTMRest.count()).thenReturn(1);
        SubTipoMantenimiento st = new SubTipoMantenimiento(1);
        SubTipoMantenimiento st1 = new SubTipoMantenimiento(2);
        List<SubTipoMantenimiento> listaSTM = new ArrayList<>();
        listaSTM.add(st);
        listaSTM.add(st1);
        Mockito.when(mokSTMRest.findall()).thenReturn(listaSTM);
        Mockito.when(mokSTMRest.findById(1)).thenReturn(st);
        Mockito.when(mokSTMRest.create(mokSTM)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokSTMRest.edit(mokSTM)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokSTMRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
        //Mockito.when(mokSTMRest.findByDescripcion("descripcion")).thenReturn(listaSTM);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        SubTipoMantenimientoRest rest = mokSTMRest;
        List<SubTipoMantenimiento> result = rest.findall();
        SubTipoMantenimiento stm = new SubTipoMantenimiento(1);
        assertThat(result, CoreMatchers.hasItems(stm));
               
    }

    /**
     * Test of count method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        SubTipoMantenimientoRest instance = mokSTMRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findById method, of class SubTipoMantenimientoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        SubTipoMantenimientoRest instance = mokSTMRest;
        SubTipoMantenimiento expResult = new SubTipoMantenimiento(1);
        SubTipoMantenimiento result = instance.findById(id);
        assertEquals(expResult, result);
    }

     @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        SubTipoMantenimientoRest instance = mokSTMRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokSTMRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        SubTipoMantenimientoRest instance = mokSTMRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokSTM);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokSTMRest, times(1)).create(mokSTM);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        SubTipoMantenimientoRest instance = mokSTMRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokSTM);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokSTMRest, times(1)).edit(mokSTM);

    }
    
}
